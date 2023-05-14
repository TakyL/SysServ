package com.example.tomcattraining.dao;

import java.util.ArrayList;

public interface Dao<T> {
    public abstract T getById(int id);
    public abstract void create(T objet) ;
    public abstract void update(T objet) ;
    public abstract void delete(T objet) ;;
    public abstract ArrayList<T> findAll();

}
