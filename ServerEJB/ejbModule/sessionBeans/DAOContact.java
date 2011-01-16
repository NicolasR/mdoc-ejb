package sessionBeans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.interfaces.IAddress;
import common.interfaces.IContact;
import common.interfaces.IContactGroup;
import common.interfaces.IPhoneNumber;
import domain.Address;
import domain.Contact;

public class DAOContact implements IDAOContact {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(String firstName, String lastName, String email,
			IAddress address, Set<IPhoneNumber> phones, Set<IContactGroup> groups) {
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setAddress((Address)address);
		contact.setPhones(phones);
		contact.setGroups(groups);
		em.persist(contact);
	}

	@Override
	public void update(IContact contact) {
		em.persist((Contact)contact);
	}

	@Override
	public void delete(long id) {
		Contact contact = (Contact)find(id);
		em.remove(contact);
	}

	@Override
	public IContact find(long id) {
		return (IContact)em.find(Contact.class, id);
	}

	@Override
	public Set<IContact> getAll() {
		Query query = em.createQuery("from Contact");
		Set<IContact> listContact = new HashSet<IContact>();
		for (Object contact : query.getResultList()) {
			listContact.add((IContact)contact);
		}
		return listContact;
	}

	@Override
	public IContact getNewContact() {
		return (IContact)new Contact();
	}
	
	public Set<IContact> query(String token) {
		Query query = em.createQuery(token);
		Set<IContact> listContact = new HashSet<IContact>();
		for (Object contact : query.getResultList()) {
			listContact.add((IContact)contact);
		}
		return listContact;
	}
	
}
