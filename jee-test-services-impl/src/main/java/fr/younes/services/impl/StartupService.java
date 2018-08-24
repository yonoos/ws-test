package fr.younes.services.impl;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import fr.jee.api.MyStartup;
import fr.jee.api.MyStartupable;

@ApplicationScoped
@MyStartup
@Default
public class StartupService implements MyStartupable{
	
	@PostConstruct
	public void init() {
		System.out.println("..... StartupService  is loaded ... ;)");
	}

	@Override
	public boolean run() {
		System.out.println("..... StartupService run");
		return true;
	}

}
