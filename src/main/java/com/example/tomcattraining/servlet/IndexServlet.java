package com.example.tomcattraining.servlet;


import com.example.tomcattraining.erreur.MessageServeur;
import com.example.tomcattraining.metiers.RendezVous;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;

import jakarta.servlet.http.*;
import com.example.tomcattraining.outilshibernate.QueryRdv;
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


        if(!idrdv.equals("null")) //Cas mise à jour
        {
            RendezVous updateRdv = ajoutRdv;
            updateRdv.setId(Integer.parseInt(idrdv)+1);//Permet d'assurer la recherche de l'id
            boolean etat = new QueryRdv().updateItem(updateRdv);
            if(etat == false)
            {
                //EnvoieMsgErreurJsp(request,response); msg géré par la jsp avec du javascript
            }
             response.sendRedirect("index.jsp");
        }
        else
        {
            if(new QueryRdv().insertItem(ajoutRdv)==false)//Si l'ajout n'est pas réalisé
            {
               // EnvoieMsgErreurJsp(request,response);
            }
            response.sendRedirect("index.jsp");//Si ajout correct alors redirect
        }



    }
    public void destroy() {
    }

    private void EnvoieMsgErreurJsp(HttpServletRequest request,HttpServletResponse response)
    {
        String sendedmsg= MessageServeur.msg;
        request.setAttribute("errormsg",sendedmsg);
        try {
            System.out.println("Envoie du msg cote servlet "+sendedmsg);
            request.getRequestDispatcher("index.jsp").forward(request, response);//Pour affichage dans l'index du msg d'erreur
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}