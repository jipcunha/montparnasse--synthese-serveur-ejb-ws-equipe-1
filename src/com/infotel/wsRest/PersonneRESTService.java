package com.infotel.wsRest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Client;
import com.infotel.metier.Personne;
import com.infotel.metier.Prestataire;
import com.infotel.metier.Voiture;
import com.infotel.wssoap.Magasin;
import com.infotel.wssoap.Produit;
import com.infotel.wssoap.ProduitNonPerissable;
import com.infotel.wssoap.ProduitPerissable;

@Stateless
@Path(value = "/personnes")
public class PersonneRESTService {

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
	@Path("addProdPeri/{nom}/{stock}/{prix}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
		public void ajouterProdPerissable(
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix,
				@PathParam(value="date")Date dateLimiteUtilisation) {
			
			ProduitPerissable p = new ProduitPerissable();
			p.setNomProduit(nomProduit);
			p.setStock(stock);
			p.setPrix(prix);
			p.setDateLimiteUtilisation(dateLimiteUtilisation);
			
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
	@Path("modProduitPeri/{id}/{nom}/{stock}/{prix}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
		public Produit modifierProdPerissable(
				@PathParam(value="id")Long idProduit,
				@PathParam(value="nom")String nomProduit,
				@PathParam(value="stock")int stock,
				@PathParam(value="prix")double prix,
				@PathParam(value="date")Date dateLimiteUtilisation) {
			
				ProduitPerissable p = new ProduitPerissable();
				p.setIdProduit(idProduit);
				p.setNomProduit(nomProduit);
				p.setStock(stock);
				p.setPrix(prix);
				p.setDateLimiteUtilisation(dateLimiteUtilisation);
					
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
}