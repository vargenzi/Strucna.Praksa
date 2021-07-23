package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;
import core.Ocena;
import core.Profesor; 

public class SveOceneJednog {

	private ArrayList<String[]> ars = new ArrayList<String[]>();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private ArrayList<Ocena> alo = new ArrayList<Ocena>();
	private ArrayList<Ocena> aloPom = new ArrayList<Ocena>();
	private ArrayList<Ucenik> aluPom = new ArrayList<Ucenik>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean Provera(String id) throws Exception {
		alu = ds.DeserijalizujUcenika();
		int i = 0;
		while(i < alu.size()) {
			if(alu.get(i).id.equals(id)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public  void PunjenjeListe(String id) throws IOException{
		int i = 0;
		while(i < alu.size()) {
			if(id.equals(alu.get(i).id)) {
				 aluPom.add(alu.get(i));
			}
			i++;
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
	
	public String[] TrazenjeIdPredmeta(String[] niz) throws Exception {
		alp = ds.DeserijalizujProfesora();
		int i = 0;
		while(i < alp.size()) {
			if(niz[0].equals(alp.get(i).email)&&niz[1].equals(alp.get(i).sifra)) {
				String povratni[] = {alp.get(i).id, alp.get(i).predmet};
				return povratni;
			}
			i++;
		}
		return null;
	}
	
	public  void PunjenjeListe2(String id, String idp) throws Exception{
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		while(i < alo.size()) {
			if(alo.get(i).id_ucenika.equals(id) && alo.get(i).id_profesora.equals(idp)) {
				aloPom.add(alo.get(i));
			}
			i++;
		}
		alo.clear();
	}
	
	public String Ispis(String predmet) {
		String tekst = "PREDMET: " + predmet + "\n";
		tekst += "                Ime: " + aluPom.get(0).ime + "\n" + "                Prezime: " + aluPom.get(0).prezime + "\n";
		int i = 0;
		while(i < aloPom.size()) {
			int j = 0;
			while(j < aluPom.size()) {
				if(aluPom.get(j).id.equals(aloPom.get(i).id_ucenika)) {
					tekst += "                Ocena: " + aloPom.get(i).ocena + "    " + "    Opis: " + aloPom.get(i).opis + "\n" + "                -------------------------- \n";
				}
				j++;
			}
			i++;
		}
		return tekst;
	}

	
	public void IsprazniListe() {
		
		alu.clear();
	}
}
