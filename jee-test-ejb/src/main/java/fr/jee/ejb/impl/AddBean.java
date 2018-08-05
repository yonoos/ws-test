package fr.jee.ejb.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import fr.jee.ejb.MyEjbLocal;
import fr.jee.ejb.MyEjbRemote;
import fr.younes.services.CalService;

/**
 * Hello world!
 *
 */
@Stateless(name="add")
@Local(MyEjbLocal.class)
@Remote(MyEjbRemote.class)
public class AddBean extends AbstractEjb{
	
	@Inject
	@Named("addService")
	private CalService service;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530567125269644364L;

	@Override
	public int doit(int a, int b) {
		return service.calculate(a, b);
	}
}
