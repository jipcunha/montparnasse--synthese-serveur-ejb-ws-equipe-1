package com.infotel.wsSoap;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless
@WebService
public class ProduitSOAPService {
	
	@EJB
	private DaoImpl dao;

	// Méthodes AJOUTER
	
	@WebMethod
	public void ajouterMagasin(
			@WebParam(name="nom")String nomMagasin,
			@WebParam(name="code")int codeMagasin,
			@WebParam(name="prix")double prixDuLocal) {
		
		Magasin m = new Magasin();
		m.setNomMagasin(nomMagasin);
		m.setCodeMagasin(codeMagasin);
		m.setPrixDuLocal(prixDuLocal);
		
		
		dao.ajouterMagasin(m);
	}
	
	@WebMethod
	public void ajouterProdPerissable(
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="date")Date dateLimiteUtilisation) {
		
		ProduitPerissable p = new ProduitPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setDateLimiteUtilisation(dateLimiteUtilisation);
		
		dao.ajouterProduit(p);
	}
	
	@WebMethod
	public void ajouterProdNonPerissable(
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="mode")String modeDemploi) {
		
		ProduitNonPerissable p = new ProduitNonPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setModeDemploi(modeDemploi);
		
		dao.ajouterProduit(p);
	}
	
	
	// Méthodes LISTER
	
	@WebMethod
	public List<Magasin> getAllMagasins() {
		return dao.getAllMagasins();
	}
	
	@WebMethod
	public List<Produit> getAllProduits() {
		return dao.getAllProduits();
	}
	
	
	// Méthodes SUPPRIMER
	
	@WebMethod
	public void supprimerMagasin(
			@WebParam(name="idMagasin")long idMagasin) {
		dao.supprimerMagasin(idMagasin);
	}
	
	@WebMethod
	public void supprimerProduit(
			@WebParam(name="idProduit")long idProduit) {
		dao.supprimerProduit(idProduit);
	}
	
	
	// Méthodes GET
	
	@WebMethod
	public Magasin getMagasin(
			@WebParam(name="idMagasin")long idMagasin) {
		return dao.getMagasin(idMagasin);
	}
	
	@WebMethod
	public Produit getProduit(
			@WebParam(name="idProduit")long idProduit) {
		return dao.getProduit(idProduit);
	}
	
	
	// Méthodes MODIFIER
	
	@WebMethod
	public Magasin modifierMagasin(
			@WebParam(name="id")Long idMagasin,
			@WebParam(name="nom")String nomMagasin,
			@WebParam(name="code")int codeMagasin,
			@WebParam(name="prix")double prixDuLocal) {
		
			Magasin m = new Magasin();
			m.setIdMagasin(idMagasin);
			m.setNomMagasin(nomMagasin);
			m.setCodeMagasin(codeMagasin);
			m.setPrixDuLocal(prixDuLocal);
				
			dao.modifierMagasin(m);
				
			return m;
	}
	
	@WebMethod
	public Produit modifierProdPerissable(
			@WebParam(name="id")Long idProduit,
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="date")Date dateLimiteUtilisation) {
		
			ProduitPerissable p = new ProduitPerissable();
			p.setIdProduit(idProduit);
			p.setNomProduit(nomProduit);
			p.setStock(stock);
			p.setPrix(prix);
			p.setDateLimiteUtilisation(dateLimiteUtilisation);
				
			dao.modifierProduit(p);
			
			return p;
	}
	
	@WebMethod
	public Produit modifierProdNonPerissable(
			@WebParam(name="id")Long idProduit,
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="mode")String modeDemploi) {
		
			ProduitNonPerissable p = new ProduitNonPerissable();
			p.setIdProduit(idProduit);
			p.setNomProduit(nomProduit);
			p.setStock(stock);
			p.setPrix(prix);
			p.setModeDemploi(modeDemploi);
				
			dao.modifierProduit(p);
			
			return p;
	}
	
	@WebMethod
	public void ajouterProduitPerissableMagasin (Produit p, long idMagasin) {
		
	}
	
	@WebMethod
	public void ajouterProduitNonPerissableMagasin (Produit p, long idMagasin) {
		
	}
	
	@WebMethod
	public double calculPrixMagasin (Magasin m) {
		return 4.5;
	}
	
}