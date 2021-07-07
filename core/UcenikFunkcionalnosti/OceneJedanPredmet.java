package core.UcenikFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class OceneJedanPredmet {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<String[]> als = new ArrayList<String[]>();

	
	public boolean PostojanjePredmeta(String predmet) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(predmet)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}
	
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
	
	public String[] TrazenjeImenaJmbg(String[] niz) throws IOException {
		
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
	
	public int PunjenjeListe(String predmet, String jmbg) throws IOException {
		BufferedReader br;
		br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		int k = 0;
		
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[1].equals(jmbg) && substrings[2].equals(predmet)) {
				String novo[] = {substrings[3], substrings[4]};
				als.add(novo);
				k = 1;
			}
		}
		br.close();
		return k;
	}
	
	public String Ispis(String predmet, String niz1[]) {
		int i = 0;
		double prosek = Prosek();
		String fprosek = new DecimalFormat("#.00").format(prosek);
		String tekst = "PREDMET: " + predmet + "\nProsek: " + fprosek +"\nIme: " + niz1[1] + "\nPrezime: " + niz1[2] + "\n"; 
		while(i<als.size()) {
			
			tekst += "           Ocena: " + als.get(i)[0] + " --- Opis: " + als.get(i)[1] + "\n"; 
			
			i++;
		}
		return tekst;
	}
	
	public double Prosek() {
		int i = 0;
		int zbir = 0;
		while(i<als.size()) {
			int ocena = Integer.parseInt(als.get(i)[0]);
			zbir += ocena;
			System.out.println("\n" + zbir);
			i++;
		}
		System.out.println("\n" + i);
		double zbir1 = zbir;
		double prosek = zbir1/i;
		return prosek;
	}
	
	public void Greska(String message) {		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public void PraznjenjeListe() {
		als.clear();
	}
}
