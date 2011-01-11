<%!	boolean isAuth(HttpSession session) {
		if (session != null)
		{
			Boolean isAuth = (Boolean)session.getAttribute("isAuth");
			if (isAuth != null)
				return true;
		}
		return false;
	}
%>