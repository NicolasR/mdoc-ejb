package sessionBeans;

import java.util.Set;

import javax.ejb.Remote;

import common.interfaces.IAddress;
import common.interfaces.IContact;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 */
@Remote
public interface IDAOContact {
	void create(String firstName, String lastName, String email, IAddress address);
	void create(String firstName, String lastName, String email, IAddress address, String numSiret);
	void update(IContact contact);
	void delete(long id);
	IContact find(long id);
	Set<IContact> getAll();
}
