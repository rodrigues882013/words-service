package com.words.dao;

import java.util.List;


public interface ManagerDao<T> {
    T getById(String id);
    List<T> getAll();
    T create(T object);
    boolean delete(String id);
    T update(T object);
}
