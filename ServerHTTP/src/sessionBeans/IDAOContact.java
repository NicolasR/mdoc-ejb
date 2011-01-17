package sessionBeans;

import java.util.Set;

import common.interfaces.IAddress;
import common.interfaces.IContact;
import common.interfaces.IContactGroup;
import common.interfaces.IPhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 */
public interface IDAOContact {
	IContact getNewContact();
	void create(String firstName, String lastName, String email, IAddress address, Set<IPhoneNumber> phones, Set<IContactGroup> groups);
	void update(IContact contact);
	void delete(long id);
	IContact find(long id);
	Set<IContact> getAll();
	Set<IContact> query(String token);
}
