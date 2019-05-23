package com.infotel.ejb;

import java.util.List;

import javax.ejb.Local;

import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;

@Local
public interface IProjetLocal {

	public void ajouterMagasin(Magasin m);
	public void supprimerMagasin (long idMagasin);
	public List<Magasin> getAllMagasins();
	public Magasin getMagasin (long idMagasin);
	public Magasin modifierMagasin (Magasin m);
	
	public void ajouterProduit(Produit p);
	public void supprimerProduit(long idProduit);
	public List<Produit> getAllProduits();
	public Produit getProduit (long idProduit);
	public Produit modifierProduit (Produit p);
	
	public void ajouterProduitMagasin (Produit p, long idMagasin);
	public double calculPrixMagasin (Magasin m);
}
