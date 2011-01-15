package sessionBeans;

import java.util.Set;

import common.interfaces.IAddress;
import common.interfaces.IEntreprise;

import domain.ContactGroup;
import domain.PhoneNumber;

public interface IDAOEntreprise extends IDAOContact{
	IEntreprise getNewEntreprise();
	void create(String firstName, String lastName, String email, IAddress address, Set<PhoneNumber> phones, Set<ContactGroup> groups, String numSiret);
}
