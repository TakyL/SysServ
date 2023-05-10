package com.example.tomcattraining.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity//With hibernate
@Table(name = "Personnes")
public class Personne implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne()
    {

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
