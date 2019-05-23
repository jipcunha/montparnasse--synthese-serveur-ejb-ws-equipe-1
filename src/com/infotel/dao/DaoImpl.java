package com.infotel.dao;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean //permet le dialogue entre la dao et le WS
public class DaoImpl implements IdaoLocal, IdaoRemote {

	@PersistenceContext(unitName = "pu_ejb_ws")
	EntityManager em;

	@Override
	public void ajouterMagasin(Magasin m) {
		em.persist(m);
	}
	
	@Override
	public void supprimerMagasin (long idMagasin){
		Magasin m = em.find(Magasin.class, idMagasin);
		em.remove(m);
	}
	
	@Override
	public List<Magasin> getAllMagasin(){
		return em.createQuery("select m from Magasin m").getResultList();
	}
	
	@Override
	public Magasin getMagasin (long idMagasin){
		return em.find(Magasin.class, idMagasin);
	}
	
	@Override
	public Magasin modifierMagasin (Magasin m){
		return em.merge(m);
	}

	@Override
	public void ajouterProduit(Produit p){
		em.persist(p);
	}
	
	@Override
	public void supprimerProduit(long idProduit){
		Produit p = em.find(Produit.class, idProduit);
		em.remove(p);
	}
	
	@Override
	public List<Produit> getAllProduits(){
		return em.createQuery("select p from Produit p").getResultList();
	}
	
	@Override
	public Produit getProduit (long idProduit){
		return em.find(Produit.class, idProduit);
	}
	
	@Override
	public Produit modifierProduit (Produit p){
		return em.merge(p);
	}
	
	@Override
	public void ajouterProduitMagasin (Produit p, long idMagasin) {
		
	}
	
	@Override
	public void supprimerProduitMagasin (Magasin m) {
		
	}
	
	@Override
	public double calculPrixMagasin (Magasin m) {
		
	}

}
