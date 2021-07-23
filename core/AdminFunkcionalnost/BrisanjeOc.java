package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;
import core.DeserijalizujSerijalizuj;
import core.Ocena;
import core.Ucenik;

public class BrisanjeOc {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Ocena> alo = new ArrayList<Ocena>();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();

	public boolean ProveraPostojanja(String id) throws Exception {
		alu = ds.DeserijalizujUcenika();
		int i = 0;
		while(i<alu.size()) {
			if(alu.get(i).id.equals(id)) {
				alu.clear();
				return true;
			}
			i++;
		}
		alu.clear();
		return false;
	}
	
	public String TrazenejOcena(String id) throws Exception {
		alo = ds.DeserijalizujOcenu();
		int i = 0;
		String tekst = "";
		while(i<alo.size()) {
			if(alo.get(i).id_ucenika.equals(id)) {
				tekst += "               Predmet: " + alo.get(i).predmet + "\n               Ocena:" + alo.get(i).ocena + "\n               Opis:" + alo.get(i).opis + "\n               ID:" + alo.get(i).id_ocene + "\n ------------------------------------------------ \n";
			}
			i++;
		}
		return tekst;
	}
	
	public int ProveraPosotjanjaId(String id) {
		
		int i = 0;
		while(i<alo.size()) {
			if(alo.get(i).id_ocene.equals(id)) {
				alo.remove(i);
				return i;
			}
			i++;
		}
		
	return 100;
	}
	
	public void UpisUFile() throws Exception {
		Ocena objekat = null;
		ds.SerijalizujOcenu(objekat, alo, false);
		alo.clear();
	}
	
	public void Uspeh() {
		String message = "Uspesno obrisana ocena.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
		
}
