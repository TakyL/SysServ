<%@ page import="java.util.Date" %>
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
    <title>JSP - Annuaire</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <link href="css/miseenforme.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>


</head>
<body >
<h1><%= "Annuaire " %></h1>

<br/>
<p>
    Date du jour : <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>

<%
    Bouton button = new Bouton("Ajouter un RDV", "/hello-servlet2");
%>
<form id="myForm" method="POST" class="styleform">
    <%@include file="html/formajouter.html"%>
    <input type="hidden" name="buttonAction" value="<%= button.getAction() %>">
</form>
<div class="stylebtn">
<button onclick="submitForm()" style="text-align: center"><%= button.getLabel() %></button>
</div>

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