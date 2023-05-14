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

    }

    //Le post pour ajouter
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        //TODO:  vérif si il existe pas déjà et puis push dans la db

        response.sendRedirect("index.jsp");
    }
    public void destroy() {
    }
}