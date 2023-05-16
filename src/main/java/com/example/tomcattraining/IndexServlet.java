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

        System.out.println("Valeur saisie : "+nomclient+"/"+nomemploye+"/"+rdvdate+"/"+heure);
        RendezVous ajoutRdv = new RendezVous(nomemploye,nomclient,rdvdate,heure);
        System.out.println("Rdv crée : "+ajoutRdv);
        new QueryRdv().insertItem(ajoutRdv);

        response.sendRedirect("index.jsp");
    }
    public void destroy() {
    }
}