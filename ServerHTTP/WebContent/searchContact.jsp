<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rechercher un contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<form method="post" action="SearchContact">
	<select name="searchType">
		<option value="byfirstName">Prénom</option>
		<option value="bylastName">Nom</option>
		<option value="byid">Id</option>
	</select>
	<input type="text" name="value" size="25">
<br />
<br />
<input type="submit" value="Rechercher"> <input type="reset" value="Effacer">
</form>
</body>
</html>