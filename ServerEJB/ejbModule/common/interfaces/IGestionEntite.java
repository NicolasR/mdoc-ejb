package common.interfaces;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IGestionEntite {
	
	HashMap<Integer, String> findContact(long contactid);
	
	HashMap<Long, HashMap<Integer, String>> getAllContacts();
	
	List<String> findAddress(long contactid);
		
	HashMap<Long, HashMap<Integer, String>> getAllAddress();
	
	List<String> findContactGroups(long contactid);
	
	HashMap<Long, String> getAllContactGroups();
	
	List<String> findPhones(long contactid);
}
