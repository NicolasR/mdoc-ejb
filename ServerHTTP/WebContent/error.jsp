<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
<title>Erreur</title>
</head>
<body>
<%@ page isErrorPage="true"%>
<div style="text-align: center;">
	<h2>Epic Fail!</h2>
	<br />
	<div id="error_desc">
		<%=exception.getMessage() %>
	</div> 
	<a href="accueil.jsp">Accueil</a>
</div>
</body>
</html>