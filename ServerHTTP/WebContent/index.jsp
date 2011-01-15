<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Authentification n&eacute;cessaire</title>
</head>
<body>

<%@ include file="auth.jsp"%>
<% if (isAuth(session))
   {
	%><jsp:forward page="accueil.jsp" /><%
   }

%>
<h3 id="index_titre">Identification</h3>
<div id="login">
	<form method="post" action="CheckLogin">
		<table style="border: 0;">
			<tr>
				<td style="text-align: left;">Nom:</td><td style="text-align: left;"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td style="text-align: left; width: 100px;">Mot de passe:</td><td style="text-align: left;"><input type="password" name="password" style="width: 150px;"></td>
			</tr>
		</table>
	<p></p>
	<input type="submit" value="Valider"> <input type="reset"
		value="Effacer">
	</form>
</div>
</body>
</html>