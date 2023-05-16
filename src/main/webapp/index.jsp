<%@ page import="java.util.Date" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="tableau.Tableau" %>
<%@ page import="tableau.Bouton" %>

<%@ page import="com.example.tomcattraining.metiers.RendezVous" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.swing.table.DefaultTableModel" %>
<%@ page import="static outilshibernate.Main.RemplitDatabase" %>
<%@ page import="outilshibernate.QueryRdv" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="personne" scope="request" class="com.example.tomcattraining.beans.Personne" />
<jsp:useBean id="user" scope="request" class="com.example.tomcattraining.metiers.Utilisateur" />
<jsp:useBean id="rdv" scope="request" class="com.example.tomcattraining.metiers.RendezVous" />

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body >
<h1><%= "Annuaire " %>
</h1>

<br/>
<p>
    Date du jour : <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>
        <a href="hello-servlet2" >Vers la Servlet</a>

<p>nom initial = <jsp:getProperty name="personne" property="nom" /></p>

<jsp:setProperty name="personne" property="nom" value="Adibouh" />
<p>nom mise à jour = <jsp:getProperty name="personne" property="nom" /></p>

<%
    Bouton button = new Bouton("Ajouter un RDV", "/hello-servlet2");
%>
<form id="myForm" method="POST">
    <%@include file="html/formajouter.html"%>
    <input type="hidden" name="buttonAction" value="<%= button.getAction() %>">
</form>

<button onclick="submitForm()"><%= button.getLabel() %></button>


<%
    if (application.getAttribute("dataAdded") == null) {
        RemplitDatabase();
        application.setAttribute("dataAdded", true);
    }

    DefaultTableModel model = new DefaultTableModel(new Object[][] {},
            new String[] { "Date ", "Heure", "Client", "Employé" });


        // fetch all RendezVous objects from the database
        List<RendezVous> rendezVousList = new QueryRdv().findAllElmt();

        // iterate over the list of RendezVous objects and add them to the table model
        for (RendezVous rendezVous : rendezVousList) {
            Object[] rowData = { rendezVous.getDate_rdv(), rendezVous.getHeure_rdv(), rendezVous.getNom_client(), rendezVous.getNom_employe() };
            model.addRow(rowData);
        }


    Tableau table = new Tableau(model);
    String htmltable = table.AfficherJSP();
%>

<%= htmltable %>

</body>
</html>