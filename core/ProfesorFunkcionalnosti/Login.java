package core.ProfesorFunkcionalnosti;

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

import core.Profesor;
import ui.PutanjeSlikaIFajlova;

public class Login {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Profesor> alp = new ArrayList<Profesor>();
	
	public boolean Provera(String email, String sifra)  throws Exception{
		Deserijalizuj(pf.PutanjaProfesorPr);
		int i = 0;
		while(i<alp.size()) {
			if(alp.get(i).email.equals(email)&&alp.get(i).sifra.equals(sifra)){
				return true;
			}
			i++;
		}
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
	
	@SuppressWarnings("unchecked")
	public void Deserijalizuj(String putanja) throws Exception {		
		File file = new File(putanja);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = null;
	    try {
	    	ois = new ObjectInputStream(fis);
	    	alp = (ArrayList<Profesor>)ois.readObject();
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
