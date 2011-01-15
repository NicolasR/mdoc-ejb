package sessionBeans;

import java.util.Set;

import common.interfaces.IAddress;
import common.interfaces.IContactGroup;
import common.interfaces.IEntreprise;
import common.interfaces.IPhoneNumber;

public interface IDAOEntreprise extends IDAOContact{
	IEntreprise getNewEntreprise();
	void create(String firstName, String lastName, String email, IAddress address, Set<IPhoneNumber> phones, Set<IContactGroup> groups, String numSiret);
}
