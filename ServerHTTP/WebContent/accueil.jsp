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
<div id="accueil_menu">
	<div><a href="addContact.jsp">Ajouter un contact</a></div>
	<div><a href="deleteContact.jsp">Supprimer un contact</a></div>
	<div><a href="searchContact.jsp">Chercher un contact</a></div>
</div>
<br />
<a href="logout.jsp">Se déconnecter</a>
</body>
</html>