package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionBeans.IDAOContact;

/**
 * Servlet implementation class DeleteContactControler
 */
public class DeleteContactControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contacts", daoContact.getAll());
		request.getRequestDispatcher("deleteContact.jsp").forward(request, response);
	}

}
