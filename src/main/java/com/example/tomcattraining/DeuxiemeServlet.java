package com.example.tomcattraining;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "hello-servlet3", value = "/hello-servlet3")
public class DeuxiemeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();

        // ArrayList<Personne> a =  test();


        out.println("<html><body>");

        out.println("<div>La servlet rest fonctionne</div>");
        out.println("</body></html>");

    }

    public void CreationDb()
    {
        String url="jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1;INIT=create table TPERSONNE (NOM VARCHAR2(50), PRENOM VARCHAR2(100), ID INT PRIMARY KEY AUTO_INCREMENT);";
        Connexion a = new Connexion(url);
        out.println("DB Crée");
    }
}
