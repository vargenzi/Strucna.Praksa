package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class SveOceneJednog {

	private ArrayList<String> ars = new ArrayList<String>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean Provera(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(id)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}
	
	public  void PunjenjeListe(String jmbg) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(jmbg.equals(substrings[2])) {
				String ime = substrings[0];
				String prezime = substrings[1];
				ars.add(ime);
				ars.add(prezime);
			}	
		}
		br.close();
	}
	
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
	
	public String[] TrazenjeJmbgIPredmet(String[] niz) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String linije;
		String substrings[];
		String random[] = null;

		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[7])&&niz[1].equals(substrings[8])) {
				String povratni[] = {substrings[2]};
				br.close();
				return povratni;
			}
		}
		br.close();
		return random;
	}
	
	public  void PunjenjeListe2(String id, String idp) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(id.equals(substrings[1]) && idp.equals(substrings[0])) {
				String ocena = substrings[3];
				String opis = substrings[4];
				
				ars.add(ocena);
				ars.add(opis);
			}
			
		}
		br.close();
		
	}
	
	public String Ispis(String predmet) {
		String tekst = "Predmet: " + predmet + "\n";
		tekst += "                Ime: " + ars.get(0) + "\n" + "                Prezime: " + ars.get(1) + "\n"; 
		int i = 2;
		while(i<ars.size()) {
			int s = Integer.parseInt(ars.get(i));

			if((s>=1)&&(s<=5)) {
				tekst += "                Ocena: " + ars.get(i) + "    " + "    Opis: " + ars.get(i+1) + "\n" + "                -------------------------- \n";
				}
			i+=2;
		}
		ars.clear();
		return tekst;
	}
	
	public  String Predmet(String id, String idp) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(id.equals(substrings[1]) && idp.equals(substrings[0])) {
				br.close();
				return substrings[2];
			}	
		}
		br.close();
		return null;
	}
}
