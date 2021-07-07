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

import core.Ucenik;

public class BrisanjeUc {
	private ArrayList<Ucenik> aluc = new ArrayList<Ucenik>();
	private ArrayList<String> idal = new ArrayList<String>();
	private ArrayList<String[]> aloc = new ArrayList<String[]>();
	private PutanjeSlikaIFajlova bf = new PutanjeSlikaIFajlova();
	
	public void PunjenjeListeUcenika() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(bf.PutanjaUcenik));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Ucenik ucenik = new Ucenik(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9], substrings[10]);
			aluc.add(ucenik);
		}
		br.close();
	}
	
	public boolean Provera(String id){
		int i = 0;
		while(i<aluc.size()) {
			if(id.equals(aluc.get(i).jmbg)) {
				return true;
			}
			i++;
		}		
		return false;
	}
	
	public void PunjenjeListeID() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(bf.PutanjaJmbg));
		String vrednosti;
		while((vrednosti = br.readLine())!= null) {
			
			idal.add(vrednosti);
		}
		br.close();
	}
	
	public void PunjenjeListeOcena() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(bf.PutanjaOcene));
		String vrednosti;
		String[] substrings;
		
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			aloc.add(substrings);
		}
		br.close();
	}
	
	public void PretragaListeId(String id) {
		int i = 0;
		int k;
		while(i<idal.size()) {
			if(idal.get(i).equals(id)) {
				k = i;
				idal.remove(k);
			}
			
			i++;
		}
	}
	
	public void PretragaListeUcenika(String id) {
		int i = 0;
		int k;
		while(i<aluc.size()) {
			if(aluc.get(i).jmbg.equals(id)) {
				k = i;
				aluc.remove(k);
			}
			
			i++;
		}
	}
	
	public int PretragaListeOcena(String id) {
		int i = 0;
		int k = 0;
		while(i<aloc.size()) {
			if(aloc.get(i)[1].equals(id)) {
				k++;
				aloc.remove(i);
				return k;
			}
			i++;
		}
		return 0;
	}
	
	public void BrisanjeOcene(String id) {
		while(true) {
			int k = PretragaListeOcena(id);
			if(k == 0) {
				return;
			}
		}
	}
	
	public void UpisUucenika() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(bf.PutanjaUcenik));
		int i = 0;
		while(i<aluc.size()) {
			
			bw.write(aluc.get(i).ime + "/" + aluc.get(i).prezime + "/" + aluc.get(i).jmbg + "/" + aluc.get(i).dan_rodjenja + "/" + aluc.get(i).mesec_rodjenja + "/" + aluc.get(i).godina_rodjenja + "/" + aluc.get(i).pol + "/" + aluc.get(i).razred + "/" + aluc.get(i).godina_upisa + "/" + aluc.get(i).email + "/" + aluc.get(i).sifra);
			bw.newLine();
			i++;
		}
		aluc.clear();
		bw.close();
	}
	
	public void UpisUOcene() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(bf.PutanjaOcene));
		int i = 0;
		while(i<aloc.size()) {
			
			bw.write(aloc.get(i)[0] + "/" + aloc.get(i)[1] + "/" +aloc.get(i)[2] + "/" +aloc.get(i)[3] + "/" +aloc.get(i)[4] + "/" +aloc.get(i)[5]);
			bw.newLine();
			i++;
		}
		aloc.clear();
		bw.close();
		}

	public void UpisUId() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(bf.PutanjaJmbg));
		int i = 0;
		while(i<idal.size()) {
			
			bw.write(idal.get(i));
			bw.newLine();	
			i++;
		}
		idal.clear();
		bw.close();
	}
	
	public void Uspeh() {
		String message = "Uspesno obrisan ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	public void PraznjenjeListe1(){
		idal.clear();
	}
	
	public void PraznjenjeListe2(){
		aluc.clear();
	}
	
	public void PraznjenjeListe3(){
		aloc.clear();
	}
}
