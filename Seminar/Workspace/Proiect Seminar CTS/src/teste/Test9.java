package teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import proiect.CarDealer;
import proiect.Componente;
import proiect.Oras;
import proiect.Vehicul;


public class Test9 {

	@Test
	public void TestVenitTotalEquals() throws Exception {
		ArrayList<Vehicul> list=new ArrayList<>();
		
		Oras oras=new Oras("Bucuresti", "1");
		Oras oras2=new Oras("Focsani", "2");
		
		Componente c=new Componente();
		Componente c2=new Componente();
		
		c.setOras(oras);
		c2.setOras(oras2);
		
		c.setNrVanzari(51);
		c2.setNrVanzari(15);
		
		c.setPret(1500.0);
		c2.setPret(950.0);
				 
		list.add(c);
		list.add(c2);
		
		assertEquals(90750 , new CarDealer().venitTotal((ArrayList<Vehicul>) list),0.0);
	}
	
	@Test
	public void TestVenitTotalFalse() throws Exception {
		ArrayList<Vehicul> list=new ArrayList<>();
		
		Oras oras=new Oras("Bucuresti", "1");
		Oras oras2=new Oras("Focsani", "2");
		
		Componente c=new Componente();
		Componente c2=new Componente();
		
		c.setOras(oras);
		c2.setOras(oras2);
		
		c.setNrVanzari(0);
		c2.setNrVanzari(0);
		
		c.setPret(0);
		c2.setPret(0);
				 
		list.add(c);
		list.add(c2);
		
		assertEquals(0 , new CarDealer().venitTotal((ArrayList<Vehicul>) list),0.0);
	}

	@Test
	public void TestFaraVanzari() throws Exception {
		ArrayList<Vehicul> list=new ArrayList<>();
		
		Oras oras=new Oras("Bucuresti", "1");
		Oras oras2=new Oras("Focsani", "2");
		
		Componente c=new Componente();
		Componente c2=new Componente();
		
		c.setOras(oras);
		c2.setOras(oras2);
		
		c.setNrVanzari(0);
		c2.setNrVanzari(0);
		
		c.setPret(1500.0);
		c2.setPret(950.0);
				 
		list.add(c);
		list.add(c2);
		
		assertEquals(0 , new CarDealer().venitTotal((ArrayList<Vehicul>) list),0.0);
	}

	@Test
	public void TestFaraPret() throws Exception {
		ArrayList<Vehicul> list=new ArrayList<>();
		
		Oras oras=new Oras("Bucuresti", "1");
		Oras oras2=new Oras("Focsani", "2");
		
		Componente c=new Componente();
		Componente c2=new Componente();
		
		c.setOras(oras);
		c2.setOras(oras2);
		
		c.setNrVanzari(51);
		c2.setNrVanzari(15);
		
		c.setPret(0);
		c2.setPret(0);
				 
		list.add(c);
		list.add(c2);
		
		assertEquals(0 , new CarDealer().venitTotal((ArrayList<Vehicul>) list),0.0);
	}
	
}
