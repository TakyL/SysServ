<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 02/03/2023
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
<%-- Déclaration des variables dans le scriptlet --%>
<% String a = "Bonjour";
  String b=" la ";
  String c=" Licence Pro";
  String s = a + b + c;
%>
 <%= s%>
</p>
</body>
</html>
