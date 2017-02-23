package com.words.resources;

import com.words.dao.EntityFactoryDao;
import com.words.dao.ManagerDao;
import com.words.dao.WordDao;
import com.words.models.Word;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("words")
public class Words {

    private final String RESOURCE_TYPE = "word";

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") Integer wordId) {
        return wordId.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {

        try {
            ManagerDao wordDao = EntityFactoryDao.getDao(RESOURCE_TYPE);
            List<Word> words = (ArrayList<Word>) wordDao.getAll();
            System.out.println(words.get(0).getWord());

        } catch (Exception ignored){
            System.out.println("Error: " + ignored);
        }

        return "List All Drivers";
    }
}
