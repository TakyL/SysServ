package com.example.tomcattraining.metiers;

import com.example.tomcattraining.dao.factory.DaoFactory;
import com.example.tomcattraining.metiers.RendezVous;
import jakarta.ws.rs.core.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class TableauView  {

    private TableView<RendezVous> tbl;

    private TableColumn<RendezVous, String> colNomClient = new TableColumn<>();

    private TableColumn<RendezVous, String> colNomEmploye = new TableColumn<>();

    private TableColumn<RendezVous, Date> colDate = new TableColumn<>();

    private TableColumn<RendezVous, String> colHeure = new TableColumn<>();

    public TableView<RendezVous> getTbl() {
        return tbl;
    }

    public TableauView() {
        Chargement();
    }

    private void Chargement()
    {
        colDate.setCellValueFactory(new PropertyValueFactory<RendezVous,Date>("Rendez-Vous"));
        colHeure.setCellValueFactory(new PropertyValueFactory<RendezVous,String>("Heure"));
        colNomClient.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("Client"));
        colNomEmploye.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("Employe"));
        tbl.getColumns().setAll(colDate,colHeure,colNomClient,colNomEmploye);
        tbl.getItems().addAll(DaoFactory.getDAOFactory().getRendezVousDao().findAll());

    }

}
