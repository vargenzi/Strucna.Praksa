package core.UcenikFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import ui.PutanjeSlikaIFajlova;

public class OceneSviPredmeti {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	public ArrayList<String[]> als = new ArrayList<String[]>();
	public ArrayList<Double> ald = new ArrayList<Double>();
	public ArrayList<String> als1 = new ArrayList<String>();

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
	
	public String[] TrazenjeImenaIID(String[] niz) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String linije;
		String substrings[];
		String random[] = null;
		
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[9])&&niz[1].equals(substrings[10])) {
				String ime = substrings[0];
				String prezime = substrings[1];
				String jmbg = substrings[2];
				String podaci[] = {jmbg, ime, prezime};
				br.close();
				return podaci;
			}
		}
		br.close();
		return random;
	}
	
	public void TrazenjeOcena(String[] niz1) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			
			if(niz1[0].equals(substrings[1])) {
				String predmet = substrings[2];
				String ocena = substrings[3];
				String opis = substrings[4];
				String novo[] = {niz1[1], niz1[2], predmet, ocena, opis};
				als.add(novo);	
			}
		}
	br.close();
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
		return tekst;
	}
}
