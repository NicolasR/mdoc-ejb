package sessionBeans;

import java.util.Set;

import javax.ejb.Remote;

import common.interfaces.IContactGroup;

@Remote
public interface IDAOContactGroup {
	void create(String groupName);
	void update(IContactGroup group);
	void delete(long id);
	IContactGroup find(long id);
	Set<IContactGroup> getAll();
}