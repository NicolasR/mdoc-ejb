<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Your name</title>
</head>
<body>

<%@ include file="auth.jsp"%>
<% if (isAuth(session))
   {
	%><jsp:forward page="accueil.jsp" /><%
   }

%>
<h3>Bonjour, quel est votre nom ?</h3>
<form method="post" action="CheckLogin">Nom: <input type="text"
	name="username" size="25">Mot de passe: <input type="password"
	name="password" size="25">
<p></p>
<input type="submit" value="Valider"> <input type="reset"
	value="Effacer"></form>
</body>
</html>