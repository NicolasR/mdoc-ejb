<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Rechercher un contact</title>
</head>
<body>
<%@ include file="checkLoginOK.jsp" %>
<div style="text-align: center;">
	<h1>Rechercher un contact</h1>
</div>
<div style="text-align: center;">

	<table id="search_menu" style="margin: auto;">
		<form method="post" action="SearchContact">
			<tr>
				<td>
					<select name="searchType">
						<option value="byfirstName">Prénom</option>
						<option value="bylastName">Nom</option>
						<option value="byid">Id</option>
						<option value="bygroup">Groupe</option>
					</select>
				</td>
				<td><input type="text" name="value" size="25"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Rechercher"> <input type="reset" value="Effacer"></td>
			</tr>
		</form>
	</table>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>