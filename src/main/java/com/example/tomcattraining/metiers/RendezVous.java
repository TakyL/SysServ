package com.example.tomcattraining.metiers;

import javax.persistence.*;
import java.util.Date;

@Entity//With hibernate
@Table(name = "Rdv")
public class RendezVous {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "employe")
    private String nom_employe;

    @Column(name = "client")
    private String nom_client;

    @Column(name = "date")
    private Date date_rdv;//Date au format dd/mmmm/yyyy

    @Column(name = "heure")
    private String heure_rdv; //Heure au format RDV

    public RendezVous(String nom_employe, String nom_client, Date date_rdv, String heure_rdv) {
        this.nom_employe = nom_employe;
        this.nom_client = nom_client;
        this.date_rdv = date_rdv;
        this.heure_rdv = heure_rdv;
    }

    public RendezVous()
    {

    }

    @Override
    public String toString() {
        return nom_client+" a rdv avec "+nom_employe+" le "+date_rdv+" à "+ heure_rdv;
    }
}
