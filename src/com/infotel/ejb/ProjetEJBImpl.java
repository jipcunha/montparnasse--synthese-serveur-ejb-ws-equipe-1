package com.infotel.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.infotel.dao.IdaoRemote;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;

@Stateless(name="ejbProjet")
public class ProjetEJBImpl implements IProjetLocal, IProjetRemote {

	@EJB
	private IdaoRemote dao;

	public IdaoRemote getDao() {
		return dao;
	}

	public void setDao(IdaoRemote dao) {
		this.dao = dao;
	}

	@Override
	public void ajouterMagasin(Magasin m) {
		dao.ajouterMagasin(m);
		
	}

	@Override
	public void supprimerMagasin(long idMagasin) {
		dao.supprimerProduit(idMagasin);
		
	}

	@Override
	public List<Magasin> getAllMagasins() {
		// TODO Auto-generated method stub
		return dao.getAllMagasins();
	}

	@Override
	public Magasin getMagasin(long idMagasin) {
		// TODO Auto-generated method stub
		return dao.getMagasin(idMagasin);
	}

	@Override
	public Magasin modifierMagasin(Magasin m) {
		// TODO Auto-generated method stub
		return dao.modifierMagasin(m);
	}

	@Override
	public void ajouterProduit(Produit p) {
		dao.ajouterProduit(p);
	}

	@Override
	public void supprimerProduit(long idProduit) {
		dao.supprimerProduit(idProduit);
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return dao.getAllProduits();
	}

	@Override
	public Produit getProduit(long idProduit) {
		// TODO Auto-generated method stub
		return dao.getProduit(idProduit);
	}

	@Override
	public Produit modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		return dao.modifierProduit(p);
	}

	@Override
	public void ajouterProduitMagasin(Produit p, long idMagasin) {
		dao.ajouterProduitMagasin(p, idMagasin);
		
	}

	@Override
	public double calculPrixMagasin(Magasin m) {
		// TODO Auto-generated method stub
		return dao.calculPrixMagasin(m);
	}
	
	

}
