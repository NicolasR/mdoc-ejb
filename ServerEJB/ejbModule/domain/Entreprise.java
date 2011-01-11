package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Conctact de type Entreprise
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("E")
public class Entreprise extends Contact {
	
	/**
	 * Numéro SIRET
	 */
	private Integer NumSiret;
	
	
	/**
	 * Constructeur
	 */
	public Entreprise() {
		super();
	}

	/**
	 * Renvoie le numéro SIRET
	 * @return le numéro SIRET
	 */
	public Integer getNumSiret() {
		return NumSiret;
	}

	/**
	 * Définie le numéro SIRET
	 * @param numSiret le nouveau numéro SIRET
	 */
	public void setNumSiret(Integer numSiret) {
		NumSiret = numSiret;
	}

}
