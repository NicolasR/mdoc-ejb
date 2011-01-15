<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="domain.ContactGroup"%>
<%@page import="dao.DAO"%>
<%@page import="dao.AbstractDAOFactory"%>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Ajouter un contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<script language="JavaScript">
  function showhidefield()
  {
    if (document.getElementById("isEntreprise").checked)
    {
      document.getElementById("siret").style.display = "block";
      document.getElementById("siretsecond").style.display = "block";
    }
    else
    {
      document.getElementById("siret").style.display = "none";
      document.getElementById("siretsecond").style.display = "none";
    }
  }
</script>
<div style="text-align: center;">
	<h1>Ajouter un contact</h1>
</div>
<div style="text-align: center;">
	<form method="post" action="NewContact">
		<table id="addContact_menu" style="margin: auto;">
			<tr><td colspan="2" style="padding-top: 20px; padding-bottom: 15px; font-weight: bold;">Information du contact</td></tr>
			<tr><td>Prénom :</td><td><input type="text" name="firstName" size="25"></td></tr>
			<tr><td>Nom :</td><td><input type="text" name="lastName" size="25"></td></tr>
			<tr><td>Email :</td><td><input type="text" name="email" size="25"></td></tr>
			<tr><td colspan="2" style="padding-top: 20px; padding-bottom: 15px; font-weight: bold;">Addresse</td></tr>
			<tr><td>Rue :</td><td><input type="text" name="street" size="25"></td></tr>
			<tr><td>Ville :</td><td><input type="text" name="city" size="25"></td></tr>
			<tr><td>Code postale :</td><td><input type="text" name="zip" size="25"></td></tr>
			<tr><td>Pays :</td><td><input type="text" name="country" size="25"></td></tr>
			<tr><td colspan="2" style="padding-top: 20px; padding-bottom: 15px; font-weight: bold;">Téléphone</td></tr>
			<tr><td>Type de téléphone :</td><td><input type="text" name="phoneKind" size="25"></td></tr>
			<tr><td>Numéro de téléphone :</td><td><input type="text" name="phoneNumber" size="25"></td></tr>
			<tr><td>Entreprise:</td><td><input type="checkbox" id="isEntreprise" name="isEntreprise" onclick="showhidefield()" size="25"></td></tr>
			<tr><td id="siret" style="display:none;">Numéro SIRET:</td><td id="siretsecond" style="display:none;"><input type="text" name="numSiret"></td></tr>
			<%
			//AbstractDAOFactory adf = AbstractDAOFactory
			//	.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
			//DAO<ContactGroup> daoContactGroup = adf.getDAOContactGroup();
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			DAO<ContactGroup> daoContactGroup = (DAO<ContactGroup>)context.getBean("DAOContactGroup");
			if (daoContactGroup.getAll().size() > 0)
			{
				
			%>
			<tr><td colspan="2" style="padding-top: 20px; padding-bottom: 15px; font-weight: bold;">Choisissez les groupes :</td></tr>
				<%
				for(ContactGroup group : daoContactGroup.getAll())
				{
					%>
					<tr>
						<td colspan="2" >
							<input type="checkbox" name="<%=group.getGroupName()%>" id="<%=group.getGroupName()%>" /> 
							<label for="<%=group.getGroupName()%>"><%=group.getGroupName()%></label><br />
						</td>
					</tr>
					<%
				}
			%>
			<%
			}
			%>
			<tr><td colspan="2" style="padding-bottom: 50px;"><input type="submit" value="Ajouter" style="margin-right: 5px;"><input type="reset" value="Effacer"></td></tr>
	</form>
	<form method="post" action="CreateGroup">
		<tr>
			<td style="font-weight: bold;">Créer un nouveau groupe :</td>
			<td><input type="text" name="newGroup" size="25"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Créer groupe"></td>
		</tr>
	</form>
	</table>
	</form>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>