package com.words.dao;

import com.words.models.Word;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class WordDao implements ManagerDao<Word>{

    private EntityManager getEntityManager() {

        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {

            factory = Persistence.createEntityManagerFactory("words");
            entityManager = factory.createEntityManager();

        } finally {
            assert factory != null;
            factory.close();
        }
        return entityManager;
    }


    @Override
    public Word getById(String id) {
        return null;
    }

    @Override
    public List<Word> getAll() {
        ArrayList<Word> ws = new ArrayList<>();
        ws.add(new Word("Felipe"));
        return ws;
    }

    @Override
    public Word create(Word object) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }

    @Override
    public Word update(Word object) {
        return null;
    }
}
