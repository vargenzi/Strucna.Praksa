package core.AdminFunkcionalnost;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;

public class PrepravkaUc {
	
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public boolean ProveraPostojanjaID(String id) {
		int i = 0;
		while(i<alu.size()) {
			if(id.equals(alu.get(i).id)) {
				alu.clear();
				return true;
			}
			i++;
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
			if(id.equals(alu.get(i).id)) {
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
	
	public boolean PoklapanjeGodina(String godinaUpisa, String godina, String razred) {
		
		int godina_u = Integer.parseInt(godinaUpisa);
		int godina_r = Integer.parseInt(godina);
		int razlika = godina_u - godina_r;
		String substrings[] = razred.split(" ", 100);
		if(substrings[1].equals("SS")) {
			if(substrings[0].equals("Prvi")) {
				if((razlika == 14)||(razlika == 15)||(razlika == 16)) {
					return false;
				}
			}
			if(substrings[0].equals("Drugi")) {
				if((razlika == 15)||(razlika == 16)||(razlika == 17)) {
					return false;
				}
			}
			if(substrings[0].equals("Treci")) {
				if((razlika == 16)||(razlika == 17)||(razlika == 18)) {
					return false;
				}
			}
			if(substrings[0].equals("Cetvrti")) {
				if((razlika == 17)||(razlika == 18)||(razlika == 19)) {
					return false;
				}
			}
		}
		if(substrings[1].equals("OS")) {
			if(substrings[0].equals("Prvi")) {
				if((razlika == 6)||(razlika == 7)||(razlika == 8)) {
					return false;
				}
			}
			if(substrings[0].equals("Drugi")) {
				if((razlika == 7)||(razlika == 8)||(razlika == 9)) {
					return false;
				}
			}
			if(substrings[0].equals("Treci")) {
				if((razlika == 8)||(razlika == 9)||(razlika == 10)) {
					return false;
				}
			}
			if(substrings[0].equals("Cetvrti")) {
				if((razlika == 9)||(razlika == 10)||(razlika == 11)) {
					return false;
				}
			}
			if(substrings[0].equals("Peti")) {
				if((razlika == 10)||(razlika == 11)||(razlika == 12)) {
					return false;
				}
			}
			if(substrings[0].equals("Sesti")) {
				if((razlika == 11)||(razlika == 12)||(razlika == 13)) {
					return false;
				}
			}
			if(substrings[0].equals("Sedmi")) {
				if((razlika == 12)||(razlika == 13)||(razlika == 14)) {
					return false;
				}
			}
			if(substrings[0].equals("Osmi")) {
				if((razlika == 13)||(razlika == 14)||(razlika == 15)) {
					return false;
				}
			}
		}
		
		return true;
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
	
	public void Cuvanje() throws Exception {
		Serijalizuj(pf.PutanjaUcenikUc);
	}
	
	public void Serijalizuj(String putanja) throws Exception{
        File file = new File(putanja);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream aoos = new ObjectOutputStream(fos);
        aoos.writeObject(alu);
        aoos.close();
        fos.close();
        alu.clear();
    }
	
	public void Uspeh() {
		String message = "Uspesno prepravljen ucenik.";
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
	    	alu = (ArrayList<Ucenik>)ois.readObject();
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
	
}
