package sessionBeans;

import java.util.Set;

import javax.ejb.Stateless;

import common.interfaces.IAddress;

@Stateless(mappedName="DAOAddress")
public class DAOAddress implements IDAOAddress {

	@Override
	public void create(String street, String city, String zip, String country) {
	}

	@Override
	public void update(IAddress address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public IAddress find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<IAddress> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
