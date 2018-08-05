package fr.jee.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.jee.ejb.MyEjbLocal;
import fr.jee.ejb.MyEjbRemote;

/**
 * Hello world!
 *
 */
@Stateless(name="hello")
@Local(MyEjbLocal.class)
@Remote(MyEjbRemote.class)
public class HelloWorldBean extends AbstractEjb{
	
	@EJB(beanName="add")
	private MyEjbLocal addBean;
	
	@EJB(beanName="multi")
	private MyEjbLocal multiBean;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6727690144710806440L;
	
	@Override
	public int doit(int a, int b) {
		return multiBean.doit(addBean.doit(a, b), addBean.doit(a, b))  ;
	}
    
}
