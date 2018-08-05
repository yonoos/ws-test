package fr.jee.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface MyEjbRemote extends Serializable{
	
	int doit(int a, int b);

}
