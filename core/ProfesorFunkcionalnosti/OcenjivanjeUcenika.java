package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class OcenjivanjeUcenika {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
		
	public boolean ValidacijUnosa(String id) {
		if(id.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean ProveraPostojanjaID(String id) throws IOException {
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
	
	public String[] TrazenjeJmbgIPredmet(String[] niz) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String linije;
		String substrings[];
		String random[] = {"0"};

		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[7])&&niz[1].equals(substrings[8])) {
				String povratni[] = {substrings[2], substrings[9]};
				br.close();
				return povratni;
			}
		}
		br.close();
		return random;
	}
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean ValidacijUnosa2(String ocena, String opis) {
		if(ocena.equals("-")||opis.equals("")) {
			return false;
		}else {
			return true;
		}
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
	
	public void UpisivanjeOcene(String niz[], String id, String ocena, String opis, String idocene) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaOcene, true));
		bw.write(niz[0] + "/" + id + "/" +  niz[1] + "/" + ocena + "/" + opis + "/" + idocene);
		bw.newLine();
		bw.close();
	}
	
	public void Uspeh() {
		String message = "Uspesno ocenjen ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public int IdOcene() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[] = null;
		int i = 0;
		while((linije = br.readLine()) != null) {
			i++;
			substrings = linije.split("/", 100);
		}
		int id = 0;
		if(i != 0) {
			id = Integer.parseInt(substrings[5]);
		}
		
		br.close();
		return id;
	}
}
