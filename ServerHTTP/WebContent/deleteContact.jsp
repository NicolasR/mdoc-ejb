<%@page import="common.interfaces.IPhoneNumber"%>
<%@page import="common.interfaces.IContactGroup"%>
<%@page import="java.util.Set"%>
<%@page import="common.interfaces.IContact"%>
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
		
	<div style="text-align: center;">
		<h1>Liste des contacts</h1>
	</div>
	<div id="delete_menu">
		<table style="border: solid 1px black; margin: auto;">
		<thead>
		<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Email</th>
		<th>Adresse</th>
		<th>Groupes</th>
		<th>Téléphones</th>
		</tr>
		</thead>
		<tbody>
		<%
		for(IContact c : (Set<IContact>)request.getAttribute("contacts"))
		{
			%>
			<tr>
			<td><input type="checkbox" name="<%=c.getId()%>" id="<%=c.getId()%>" />
			<label for="<%=c.getId()%>"><%=c.getId()%></label></td>
			<td><%=c.getLastName()%></td>
			<td><%=c.getFirstName()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getAddress().getStreet()%> <%=c.getAddress().getZip()%> <%=c.getAddress().getCity()%> <%=c.getAddress().getCountry()%></td>
			<%
			if (c.getGroups().size()>0)
			{
				%><td><select><%for(IContactGroup group : c.getGroups()) { %> <option><%=group.getGroupName()%></option> <% } %></select></td><%
			}
			else
			{
				%><td>Aucun</td><%
			}
			%>
			<%
			if (c.getPhones().size()>0)
			{
				%><td><select><%for(IPhoneNumber phone : c.getPhones()) { %> <option><%=phone.getPhoneNumber()%></option> <% } %></select></td><%
			}
			else
			{
				%><td>Aucun</td><%
			}
			%>
			</tr>
			<%
		}
		%>
		</tbody>
		</table>
		<input type="submit" value="Supprimer contact" style="margin-top: 20px;">
	</div>
		<%
		%>
	
	</form>
	<%@ include file="bottom.jsp" %>
</body>
</html>