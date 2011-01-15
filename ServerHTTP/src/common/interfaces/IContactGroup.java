package common.interfaces;

import java.util.Set;

public interface IContactGroup {
	Long getGroupId();
	String getGroupName();
	Set<IContact> getContacts();
	
	void setGroupId(Long groupId);
	void setGroupName(String gorupName);
	void setContacts(Set<IContact> contacts);
}
