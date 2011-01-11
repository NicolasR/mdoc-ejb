package util;

import domain.Contact;

public class AOPclass {
	public void contactCreated(Contact contact) {
		System.out.println("Contact created:");
		System.out.println("firstName: "+contact.getFirstName());
		System.out.println("lastName: "+contact.getLastName());
		System.out.println("END");
	}
}
