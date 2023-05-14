package com.example.tomcattraining.dao.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.tomcattraining.dao.RendezVousDao;
import com.example.tomcattraining.metiers.RendezVous;

public class H2RendezVousFactory extends RendezVousDao {

    private static H2RendezVousFactory instance;

    private List<RendezVous> data;

    public static H2RendezVousFactory getInstance() {

        if (instance == null) {
            instance = new H2RendezVousFactory();
        }

        return instance;
    }

    private H2RendezVousFactory() {

        this.data = new ArrayList<RendezVous>();

      //  this.donnees.add(new Periodicite(1, "Mensuel"));
      //  this.donnees.add(new Periodicite(2, "Quotidien"));
            //Chargement des données via la database
    }

    @Override
    public RendezVous getById(int id) {
        return super.getById(id);
    }

    @Override
    public boolean create(RendezVous objet) {
        return super.create(objet);
    }

    @Override
    public boolean update(RendezVous objet) {
        return super.update(objet);
    }

    @Override
    public boolean delete(RendezVous objet) {
        return super.delete(objet);
    }

    @Override
    public ArrayList<RendezVous> findAll() {
        return (ArrayList<RendezVous>) this.data;
    }
}
