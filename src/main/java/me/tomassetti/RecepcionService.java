package me.tomassetti;
 
import com.beust.jcommander.JCommander;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import me.tomassetti.handlers.*;
import me.tomassetti.model.Area;
import me.tomassetti.model.Model;
import me.tomassetti.sql2omodel.Sql2oModel;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.port;

public class RecepcionService 
{

    private static final Logger logger = Logger.getLogger(RecepcionService.class.getCanonicalName());

    public static void main( String[] args) {
        CommandLineOptions options = new CommandLineOptions();
        new JCommander(options, args);

        logger.finest("Options.debug = " + options.debug);
        logger.finest("Options.database = " + options.database);
        logger.finest("Options.dbHost = " + options.dbHost);
        logger.finest("Options.dbUsername = " + options.dbUsername);
        logger.finest("Options.dbPort = " + options.dbPort);
        logger.finest("Options.servicePort = " + options.servicePort);

        port(options.servicePort);

        Sql2o sql2o = new Sql2o("jdbc:postgresql://" + options.dbHost + ":" + options.dbPort + "/" + options.database,
                options.dbUsername, options.dbPassword, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });

        Model sql2o_model = new Sql2oModel(sql2o);
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(RecepcionService.class, "/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        
        get("/alive", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "ok";
            }
        });

    

        //AREAS
        //listado
        get("/areas", new AreasSearchHandler(sql2o_model, freeMarkerEngine));
        //crear
        get("/areas/create_form", new AbstractRequestHandler<EmptyPayload>(EmptyPayload.class, null, freeMarkerEngine) {
			@Override
			protected Answer processImpl(EmptyPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
				return view("areas_create.ftl", new Area());
			}
		});
        post("/areas", new AbstractRequestHandler<NewAreaPayload>(NewAreaPayload.class, null, freeMarkerEngine) {
			@Override
			protected Answer processImpl(NewAreaPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
				sql2o_model.areasCreate(value);
				return redirect("/areas");
			}
		}); //AreaCreatePayload
        /*
        //editar
        get("/areas/:uuid/edit_form", null);
        put("/areas/:uuid", null); //AreaUpdatePayload
        //ver detalle
        get("/areas/:uuid", null);
        //eliminar
        get("/areas/:uuid/delete_form", null);
        delete("/areas/:uuid", null);
		*/
    
    
    
    
    
    
    }
}
