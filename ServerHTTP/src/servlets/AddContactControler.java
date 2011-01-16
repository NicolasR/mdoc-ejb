package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionBeans.IDAOContactGroup;

/**
 * Servlet implementation class AddContactControler
 */
public class AddContactControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContactGroup")
	IDAOContactGroup daoContactGroup;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactControler() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("groups", daoContactGroup.getAll());
		request.getRequestDispatcher("addContact.jsp").forward(request, response);
	}

}
