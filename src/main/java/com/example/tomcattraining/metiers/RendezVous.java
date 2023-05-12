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

}
