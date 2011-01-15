package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;
	
	@EJB(name="DAOPhoneNumber")
	IDAOPhoneNumber daoPhoneNumber;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContact() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  
	      String firstName = request.getParameter("firstName");
	      String lastName = request.getParameter("lastName");
	      String email = request.getParameter("email");
	      String id = request.getParameter("id");
	      String street = request.getParameter("street");
	      String zip = request.getParameter("zip");
	      String city = request.getParameter("city");
	      String country = request.getParameter("country");
	      IContact contact = daoContact.find(Long.parseLong(id));
	      contact.setFirstName(firstName);
	      contact.setLastName(lastName);
	      contact.setEmail(email);
	      contact.getAddress().setStreet(street);
	      contact.getAddress().setZip(zip);
	      contact.getAddress().setCity(city);
	      contact.getAddress().setCountry(country);
	      
	      if (!request.getParameter("phoneKind").equals("") && !request.getParameter("phoneNumber").equals(""))
	      {
	    	  String phoneKind = request.getParameter("phoneKind");
		      String phoneNumber = request.getParameter("phoneNumber");
		      IPhoneNumber pn = daoPhoneNumber.getNewPhoneNumber();
		      pn.setPhoneKind(phoneKind);
		      pn.setPhoneNumber(phoneNumber);
		      pn.setContact(contact);
		      
		      contact.getPhones().add(pn);
	      }
	      
	      daoContact.update(contact);
		}
	      request.getRequestDispatcher("accueil.jsp").forward(request, response);
	}

}
