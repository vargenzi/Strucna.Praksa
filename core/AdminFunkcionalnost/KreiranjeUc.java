package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;

public class KreiranjeUc {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();

	
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}

	
	public boolean ValidacijaUnosa(String ime, String prezime, String id, String pol, String dan, String mesec, String godina, String godina_upisa, String razred, String email, String sifra) {
		
		if(ime.equals("")||prezime.equals("")||id.equals("")||(pol == null)||dan.equals("-")||mesec.equals("-")||godina.equals("-")||godina_upisa.equals("-")||razred.equals("-")||email.equals("")||sifra.equals("")||(sifra.length()<8)) {
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
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik)); 
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(substrings[9].equals(email)||substrings[10].equals(sifra)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
		
	}
	
	public void Uspeh() {
		String message = "Uspresno sacuvan novi ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Ucenik ucenik) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaUcenik, true)); 
		
		bw.write(ucenik.ime + "/" + ucenik.prezime + "/" + ucenik.jmbg + "/" + ucenik.dan_rodjenja + "/" + ucenik.mesec_rodjenja + "/" + ucenik.godina_rodjenja  + "/" + ucenik.pol + "/" + ucenik.razred + "/" + ucenik.godina_upisa + "/" + ucenik.email + "/" + ucenik.sifra);
		bw.newLine();
		bw.close();
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(pf.PutanjaJmbg, true));
		bw1.write(ucenik.jmbg);
		bw1.newLine();
		bw1.close();
		
		
	}
	
}
