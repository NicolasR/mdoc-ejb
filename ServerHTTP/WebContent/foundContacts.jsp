<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="domain.Contact"%>
<%@page import="domain.ContactGroup"%>
<%@page import="dao.DAO"%>
<%@page import="dao.AbstractDAOFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de la recherche</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<% 
//AbstractDAOFactory adf = AbstractDAOFactory
//.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);

//DAO<Contact> daoContact = adf.getDAOContact();
ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
List<Contact> list = new ArrayList<Contact>();
String searchType = request.getParameter("searchType");
if (searchType.equals("byfirstName") || searchType.equals("bylastName")) {
	String token = request.getParameter("value").toLowerCase();
	for(Contact contact : daoContact.getAll()) {
		if (contact.getFirstName().toLowerCase().contains(token))
			list.add(contact);
	}
}
else if (searchType.equals("bygroup")) {
	String token = request.getParameter("value").toLowerCase();
	for(Contact contact : daoContact.getAll()) {
		for (ContactGroup group : contact.getGroups()) {
			if (group.getGroupName().toLowerCase().contains(token))
				list.add(contact);
		}
	}
}
if (list.size() == 0)
	out.println("<h1>Aucun résultat!</h1>");
else
{
	out.println(list.size()+" résultat(s)");
	out.println("<table border='1'>");
	out.println("<tr>");
	out.print("<td>Nom</td>");
	out.print("<td>Prénom</td>");
	out.print("<td>Email</td>");
	out.print("<td></td>");
	out.println("</tr>");
	for(Contact contact : list) {
		out.println("<tr>");
		out.print("<td>"+contact.getLastName()+"</td>");
		out.print("<td>"+contact.getFirstName()+"</td>");
		out.print("<td>"+contact.getEmail()+"</td>");
		out.print("<td>");
		String urlargs = "updateContact.jsp?"+
		"id=" + contact.getId() + //"&firstname="+
		//contact.getFirstName() + "&lastname="+
		//contact.getLastName() + 
		"&email=" + contact.getEmail();
		out.print("<a href='"+urlargs+"'>Modifier</a>");
		out.println("</tr>");
	}
	out.println("</table>");
}
%>
</body>
</html>