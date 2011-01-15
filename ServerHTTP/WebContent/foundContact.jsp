<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="domain.Contact"%>
<%@page import="dao.DAO"%>
<%@page import="dao.AbstractDAOFactory"%>
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
	//AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);

	//DAO<Contact> daoContact = adf.getDAOContact();
	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
	long id = Long.parseLong(request.getParameter("value"));
	Contact contact = daoContact.find(id);

	if (contact == null) 
	{
		%><h1 style="text-align: center;">Pas de contact avec cet id</h1><%
	} 
	else 
	{
		%>Nom:<%=contact.getLastName()%><br>
		Prenom:<%=contact.getFirstName()%><br>
		email:<%=contact.getEmail()%><br>
		<% String urlargs = "updateContact.jsp?"+
			"id=" + contact.getId() + //"&firstname="+
			//contact.getFirstName() + "&lastname="+
			//contact.getLastName() +
			"&email=" + contact.getEmail();%>
		<a href='<%=urlargs%>'>Modifier</a>
		<%
	}%>
<%@ include file="bottom.jsp" %>
</body>
</html>