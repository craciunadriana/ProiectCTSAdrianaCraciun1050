package proiect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Masina extends Vehicul{

	String serie, categorie;
	int nr;
	ArrayList<Oras> oras;
		
	public Masina(String serie, String categorie, ArrayList<Oras> oras, String marca, double pret) {
		this.serie = serie;
		this.categorie = categorie;
		this.oras = oras;
		
		setMarca(marca);
		setPret(pret);
	}
	
	public Masina(String serie, String categorie, ArrayList<Oras> oras, String marca, String tip, double pret) {
		this.serie = serie;
		this.categorie = categorie;
		this.oras = oras;
		
		setTip(tip);
		setMarca(marca);
		setPret(pret);
	}

	public Masina() {
		serie=null;
	}
	
	
	public Masina(String serie) {
		super();
		this.serie =serie;
	}
	
	public Masina (Masina m){
		this.marca=m.getMarca();
		this.serie=m.getSerie();
		this.nr=m.getNr();
	}

	public Masina(String marca, double pret) {
		this.marca=marca;
		this.pret=pret;
		this.serie="1993";
	
	}
	
	public static void salvareFisier(ArrayList<Masina> masini) throws Exceptions {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("masini.txt"));
			for (Masina m : masini) {
				writer.write(m.getCategorie());
				writer.write(",");
				writer.write(m.getSerie());
				writer.write(",");
				writer.write(m.getMarca());
				writer.write(",");
				writer.write(String.valueOf(m.getPret()));
				writer.write(",");
				writer.write(String.valueOf(m.getNrVanzari()));
				writer.write('\n');

				for (Oras cd : m.getOras()) {
					writer.write(cd.getNume());
					writer.write(",");
					writer.write(cd.getCod());
					writer.write(",");
				}
			writer.write('\n');
			}
		} 
		catch (IOException e) {
			throw new Exceptions("Nu se poate citi din fisier", e);
		}
		
		finally {
				try {
						writer.close();
					} 
				catch (IOException e) {
					throw new Exceptions("Nu se poate inchide fisierul", e);
					}
				}
			}

	public static ArrayList<Masina> citireFisier() throws Exceptions {
		ArrayList<Masina> masini = new ArrayList<Masina>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("masini.txt"));
			String linie = null;
			while ((linie = reader.readLine()) != null) {

				String[] sep = linie.split(",");

				Masina m = new Masina(sep[1], sep[0], null, sep[2], Double.valueOf(sep[3]));
	            m.setNrVanzari(Integer.valueOf(sep[4]));
				
	            if ((linie = reader.readLine()) != null) {
					ArrayList<Oras> cd = new ArrayList<Oras>();
					
					String[] sepDeal = linie.split(",");
					for (int i = 0; i < sepDeal.length; i += 2) {
						Oras c = new Oras(sepDeal[i], sepDeal[i + 1]);
						cd.add(c);
					}
							
					m.setOras(cd);
				}
						
	            masini.add(m);
					
			}
		
		} 
		catch (IOException e) {
			throw new Exceptions("Nu se poate citi din fisier", e);
		}
		
		finally {
				try {
						reader.close();
					}
				catch (IOException e) {
					throw new Exceptions("Nu se poate inchide", e);
					}
				}
		return masini;
		
	}
			
	public static int nrMasini() throws Exceptions{
		int nrMasini;
		
		ArrayList<Masina> lista=new ArrayList<>();
		lista=citireFisier();
		
		if(lista.size()!=0)
			nrMasini=lista.size();
		else nrMasini=0;
		
		return nrMasini;
		
	}
			
	public static int nrOrase(String marca) throws Exceptions{
		
		int nrOrase = 0;
				
		ArrayList<Masina> lista=new ArrayList<>();
		lista=citireFisier();
		
		for (Masina m : lista){
			if(m.getMarca().equals(marca))
				nrOrase=m.getOras().size();
					
			else nrOrase=0;
					
		}
			
		return nrOrase;
			
	}

	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public ArrayList<Oras> getOras() {
		return oras;
	}
	public void setOras(ArrayList<Oras> oras) {
		this.oras = oras;
	}

	@Override
	public String toString() {
		return this.serie + " " +this.categorie + " " + this.nr + " " + this.oras;
	}
	
	
}
