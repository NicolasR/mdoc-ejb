package domain;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
public class Contact {
	/**
	 * Le prénom du contact
	 */
	private String firstName;
	
	/**
	 * Le nom du contact
	 */
	private String lastName;
	
	/**
	 * L'émail du contact
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
	 * Les numéros de téléphone associé au contact
	 */
	private Set<PhoneNumber> phones;
	
	/**
	 * Les groupes auxquels le contact appartient
	 */
	private Set<ContactGroup> groups;
	
	
	/**
	 * Renvoie les numéros de téléphone du contact
	 * @return les numéros de téléphone
	 */
	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	/**
	 * Définie la liste des numéros de téléphone du contact
	 * @param phones la nouvelle liste de numéros de téléphone
	 */
	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	/**
	 * Renvoie la liste des groupes du contact
	 * @return la liste des groupes du contact
	 */
	public Set<ContactGroup> getGroups() {
		return groups;
	}

	/**
	 * Définie la liste des groupes du contact
	 * @param groups la nouvelle liste de groupes
	 */
	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}

	/**
	 * Renvoie l'adresse du contact
	 * @return l'adresse du contact
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Définie l'adresse du contact
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
	 * Renvoie le prénom du contact
	 * @return le prénom du contact
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Définie le prénom du contact
	 * @param firstName le nouveau prénom du contact
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
	 * Définie le nom du contact
	 * @param lastName le nouveau nom du contact
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Renvoie l'émail du contact
	 * @return l'email du contact
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Définie l'email du contact
	 * @param email le nouvel email du contact
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Renvoie l'identifiant du contact
	 * @return l'identifiant associé au contact
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Définie l'identifiant du contact
	 * @param id le nouvel identifiant du contact
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
