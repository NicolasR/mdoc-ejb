<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
<% response.setContentType("text/html");
		
		if( request.getParameter("username").equals(request.getParameter("password")) )
		{%>
Hello M.
<%=request.getParameter("username")%>
<jsp:forward page="accueil.jsp" />
<% 		}
		else
		{
		%>
			<jsp:forward page="index.jsp" />
		<%
		}%>
</body>
</html>