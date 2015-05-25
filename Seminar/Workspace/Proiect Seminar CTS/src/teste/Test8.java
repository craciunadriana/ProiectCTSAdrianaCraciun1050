package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import proiect.Exceptions;
import proiect.Masina;
import proiect.Vehicule;

public class Test8 {

	@Test
	public void TestListaMasiniNotNull() throws Exceptions {
		
		ArrayList<Masina> lista=Vehicule.afiseazaMasina();
		assertNotNull(lista);
		
	}
	
	@Test
	public void TestNrOrase() throws Exceptions {
		
		int nr=Masina.nrOrase("2");
		assertNotNull(nr);
	}	
		
	
	@Test
	public void TestNrOraseEquals() throws Exceptions {
	
		
		int nr=Masina.nrOrase("0");
		assertEquals(0, nr);
	}
	
	
	
	@Test
	public void TestNrMasini() throws Exceptions {
		
		int nr=Masina.nrMasini();
		assertNotNull(nr);
	}	
		
	
	@Test
	public void TestNrMasiniEquals() throws Exceptions {
	
		int nr= Masina.nrMasini();
		assertEquals(2, nr);
	}
	
	
}
