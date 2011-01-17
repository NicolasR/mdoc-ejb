package sessionBeans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.interfaces.IContact;
import common.interfaces.IContactGroup;
import domain.ContactGroup;

@Stateless(mappedName="DAOContactGroup")
public class DAOContactGroup implements IDAOContactGroup {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(String groupName) {
		ContactGroup contactGroup = new ContactGroup();
		contactGroup.setGroupName(groupName);
		em.persist(contactGroup);
	}

	@Override
	public void update(IContactGroup group) {
		em.persist((ContactGroup)group);
	}

	@Override
	public void delete(long id) {
		ContactGroup contactGroup = (ContactGroup)find(id);
		em.remove(contactGroup);
	}

	@Override
	public IContactGroup find(long id) {
		return (IContactGroup)em.find(ContactGroup.class, id);
	}

	@Override
	public Set<IContactGroup> getAll() {
		Query query = em.createQuery("from ContactGroup");
		Set<IContactGroup> listContactGroup = new HashSet<IContactGroup>();
		for (Object contactGroup : query.getResultList()) {
			listContactGroup.add((IContactGroup)contactGroup);
		}
		return listContactGroup;
	}

	@Override
	public IContactGroup getNewContactGroup() {
		return (IContactGroup)new ContactGroup();
	}

	@Override
	public Set<IContactGroup> query(String token) {
		Query query = em.createQuery(token);
		Set<IContactGroup> listContactGroup = new HashSet<IContactGroup>();
		for (Object contactGroup : query.getResultList()) {
			listContactGroup.add((IContactGroup)contactGroup);
		}
		return listContactGroup;
	}

	

}
