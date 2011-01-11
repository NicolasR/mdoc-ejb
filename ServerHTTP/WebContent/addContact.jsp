<%@page import="sessionBeans.IGestionContactRemote" %>
<%@page import="java.util.HashMap" %>
<%@page import="ejbsrc.Fonctions" %>
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
    }
    else
    {
      document.getElementById("siret").style.display = "none";
    }
  }
</script>
<form method="post" action="NewContact">
<fieldset>
Prénom : <input type="text" name="firstName" size="25">
<br />
Nom : <input type="text" name="lastName" size="25">
<br />
Email : <input type="text" name="email" size="25">
</fieldset>
<fieldset>
Rue : <input type="text" name="street" size="25">
<br />
Ville : <input type="text" name="city" size="25">
<br />
Code postale : <input type="text" name="zip" size="25">
<br />
Pays : <input type="text" name="country" size="25">
<br />
</fieldset>
<fieldset>
Type de téléphone : <input type="text" name="phoneKind" size="25">
<br />
Numéro de téléphone : <input type="text" name="phoneNumber" size="25">
<br />
</fieldset>
<fieldset>
Entreprise: <input type="checkbox" id="isEntreprise" name="isEntreprise" onclick="showhidefield()">
</fieldset>
<fieldset id="siret" style="display:none;">
Numéro SIRET: <input type="text" name="numSiret">
</fieldset>
<%
//AbstractDAOFactory adf = AbstractDAOFactory
//	.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
//DAO<ContactGroup> daoContactGroup = adf.getDAOContactGroup();
HashMap<Long, String> groups = Fonctions.getGestionEntiteRemote().getAllContactGroups();
if (groups.size() > 0)
{
	
%>
<fieldset>
Choisissez les groupes :<br />
	<%
	for(String name : groups.values())
	{
		%>
		<input type="checkbox" name="<%=name%>" id="<%=name%>" /> 
		<label for="<%=name%>"><%=name%></label><br />
		<%
	}
%>
</fieldset>
<%
}
%>
<input type="submit" value="Ajouter"> <input type="reset" value="Effacer">
</form>
<form method="post" action="CreateGroup">
<fieldset>
Créer un nouveau groupe : <input type="text" name="newGroup" size="25"> <input type="submit" value="Créer groupe">
</fieldset>
</form>
</body>
</html>