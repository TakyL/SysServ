package com.example.tomcattraining;


import com.example.tomcattraining.beans.Personne;
import com.example.tomcattraining.tags.Process;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.http.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "hello-servlet2", value = "/hello-servlet2")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();

      // ArrayList<Personne> a =  test();

        // Log a message using the LoggingListener
        context.log("HelloServlet: doGet method called");

    InitProcess();
        // Hello

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
       /* for (Personne p : a) {
            out.println(p.getNom() + " " + p.getPrenom());
        }*/
        out.println("<div>La servlet fonctionne</div>");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>OK CA MARCHE</h1>");
       /* for (Personne p : a) {
            out.println(p.getNom() + " " + p.getPrenom());
        }*/
        out.println("<div>La servlet fonctionne</div>");
        out.println("</body></html>");
    }
    public void destroy() {
    }


    public ArrayList<Personne> test()
    {
        String url="jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1;INIT=create table TPERSONNE (NOM VARCHAR2(50), PRENOM VARCHAR2(100), ID INT PRIMARY KEY AUTO_INCREMENT);";
        Connexion a = new Connexion(url);
       return  a.renvoielistpersonne();
    }

    public void InitProcess()
    {

        Process p = new Process();
    }
}