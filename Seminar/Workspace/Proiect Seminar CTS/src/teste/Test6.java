package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import proiect.Login;
import proiect.Oras;


public class Test6 {

	Oras o;
	
	@Before
	public void setUp(){
		o=Mockito.mock(Oras.class);
		
	}
	
	@Test
	public void TestTrue() {
		Mockito.when(o.getNume()).thenReturn("Bucuresti");
		Mockito.when(o.getCod()).thenReturn("1993");
		assertTrue(new Login().logare(o));
	}
	
	@Test
	public void TestFalse() {
		Mockito.when(o.getNume()).thenReturn("Foscani");
		Mockito.when(o.getCod()).thenReturn("2015");
		assertFalse(new Login().logare(new Oras(o.getNume(),o.getCod())));
	}
	
	@Test
	public void TestLogareGresit()
	{
		Mockito.when(o.getNume()).thenReturn(null);
		Mockito.when(o.getCod()).thenReturn(null);
		assertFalse(new Login().logare(o));
	}
	
}
