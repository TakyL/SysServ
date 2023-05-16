package com.example.tomcattraining.metiers;

import javax.persistence.*;

import static com.example.tomcattraining.outils.OutilsDatesHeures.*;

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
    private String date_rdv;//Date au format dd/mmmm/yyyy

    @Column(name = "heure")
    private String heure_rdv; //Heure au format RDV

    public RendezVous(String nom_employe, String nom_client, String date_rdv, String heure_rdv) {
        if(Controle(nom_employe,nom_client,date_rdv,heure_rdv))
        {
            this.nom_employe = nom_employe;
            this.nom_client = nom_client;
            this.date_rdv = formateDate(date_rdv);
            this.heure_rdv = heure_rdv;
        }
    }

    public RendezVous()
    {

    }

    /**
     * Vérifie si tout est ok
     * @param nom_employe
     * @param nom_client
     * @param date
     * @param heure
     * @return
     */

    private boolean Controle(String nom_employe,String nom_client,String date,String heure)
    {
       // System.out.println("CHECK"+nom_employe+nom_client+date+heure);
        if(verifieStringNonVide(nom_client,nom_employe,date,heure))
        {
            return VerifieFormatHeure(heure) && isFormatAccepted((date));

        }
        return false;
    }

    @Override
    public String toString() {
        return nom_client+" a rdv avec "+nom_employe+" le "+date_rdv+" à "+ heure_rdv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe = nom_employe;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(String date_rdv) {
        this.date_rdv = date_rdv;
    }

    public String getHeure_rdv() {
        return heure_rdv;
    }

    public void setHeure_rdv(String heure_rdv) {
        this.heure_rdv = heure_rdv;
    }
}
