package core.UcenikFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;
import core.Ocena;

public class OceneSviPredmeti {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<String[]> als = new ArrayList<String[]>();
	private ArrayList<Double> ald = new ArrayList<Double>();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private ArrayList<Ocena> alo = new ArrayList<Ocena>();
	private ArrayList<String> als1 = new ArrayList<String>();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();

	public String[] CitanjeLogova() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.LogoviUc));
		String linija;
		String email;
		String sifra;
		String substrings[];
		linija = br.readLine();
		substrings = linija.split("/", 100);
		email = substrings[0];
		sifra = substrings[1];
		String niz[] = {email, sifra};
		
		br.close();
		return niz;
	}
	
	public String[] TrazenjeImenaIID(String[] niz) throws Exception {
		alu = ds.DeserijalizujUcenika();
		int i = 0;
		
		while(i < alu.size()) {
			if(niz[0].equals(alu.get(i).email)&&niz[1].equals(alu.get(i).sifra)) {
				String ime = alu.get(i).ime;
				String prezime = alu.get(i).prezime;
				String id = alu.get(i).id;
				String podaci[] = {id, ime, prezime};
				return podaci;
			}
			i++;
		}
		return null;
	}
	
	public void TrazenjeOcena(String[] niz1) throws Exception {
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		
		while(i < alo.size()) {
			
			if(niz1[0].equals(alo.get(i).id_ucenika)) {
				String predmet = alo.get(i).predmet;
				String ocena = alo.get(i).ocena;
				String opis = alo.get(i).opis;
				String novo[] = {niz1[1], niz1[2], predmet, ocena, opis};
				als.add(novo);	
			}
			i++;
		}
	}
	
	public boolean Ponavljanje(String predmet) {
		int i = 0;
		
		while(i<als1.size()) {
			if(als1.get(i).equals(predmet)) {
				return false;
			}	
			i++;
		}
		return true;
	}
	
	public void ProlazKrozNiz() {
		int i = 0;
		
		while(i<als.size()) {
			int k = 0;
			int brojac = 0;
			String p = als.get(i)[2];
			int zbir = 0;
			boolean prov = false;

			while(k<als.size() && Ponavljanje(p)) {
				if(p.equals(als.get(k)[2])) {
					zbir += Integer.parseInt(als.get(k)[3]);
					brojac++;
					prov = true;
				}
				
				k++;
			}
			
			if(prov == true) {
			als1.add(p);
			double zbir1= zbir;
			double prosek = zbir1/brojac;
			ald.add(prosek);
			}
			i++;
		}
	}
	
	public double Prosek() {
		int  i = 0;
		double zbir = 0.0;
		while(i<ald.size()) {
			zbir += ald.get(i);
			i++;
		}
		double prosek = zbir/i;
		return prosek;
		
	}
	
	public String Ispis(String[] niz1) {
		int i = 0;
		double prosek = Prosek();
		ald.clear();
		als1.clear();
		
		String fprosek = new DecimalFormat("#.00").format(prosek);
		String tekst = "Ime: " + niz1[1] + "\n" + "Prezime: " + niz1[2] + "\nTrenutni uspeh: "+ fprosek + "\n"; 
		
		while(i<als.size()) {
			tekst += "         Predmet: " + als.get(i)[2] + " --- Ocena: " + als.get(i)[3] + " --- Opis: " + als.get(i)[4] + "\n";
			i++;
		}
		if(als.size() == 0) {
			tekst = "Nemate upisane ocene.";
		}
		return tekst;
	}
	
	public void PraznjenejLista() {
		als.clear();
		als1.clear();
		alu.clear();
		alo.clear();
		ald.clear();
	}
}
