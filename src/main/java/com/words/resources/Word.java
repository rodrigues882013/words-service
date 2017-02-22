package com.words.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("words")
public class Word {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") Integer wordId) {
        return wordId.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return "List All Drivers";
    }
}
