package common.interfaces;

public interface IAddress {
	long getId();
	String getStreet();
	String getZip();
	String getCity();
	String getCountry();
	
	void setId(long id);
	void setStreet(String street);
	void setZip(String zip);
	void setCity(String city);
	void setCountry(String country);
}
