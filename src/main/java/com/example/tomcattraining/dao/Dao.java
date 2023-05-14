package com.example.tomcattraining.dao;

import java.util.ArrayList;

public interface Dao<T> {
    public abstract T getById(int id);
    public abstract boolean create(T objet) ;
    public abstract boolean update(T objet) ;
    public abstract boolean delete(T objet) ;;
    public abstract ArrayList<T> findAll();

}
