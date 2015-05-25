package proiect;

public class Componente extends Vehicul{

	Oras oras;
	String nume;
	int cantStoc;
		
	public Componente(Oras oras, int cantStoc) {
		super();
		this.oras = oras;
		this.cantStoc =cantStoc;
	}
	
	public Componente(String nume,int cantStoc){
	
		this.nume=nume;
		this.cantStoc=cantStoc;
	}
		
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Componente() {
		
	}

	public Oras getOras() {
		return oras;
	}


	public void setOras(Oras oras) {
		this.oras = oras;
	}


	public int getCantStoc() {
		return cantStoc;
	}


	public void setCantStoc(int cantStoc) throws Exception {
		
		if(cantStoc<0) throw new Exception ("Nu exista pe stoc");
		else if(cantStoc > 10000) throw new Exception("Cantitate stoc incorecta");
		
		this.cantStoc = cantStoc;
	}


	public double profit(Componente c) throws Exception{
	
		if(c !=null){
			if(cantStoc !=0 & this.getPret() !=0.0)
				return cantStoc * this.getPret();
			
			else return 0.0;
			
		}
		else throw new Exception ("Componenta nu exista");
		
	}
	
	public int comanda(int cantStoc)
	{
		if(cantStoc > 45)
			this.cantStoc=cantStoc;
		else this.cantStoc=cantStoc+100;
		
		return cantStoc;
	}
		
}
