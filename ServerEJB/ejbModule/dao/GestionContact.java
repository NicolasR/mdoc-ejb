package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
import domain.PhoneNumber;

@Stateless(mappedName="GestionContactBean")
public class GestionContact implements IGestionContactRemote{
	
	@PersistenceContext
	EntityManager em;
	
	private Contact contact;
	private Address address;
	private ContactGroup contactgroup;
	private Set<PhoneNumber> phones;
	
	public GestionContact() {
		phones = new HashSet<PhoneNumber>();
	}
	public void saveContact() {
		em.persist(contact);
	}
	
	private void delete(Object obj) {
		em.remove(obj);
	}
	
	public void createContact(String firstName, String lastName, String email) {
		contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		//save(contact);
	}
	
	public void createEntreprise(String firstName, String lastName, String email, int numsiret) {
		Entreprise entreprise = new Entreprise();
		entreprise.setFirstName(firstName);
		entreprise.setLastName(lastName);
		entreprise.setEmail(email);
		entreprise.setNumSiret(numsiret);
		contact = entreprise;
		//save(contact);
	}
	
	public void setAddress(String street, String city, String zip, String country) {
		address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
	}
	
	public void setContactGroup(String name) {
		contactgroup = new ContactGroup();
		contactgroup.setGroupName(name);
	}
	
	public void addPhoneNumber(String phoneKind, String phoneNumber) {
		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		phones.add(phone);
	}
	
	public void update(int token, List<String> value, long id) {
		contact = em.find(Contact.class, id);
		address = contact.getAddress();
		boolean update = true;
		switch(token) {
			case FIRSTNAME:
				contact.setFirstName(value.get(0));
				break;
			case LASTNAME:
				contact.setLastName(value.get(0));
				break;
			case EMAIL:
				contact.setEmail(value.get(0));
				break;
			case NUMSIRET:
				((Entreprise)contact).setNumSiret(Integer.parseInt(value.get(0)));
				break;
			case STREET:
				address.setStreet(value.get(0));
				break;
			case CITY:
				address.setCity(value.get(0));
				break;
			case ZIP:
				address.setZip(value.get(0));
				break;
			case COUNTRY:
				address.setCountry(value.get(0));
				break;
			case PHONE:
				PhoneNumber phone = new PhoneNumber();
				phone.setPhoneKind(value.get(0));
				phone.setPhoneNumber(value.get(1));
				break;
			default:
				update=false;
		}
		if (update) {
			contact.setAddress(address);
			contact.setPhones(phones);
			saveContact();
		}
	}
	
	public List<String> get(int token, String item, long id) {
		contact = em.find(Contact.class, id);
		address = contact.getAddress();
		List<String> values = new ArrayList<String>();
		switch(token) {
			case FIRSTNAME:
				values.add(contact.getFirstName());
				break;

			case LASTNAME:
				values.add(contact.getLastName());
				break;
				
			case EMAIL:
				values.add(contact.getEmail());
				break;

			case NUMSIRET:
				values.add(((Entreprise)contact).getNumSiret().toString());
				break;

			case STREET:
				values.add(address.getStreet());
				break;

			case CITY:
				values.add(address.getCity());
				break;

			case ZIP:
				values.add(address.getZip());
				break;
				
			case COUNTRY:
				values.add(address.getCountry());
				break;

			default:
				return null;
		}
		return values;
	}
	
	public void deleteContact(long id) {
		contact = em.find(Contact.class, id);
		address = contact.getAddress();
		delete(contact);
		contact = null;
		address = null;
	}
	
	
}
