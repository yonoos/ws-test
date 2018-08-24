package fr.jee.ejb;


import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import fr.jee.api.MyStartup;
import fr.jee.api.MyStartupable;

@Singleton
@Startup
public class MyStartupEjb {
	
	List<MyStartupable> m_startup;
	
	@PostConstruct
	public void init() {
		System.out.println("MyStartupEjb is starting ....");
	}
	
	@Inject
	@MyStartup
	@Any
	public void setStatupables(Instance<MyStartupable> _objects) {
		m_startup = new LinkedList<>();
		for (MyStartupable o : _objects) {
//			m_startup.add(o);
			o.run();
			System.out.println(o.getClass().getName());
		}
	}

}
