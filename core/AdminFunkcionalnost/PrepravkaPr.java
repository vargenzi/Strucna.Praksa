package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		int i = 0;
		while(i<alp.size()) {
			
			if(id.equals(alp.get(i).id)) {
				alp.clear();
				return true;
			}
			i++;
		}
		alp.clear();
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
			if(id.equals(alp.get(i).id)) {
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
	
	public void Cuvanje() throws Exception {
		Serijalizuj(pf.PutanjaProfesorPr);
	}
	
	public void Uspeh() {
		String message = "Uspesno prepravljen profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	@SuppressWarnings("unchecked")
	public void Deserijalizuj(String putanja) throws Exception {		
		File file = new File(putanja);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = null;
	    try {
	    	ois = new ObjectInputStream(fis);
	    	alp = (ArrayList<Profesor>)ois.readObject();
	    }catch(EOFException e) {
	    	System.out.println("End of file.");
	    }
	    try {
	        ois.close();
	        fis.close();
	    }catch(NullPointerException e) {
	    	System.out.println("");
	    }
	}
	
	public void Serijalizuj(String putanja) throws Exception{
        File file = new File(putanja);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream aoos = new ObjectOutputStream(fos);
        aoos.writeObject(alp);
        aoos.close();
        fos.close();
        alp.clear();
    }
	
}
