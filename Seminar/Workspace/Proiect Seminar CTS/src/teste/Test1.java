package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import proiect.Oras;
import proiect.Masina;

public class Test1 {

	ArrayList<Oras> lista;
	Masina m;
	
	@Before
	public void setUp(){
		
		m=new Masina();
		lista =new ArrayList<>();
		
	}
	
	@Test
	public void testFisierNotNull() throws IOException {
		
		File f = new File("Orase");
		if(!f.exists()) throw new FileNotFoundException("Nu exista fisier");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String linie = null;
		while((linie = reader.readLine())!=null){
			
			String[] continut = linie.split("\t");
			
			if(continut.length==1)
				continue;
			
			String nume = continut[0];
			String cod = continut[1];
			Oras cd=new Oras(nume, cod);
			ArrayList<Oras> list=new ArrayList<Oras>();
			list.add(cd);
			m.setOras(list);
			
			assertNotNull(m);
			
		}
		
		reader.close();
		
		
	}
	
	@Test
	public void testFisierEqual() throws IOException {
		File f = new File("Masini");
		if(!f.exists()) throw new FileNotFoundException("Nu exista fisier");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		
		String linie = null;
		while((linie = reader.readLine())!=null){
				
			String[] continut = linie.split("\t");
			if(continut.length==1)
				continue;
			
			String nume = continut[0];
			String cod = continut[1];
			Oras a=new Oras(nume,cod);
			ArrayList<Oras> lista=new ArrayList<Oras>();
			lista.add(a);
			
			m.setOras(lista);
			m.setMarca(continut[2]);
			assertEquals("Bucuresti Ford 12345",m);
			
			}
		
		reader.close();
	}

}
