package ejbsrc;

import javax.ejb.EJB;

import sessionBeans.IGestionContactRemote;
import sessionBeans.IGestionEntite;


public class Fonctions {
	@EJB(name="GestionContactBean")
	private static IGestionContactRemote gestionContactRemote;
	
	@EJB(name="GestionEntiteBean")
	private static IGestionEntite gestionEntiteRemote;
	
	public static IGestionContactRemote getGestionContactRemote() {
		return gestionContactRemote;
	}
	
	public static IGestionEntite getGestionEntiteRemote() {
		return gestionEntiteRemote;
	}
}
