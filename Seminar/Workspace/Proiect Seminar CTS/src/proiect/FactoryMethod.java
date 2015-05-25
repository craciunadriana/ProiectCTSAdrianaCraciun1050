package proiect;


public class FactoryMethod {

	public Vehicul vehiculNou(String v){
		 
		switch (v){
		case "Componente" :  return new Componente();
		case "Masina" : return new Masina("Marca", 150);
		 
		}
		 
		return null;
		
	}
}
