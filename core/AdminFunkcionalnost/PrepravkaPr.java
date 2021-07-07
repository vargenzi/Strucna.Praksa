package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Profesor;
import ui.PutanjeSlikaIFajlova;

public class PrepravkaPr {
	
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public void PunjenjeListeProfesora() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Profesor profesor = new Profesor(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9]);
			alp.add(profesor);
		}
		br.close();
	
	}
	
	public boolean ProveraPostojanja(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String linije;
		String substrings[];
		
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(id.equals(substrings[2])) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}
	
	public void Greska(String poruka) {
		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, poruka, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}
	
	public int PretragaProfesora(String id) {
		int i = 0;
		int k;
		while(i<alp.size()) {
			if(id.equals(alp.get(i).jmbg)) {
				k = i;
				return k;
			}
			
			i++;
		}
		
		return 123456;
	}
	
	public Profesor VratiProfesora(int indeks) {
		Profesor profesor = alp.get(indeks);
		return profesor;
		
	}
	
	public void PostaviIme(String ime, int indeks, Profesor profesor) {
		
		profesor.ime = ime;
		alp.set(indeks, profesor);
	}
	
	public void PostaviPrezime(String prezime, int indeks, Profesor profesor) {
		
		profesor.prezime = prezime;
		alp.set(indeks, profesor);
	}
	
	public void PostaviPol(String pol, int indeks, Profesor profesor) {
		
		profesor.pol = pol;
		alp.set(indeks, profesor);
	}
	
	public void PostaviDanMesecGodinu(String dan, String mesec, String godina, int indeks, Profesor profesor) {
	
	profesor.dan_rodjenja = dan;
	profesor.mesec_rodjenja = mesec;
	profesor.godina_rodjenja = godina;
	alp.set(indeks, profesor);
	}
	
	public void PostaviEmail(String email, int indeks, Profesor profesor) {
		
		profesor.email = email;
		alp.set(indeks, profesor);
	}
	
	public void PostaviSifru(String sifra, int indeks, Profesor profesor) {
		
		profesor.sifra = sifra;
		alp.set(indeks, profesor);
	}
	
	public void PostaviPredmet(String predmet, int indeks, Profesor profesor) {
		
		profesor.predmet = predmet;
		alp.set(indeks, profesor);
	}
	
	public void Cuvanje() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaProfesor));
		int i = 0;
		while(i<alp.size()) {
			
			bw.write(alp.get(i).ime + "/" + alp.get(i).prezime + "/" + alp.get(i).jmbg + "/" + alp.get(i).dan_rodjenja + "/" + alp.get(i).mesec_rodjenja + "/" + alp.get(i).godina_rodjenja + "/" + alp.get(i).pol + "/" + alp.get(i).email + "/" + alp.get(i).sifra + "/" + alp.get(i).predmet);
			bw.newLine();
			
			
			i++;
		}
		bw.close();
	}
	
	public void Uspeh() {
		String message = "Uspesno prepravljen profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void PraznjenjeListe() {
		alp.clear();
	}
	
}
