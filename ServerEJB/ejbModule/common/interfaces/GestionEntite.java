package common.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;

@Stateless(mappedName="GestionEntiteBean")
public class GestionEntite implements IGestionEntite {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public HashMap<Long, HashMap<Integer, String>> getAllContacts() {
		Query query = em.createQuery("from Contact");
		HashMap<Long, HashMap<Integer, String>> result = new HashMap<Long, HashMap<Integer, String>>();
		for(Contact contact : (List<Contact>)query.getResultList()) {
			HashMap<Integer, String> values = new HashMap<Integer, String>();
			values.put(IGestionContactRemote.FIRSTNAME, contact.getFirstName());
			values.put(IGestionContactRemote.LASTNAME, contact.getLastName());
			values.put(IGestionContactRemote.EMAIL, contact.getEmail());
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findPhones(long contactid) {
		Query query = em.createQuery("from PhoneNumber where CONTACT = "+contactid);
		return query.getResultList();
	}
	
	
	@Override
	public HashMap<Long, HashMap<Integer, String>> getAllAddress() {
		Query query = em.createQuery("from Contact");
		HashMap<Long, HashMap<Integer, String>> result = new HashMap<Long, HashMap<Integer, String>>();
		for(Address address : (List<Address>)query.getResultList()) {
			HashMap<Integer, String> values = new HashMap<Integer, String>();
			values.put(IGestionContactRemote.CITY, address.getCity());
			values.put(IGestionContactRemote.COUNTRY, address.getCountry());
			values.put(IGestionContactRemote.STREET, address.getStreet());
			values.put(IGestionContactRemote.ZIP, address.getZip());
			result.put(address.getId(), values);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<String> findAddress(long contactid) {
		Query query = em.createQuery("from Address where CONTACT = "+contactid);
		return query.getResultList();
	}
	
	@Override
	public HashMap<Long, String> getAllContactGroups() {
		Query query = em.createQuery("from Contact");
		HashMap<Long, String> result = new HashMap<Long, String>();
		for(ContactGroup contactgroup : (List<ContactGroup>)query.getResultList()) {
			result.put(contactgroup.getGroupId(), contactgroup.getGroupName());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<String> findContactGroups(long contactid) {
		Query query = em.createQuery("from ContactGroup where CONTACT = "+contactid);
		return query.getResultList();
	}

	@Override
	public HashMap<Integer, String> findContact(long contactid) {
		return em.find(Contact.class, contactid);
	}
	
}
