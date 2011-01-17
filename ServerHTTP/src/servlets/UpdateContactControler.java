package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.interfaces.IContact;

import sessionBeans.IDAOContact;

/**
 * Servlet implementation class UpdateContactControler
 */
public class UpdateContactControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactControler() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		IContact contact = daoContact.find(Long.parseLong(id));
		request.setAttribute("email", request.getParameter("email"));
		
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("updateContact.jsp").forward(request, response);
	}

}
