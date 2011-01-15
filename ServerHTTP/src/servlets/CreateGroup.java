package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.interfaces.IContactGroup;

import sessionBeans.IDAOContactGroup;

/**
 * Servlet implementation class CreateGroup
 */
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContactGroup")
	IDAOContactGroup daoContactGroup;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGroup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean needToCreate = true;
		for (IContactGroup group : daoContactGroup.getAll()) {
			if (group.getGroupName().equals(request.getParameter("newGroup")))
			{
				needToCreate = false;
				break;
			}
		}
		if (needToCreate && request.getParameter("newGroup").length()>0)
		{
			daoContactGroup.create(request.getParameter("newGroup"));
		}
		request.getRequestDispatcher("addContact.jsp").forward(request, response);
	}

}
