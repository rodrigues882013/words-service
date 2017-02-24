package com.words.dao;

import com.words.models.Word;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class WordDao implements ManagerDao<Word>{

    private EntityManagerFactory factory = null;
    private EntityManager entityManager = null;
    private final String ENTITY = "Word";

    private EntityManager getEntityManager() {



        factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();


        return entityManager;
    }

    public WordDao(){
        super();
    }

    @Override
    public Word getById(String id) {
        EntityManager entityManager = getEntityManager();
        Word word = null;

        try {
            entityManager.getTransaction().begin();
            word = entityManager.find(Word.class, id);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
            factory.close();
        }

        return word;
    }

    @Override
    public List<Word> getAll() {
        EntityManager entityManager = getEntityManager();
        List resultSet = null;

        try {
            entityManager.getTransaction().begin();
            resultSet = entityManager.createQuery("FROM " + ENTITY, Word.class).getResultList();
            entityManager.getTransaction().commit();

        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
            factory.close();
        }

        return resultSet;
    }

    private Word save(Word word){
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(word);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            entityManager.close();
            factory.close();
        }

        return word;
    }

    @Override
    public Word create(Word object) {
        return save(object);
    }

    @Override
    public boolean delete(String id) {
        EntityManager entityManager = getEntityManager();
        boolean result = true;

        try {

            Word word = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(word);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            result = false;

        } finally {
            entityManager.close();
            factory.close();
        }

        return result;
    }

    @Override
    public Word update(Word object) {
        return save(object);
    }
}
