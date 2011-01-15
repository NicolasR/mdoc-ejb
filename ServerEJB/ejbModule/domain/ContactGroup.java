package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import common.interfaces.IContact;
import common.interfaces.IContactGroup;

@Entity
public class ContactGroup implements IContactGroup{
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private Long groupId;
	private String groupName;
	private Set<Contact> contacts;
	
	
	public ContactGroup() {
	}
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<IContact> getContacts() {
		Set<IContact> list = new HashSet<IContact>();
		for (Contact contact : contacts) {
			list.add((IContact)contact);
		}
		return list;
	}
	
	public void setContacts(Set<IContact> contacts) {
		if (this.contacts == null)
			this.contacts = new HashSet<Contact>();
		for (IContact contact : contacts) {
			this.contacts.add((Contact)contact);
		}
	}
	
}
