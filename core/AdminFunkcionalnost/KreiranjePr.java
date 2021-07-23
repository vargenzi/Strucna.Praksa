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
import core.DeserijalizujSerijalizuj;

public class KreiranjePr {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
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

	public boolean JedinstvenostEmailSifra(String sifra, String email) throws Exception {
		int i = 0;
		alp = ds.DeserijalizujProfesora();
		try {
			while(i<alp.size()) {
				if(alp.get(i).email.equals(email) || alp.get(i).sifra.equals(sifra)) {
					return true;
				}
				i++;
			}
		}catch(NullPointerException e) {
			System.out.println("");
		}
		return false;
	}
	
	public void Uspeh() {
		String message = "Uspresno sacuvan novi profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Profesor profesor) throws IOException {
		try {
			ds.SerijalizujProfesora(profesor, alp, true);
			IsprazniAlp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		UpisId(profesor.id);
	}
	
	public void UpisId(String id) throws IOException {
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(pf.PutanjaJmbg, true));
		bw1.write(id);
		bw1.newLine();
		bw1.close();
	}
	public void IsprazniAlp() {
		alp.clear();
	}
}
