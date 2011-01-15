package sessionBeans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.interfaces.IAddress;
import common.interfaces.IContact;
import common.interfaces.IEntreprise;

import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
import domain.PhoneNumber;

public class DAOEntreprise implements IDAOEntreprise {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public IContact getNewContact() {
		return (IContact)new Entreprise();
	}

	@Override
	public void create(String firstName, String lastName, String email,
			IAddress address, Set<PhoneNumber> phones, Set<ContactGroup> groups) {
		Contact contact = new Entreprise();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setPhones(phones);
		contact.setGroups(groups);
		em.persist(contact);
	}

	@Override
	public void update(IContact contact) {
		em.persist((IContact)contact);
	}

	@Override
	public void delete(long id) {
		Contact contact = (Entreprise)find(id);
		em.remove(contact);
	}

	@Override
	public IContact find(long id) {
		return (IContact)em.find(Entreprise.class, id);
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
	public IEntreprise getNewEntreprise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String firstName, String lastName, String email,
			IAddress address, Set<PhoneNumber> phones,
			Set<ContactGroup> groups, String numSiret) {
		// TODO Auto-generated method stub
		Contact contact = new Entreprise();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setPhones(phones);
		contact.setGroups(groups);
		((Entreprise)contact).setNumSiret(Integer.parseInt(numSiret));
		em.persist(contact);
	}

}
