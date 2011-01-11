package common.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IGestionContactRemote {
	static int FIRSTNAME = 1;
	static int LASTNAME = 2;
	static int EMAIL = 3;
	static int NUMSIRET = 4;
	static int STREET = 5;
	static int CITY = 6;
	static int ZIP = 7;
	static int COUNTRY = 8;
	static int PHONE = 9;
	static int ADDRESS = 10;
	
	void saveContact();
	
	void createContact(String firstName, String lastName, String email);
	
	void createEntreprise(String firstName, String lastName, String email, int numsiret);
	
	void setAddress(String street, String city, String zip, String country);
	
	void setContactGroup(String name);
	
	public void addPhoneNumber(String phoneKind, String phoneNumber);
	
	void update(int token, List<String> value, long id);
	
	List<String> get(int token, String item, long id);
	
	void deleteContact(long id);
}
