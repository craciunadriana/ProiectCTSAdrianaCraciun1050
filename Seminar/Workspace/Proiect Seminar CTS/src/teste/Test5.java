package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import proiect.Componente;
import proiect.Vehicul;

public class Test5 {

	Vehicul v;
	
	@Before
	public void setUp(){
		v=Mockito.mock(Vehicul.class);
	}
	
	@Test
	public void TestFalse() {
		v.setPret(150000.0);
		assertFalse(v.verificareReduceri());
			
	}
	
	@Test
	public void TestFalseWhen() {
		Mockito.when(v.getPret()).thenReturn(1500.0);
		assertFalse(v.verificareReduceri());
	}
	
	
	@Test
	public void TestTrue() {
		Vehicul v=new Componente();
		v.setPret(300.0);
		assertTrue(v.verificareReduceri());
		
		
	}
}
