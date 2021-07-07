package core.ProfesorFunkcionalnosti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class Login {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public boolean Provera(String email, String sifra)  throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaProfesor));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			
			substrings = linije.split("/", 100);
			if(substrings[7].equals(email) && substrings[8].equals(sifra)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
	}
	
	public void UpisULogove(String email, String sifra) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.LogoviProf));
	
		bw.write(email + "/" + sifra);
		
		bw.close();
	}
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
}
