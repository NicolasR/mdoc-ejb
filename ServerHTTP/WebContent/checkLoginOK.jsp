<%@ include file="auth.jsp" %>
<% if (!isAuth(session))
   {
	%><jsp:forward page="index.jsp" /><%
   }
%>