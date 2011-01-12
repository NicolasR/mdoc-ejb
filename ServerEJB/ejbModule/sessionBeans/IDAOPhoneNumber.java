package sessionBeans;

import java.util.Set;

import javax.ejb.Remote;

import common.interfaces.IContact;
import common.interfaces.IPhoneNumber;

@Remote
public interface IDAOPhoneNumber {
	void create(String phoneKind, String phoneNumber, IContact contact);
	void update(IPhoneNumber phoneNumber);
	void delete(long id);
	IPhoneNumber find(long id);
	Set<IPhoneNumber> getAll();
}
