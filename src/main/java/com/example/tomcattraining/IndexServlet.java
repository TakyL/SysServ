package com.example.tomcattraining;


import com.example.tomcattraining.metiers.RendezVous;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;

import jakarta.servlet.http.*;
import outilshibernate.QueryRdv;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "hello-servlet2", value = "/hello-servlet2")
public class IndexServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    //Le post pour ajouter
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String nomclient = request.getParameter("nom_cl");
        String nomemploye = request.getParameter("nom_emp");
        String rdvdate = request.getParameter("rdvdate");
        String heure = request.getParameter("heurerdv");
        String idrdv =request.getParameter("idrdv");

        System.out.println("Valeur saisie : "+nomclient+"/"+nomemploye+"/"+rdvdate+"/"+heure+"/"+idrdv);
        RendezVous ajoutRdv = new RendezVous(nomemploye,nomclient,rdvdate,heure);
        System.out.println("Rdv crée : "+ajoutRdv);
        response.sendRedirect("index.jsp");

        if(!idrdv.equals("null")) //Cas mise à jour
        {
            RendezVous updateRdv = ajoutRdv;
            updateRdv.setId(Integer.parseInt(idrdv)+1);//Permet d'assurer la recherche de l'id
            new QueryRdv().updateItem(updateRdv);
        }
        else
        {
            if(new QueryRdv().insertItem(ajoutRdv)==false)//Si l'ajout n'est pas réalisé
            {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to add rendezvous");
            }
        }



    }
    public void destroy() {
    }
}