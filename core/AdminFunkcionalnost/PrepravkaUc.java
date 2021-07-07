package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;

public class PrepravkaUc {
	
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public void PunjenjeListeUcenika() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Ucenik ucenik = new Ucenik(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9], substrings[10]);
			alu.add(ucenik);
		}
		br.close();
	
	}
	
	public boolean ProveraPostojanjaID(String id) {
		int i = 0;
		while(i<alu.size()) {
			if(id.equals(alu.get(i).jmbg)) {
				alu.clear();
				return true;
			}
		}
		alu.clear();
		return false;
		
		
	}
	
	public void Greska(String poruka) {
		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, poruka, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}
	
	public int PretragaUcenika(String id) {
		int i = 0;
		int k;
		while(i<alu.size()) {
			if(id.equals(alu.get(i).jmbg)) {
				k = i;
				return k;
			}
			
			i++;
		}
		
		return 123456;
	}
	
	public Ucenik VratiUcenika(int indeks) {
		Ucenik ucenik = alu.get(indeks);
		return ucenik;
		
	}
	
	public void PostaviIme(String ime, int indeks, Ucenik ucenik) {
		
		ucenik.ime = ime;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviPrezime(String prezime, int indeks, Ucenik ucenik) {
		
		ucenik.prezime = prezime;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviPol(String pol, int indeks, Ucenik ucenik) {
		
		ucenik.pol = pol;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviDanMesecGodinu(String dan, String mesec, String godina, int indeks, Ucenik ucenik) {
	
		ucenik.dan_rodjenja = dan;
		ucenik.mesec_rodjenja = mesec;
		ucenik.godina_rodjenja = godina;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviGodinuUpisa(String godina, int indeks, Ucenik ucenik) {
		
		ucenik.godina_upisa = godina;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviEmail(String email, int indeks, Ucenik ucenik) {
		
		ucenik.email = email;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviSifru(String sifra, int indeks, Ucenik ucenik) {
		
		ucenik.sifra = sifra;
		alu.set(indeks, ucenik);
	}
	
	public void PostaviRazred(String razred, int indeks, Ucenik ucenik) {
		
		ucenik.razred = razred;
		alu.set(indeks, ucenik);
	}
	
	public void Cuvanje() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaUcenik));
		int i = 0;
		while(i<alu.size()) {
			
			bw.write(alu.get(i).ime + "/" + alu.get(i).prezime + "/" + alu.get(i).jmbg + "/" + alu.get(i).dan_rodjenja + "/" + alu.get(i).mesec_rodjenja + "/" + alu.get(i).godina_rodjenja + "/" + alu.get(i).pol + "/" + alu.get(i).razred + "/" + alu.get(i).godina_upisa + "/" + alu.get(i).email+ "/" + alu.get(i).sifra);
			bw.newLine();
			
			
			i++;
		}
		bw.close();
		alu.clear();
	}
	
	public void Uspeh() {
		String message = "Uspesno prepravljen ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
}
