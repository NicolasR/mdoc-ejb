package sessionBeans;

import java.util.Set;

import common.interfaces.IAddress;

public interface IDAOAddress {
	IAddress getNewAddress();
	void create(String street, String city, String zip, String country);
	void update(IAddress address);
	void delete(long id);
	IAddress find(long id);
	Set<IAddress> getAll();
	Set<IAddress> query(String token);
}
