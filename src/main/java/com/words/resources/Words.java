package com.words.resources;

import com.words.dao.EntityFactoryDao;
import com.words.dao.ManagerDao;
import com.words.dao.WordDao;
import com.words.models.Word;

import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("words")
public class Words {

    private final String RESOURCE_TYPE = "word";

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") String wordId) {
        Word word = new Word("Erro");
        try {
            WordDao wordDao = (WordDao) EntityFactoryDao.getDao(RESOURCE_TYPE);
            System.out.println(wordId);
            word = (Word) wordDao.getById(wordId);

        } catch (Exception ignored){
            System.out.println("Error: " + ignored);
        }
        return word.getWord();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {

        try {
            WordDao wordDao = (WordDao) EntityFactoryDao.getDao(RESOURCE_TYPE);

            List<Word> words = wordDao.getAll();
            for (Word w : (ArrayList<Word>) words){
                System.out.println("Word: " + w.getWord());
            }


        } catch (Exception ignored){
            System.out.println("Error: " + ignored);
        }

        return "List All Drivers";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String save() {

        try {
            WordDao wordDao = (WordDao) EntityFactoryDao.getDao(RESOURCE_TYPE);

        } catch (Exception ignored){
            System.out.println("Error: " + ignored);
        }
        return "";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String calculate() {

        try {
            WordDao wordDao = (WordDao) EntityFactoryDao.getDao(RESOURCE_TYPE);

        } catch (Exception ignored){
            System.out.println("Error: " + ignored);
        }
        return "";
    }
}
