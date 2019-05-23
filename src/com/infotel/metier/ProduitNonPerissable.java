package com.infotel.metier;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NONPERI")
public class ProduitNonPerissable extends Produit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4156311191205583061L;
	private String modeDemploi;

	public String getModeDemploi() {
		return modeDemploi;
	}

	public void setModeDemploi(String modeDemploi) {
		this.modeDemploi = modeDemploi;
	}

	

}
