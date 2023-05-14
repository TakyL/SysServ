package com.example.tomcattraining.tags;

import com.example.tomcattraining.beans.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;


public class Process {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("testH2");

    public void updatePersonne(Personne p)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();

    }

    public void createPersonne(Personne p)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
    public void deletePersonne(Personne p)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public Personne recherche(Personne p)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Personne psearch = em.find(Personne.class,1);
        em.detach(psearch);
        em.getTransaction().commit();
        if (psearch == null) {
            System.out.println("Personne non trouvée");
        } else{
            System.out.println("Personne.nom=" + psearch.getNom());
        }
        return psearch;
    }

    public void lancement()
    {
        Personne cobaye = new Personne("Fabian","Kasner");
        createPersonne(cobaye);
        cobaye = recherche(cobaye);
        cobaye.setNom("Fabios");
        cobaye.setPrenom("Vendate");
        System.out.println("TEST"+ cobaye);
        updatePersonne(cobaye);
        cobaye = recherche(cobaye);
        System.out.println(cobaye);
    }

    public Process() {
        lancement();
    }
}
