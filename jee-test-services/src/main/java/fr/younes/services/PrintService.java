package fr.younes.services;

import java.io.Serializable;

public interface PrintService extends Serializable{
	
	void print(int a);
	
	void print(String s);

}
