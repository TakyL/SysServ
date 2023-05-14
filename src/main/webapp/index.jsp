<%@ page import="java.util.Date" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="tableau.Tableau" %>
<%@ page import="tableau.Bouton" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="personne" scope="request" class="com.example.tomcattraining.beans.Personne" />
<jsp:useBean id="user" scope="request" class="com.example.tomcattraining.metiers.Utilisateur" />
<jsp:useBean id="rdv" scope="request" class="com.example.tomcattraining.beans.Personne" />
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body >
<h1><%= "Hello World!" %>
</h1>

<br/>
<p>
    Date du jour : <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>
        <a href="hello-servlet2" >Vers la Servlet</a>
    <a href="hello-servlet3" >Vers la Servlet REST</a>
<%@include file="html/test.html"%>

<p>nom initial = <jsp:getProperty name="personne" property="nom" /></p>

<jsp:setProperty name="personne" property="nom" value="Adibouh" />
<p>nom mise à jour = <jsp:getProperty name="personne" property="nom" /></p>
<%
    Bouton button = new Bouton("Click me!", "/hello-servlet2");
%>
<form id="myForm" method="POST">
    <input type="hidden" name="buttonAction" value="<%= button.getAction() %>">
</form>

<button onclick="submitForm()"><%= button.getLabel() %></button>

<script>
    function submitForm() {
        document.getElementById("myForm").action = '<%= request.getContextPath() %>' + document.getElementsByName("buttonAction")[0].value;
        document.getElementById("myForm").submit();
    }
</script>
<%
    Tableau table = new Tableau();
    String htmltable = table.AfficherJSP();
%>

<%= htmltable %>

<script>
    function redirectToUrl(url) {
        location.href = url;
    }
</script>
</body>
</html>