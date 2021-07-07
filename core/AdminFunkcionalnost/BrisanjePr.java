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

public class BrisanjePr {
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	public ArrayList<Profesor> alp = new ArrayList<Profesor>();
	public ArrayList<String> alid = new ArrayList<String>();

	
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
	
	public boolean Provera(String id){
		int i = 0;
		while(i<alp.size()) {
			if(id.equals(alp.get(i).jmbg)) {
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
			
			alid.add(vrednosti);
		}
		br.close();
	}
	
	public void PretragaListeProfesora(String id) {
		int i = 0;
		int k;
		while(i<alp.size()) {
			if(alp.get(i).jmbg.equals(id)) {
				k = i;
				alp.remove(k);
			}
			
			i++;
		}
			
	}
	
	public void PretragaListeId(String id) {
		int i = 0;
		int k;
		while(i<alid.size()) {
			if(alid.get(i).equals(id)) {
				k = i;
				alid.remove(k);
			}
			
			i++;
		}
			
	}
	
	public void UpisUProfesora() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaProfesor));
		int i = 0;
		while(i<alp.size()) {
			
			bw.write(alp.get(i).ime + "/" + alp.get(i).prezime + "/" + alp.get(i).jmbg + "/" + alp.get(i).dan_rodjenja + "/" + alp.get(i).mesec_rodjenja + "/" + alp.get(i).godina_rodjenja + "/" + alp.get(i).pol + "/" + alp.get(i).email + "/" + alp.get(i).sifra + "/" + alp.get(i).predmet + "/" + alp.get(i).sifra);
			bw.newLine();
			
			
			i++;
		}
		alp.clear();
		bw.close();
		}


	public void UpisUId() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaJmbg));
		int i = 0;
		while(i<alid.size()) {
			
			bw.write(alid.get(i));
			bw.newLine();
			
			
			i++;
		}
		alid.clear();
		bw.close();
		}
	
	public void Uspeh() {
		String message = "Uspesno obrisan profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
		
	
}
