package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionBeans.IDAOAddress;
import sessionBeans.IDAOContact;
import sessionBeans.IDAOContactGroup;
import sessionBeans.IDAOEntreprise;
import sessionBeans.IDAOPhoneNumber;

import common.interfaces.IAddress;
import common.interfaces.IContactGroup;
import common.interfaces.IPhoneNumber;

/**
 * Servlet implementation class NewContact
 */
public class NewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="DAOPhoneNumber")
	IDAOPhoneNumber daoPhoneNumber;
	
	@EJB(name="DAOAddress")
	IDAOAddress daoAddress;
	
	@EJB(name="DAOContact")
	IDAOContact daoContact;
	
	@EJB(name="DAOEntreprise")
	IDAOEntreprise daoEntreprise;
	
	@EJB(name="DAOContactGroup")
	IDAOContactGroup daoContactGroup;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewContact() {
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

		/**
		 * Définition de l'adresse
		 */
		IAddress address = daoAddress.getNewAddress();
		address.setCity(request.getParameter("city"));
		address.setStreet(request.getParameter("street"));
		address.setCountry(request.getParameter("country"));
		address.setZip(request.getParameter("zip"));

		/**
		 * Récupération du nom, prénom et email
		 */
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		/**
		 * Définition des numéros de téléphone
		 */
		IPhoneNumber newphoneNumber = daoPhoneNumber.getNewPhoneNumber();
		String phoneKind = request.getParameter("phoneKind");
		String phoneNumber = request.getParameter("phoneNumber");
		newphoneNumber.setPhoneKind(phoneKind);
		newphoneNumber.setPhoneNumber(phoneNumber);
		
		/**
		 * Ajout d'une liste de numéros
		 */
		HashSet<IPhoneNumber> listNumbers = new HashSet<IPhoneNumber>();
		listNumbers.add(newphoneNumber);
		
		String isEntreprise = request.getParameter("isEntreprise");
		String numSiret = request.getParameter("numSiret");
		
		/**
		 * Ajout des groupes associés au contact
		 */
		//DAO<ContactGroup> daoContactGroup = adf.getDAOContactGroup();
		Set<IContactGroup> groups = daoContactGroup.getAll();
		HashSet<IContactGroup> set = new HashSet<IContactGroup>();
		for (IContactGroup group : groups) {
			String groupString = request.getParameter(group.getGroupName());
			if (groupString != null && groupString.equals("on")) {
				set.add(group);
			}
		}
		
		/**
		 * Création du contact
		 */
		if (isEntreprise != null && isEntreprise.equals("on")) {
			daoContact.create(firstName, lastName, email, address, listNumbers, set);
		}
		else
		{
			daoEntreprise.create(firstName, lastName, email, address, listNumbers, set, numSiret);
		}
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
	}

}
