package sessionBeans;

import java.util.Set;

import javax.ejb.Remote;

import common.interfaces.IAddress;
import common.interfaces.IContact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 */
@Remote
public interface IDAOContact {
	void create(String firstName, String lastName, String email, IAddress address, Set<PhoneNumber> phones, Set<ContactGroup> groups);
	void create(String firstName, String lastName, String email, IAddress address, Set<PhoneNumber> phones, Set<ContactGroup> groups, String numSiret);
	void update(IContact contact);
	void delete(long id);
	IContact find(long id);
	Set<IContact> getAll();
}
