package sessionBeans;

import java.util.Set;

import javax.ejb.Remote;

import common.interfaces.IAddress;

@Remote
public interface IDAOAddress {
	IAddress getNewAddress();
	void create(String street, String city, String zip, String country);
	void update(IAddress address);
	void delete(long id);
	IAddress find(long id);
	Set<IAddress> getAll();
}
