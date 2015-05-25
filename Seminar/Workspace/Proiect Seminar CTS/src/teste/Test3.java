package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import proiect.Componente;
import proiect.Masina;
import proiect.Oras;

public class Test3 {

	@Test
	public void TestCautaOrasDupaNumeEquals() throws Exception 
	{
		
		Oras o=new Oras("Bucuresti", "1");
		Oras o2=new Oras("Focsani", "2");
		ArrayList<Oras> lista= new ArrayList<>();	
		lista.add(o);
		lista.add(o2);
			
		assertEquals(Oras.cautaOrasDupaNume(lista, "1").toString(), "Nume: Bucuresti, Cod: 1");
		assertEquals(Oras.cautaOrasDupaNume(lista, "2").toString(), "Nume: Focsani, Cod: 2");
			
	}
	
	@Test
	public void TestCautareVehiculDupaPret() throws Exception
	{
		Masina v1=new Masina("Ford", 1500.0);
		Masina v2=new Masina("Fiesta", 350.0);
		ArrayList<Masina> lista=new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		
		assertEquals(Masina.cautaVehiculDupaPret(lista, 1500.0).toString(), "Ford 1500.0" );
		assertEquals(Masina.cautaVehiculDupaPret(lista, 350.0).toString(), "Fiesta 350.0");
		
	}
	
	@Test
	public void TestObiecteDiferite()
	{
		Masina m=new Masina("Ford" , 1500.0);
		Componente c=new Componente("Motor", 150);
		
		assertNotSame(m, c);
		
	}
	
}
