package common.interfaces;

import java.util.Set;

import common.interfaces.IAddress;
import common.interfaces.IContactGroup;
import common.interfaces.IPhoneNumber;

public interface IContact {
	Long getId();
	String getFirstName();
	String getLastName();
	String getEmail();
	Set<IPhoneNumber> getPhones();
	Set<IContactGroup> getGroups();
	IAddress getAddress();
	
	void setId(Long id);
	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setEmail(String email);
	void setPhones(Set<IPhoneNumber> phones);
	void setGroups(Set<IContactGroup> groups);
	void setAddress(IAddress address);
}
