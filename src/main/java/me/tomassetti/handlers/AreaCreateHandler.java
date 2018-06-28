package me.tomassetti.handlers;

import me.tomassetti.AbstractRequestHandler;
import me.tomassetti.Answer;
import me.tomassetti.model.Model;

import java.util.Map;
import java.util.UUID;

public class AreaCreateHandler extends AbstractRequestHandler<NewAreaPayload> {

   private Model model;

    public AreaCreateHandler(Model model) {
        super(NewAreaPayload.class, model);
        this.model = model;
    }
/*
    @Override
    protected Answer processImpl(NewAreaPayload creation, Map<String, String> urlParams, boolean shouldReturnHtml) {
        UUID post = UUID.fromString(urlParams.get(":uuid"));
        if (!model.existPost(post)){
            return new Answer(400);
        }
        UUID id = model.Area(post, creation.getArea());
        return Answer.ok(id.toString());
    
     return view("areas_creacion.ftl", model.areasList());
    } */

	@Override
	protected Answer processImpl(NewAreaPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
		// TODO Auto-generated method stub
		return null;
	}
}
