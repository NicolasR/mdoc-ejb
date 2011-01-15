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
 * Servlet implementation class deleteContact
 */
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteContact() {
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
		
		for (IContact c : daoContact.getAll()) {
			String s = request.getParameter(c.getId().toString());
			if (s != null && s.equals("on")) {
				//long addressId = c.getAddress().getId();
				c.setAddress(null);
				//List<Contact> list = daoContact.query("from Contact where address="+addressId);
				//if (list.size() == 1)
					//daoAddress.delete(addressId);
				daoContact.delete(c.getId());
			}
		}
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
	}

}
