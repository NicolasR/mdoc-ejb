package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import common.interfaces.IAddress;
import common.interfaces.IContact;
import common.interfaces.IContactGroup;
import common.interfaces.IPhoneNumber;


/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Contact enregistré
 */
/**
 * @author Administrateur
 *
 */
@Entity
@DiscriminatorValue("C")
public class Contact implements IContact{
	/**
	 * Le pr�nom du contact
	 */
	private String firstName;
	
	/**
	 * Le nom du contact
	 */
	private String lastName;
	
	/**
	 * L'�mail du contact
	 */
	private String email;
	
	/**
	 * L'identifiant du contact
	 */
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * L'adresse du contact
	 */
	private Address address;
	
	/**
	 * Les num�ros de téléphone associ� au contact
	 */
	private Set<PhoneNumber> phones;
	
	/**
	 * Les groupes auxquels le contact appartient
	 */
	private Set<ContactGroup> groups;
	
	
	/**
	 * Renvoie les num�ros de t�l�phone du contact
	 * @return les num�ros de t�l�phone
	 */
	public Set<IPhoneNumber> getPhones() {
		Set<IPhoneNumber> list = new HashSet<IPhoneNumber>();
		for (PhoneNumber phoneNumber : phones) {
			list.add((IPhoneNumber)phoneNumber);
		}
		return list;
	}

	/**
	 * D�finie la liste des num�ros de t�l�phone du contact
	 * @param phones la nouvelle liste de num�ros de t�l�phone
	 */
	public void setPhones(Set<IPhoneNumber> phones) {
		if (this.phones == null)
			this.phones = new HashSet<PhoneNumber>();
		for (IPhoneNumber phoneNumber : phones) {
			this.phones.add((PhoneNumber)phoneNumber);
		}
	}

	/**
	 * Renvoie la liste des groupes du contact
	 * @return la liste des groupes du contact
	 */
	public Set<IContactGroup> getGroups() {
		Set<IContactGroup> list = new HashSet<IContactGroup>();
		for (ContactGroup contactGroup : groups) {
			list.add((IContactGroup)contactGroup);
		}
		return list;
	}

	/**
	 * D�finie la liste des groupes du contact
	 * @param groups la nouvelle liste de groupes
	 */
	public void setGroups(Set<IContactGroup> groups) {
		if (this.groups == null)
			this.groups = new HashSet<ContactGroup>();
		for (IContactGroup contactGroup : groups) {
			this.groups.add((ContactGroup)contactGroup);
		}
	}

	/**
	 * Renvoie l'adresse du contact
	 * @return l'adresse du contact
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * D�finie l'adresse du contact
	 * @param address la nouvelle adresse du contact
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Constructeur vide
	 */
	public Contact() {
	}
	
	/**
	 * Renvoie le pr�nom du contact
	 * @return le pr�nom du contact
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * D�finie le pr�nom du contact
	 * @param firstName le nouveau pr�nom du contact
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Renvoie le nom du contact
	 * @return le nom du contact
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * D�finie le nom du contact
	 * @param lastName le nouveau nom du contact
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Renvoie l'�mail du contact
	 * @return l'email du contact
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * D�finie l'email du contact
	 * @param email le nouvel email du contact
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Renvoie l'identifiant du contact
	 * @return l'identifiant associ� au contact
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * D�finie l'identifiant du contact
	 * @param id le nouvel identifiant du contact
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setAddress(IAddress address) {
		// TODO Auto-generated method stub
		this.address = (Address)address;
	}
}
