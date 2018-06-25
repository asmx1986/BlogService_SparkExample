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

    @Override
    protected Answer processImpl(NewAreaPayload creation, Map<String, String> urlParams, boolean shouldReturnHtml) {
       /* UUID post = UUID.fromString(urlParams.get(":uuid"));
        if (!model.existPost(post)){
            return new Answer(400);
        }
        UUID id = model.createComment(post, creation.getArea(), creation.getContent());
        return Answer.ok(id.toString());
    */
    	return null;
    }
}
