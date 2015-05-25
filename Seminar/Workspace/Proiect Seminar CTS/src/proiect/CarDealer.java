package proiect;

import java.util.ArrayList;


public class CarDealer {

	String nume;
		
	Oras cd =new Oras("Bucuresti ", "1");
	Componente c= (Componente) new FactoryMethod().vehiculNou("Motor");
	Masina m= (Masina) new FactoryMethod().vehiculNou("Masina");

	private static CarDealer instanta=null;
	
	public CarDealer(){
		this.nume="Bucuresti";}

	public static CarDealer getInstanta(){
		if(instanta==null)
			instanta=new CarDealer();
		return instanta;
		
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}


	public String informatiiOras(){
		return "Oras: " + this.nume;
	}

	public double venitTotal(ArrayList<Vehicul> arrayList) throws Exception{
		 
		double venit=0;
		 		
		for (Vehicul v : arrayList){
			if(v.getPret()!=0 && v.getNrVanzari() !=0)
			 
				venit+=v.getPret()*v.getNrVanzari();
			
			else venit=0;
		}
		
		return venit;
	}
	
}
