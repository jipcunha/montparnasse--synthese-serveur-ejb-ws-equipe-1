package com.infotel.dao;

import java.util.List;

import javax.ejb.Remote;

import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;


@Remote
public interface IdaoRemote {

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
