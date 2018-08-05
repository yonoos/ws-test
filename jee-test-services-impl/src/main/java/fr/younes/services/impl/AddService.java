package fr.younes.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import fr.younes.services.CalService;

@ApplicationScoped
@Named("addService")
public class AddService  implements CalService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3641429299699786212L;
	
	public AddService() {
		super();
	}

	@Override
	public int calculate(int a, int b) {
		return a+b;
	}

}
