package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class OceneSvihIzJednog {

	private ArrayList<String[]> als = new ArrayList<String[]>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public String[] CitanjeLogova() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.LogoviProf));
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
	
	public String[] TrazenjeIdIPredmeta(String[] niz) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String linije;
		String substrings[];
		String random[] = null;

		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[7]) && niz[1].equals(substrings[8])) {
				String povratni[] = {substrings[2], substrings[9]};
				br.close();
				return povratni;
			}	
		}
		br.close();
		return random;
	}

	public void Greska(String poruka) {
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, poruka, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public void PunjenjeListe(String niz1[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(substrings[0].equals(niz1[0])) {
				String jmbg = substrings[1];
				String ocena = substrings[3];
				String opis = substrings[4];
				String predmet = substrings[2];
				String podaci[] = {jmbg, ocena, opis, predmet};
				als.add(podaci);
			}	
		}
		br.close();
	}
	
	public void TrazenjeImena() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String linije;
		String substrings[];
		
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			int i = 0;
			while(i<als.size()) {
				String podaci[] = als.get(i);
				if(substrings[2].equals(podaci[0])) {
					String novo[] = {podaci[0], podaci[1], podaci[2], podaci[3], substrings[0], substrings[1]};
					als.set(i, novo);
					}
				i++;
				}
			}	
		br.close();
	}
	
	public String Ispis() {
		String tekst = "PREDMET: " + als.get(0)[3] + "\n";
		int i = 0;
		
		while(i<als.size()) {
			tekst += "              Ime: " + als.get(i)[4] + " -- Prezime: " + als.get(i)[5] + " -- Ocena: " + als.get(i)[1] + " -- Opis:" + als.get(i)[2] + "\n";
			
			i++;
		}
		return tekst;
	}
	
	public void praznjenjeListe() {
		als.clear();
	}
	
}
