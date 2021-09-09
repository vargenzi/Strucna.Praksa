package core.AdminFunkcionalnost;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Profesor;
import core.Baza;

public class KreiranjePr {

	private Baza baza = new Baza();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}

	
	public boolean ValidacijaUnosa(String ime, String prezime, String id, String pol, String dan, String mesec, String godina, String predmet, String email, String sifra) {
		
		if(ime.equals("") || prezime.equals("") || id.equals("") || (pol == null) || email.equals("") || sifra.equals("") || dan.equals("-") || mesec.equals("-") || godina.equals("-") || predmet.equals("") || (sifra.length()<8)) {
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
	
	public void Uspeh() {
		String message = "Uspresno sacuvan novi profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Cuvanje(Profesor profesor) throws IOException, ClassNotFoundException, SQLException {
		Connection con = baza.Konekcija();
		baza.UpisProfesora(profesor, con);
		baza.PrekidVeze(con);
		con = baza.Konekcija();
		baza.UpisDodatnihPodatakaPr(profesor, con);
		baza.PrekidVeze(con);
	}
}
