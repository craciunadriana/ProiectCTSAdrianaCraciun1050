package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import proiect.Exceptions;
import proiect.Masina;
import proiect.Oras;
import proiect.PretNegativ;
import proiect.PretPesteLimita;
import proiect.Vehicul;

public class Test2 {
	
	@Test
	public void testVerificareCod()
	{
		Oras o=new Oras("Bucuresti", "1", "12345");
		assertEquals("1", o.getCod());
	}

	@Test
	public void testVerificareCodNull()
	{
		Oras o=new Oras();
		assertEquals("", o.getCod());
	}
	
	@Test
	public void testeazaPretNegativ() throws PretNegativ, PretPesteLimita {
		
		try{
			
		Masina m=new Masina();
		m.pretNou(-1500);
		
		assertFalse(true);
		}
		
		catch(PretNegativ e) { 
			assertTrue(true);
		}
	}
	
	@Test
	public void testeazaPretPesteLimita() throws PretNegativ, PretPesteLimita {
		try{
			
		Masina m=new Masina();
		m.pretNou(1500000);
		
		assertFalse(true);
		} 
		catch(PretPesteLimita e) { 
			assertTrue(true);
		}
	}
	
	@Test
	public void testReducereTrue() throws PretNegativ, PretPesteLimita {
		Vehicul v=new Masina();
		v.pretNou(1500);
		assertTrue(v.verificareReduceri());
	}
	
	@Test
	public void testReducereFalse() throws PretNegativ, PretPesteLimita {
		Vehicul v=new Masina();
		v.pretNou(1000000);
		assertFalse(v.verificareReduceri());
	}

	@Test
	public void testListaMasiniNull() throws Exceptions{
		
		ArrayList<Masina> lista=(ArrayList<Masina>) Masina.citireFisier();
		assertNotNull(lista);
	}
	
}
