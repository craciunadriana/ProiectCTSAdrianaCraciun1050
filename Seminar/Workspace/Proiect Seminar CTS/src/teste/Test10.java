package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import proiect.Componente;
import proiect.Oras;


public class Test10 {
	
	Oras o1, o2, o3;
	ArrayList<Oras> lista;
	Componente c;
	
	@Before
	public void setUp()
	{
		
		o1= new Oras("Bucuresti", "1");
		o2= new Oras("Focsani", "2");
		o3= new Oras("Buzau", "3");
		lista=new ArrayList<>();
		lista.add(o1);
		lista.add(o2);
		lista.add(o3);
		c=new Componente(o1,125);
	}

	@Test
	public void TestOrasDupaNumeTrue() throws Exception {
		
		try{
	
		Oras.cautaOrasDupaNume(lista, "1");
		
		}
		catch(Exception e) {
			assertTrue(true);}
	}
	
	@Test
	public void TestOrasDupaNumeFalse() throws Exception {
		
		try{
				
		Oras.cautaOrasDupaNume(lista, "10");
		
		}
		catch(Exception e) {
			assertFalse(false);
			}
	}
	
	@Test
	public void TestComanda() throws Exception
	{
		c= new Componente(o1, 25);
		c.setPret(1400);
		assertEquals(125,c.comanda(125));
	}
	
	
	@Test
	public void TestComandaNull() throws Exception {
		
		c=new Componente(o1,0);
		c.setPret(0);
		assertEquals(0,c.comanda(0));
	}
	
	
}
