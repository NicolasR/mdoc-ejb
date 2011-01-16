package sessionBeans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.interfaces.IContact;
import common.interfaces.IPhoneNumber;
import domain.Contact;
import domain.PhoneNumber;

public class DAOPhoneNumber implements IDAOPhoneNumber {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(String phoneKind, String phoneNumber, IContact contact) {
		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		phone.setContact((Contact)contact);
		em.persist(phone);
	}

	@Override
	public void update(IPhoneNumber phoneNumber) {
		em.persist((PhoneNumber)phoneNumber);
	}

	@Override
	public void delete(long id) {
		PhoneNumber phone = (PhoneNumber)find(id);
		em.remove(phone);
	}

	@Override
	public IPhoneNumber find(long id) {
		return (IPhoneNumber)em.find(PhoneNumber.class, id);
	}

	@Override
	public Set<IPhoneNumber> getAll() {
		Query query = em.createQuery("from PhoneNumber");
		Set<IPhoneNumber> listPhoneNumber = new HashSet<IPhoneNumber>();
		for (Object phoneNumber : query.getResultList()) {
			listPhoneNumber.add((IPhoneNumber)phoneNumber);
		}
		return listPhoneNumber;
	}

	@Override
	public IPhoneNumber getNewPhoneNumber() {
		return (IPhoneNumber)new PhoneNumber();
	}

	@Override
	public Set<IPhoneNumber> query(String token) {
		Query query = em.createQuery(token);
		Set<IPhoneNumber> listPhoneNumber = new HashSet<IPhoneNumber>();
		for (Object phoneNumber : query.getResultList()) {
			listPhoneNumber.add((IPhoneNumber)phoneNumber);
		}
		return listPhoneNumber;
	}

}
