package com.example.tomcattraining.outilshibernate;

import com.example.tomcattraining.metiers.RendezVous;
import com.example.tomcattraining.metiers.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            // create a new user
            Utilisateur user = new Utilisateur("John", "Doe");
            Utilisateur user2 = new Utilisateur("Mary","Sue");
            session.save(user);
            session.save(user2);
            RendezVous rdv = new RendezVous(user.getNom(), user2.getNom(), "10/02/2022","10:10");
            session.save(rdv);
            session.save(new Utilisateur("Mary","Sue5"));
            session.save(new RendezVous(user.getNom(), user.getNom(), "25/02/2022","20:10"));
            // retrieve the user from the database
            Query query = session.createQuery("from Utilisateur where id = :nom");
            Query query1 = session.createQuery("from RendezVous where nom_client = :heure");
            query1.setParameter("heure",user.getNom());
            query.setParameter("nom", 1);
            Utilisateur retrievedUser = (Utilisateur) query.uniqueResult();
            RendezVous rerievedRdv = (RendezVous) query1.uniqueResult();

            System.out.println("Retireved rdv "+ rerievedRdv);

            System.out.println("Retrieved user: " + retrievedUser);
            session.getTransaction().commit();
        }
    }

    public static void RemplitDatabase()
    {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            // create a new user
            Utilisateur user = new Utilisateur("John", "Doe");
            Utilisateur user2 = new Utilisateur("Mary","Sue");
            RendezVous rdv = new RendezVous(user.getNom(), user2.getNom(), "13/10/2010","10:11");
            RendezVous rdv1 = new RendezVous("Bonjour","Bonsoir","10/10/2010","10:25");
            session.save(rdv);
            session.save(rdv1);


            session.getTransaction().commit();
        }
    }
}
