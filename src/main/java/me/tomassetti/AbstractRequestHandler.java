package me.tomassetti;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import me.tomassetti.handlers.EmptyPayload;
import me.tomassetti.model.Model;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractRequestHandler<V extends Validable> implements RequestHandler<V>, Route {

    private Class<V> valueClass;
    protected Model model;
    private FreeMarkerEngine freeMarkerEngine;

    private static final int HTTP_BAD_REQUEST = 400;

    public AbstractRequestHandler(Class<V> valueClass, Model model){
    	this(valueClass, model, null);
    }

    public AbstractRequestHandler(Class<V> valueClass, Model model, FreeMarkerEngine freeMarkerEngine){
        this.valueClass = valueClass;
        this.model = model;
        this.freeMarkerEngine = freeMarkerEngine;
    }

    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    protected Answer view(String view, Object model) {
    	Map<String, Object> viewModel = new HashMap<>();
    	viewModel.put("model", model);
    	viewModel.put("bodyTemplate", view);
        return new Answer(200, this.freeMarkerEngine.render(new ModelAndView(viewModel, "layout.ftl")));
    }
    
    protected Answer redirect(String location) {
        return new Answer(303, location);    	
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(data);
        } catch (IOException e){
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }

    public final Answer process(V value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if (value != null && !value.isValid()) {
            return new Answer(HTTP_BAD_REQUEST);
        } else {
            return processImpl(value, urlParams, shouldReturnHtml);
        }
    }

    protected abstract Answer processImpl(V value, Map<String, String> urlParams, boolean shouldReturnHtml);


    @Override
    public Object handle(Request request, Response response) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            V value = null;
            if (valueClass != EmptyPayload.class) {
            	String auxBody = request.body();
        		if (!request.contentType().contains("json")) {
        			List<NameValuePair> pairs = URLEncodedUtils.parse(auxBody, Charset.defaultCharset());
        			Map<String, String> map = new HashMap<>();
    		        for(int i=0; i<pairs.size(); i++){
    		            NameValuePair pair = pairs.get(i);
    		            map.put(pair.getName(), pair.getValue());
    		        }
    		        auxBody = objectMapper.writeValueAsString(map);
        		}
    			value = objectMapper.readValue(auxBody, valueClass);
            }
            Map<String, String> urlParams = request.params();
            Answer answer = process(value, urlParams, shouldReturnHtml(request));
            response.status(answer.getCode());
            if (answer.getCode() == 303) {
            	response.redirect(answer.getBody(), answer.getCode());
            } else {
	            String bodyResult = answer.getBody();
	            if (shouldReturnHtml(request)) {
	                response.type("text/html");
	            } else {
	                response.type("application/json");
	            }
	            response.body(bodyResult);
            }
            return answer.getBody();
        } catch (JsonMappingException e) {
            response.status(400);
            response.body(e.getMessage());
            return e.getMessage();
        }
    }

}
