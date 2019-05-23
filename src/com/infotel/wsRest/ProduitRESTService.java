package com.infotel.wsRest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless
@Path(value = "/produits")
public class ProduitRESTService {

	@EJB
	private DaoImpl dao;

	// Méthodes AJOUTER
	
	@GET
	@Path("addMagasin/{nom}/{code}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
		public void ajouterMagasin(
				@PathParam(value="nom")String nomMagasin,
				@PathParam(value="code")int codeMagasin,
				@PathParam(value="prix")double prixDuLocal) {
			
			Magasin m = new Magasin();
			m.setNomMagasin(nomMagasin);
			m.setCodeMagasin(codeMagasin);
			m.setPrixDuLocal(prixDuLocal);
			
			
			dao.ajouterMagasin(m);
		}
		
	@GET
	@Path("addProdPeri/{nom}/{stock}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
		public void ajouterProdPerissable(
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix) {
			
			ProduitPerissable p = new ProduitPerissable();
			p.setNomProduit(nomProduit);
			p.setStock(stock);
			p.setPrix(prix);
			p.setDateLimiteUtilisation(new Date());
			
			dao.ajouterProduit(p);
		}
		
	@GET
	@Path("addProdNonPeri/{nom}/{stock}/{prix}/{mode}")
	@Produces(MediaType.APPLICATION_JSON)
		public void ajouterProdNonPerissable(
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix,
				@PathParam(value="mode")String modeDemploi) {
			
			ProduitNonPerissable p = new ProduitNonPerissable();
			p.setNomProduit(nomProduit);
			p.setStock(stock);
			p.setPrix(prix);
			p.setModeDemploi(modeDemploi);
			
			dao.ajouterProduit(p);
		}
		
		
		// Méthodes LISTER
		
	@GET
	@Path("getAllMagasins")
	@Produces(MediaType.APPLICATION_JSON)
		public List<Magasin> getAllMagasins() {
			return dao.getAllMagasins();
		}
		
	@GET
	@Path("getAllProduits")
	@Produces(MediaType.APPLICATION_JSON)
		public List<Produit> getAllProduits() {
			return dao.getAllProduits();
		}
		
		
		// Méthodes SUPPRIMER
		
	@GET
	@Path("supprMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
		public void supprimerMagasin(
				@PathParam(value="idMagasin")long idMagasin) {
			dao.supprimerMagasin(idMagasin);
		}
		
	@GET
	@Path("supprProduit/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
		public void supprimerProduit(
				@PathParam(value="idProduit")long idProduit) {
			dao.supprimerProduit(idProduit);
		}
		
		
		// Méthodes GET
		
	@GET
	@Path("getMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
		public Magasin getMagasin(
				@PathParam(value="idMagasin")long idMagasin) {
			return dao.getMagasin(idMagasin);
		}
		
	@GET
	@Path("getProduit/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
		public Produit getProduit(
				@PathParam(value="idProduit")long idProduit) {
			return dao.getProduit(idProduit);
		}
		
		
		// Méthodes MODIFIER
		
	@GET
	@Path("modMagasin/{id}/{nom}/{code}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
		public Magasin modifierMagasin(
				@PathParam(value="id")Long idMagasin,
				@PathParam(value="nom")String nomMagasin,
				@PathParam(value="code")int codeMagasin,
				@PathParam(value="prix")double prixDuLocal) {
			
				Magasin m = new Magasin();
				m.setIdMagasin(idMagasin);
				m.setNomMagasin(nomMagasin);
				m.setCodeMagasin(codeMagasin);
				m.setPrixDuLocal(prixDuLocal);
					
				dao.modifierMagasin(m);
					
				return m;
		}
		
	@GET
	@Path("modProduitPeri/{id}/{nom}/{stock}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
		public Produit modifierProdPerissable(
				@PathParam(value="id")Long idProduit,
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix) {
			
				ProduitPerissable p = new ProduitPerissable();
				p.setIdProduit(idProduit);
				p.setNomProduit(nomProduit);
				p.setStock(stock);
				p.setPrix(prix);
				p.setDateLimiteUtilisation(new Date());
					
				dao.modifierProduit(p);
				
				return p;
		}
		
	@GET
	@Path("modProduitNonPeri/{id}/{nom}/{stock}/{prix}/{mode}")
	@Produces(MediaType.APPLICATION_JSON)
		public Produit modifierProdNonPerissable(
				@PathParam(value="id")Long idProduit,
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix,
				@PathParam(value="mode")String modeDemploi) {
			
				ProduitNonPerissable p = new ProduitNonPerissable();
				p.setIdProduit(idProduit);
				p.setNomProduit(nomProduit);
				p.setStock(stock);
				p.setPrix(prix);
				p.setModeDemploi(modeDemploi);
					
				dao.modifierProduit(p);
				
				return p;
		}
	
	@GET
	@Path("addProdPeriMag/{nom}/{stock}/{prix}/{date}/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterProduitPerissableMagasin (
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="date")Date dateLimiteUtilisation,
			@WebParam(name="idMagasin")Long idMagasin) {
		
		ProduitPerissable p = new ProduitPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setDateLimiteUtilisation(dateLimiteUtilisation);
		
		dao.ajouterProduitMagasin(p, idMagasin);
		
		}
	
	@GET
	@Path("addProdNonPeriMag/{nom}/{stock}/{prix}/{mode}/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterProduitNonPerissableMagasin (
			@WebParam(name="nom")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="mode")String modeDemploi,
			@WebParam(name="idMagasin")Long idMagasin) {
		
		ProduitNonPerissable p = new ProduitNonPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setModeDemploi(modeDemploi);
		
		dao.ajouterProduitMagasin(p, idMagasin);
			
		}

	@GET
	@Path("calprixMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public double calculPrixMagasin (
			@WebParam(name="idMagasin")Long idMagasin) {
		
		Magasin m = new Magasin();
		m = dao.getMagasin(idMagasin);
	
		return dao.calculPrixMagasin(m);
	}
	
}