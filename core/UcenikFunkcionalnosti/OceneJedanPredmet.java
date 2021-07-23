package core.UcenikFunkcionalnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;
import core.Ocena;
import core.Profesor;
import core.Ucenik;

public class OceneJedanPredmet {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	private ArrayList<String[]> als = new ArrayList<String[]>();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private ArrayList<Ocena> alo = new ArrayList<Ocena>();

	public boolean PostojanjePredmeta(String predmet) throws Exception {
		alp = ds.DeserijalizujProfesora();
		int i = 0;
		while(i < alp.size()) {
			if(alp.get(i).predmet.equals(predmet)) {
				return true;
			}
			i++;
		}
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
	
	public String[] TrazenjeImenaJmbg(String[] niz) throws Exception {
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
	
	public boolean PunjenjeListe(String predmet, String id) throws Exception {
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		boolean k = false;
		
		while(i < alo.size()) {
			
			if(alo.get(i).id_ucenika.equals(id) && alo.get(i).predmet.equals(predmet)) {
				
				String novo[] = {alo.get(i).opis, alo.get(i).ocena};
				als.add(novo);
				k = true;
			}
			i++;
		}
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
			int ocena = Integer.parseInt(als.get(i)[1]);
			zbir += ocena;
			i++;
		}
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
		alu.clear();
		alp.clear();
		alo.clear();
	}
}
