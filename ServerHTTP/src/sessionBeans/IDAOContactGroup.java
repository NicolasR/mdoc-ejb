package sessionBeans;

import java.util.Set;

import common.interfaces.IContactGroup;

public interface IDAOContactGroup {
	IContactGroup getNewContactGroup();
	void create(String groupName);
	void update(IContactGroup group);
	void delete(long id);
	IContactGroup find(long id);
	Set<IContactGroup> getAll();
	Set<IContactGroup> query(String token);
}
