package core.UcenikFunkcionalnosti;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;

public class UcenikLogin {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	
	public boolean Provera(String email, String sifra) {
		if(email.equals("") || sifra.equals("")) {
			return true;
		}
		return false;
	}
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean ProveraPostojanja(String email, String sifra)  throws Exception{
		Deserijalizuj(pf.PutanjaUcenikUc);
		int i = 0;
		while(i<alu.size()) {
			if(alu.get(i).email.equals(email)&&alu.get(i).sifra.equals(sifra)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public void UpisULogove(String email, String sifra) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.LogoviUc));
		
		bw.write(email + "/" + sifra);
		
		bw.close();
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
