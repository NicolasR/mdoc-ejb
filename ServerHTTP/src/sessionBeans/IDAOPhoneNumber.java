package sessionBeans;

import java.util.Set;

import common.interfaces.IContact;
import common.interfaces.IPhoneNumber;

public interface IDAOPhoneNumber {
	IPhoneNumber getNewPhoneNumber();
	void create(String phoneKind, String phoneNumber, IContact contact);
	void update(IPhoneNumber phoneNumber);
	void delete(long id);
	IPhoneNumber find(long id);
	Set<IPhoneNumber> getAll();
}
