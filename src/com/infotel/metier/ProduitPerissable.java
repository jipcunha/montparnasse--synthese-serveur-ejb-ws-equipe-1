package com.infotel.metier;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PERI")
public class ProduitPerissable extends Produit {
	
	private Date dateLimiteUtilisation;

	public Date getDateLimiteUtilisation() {
		return dateLimiteUtilisation;
	}

	public void setDateLimiteUtilisation(Date dateLimiteUtilisation) {
		this.dateLimiteUtilisation = dateLimiteUtilisation;
	}

}
