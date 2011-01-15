package common.interfaces;

public interface IPhoneNumber {
	Long getId();
	String getPhoneKind();
	String getPhoneNumber();
	IContact getContact();
	
	void setId(Long id);
	void setPhoneKind(String phoneKind);
	void setPhoneNumber(String phoneNumber);
	void setContact(IContact contact);
}
