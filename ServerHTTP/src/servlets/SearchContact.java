package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionBeans.IDAOContact;

import common.interfaces.IContact;

/**
 * Servlet implementation class SearchContact
 */
public class SearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchContact() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("searchType");
		if (value.equals("byid"))
		{
			long id = Long.parseLong(request.getParameter("value"));
			request.setAttribute("contactFound", daoContact.find(id));
			
			request.getRequestDispatcher("foundContact.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("contacts", daoContact.getAll());
			String token = request.getParameter("value").toLowerCase();
			request.setAttribute("query1", daoContact.query("from Contact WHERE firstName LIKE '%"+token+"%'"));
			
			request.setAttribute("query2", daoContact.query("from Contact WHERE lastName LIKE '%"+token+"%'"));
			
			request.getRequestDispatcher("foundContacts.jsp").forward(request, response);
		}
	}

}
