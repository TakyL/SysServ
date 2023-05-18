package com.example.tomcattraining.dao;

import com.example.tomcattraining.metiers.RendezVous;
import com.example.tomcattraining.metiers.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;
import outilshibernate.OutilsHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDao implements Dao<RendezVous> {

    //private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testH2");//FIXME Declenche des erreurs via des createtables
    @Override
    public RendezVous getById(int id) {
        return null;
    }

    @Override
    public void create(RendezVous objet) {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            RendezVous rdv = objet;
            session.save(rdv);

            session.getTransaction().commit();
            System.out.println("Objet Rdv ajouté à la db ");
        }

    }

    @Override
    public void update(RendezVous objet) {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();
            session.update(objet);
            session.getTransaction().commit();
            System.out.println("Objet Rdv modifie à la db ");
        }


    }

    @Override
    public void delete(RendezVous objet) {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.remove(objet);
//        em.getTransaction().commit();
//        em.close();
    }

    @Override
    public List<RendezVous> findAll() {
        return   OutilsHibernate.getSession().createQuery("FROM RendezVous", RendezVous.class).list();
    }
}
