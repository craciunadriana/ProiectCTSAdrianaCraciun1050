package proiect;

import java.util.ArrayList;

public class Vehicul {

	String tip, marca;
	double pret;
	int nrVanzari;
	
	@Override
	public String toString() {
		
		return this.getMarca()+ " " + this.getPret();
	}
	
	public Vehicul() {
		super();
		this.tip="";
		this.marca="";
		this.pret=0.0;
		this.nrVanzari=0;
	}
	
	public Vehicul(String tip, String marca, double pret, int nrVanzari) {
		this.tip = tip;
		this.marca = marca;
		this.pret = pret;
		this.nrVanzari = nrVanzari;
	}

	public Vehicul(Vehicul v){
		this.tip = v.tip;
		this.marca = v.marca;
		this.pret = v.pret;
		this.nrVanzari = v.nrVanzari;
	}


	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	public int getNrVanzari() {		
		return nrVanzari;
	}
	public void setNrVanzari(int nrVanzari) {
		this.nrVanzari = nrVanzari;
	}
	
	public static Vehicul cautaVehiculDupaPret(ArrayList<Masina> masini,double pret) throws Exception{
		Vehicul v=null;
		
		if(masini.size() == 0 ) throw new Exception("Nu exista masini");
		
		else if(masini.size() != 0){
		if(pret != 0)
			for(Vehicul i: masini)
				if(pret == i.getPret())
					v=new Vehicul(i);
				
			if(v==null) throw new Exception("Vehiculul nu exista");
		}
		else throw new Exception("Nu exista");
		
		return v;
	}

	public boolean verificareReduceri(){
		boolean pret=false;
		
		if(getPret()<15000.0)
			 pret=true;
		
		if(getPret()>15000.0)
			pret=false;
		
		return pret;
			
	}
	
	public void pretNou(double pret) throws PretNegativ, PretPesteLimita{
		
		if(pret<0) throw new PretNegativ();
		else if(pret>1000000) throw new PretPesteLimita();
		
		this.pret=pret;
		
	}

	
	
	
}
