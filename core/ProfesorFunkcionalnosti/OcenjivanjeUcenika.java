package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ocena;
import core.Profesor;
import core.Ucenik;
import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;

public class OcenjivanjeUcenika {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private ArrayList<Ocena> alo = new ArrayList<Ocena>();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
	public boolean ValidacijUnosa(String id) {
		if(id.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean ProveraPostojanjaIdUcenika(String id) throws Exception {
		alu = ds.DeserijalizujUcenika();
		int i = 0;
		while(i < alu.size()) {
			if(alu.get(i).id.equals(id)) {
				alu.clear();
				return true;
			}
			i++;
		}
		alu.clear();
		return false;
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
	
	public void Uspeh() {
		String message = "Uspesno ocenjen ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public int IdOcene() throws Exception {
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		while(i<alo.size()) {

			i++;
		}
		int id = 0;
		if(i != 0) {
			id = i;
		}
		return id;
	}
	
	public String[] IdProfIPredmet(String email, String sifra) throws Exception {
		alp = ds.DeserijalizujProfesora();
		int i = 0;
		while(i < alp.size()) {
			if(alp.get(i).email.equals(email) && alp.get(i).sifra.equals(sifra)) {
				String predmet = alp.get(i).predmet;
				String id_prof = alp.get(i).id;
				String povratni []= {id_prof, predmet};
				alp.clear();
				return povratni;
			}
			i++;
		}
		return null;
	}
	
	public void UpisiOcenu(Ocena ocena) throws Exception {
		ds.SerijalizujOcenu(ocena, alo, true);
		alo.clear();
	}
}
