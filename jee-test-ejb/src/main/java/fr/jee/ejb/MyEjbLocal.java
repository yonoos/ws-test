package fr.jee.ejb;

import java.io.Serializable;

import javax.ejb.Local;

@Local
public interface MyEjbLocal extends Serializable{
	
	int doit(int a, int b);

}
