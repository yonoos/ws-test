package fr.jee.ejb;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.sql.DataSource;

import fr.jee.api.MyStartup;
import fr.jee.api.MyStartupable;

@Singleton
@Startup
public class MyStartupEjb {

	List<MyStartupable> m_startup;
	//@Resource(lookup="java:jdbc/wexVS4TMS", type=DataSource.class, authenticationType=AuthenticationType.CONTAINER, shareable=true)
	private DataSource ds;

	@PostConstruct
	public void init() {
		System.out.println("MyStartupEjb is starting ....");
	}

	@Inject
	@MyStartup
	@Any
	public void setStatupables(Instance<MyStartupable> _objects) {
		try {
			m_startup = new LinkedList<>();
			Class<?> clazz = Class.forName("younes.module.hello.Hello");
			Object object = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				System.out.println(method.getName()+" "+method.getParameterTypes());
			}
			Method method = clazz.getMethod("hola", MyStartupable.class);
			for (MyStartupable o : _objects) {
				//			m_startup.add(o);
				o.run();
				System.out.println(o.getClass().getName());
				Object results = method.invoke(object, o);
				System.out.println(results);

			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
