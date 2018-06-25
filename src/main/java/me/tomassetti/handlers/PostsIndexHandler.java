package me.tomassetti.handlers;

import me.tomassetti.AbstractRequestHandler;
import me.tomassetti.Answer;
import me.tomassetti.model.Model;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;

public class PostsIndexHandler extends AbstractRequestHandler<EmptyPayload> {

    public PostsIndexHandler(Model model, FreeMarkerEngine freeMarkerEngine) {
        super(EmptyPayload.class, model, freeMarkerEngine);
    }

    @Override
    protected Answer processImpl(EmptyPayload value, Map<String,String> urlParams, boolean shouldReturnHtml) {
      /*  if (shouldReturnHtml) {
        	/*
            String html = body().with(
                    h1("My wonderful blog"),
                    div().with(
                            model.getAllPosts().stream().map((p) ->
                                    div().with(
                                            h2(p.getTitle()),
                                            p(p.getContent()),
                                            ul().with(p.getCategories().stream().map((cat) ->
                                                    li(cat))
                                                    .collect(Collectors.toList())))
                                                )
                                    .collect(Collectors.toList()))
            ).render();
            return Answer.ok(html);
            
        	return view("posts.ftl", model.getAllPosts());
        } else {
            String json = dataToJson(model.getAllPosts());
            return Answer.ok(json);
           */
    	return null;
            
        }
    }


