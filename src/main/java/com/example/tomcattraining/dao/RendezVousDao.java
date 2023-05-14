package com.example.tomcattraining.dao;

import com.example.tomcattraining.metiers.RendezVous;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class RendezVousDao implements Dao<RendezVous> {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testH2");
    @Override
    public RendezVous getById(int id) {
        return null;
    }

    @Override
    public void create(RendezVous objet) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(RendezVous objet) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(objet);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(RendezVous objet) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(objet);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public ArrayList<RendezVous> findAll() {
        return  null;
    }
}
