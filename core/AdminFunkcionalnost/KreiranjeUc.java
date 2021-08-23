package core.AdminFunkcionalnost;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ucenik;
import core.Baza;

public class KreiranjeUc {

	private Baza baza = new Baza();
	
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
	
	public boolean ProveraJedinstvenostiID(String id) throws IOException, ClassNotFoundException, SQLException {
		Connection con = baza.Konekcija();
		String query = "SELECT * FROM osoba WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			baza.PrekidVeze(con);
			return true;
		}
		baza.PrekidVeze(con);
		return false;
	}

	public boolean JedinstvenostEmailSifra(String sifra, String email) throws Exception {		
		Connection con = baza.Konekcija();
		String query = "SELECT * FROM osoba WHERE email=? AND sifra=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, sifra);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			baza.PrekidVeze(con);
			return true;
		}
		baza.PrekidVeze(con);
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
		String message = "Uspesno sacuvan novi ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Ucenik ucenik) throws IOException, SQLException, ClassNotFoundException, ParseException{
		Connection con = baza.Konekcija();
		baza.UpisUcenika(ucenik, con);
		baza.PrekidVeze(con);
		con = baza.Konekcija();
		baza.UpisDodatnihPodatakaUc(ucenik, con);
		baza.PrekidVeze(con);
	}

}