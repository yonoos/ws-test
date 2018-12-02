package fr.jee.ejb;

import java.io.Serializable;

public interface MyEjbRemote  extends Serializable {
	
	int doit(int a, int b);

}
