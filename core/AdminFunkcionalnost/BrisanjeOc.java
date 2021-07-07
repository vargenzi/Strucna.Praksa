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

public class BrisanjeOc {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	public ArrayList<String[]> alo = new ArrayList<String[]>();

	public boolean ProveraPostojanja(String id) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(id)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
		
	}
	
	public void TrazenejOcena(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[1].equals(id)) {
				alo.add(substrings);
				System.out.print("\n" + substrings);
			}
		
		}
		br.close();
	}
	
	public String IspisOcena() {
		int i = 0;
		String tekst = "";
		while(i<alo.size()) {
			tekst += "               Predmet: " + alo.get(i)[2] + "\n               Ocena:" + alo.get(i)[3] + "\n               Opis:" + alo.get(i)[4] + "\n               ID:" + alo.get(i)[5] + "\n ------------------------------------------------ \n";
		i++;
		}
		return tekst;
	}
	
	public void PunjenjeListe() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaOcene));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			alo.add(substrings);
		}

		br.close();
	}
	
	public int ProveraPosotjanjaId(String id) {
		
		int i = 0;
		while(i<alo.size()) {
			
			if(alo.get(i)[5].equals(id)) {
				alo.remove(i);
				return i;
			}
			
			i++;
		}
		
	return 100;
	}
	
	public void UpisUFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaOcene));
		int i = 0;
		while(i<alo.size()) {
			bw.write(alo.get(i)[0] + "/" + alo.get(i)[1] + "/" +alo.get(i)[2] + "/" +alo.get(i)[3] + "/" +alo.get(i)[4] + "/" +alo.get(i)[5]);
			bw.newLine();

			i++;
		}
		alo.clear();
		bw.close();
	}
	
	public void Uspeh() {
		String message = "Uspesno obrisan profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
}
