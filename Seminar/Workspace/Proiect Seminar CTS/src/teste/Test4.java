package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import proiect.Componente;
import proiect.Exceptions;
import proiect.Masina;
import proiect.Oras;

public class Test4 {
	
	ArrayList<Masina> listaMasini;
	Masina m1, m2;
	Oras o;
	Componente c;
	
	@Before
	public void setUp()
	{
		m1=new Masina("Ford");
		m2=new Masina("Fiat");
		
		o=new Oras("Bucuresti","1");
		c=new Componente(o,125);
		listaMasini =new ArrayList<>();
		listaMasini.add(m1);
		listaMasini.add(m2);
		
		
	}
	
	@Test
	public void TestNrMasini() throws Exceptions
	{
		assertEquals(Masina.nrMasini(), listaMasini.size());
		
	}
	
	
	@Test
	public void TestProfit() throws Exception
	{
		c.setPret(1400);
		assertEquals("",175000,c.profit(c), 0.0);
	}
	
	
	@Test
	public void TestProfitNull() throws Exception {
		
		c=new Componente(o,0);
		c.setPret(5900);
		assertEquals("",0,c.profit(c),0.0);
	}
	
	@Test
	public void TestComponenteProfitNull() throws Exception {
	
	    c=null;
		try{
			c.profit(c);
			assertFalse(true);
		}
		catch (Exception e) {
			assertTrue(true);}
		
		
	}
		
	@Test
	public void TestCantStocNegativ() throws Exception {
		try{
		c=new Componente();
		c.setCantStoc(-200);
		assertFalse(true);
		} 
		catch(Exception ex) { 
			assertTrue(true);
		}
	}


	@Test
	public void TestComponenteIncorect() throws Exception {
		try{
			c=new Componente();
			c.setCantStoc(15000);
			assertFalse(true);
		} 
		catch(Exception ex) { 
			assertTrue(true);
		}
	}
	
	
	
	

}
