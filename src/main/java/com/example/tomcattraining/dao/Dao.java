package com.example.tomcattraining.dao;

import java.util.ArrayList;

public interface Dao<T> {
    T getById(int id);
    void create(T objet) ;
    void update(T objet) ;
    void delete(T objet) ;

    ArrayList<T> findAll();

}
