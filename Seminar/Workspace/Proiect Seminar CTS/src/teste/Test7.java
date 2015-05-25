package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import proiect.Masina;



public class Test7 {

	Masina m1, m2;
	ArrayList<Masina> lista;
	
	@Before
	public void setUp()
	{
		m1= new Masina("serie 1");
		m2= new Masina("serie 2");
	}
	
	@Test
	public void TestMasiniNotNull() throws Exception {
		
		m1.setMarca("Ford");
		m1.setNr(12);
		m1.setPret(500.0);
		
		m2.setMarca("Fiesta");
		m2.setNr(25);
		m2.setPret(800.0);
		
		try{
			lista=new ArrayList<>();
			lista.add(m1);
			lista.add(m2);
			Masina.cautaVehiculDupaPret(lista, 200.0);
		
			assertFalse(true);
		}
		catch(Exception e) {
			assertTrue(true);
		}
	}
	
	public void TestMasiniNull() throws Exception {
		
		m1.setMarca("Ford");
		m1.setNr(12);
		m1.setPret(400.0);
		
		m1.setMarca("Fiesta");
		m1.setNr(25);
		m2.setPret(500.0);
		
		try{
			lista=new ArrayList<>();
			lista.add(m1);
			lista.add(m2);
			Masina.cautaVehiculDupaPret(lista, 400.0);
		
			assertTrue(false);
		}
		catch(Exception e) {
			assertFalse(true);
		}
	}
	
	
	
}
