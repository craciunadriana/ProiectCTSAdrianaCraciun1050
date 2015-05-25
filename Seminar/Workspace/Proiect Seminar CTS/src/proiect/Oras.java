package proiect;

import java.util.ArrayList;


public class Oras {

	String nume, cod, identificare;
	
	public Oras(String nume, String cod, String identificare) {
		this.nume = nume;
		this.cod = cod;
		this.identificare = identificare;
	}

	//Constructor fara parametrii
	public Oras()
	{
		this.nume="";
		this.cod="";
		this.identificare="";
	}

	//Constructor cu parametrii nume, cod
	public Oras(String nume, String cod) {
		this.nume = nume;
		this.cod = cod;
	}

	//Constructor de copiere
	public Oras(Oras cd){
		this.nume=cd.nume;
		this.cod=cd.cod;
		this.identificare=cd.identificare;
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getIdentificare() {
		return identificare;
	}

	public void setIdentificare(String identificare) {
		this.identificare = identificare;
	}

	public String descrieOras(){
		return "Nume: " + this.getNume() + ", Cod: "+ this.getCod();
	}
	
	public static Oras cautaOrasDupaNume(ArrayList<Oras> oras,String cod) throws Exception{
		Oras c=null;
		if(oras.size() == 0 ) throw new Exception("Nu exista orase");
		
		else if(oras.size() != 0){
		if(cod != null)
			for(Oras i: oras)
				if(cod == i.getCod())
					c=new Oras(i);
				
			if(c==null) throw new Exception("Orasul nu exista");
		}
		else throw new Exception("Nu exista");
		
		return c;
	}

	@Override
	public String toString() {
		return descrieOras();
	}

	
}
