package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;

public class Login {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}
	
public boolean ProveraAdmina(String user, String sifra) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaAdmin));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!=null) {
			substrings = vrednosti.split("/", 100);
			if(user.equals(substrings[0]) && sifra.equals(substrings[1])) {
				br.close();
				return true;
			}
			
		}
		br.close();
		return false;	
	}
	
}
