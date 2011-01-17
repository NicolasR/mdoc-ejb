package sessionBeans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.interfaces.IAddress;

import domain.Address;

@Stateless(mappedName="DAOAddress")
public class DAOAddress implements IDAOAddress {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(String street, String city, String zip, String country) {
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		em.persist(address);
	}

	@Override
	public void update(IAddress address) {
		// TODO Auto-generated method stub
		em.persist(address);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Address address = (Address)find(id);
		em.remove(address);
	}

	@Override
	public IAddress find(long id) {
		return (IAddress)em.find(Address.class, id);
	}

	@Override
	public Set<IAddress> getAll() {
		Query query = em.createQuery("from Address");
		Set<IAddress> listAddress = new HashSet<IAddress>();
		for (Object address : query.getResultList()) {
			listAddress.add((IAddress)address);
		}
		return listAddress;
	}

	@Override
	public IAddress getNewAddress() {
		// TODO Auto-generated method stub
		return (IAddress)new Address();
	}

	@Override
	public Set<IAddress> query(String token) {
		Query query = em.createQuery(token);
		Set<IAddress> listAddress = new HashSet<IAddress>();
		for (Object address : query.getResultList()) {
			listAddress.add((IAddress)address);
		}
		return listAddress;
	}

}
