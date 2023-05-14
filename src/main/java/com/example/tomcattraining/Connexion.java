package com.example.tomcattraining;

import com.example.tomcattraining.beans.Personne;

import java.sql.*;
import java.util.ArrayList;

public class Connexion {
    private final String url;

    private Connection co = null;
    public void CloseConnexion()
    {
        try {
            this.co.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connexion(String url) {
        this.url = url;
    }



    public void requete() {
        try {
            Class.forName("org.h2.Driver");
            this.co = DriverManager.getConnection(url);
            Init();
            ResultSet résultats = null;
            ArrayList<Personne> list = new ArrayList<>();
            String requete = "SELECT * FROM TPERSONNE";
            try {
                Statement stmt = this.co.createStatement();
                ResultSet resultats = stmt.executeQuery(requete);

                // Loop through the rows in the result set
                while (resultats.next()) {
                    String nom = resultats.getString("NOM");
                    String prenom = resultats.getString("PRENOM");
                    Personne po = new Personne(nom, prenom);
                    list.add(po);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

// Print the arraylist of personnes
           /* for (personne p : list) {
                System.out.println(p.getNom() + " " + p.getPrenom());
            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public ResultSet retournerequete()
    {
        try {
            Class.forName("org.h2.Driver");
            this.co = DriverManager.getConnection(url);
            Init();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        String requete = "SELECT * FROM TPERSONNE";
        Statement stmt = null;
        try {
            stmt = this.co.createStatement();
            ResultSet resultats = stmt.executeQuery(requete);
            return resultats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Personne> renvoielistpersonne()
    {
        ResultSet resultats = retournerequete();
        ArrayList<Personne> list = new ArrayList<>();
        while (true) {
            try {
                if (!resultats.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                String prenom = resultats.getString("PRENOM");
                String nom = resultats.getString("NOM");
                Personne po = new Personne(nom, prenom);
                list.add(po);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


// Print the arraylist of personnes
            for (Personne p : list) {
               // System.out.println(p.getNom() + " " + p.getPrenom());
            }

            return list;
    }

    public void Init()
    {
        Statement stmt = null;
        try {
            stmt = this.co.createStatement();
            //stmt.execute("create table TpersonneNE (NOM VARCHAR2(50), PRENOM VARCHAR2(100), ID INT PRIMARY KEY AUTO_INCREMENT)");

// Insert data into the "TpersonneNE" table
            stmt.execute("INSERT INTO TPERSONNE (NOM, PRENOM) VALUES ('Doe', 'John')");
            stmt.execute("INSERT INTO TPERSONNE (NOM, PRENOM) VALUES ('Smith', 'Jane')");
            stmt.execute("INSERT INTO TPERSONNE (NOM, PRENOM) VALUES ('Williams', 'Bob')");

// Close the connection and statement
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
