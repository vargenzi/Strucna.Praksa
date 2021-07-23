package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;
import core.Ucenik;
import core.DeserijalizujSerijalizuj;
import core.Ocena;

public class BrisanjeUc {
	private ArrayList<Ucenik> aluc = new ArrayList<Ucenik>();
	private ArrayList<String> idal = new ArrayList<String>();
	private ArrayList<Ocena> aloc = new ArrayList<Ocena>();
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
	public boolean Provera(String id) throws Exception{
		int i = 0;
		aluc.clear();
		aluc = ds.DeserijalizujUcenika();
		while(i<aluc.size()) {
			if(id.equals(aluc.get(i).id)) {
				return true;
			}
			i++;
		}		
		return false;
	}
	
	public void PunjenjeListeID() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaJmbg));
		String vrednosti;
		while((vrednosti = br.readLine())!= null) {
			
			idal.add(vrednosti);
		}
		br.close();
	}
	
	public void PunjenjeListeOcena() throws Exception {
		aloc = ds.DeserijalizujOcenu();
	}
	
	public void PretragaListeId(String id) {
		int i = 0;
		int k;
		while(i<idal.size()) {
			if(idal.get(i).equals(id)) {
				k = i;
				idal.remove(k);
				return;
			}
			i++;
		}
	}
	
	public void PretragaListeUcenika(String id) {
		int i = 0;
		int k;
		while(i<aluc.size()) {
			if(aluc.get(i).id.equals(id)) {
				k = i;
				aluc.remove(k);
				return;
			}
			
			i++;
		}
	}
	
	public int PretragaListeOcena(String id) {
		int i = 0;
		int k = 0;
		while(i<aloc.size()) {
			if(aloc.get(i).id_ucenika.equals(id)) {
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
	
	public void UpisUucenika() throws Exception {
		Ucenik ucenik = null;
		ds.SerijalizujUcenika(ucenik, aluc, false);
		aluc.clear();
	}
	
	public void UpisUOcene() throws Exception {
			Ocena ocena = null;
			ds.SerijalizujOcenu(ocena, aloc, false);
			aloc.clear();
		}

	public void UpisUId() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaJmbg));
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
