package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Profesor;
import ui.PutanjeSlikaIFajlova;

public class KreiranjePr {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();

	
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}

	
	public boolean ValidacijaUnosa(String ime, String prezime, String id, String pol, String dan, String mesec, String godina, String predmet, String email, String sifra) {
		
		if(ime.equals("") || prezime.equals("") || id.equals("") || (pol == null) || email.equals("") || sifra.equals("") || dan.equals("-") || mesec.equals("-") || godina.equals("-") || predmet.equals("") || (sifra.length()<8)) {
			return true;
		}
		return false;
		
	}
	
	public boolean ProveraJedinstvenostiID(String jmbg) throws IOException {
		BufferedReader	br = new BufferedReader(new FileReader(pf.PutanjaJmbg));
		String linije;
		String vrednosti = "";
		while((linije = br.readLine()) != null){
			
			vrednosti = linije;
			if(vrednosti.equals(jmbg)) {
				br.close();
				return true;
			}
		}
		br.close();
		
		return false;
	}

	
	public boolean JedinstvenostEmailSifra(String sifra, String email) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor)); 
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(substrings[7].equals(email)||substrings[8].equals(sifra)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
		
	}
	
	public void Uspeh() {
		String message = "Uspresno sacuvan novi profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Profesor profesor) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaProfesor, true)); 
		
		bw.write(profesor.ime + "/" + profesor.prezime + "/" +profesor.jmbg + "/" + profesor.dan_rodjenja + "/" + profesor.mesec_rodjenja + "/" + profesor.godina_rodjenja  + "/" + profesor.pol + "/" + profesor.email + "/" + profesor.sifra + "/" + profesor.predmet);
		bw.newLine();
		bw.close();
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(pf.PutanjaJmbg, true));
		bw1.write(profesor.jmbg);
		bw1.newLine();
		bw1.close();
		
		
	}
	
}
