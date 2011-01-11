<%@page import="ejbsrc.Fonctions" %>
<%@page import="java.util.HashMap" %>
<%@page import="sessionBeans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Supprimer un contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
	<form method="post" action="DeleteContact">
		<%
		
		%>
		<table>
		<thead>
		<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
		</tr>
		</thead>
		<tbody>
		<%
		IGestionEntite entite = Fonctions.getGestionEntiteRemote();
		HashMap<Long, HashMap<Integer, String>> contacts = entite.getAllContacts();
		
		for(Long id : contacts.keySet())
		{
			HashMap<Integer, String> c = contacts.get(id);
			%>
			<tr>
			<td><input type="checkbox" name="<%=id%>" id="<%=id%>" />
			<label for="<%=id%>"><%=id%></label></td>
			<td><%=c.get(IGestionContactRemote.LASTNAME)%></td>
			<td><%=c.get(IGestionContactRemote.FIRSTNAME)%></td>
			</tr>
			<%
		}
		%>
		</tbody>
		</table>
		<%
		%>
	<input type="submit" value="Supprimer contact">
	</form>
</body>
</html>