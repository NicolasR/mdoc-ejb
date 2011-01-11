package common.interfaces;

import javax.ejb.Remote;

import domain.ContactGroup;

@Remote
public interface IDAOContactGroup {
	void create(String groupName);
	void update(String groupName, long id);
	void delete(long id);
	IDAOContactGroup find(long id);
}
