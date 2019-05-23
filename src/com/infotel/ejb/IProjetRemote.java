package com.infotel.ejb;

public interface IProjetRemote {
	
	public void ajouterMagasin(Magasin m);
	public void supprimerMagasin (long idMagasin);
	public List<Magasin> getAllMagasin();
	public Magasin getMagasin (long idMagasin);
	public Magasin modifierMagasin (Magasin m);

	public void ajouterProduit(Produit p);
	public void supprimerProduit(long idProduit);
	public List<Produit> getAllProduits();
	public Produit getProduit (long idProduit);
	public Produit modifierProduit (Produit p);
	
	public void ajouterProduitMagasin (Produit p, long idMagasin);
	public void supprimerProduitMagasin (Magasin m);
	public double calculPrixMagasin (Magasin m);
}
