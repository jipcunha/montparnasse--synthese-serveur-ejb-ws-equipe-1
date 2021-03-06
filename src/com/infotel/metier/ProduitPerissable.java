package com.infotel.metier;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DiscriminatorValue("PERI")
public class ProduitPerissable extends Produit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4333968933387797197L;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateLimiteUtilisation;

	public Date getDateLimiteUtilisation() {
		return dateLimiteUtilisation;
	}

	public void setDateLimiteUtilisation(Date dateLimiteUtilisation) {
		this.dateLimiteUtilisation = dateLimiteUtilisation;
	}

}
