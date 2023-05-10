package com.example.tomcattraining.beans;

import javax.persistence.Column;

public class PersonneRest {

    private int id;

    String nom;

    String prenom;
    int age;

    public PersonneRest(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public PersonneRest(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public PersonneRest()
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
