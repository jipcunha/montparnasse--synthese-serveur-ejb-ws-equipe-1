package com.infotel.ejb;

import javax.ejb.Stateless;

import com.infotel.dao.IdaoRemote;

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
	
	

}
