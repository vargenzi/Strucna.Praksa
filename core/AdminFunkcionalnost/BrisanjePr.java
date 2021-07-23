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

public class BrisanjePr {
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	private ArrayList<String> alid = new ArrayList<String>();
	private DeserijalizujSerijalizuj ds = new DeserijalizujSerijalizuj();
	
	public boolean Provera(String id) throws Exception{
		int i = 0;
		alp.clear();
		alp = ds.DeserijalizujProfesora();
		System.out.println(alp);
		while(i<alp.size()) {
			System.out.println(alp.get(i).id);
			if(id.equals(alp.get(i).id)) {
				
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
			if(alp.get(i).id.equals(id)) {
				k = i;
				alp.remove(k);
				return;
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
				return;
			}
			
			i++;
		}
			
	}
	
	public void UpisUProfesora() throws Exception {
		Profesor profesor = null;
		ds.SerijalizujProfesora(profesor, alp, false);
		alp.clear();
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
	public void PraznjenjeListeId() {
		alid.clear();
	}
	
	public void PraznjenjeListePr() {
		alp.clear();
	}
}
