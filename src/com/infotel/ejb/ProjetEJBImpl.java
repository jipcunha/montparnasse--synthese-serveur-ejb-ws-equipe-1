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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerMagasin(long idMagasin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Magasin> getAllMagasins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Magasin getMagasin(long idMagasin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Magasin modifierMagasin(Magasin m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerProduit(long idProduit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduit(long idProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterProduitMagasin(Produit p, long idMagasin) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void supprimerProduitMagasin(Magasin m) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public double calculPrixMagasin(Magasin m) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
