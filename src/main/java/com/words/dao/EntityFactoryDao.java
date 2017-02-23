package com.words.dao;

public class EntityFactoryDao {

    public static ManagerDao getDao(String type){
        if (type == null) return null;
        if (type.equals("word")) return new WordDao();
        return null;
    }
}
