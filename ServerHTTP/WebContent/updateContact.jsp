<%@page import="dao.DAO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.hibernate.Query"%>
<%@page import="util.HibernateUtil"%>
<%@page import="java.util.List"%>
<%@page import="domain.Contact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<%
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	//Query query = HibernateUtil.currentSession().createQuery("from Contact where"
			//+" lastname='"+lastName+"'"
			//+" and firstname='"+firstName+"'"
	//		+" email='"+email+"'"
	//		+" and id='"+id+"'");
	//@SuppressWarnings(value="unchecked")
	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
	Contact contact = daoContact.find(Long.parseLong(id));
	if (contact != null && contact.getEmail().equals(email))
	{
		//Contact contact = list.get(0);
%>
<form method="post" action="UpdateContact">
Prénom : <input type="text" name="firstName" size="25" <%out.print("value='"+contact.getFirstName()+"'"); %>>
<br />
Nom : <input type="text" name="lastName" size="25" <%out.print("value='"+contact.getLastName()+"'"); %>>
<br />
Email : <input type="text" name="email" size="25" <%out.print("value='"+contact.getEmail()+"'"); %>>
<br />
Id : <input type="text" name="id" size="25" <%out.print("value='"+contact.getId()+"'"); %>>
<br />
<br />
<input type="submit" value="Valider">
</form>
<%	}
	else
	{
	%>
	<h1>Pas de contact avec ces informations</h1>
	<% 
	}%>
</body>
</html>