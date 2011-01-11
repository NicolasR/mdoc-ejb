<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Accueil</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<h1>Bienvenue <%= (String)session.getAttribute("userName") %></h1>
<br />
<h2>Quelques liens :</h2>
<a href="addContact.jsp">Ajouter un contact</a>
<br />
<a href="deleteContact.jsp">Supprimer un contact</a>
<br />
<a href="searchContact.jsp">Chercher un contact</a>
<br />
<a href="logout.jsp">Se déconnecter</a>
<br />
<a href="test">TEST</a>
</body>
</html>