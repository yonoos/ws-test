package fr.younes.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import fr.younes.services.PrintService;

@ApplicationScoped
@Default
public class DefaultPrintService implements PrintService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2208272020557009673L;
	
	public DefaultPrintService() {
		super();
	}

	@Override
	public void print(int a) {
		System.out.println(a);
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

}
