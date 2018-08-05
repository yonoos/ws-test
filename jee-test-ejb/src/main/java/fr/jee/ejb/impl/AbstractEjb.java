package fr.jee.ejb.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.PostRemove;

import fr.jee.ejb.MyEjbLocal;
import fr.jee.ejb.MyEjbRemote;
import fr.younes.services.PrintService;

public abstract class AbstractEjb implements MyEjbLocal, MyEjbRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9096504599855651801L;
	
	@Inject
	protected PrintService printService;
	
	@PostConstruct
	public void onCreate() {
		printService.print(getClass().getSimpleName() + " created ");
	}
	
	
	@PostRemove
	public void onRemove() {
		printService.print(getClass().getSimpleName() + " removed ");
	}
	
	

}
