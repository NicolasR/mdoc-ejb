package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Adresse des contacts
 */
@Entity
public class Address {
	
	/**
	 * Identifiant de l'adresse
	 */
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * La rue
	 */
	private String street;
	
	/**
	 * La ville
	 */
	private String city;
	
	/**
	 * Le code postale
	 */
	private String zip;
	
	/**
	 * Le pays
	 */
	private String country;
		
	/**
	 * Constructeur vide
	 */
	public Address() {
		
	}

	/**
	 * Renvoie l'id associé à l'adresse
	 * @return identifiant de l'adresse
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définie l'identifiant de l'adresse
	 * @param id nouvel identifiant de l'adresse
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Renvoie la rue associée à l'adresse
	 * @return la rue
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Définie la rue associée à l'adresse
	 * @param street la nouvelle rue
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	/**
	 * Renvoie la ville associée à l'adresse
	 * @return la ville
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Définie la ville associée à l'adresse
	 * @param city la nouvelle ville
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Renvoie le code postale associé à l'adresse
	 * @return le code postale
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Définie le code postale associé à l'adresse
	 * @param zip le nouveau code postale
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Renvoie le pays associé à l'adresse
	 * @return le pays
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Définie le pays associé à l'adresse
	 * @param country le nouveau pays
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
