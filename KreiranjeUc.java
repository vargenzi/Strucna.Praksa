package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import ui.PutanjeSlikaIFajlova;

class MyObjectOutputStream  extends ObjectOutputStream{

    public MyObjectOutputStream() throws Exception, Exception{
        super();
    }
    public MyObjectOutputStream(OutputStream o) throws Exception{
        super(o);
    }
    public void writeStreamHeader(){}
}


public class KreiranjeUc {

	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private ArrayList<Ucenik> alu = new ArrayList<Ucenik>();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}

	
	public boolean ValidacijaUnosa(String ime, String prezime, String id, String pol, String dan, String mesec, String godina, String godina_upisa, String razred, String email, String sifra) {
		
		if(ime.equals("")||prezime.equals("")||id.equals("")||(pol == null)||dan.equals("-")||mesec.equals("-")||godina.equals("-")||godina_upisa.equals("-")||razred.equals("-")||email.equals("")||sifra.equals("")||(sifra.length()<8)) {
			return true;
		}
		return false;
		
	}
	
	public boolean ProveraJedinstvenostiID(String jmbg) throws Exception {

		Deserijalizuj(pf.PutanjaUcenikUc);
		int i = 0;
		while(i<alu.size()){
			if(alu.get(i).jmbg.equals(jmbg)) {
				alu.clear();
				return true;
			}
		}
		alu.clear();
		return false;
	}
		/*BufferedReader br = null;
		br = new BufferedReader(new FileReader(pf.PutanjaJmbg));
		String linije;
		String vrednosti = "";
		while((linije = br.readLine()) != null){
			
			vrednosti = linije;
			if(vrednosti.equals(jmbg)) {
				br.close();
				return false;
			}
		}
		br.close();
		
		return true;
	}*/

	public boolean JedinstvenostEmailSifra(String sifra, String email) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pf.PutanjaUcenik)); 
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(substrings[9].equals(email)||substrings[10].equals(sifra)) {
				br.close();
				return true;
			}
		}
		br.close();
		return false;
		
	}
	
	public boolean PoklapanjeGodina(String godinaUpisa, String godina, String razred) {
		
		int godina_u = Integer.parseInt(godinaUpisa);
		int godina_r = Integer.parseInt(godina);
		int razlika = godina_u - godina_r;
		String substrings[] = razred.split(" ", 100);
		if(substrings[1].equals("SS")) {
			if(substrings[0].equals("Prvi")) {
				if((razlika == 14)||(razlika == 15)||(razlika == 16)) {
					return false;
				}
			}
			if(substrings[0].equals("Drugi")) {
				if((razlika == 15)||(razlika == 16)||(razlika == 17)) {
					return false;
				}
			}
			if(substrings[0].equals("Treci")) {
				if((razlika == 16)||(razlika == 17)||(razlika == 18)) {
					return false;
				}
			}
			if(substrings[0].equals("Cetvrti")) {
				if((razlika == 17)||(razlika == 18)||(razlika == 19)) {
					return false;
				}
			}
		}
		if(substrings[1].equals("OS")) {
			if(substrings[0].equals("Prvi")) {
				if((razlika == 6)||(razlika == 7)||(razlika == 8)) {
					return false;
				}
			}
			if(substrings[0].equals("Drugi")) {
				if((razlika == 7)||(razlika == 8)||(razlika == 9)) {
					return false;
				}
			}
			if(substrings[0].equals("Treci")) {
				if((razlika == 8)||(razlika == 9)||(razlika == 10)) {
					return false;
				}
			}
			if(substrings[0].equals("Cetvrti")) {
				if((razlika == 9)||(razlika == 10)||(razlika == 11)) {
					return false;
				}
			}
			if(substrings[0].equals("Peti")) {
				if((razlika == 10)||(razlika == 11)||(razlika == 12)) {
					return false;
				}
			}
			if(substrings[0].equals("Sesti")) {
				if((razlika == 11)||(razlika == 12)||(razlika == 13)) {
					return false;
				}
			}
			if(substrings[0].equals("Sedmi")) {
				if((razlika == 12)||(razlika == 13)||(razlika == 14)) {
					return false;
				}
			}
			if(substrings[0].equals("Osmi")) {
				if((razlika == 13)||(razlika == 14)||(razlika == 15)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void Uspeh() {
		String message = "Uspresno sacuvan novi ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Ucenik ucenik) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(pf.PutanjaUcenik, true)); 
		
		bw.write(ucenik.ime + "/" + ucenik.prezime + "/" + ucenik.jmbg + "/" + ucenik.dan_rodjenja + "/" + ucenik.mesec_rodjenja + "/" + ucenik.godina_rodjenja  + "/" + ucenik.pol + "/" + ucenik.razred + "/" + ucenik.godina_upisa + "/" + ucenik.email + "/" + ucenik.sifra);
		try {
			Serijalizuj(ucenik, pf.PutanjaUcenikUc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		bw.newLine();
		bw.close();
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(pf.PutanjaJmbg, true));
		bw1.write(ucenik.jmbg);
		bw1.newLine();
		bw1.close();
		
		
	}
	
	public void Serijalizuj(Ucenik objekat, String putanja) throws Exception{
        File file = new File(putanja);
        FileOutputStream fos = new FileOutputStream(file,true);

        if(file.length()<1){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objekat);
            oos.close();
            fos.close();
        }else{
            MyObjectOutputStream mos = new MyObjectOutputStream(fos);
            mos.writeObject(objekat);
            mos.close();
            fos.close();
        }
    }
	
	public void Deserijalizuj(String putanja) throws Exception {		
		File file = new File(putanja);        
		FileInputStream fis = new FileInputStream(file);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        while(fis.available()>0){
	            Ucenik uc = (Ucenik) ois.readObject();
	            alu.add(uc);
	        }
	        ois.close();
	        fis.close();
	}

}