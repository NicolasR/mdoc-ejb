<%@page import="common.interfaces.IContact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résultat de la recherche</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<%
	IContact contact = (IContact)request.getAttribute("contactFound");
	if (contact == null) 
	{
		%><h1 style="text-align: center;">Pas de contact avec cet id</h1><%
	} 
	else 
	{
		%>Nom:<%=contact.getLastName()%><br>
		Prenom:<%=contact.getFirstName()%><br>
		email:<%=contact.getEmail()%><br>
		<% String urlargs = "UpdateContactControler?"+
			"id=" + contact.getId();%>
		<a href='<%=urlargs%>'>Modifier</a>
		<%
	}%>
<%@ include file="bottom.jsp" %>
</body>
</html>