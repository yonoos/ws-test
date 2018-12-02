package fr.younes.services.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddServiceTest {
	
	@Test
	public void testAddServiceOK() {
		
		AddService service = new AddService();
		
		assertEquals(9, service.calculate(4, 5));
	}

}
