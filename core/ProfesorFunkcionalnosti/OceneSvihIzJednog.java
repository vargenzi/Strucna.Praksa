package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;
import core.Ocena;
import core.Profesor;
import core.Ucenik;

public class OceneSvihIzJednog {

	private ArrayList<Ocena> alo = new ArrayList<Ocena>();
	private ArrayList<Ocena> aloPom = new ArrayList<Ocena>();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private ArrayList<String[]> als = new ArrayList<String[]>();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
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
	
	public String[] TrazenjeIdIPredmeta(String[] niz) throws Exception {
		alp = ds.DeserijalizujProfesora();
		String email = niz[0];
		String sifra  = niz[1];
		int i = 0;
		
		while(i<alp.size()) {
			if(email.equals(alp.get(i).email) && sifra.equals(alp.get(i).sifra)) {
				String povratni[] = {alp.get(i).id, alp.get(i).predmet};
				alp.clear();
				return povratni;
			}
			i++;
		}
		alp.clear();
		return null;
	}

	public void Greska(String poruka) {
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, poruka, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public void PunjenjeListe(String niz1[]) throws Exception {
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		while(i < alo.size()) {
			if(alo.get(i).id_profesora.equals(niz1[0])) {
				aloPom.add(alo.get(i));
			}	
		i++;
		}
	}
	
	public void TrazenjeImena() throws Exception {
		alu = ds.DeserijalizujUcenika();
		int i = 0;
		
		while(i < aloPom.size()) {
			int j = 0;
			while(j < alu.size()) {
				if(alu.get(j).id.equals(aloPom.get(i).id_ucenika)) {
					String novo [] = {alu.get(j).ime, alu.get(j).prezime, aloPom.get(i).ocena, aloPom.get(i).opis};
					als.add(novo);
				}
				j++;
			}
			i++;
		}	
	}
	
	public String Ispis(String predmet) {
		String tekst = "PREDMET: " + predmet + "\n";
		int i = 0;
		
		while(i<als.size()) {
			tekst += "              Ime: " + als.get(i)[0] + " -- Prezime: " + als.get(i)[1] + " -- Ocena: " + als.get(i)[2] + " -- Opis:" + als.get(i)[3] + "\n";
			i++;
		}

		return tekst;
	}
	
	public void PraznjenjeSvihListi() {
		als.clear();
		alu.clear();
		alo.clear();
		aloPom.clear();
	}
	
}
