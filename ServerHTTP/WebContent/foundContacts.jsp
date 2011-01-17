<%@page import="common.interfaces.IPhoneNumber"%>
<%@page import="common.interfaces.IAddress"%>
<%@page import="common.interfaces.IContactGroup"%>
<%@page import="java.util.Set"%>
<%@page import="common.interfaces.IContact"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Résultat de la recherche</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<%
List<IContact> list = new ArrayList<IContact>();
String searchType = request.getParameter("searchType");
if (request.getParameter("value").equals("*"))
{
	for(IContact contact : (Set<IContact>)request.getAttribute("contacts"))
	{
		list.add(contact);
	}
}
else if (searchType.equals("byfirstName")) {
	for(IContact contact : (Set<IContact>)request.getAttribute("query1") ) {
			list.add(contact);
	}
}
else if (searchType.equals("bylastName"))
{
	for(IContact contact : (Set<IContact>)request.getAttribute("query2") ) {
			list.add(contact);
	}
}
else if (searchType.equals("bygroup")) {
	String token = request.getParameter("value").toLowerCase();
	for(IContact contact : (Set<IContact>)request.getAttribute("contacts") ) {
		for (IContactGroup group : contact.getGroups()) {
			if (group.getGroupName().toLowerCase().contains(token))
				list.add(contact);
		}
	}
}
if (list.size() == 0)
	out.println("<h1 style='text-align: center;'>Aucun résultat!</h1>");
else
{
	%>
	<div style="text-align: center;">
		<h3><%out.print(list.size()+" résultat(s)");%></h3>
	</div>
	<div id="found" style="text-align: center;">
	<table style="border: solid 1px black; margin: auto;">
		<tr>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Email</td>
			<td>Rue</td>
			<td>Code postale</td>
			<td>Ville</td>
			<td>Pays</td>
			<td>Groupes</td>
			<td>Téléphones</td>
			<td></td>
		</tr>
	<%
	for(IContact contact : list) {
		IAddress address = contact.getAddress();
		%>
		<tr>
			<td><%=contact.getLastName()%></td>
			<td><%=contact.getFirstName()%></td>
			<td><%=contact.getEmail()%></td>
			<td><%=address.getStreet()%></td>
			<td><%=address.getZip()%></td>
			<td><%=address.getCity()%></td>
			<td><%=address.getCountry()%></td>
			<%
			if (contact.getGroups().size()>0)
			{
				%><td><select><%for(IContactGroup group : contact.getGroups()) { %> <option><%=group.getGroupName()%></option> <% } %></select></td><%
			}
			else
			{
				%><td>Aucun</td><%
			}
			%>
			<%
			if (contact.getPhones().size()>0)
			{
				%><td><select><%for(IPhoneNumber phone : contact.getPhones()) { %> <option><%=phone.getPhoneNumber()%></option> <% } %></select></td><%
			}
			else
			{
				%><td>Aucun</td><%
			}
			%>
			<td><%
				String urlargs = "UpdateContactControler?"+
				"id=" + contact.getId();%>
				<a href='<%=urlargs%>'>Modifier</a>
			</td>
		</tr><%
	}
	%>
	</table>
	</div>
	<%
}
%>
<%@ include file="bottom.jsp" %>
</body>
</html>