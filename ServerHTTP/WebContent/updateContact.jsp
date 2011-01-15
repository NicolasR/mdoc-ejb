<%@page import="domain.Address"%>
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
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
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
		Address address = contact.getAddress();
		//Contact contact = list.get(0);
%>
<form method="post" action="UpdateContact">
<div style="text-align: center;">
	<h1>Modifier un contact</h1>
</div>
<div style="text-align: center;">
	
	<table style="border: solid 1px black; margin: auto;">
		<tr>
			<td>Prénom :</td><td><input type="text" name="firstName" size="25" <%out.print("value='"+contact.getFirstName()+"'"); %>></td>
		</tr>
		<tr>
			<td>Nom :</td><td><input type="text" name="lastName" size="25" <%out.print("value='"+contact.getLastName()+"'"); %>></td>
		</tr>
		<tr>
			<td>Email :</td><td><input type="text" name="email" size="25" <%out.print("value='"+contact.getEmail()+"'"); %>></td>
		</tr>
		<tr>
			<td>Rue :</td><td><input type="text" name="street" size="25" <%out.print("value='"+address.getStreet()+"'"); %>></td>
		</tr>
		<tr>
			<td>Code Postal :</td><td><input type="text" name="zip" size="25" <%out.print("value='"+address.getZip()+"'"); %>></td>
		</tr>
		<tr>
			<td>Ville :</td><td><input type="text" name="city" size="25" <%out.print("value='"+address.getCity()+"'"); %>></td>
		</tr>
		<tr>
			<td>Pays :</td><td><input type="text" name="country" size="25" <%out.print("value='"+address.getCountry()+"'"); %>></td>
		</tr>
		<tr>
		<td>Ajouter un téléphone :</td>
		<td>
			<table>
				<tr>
				<td>Type :</td><td><input type="text" name="phoneKind" size="25"></td>
				</tr>
				<tr>
				<td>Numero :</td><td><input type="text" name="phoneNumber" size="25"></td>
				</tr>
			</table>
		</td>
		</tr>
		<tr>
			<td>Id :</td><td><%=contact.getId() %><input type="hidden" name="id" value="<%=contact.getId() %>"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Valider"></td>
		</tr>
	</table>
<%	}
	else
	{
	%>
	<h1>Pas de contact avec ces informations</h1>
	<% 
	}%>
</div>
</form>
<%@ include file="bottom.jsp" %>
</body>
</html>