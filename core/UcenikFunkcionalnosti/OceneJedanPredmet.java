package core.UcenikFunkcionalnosti;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Baza;

public class OceneJedanPredmet {
		
	private Baza baza = new Baza();

	public boolean PostojanjePredmeta(String predmet) throws Exception {
		Connection con = baza.Konekcija();
		String query = "SELECT * FROM ocene WHERE predmet=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, predmet);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			baza.PrekidVeze(con);
			return true;
		}
		baza.PrekidVeze(con);
		return false;
	}
	
	public String[] CitanjeLogova() throws IOException, ClassNotFoundException, SQLException {
		Connection con = baza.Konekcija();
		String query = "SELECT email, sifra FROM osoba WHERE log=? AND uloga=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 1);
		ps.setString(2, "ucenik");
		ResultSet rs = ps.executeQuery();
		String email = "";
		String sifra = "";
		if(rs.next()) {
			email = rs.getString(1);
			sifra = rs.getString(2);
		}
		String niz[] = {email, sifra};
		baza.PrekidVeze(con);
		return niz;
	}
	
	public String[] TrazenjeImenaId(String[] niz) throws Exception {
		String email = niz[0];
		String sifra = niz[1];
		
		Connection con = baza.Konekcija();
		String query = "SELECT ime, prezime, id FROM osoba WHERE email=? AND sifra=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, sifra);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String ime = rs.getString(1);
			String prezime = rs.getString(2);
			String id = rs.getString(3);
			String podaci[] = {ime, prezime, id};
			return podaci;
		}
		return null;
	}
	
	public String Ispis(String predmet, String niz1[]) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "SELECT prosek FROM prosek WHERE iducenika=? AND predmet=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, niz1[2]);
		ps.setString(2, predmet);
		ResultSet rs = ps.executeQuery();
		double prosek = 0.0;
		if(rs.next()) {
			prosek = rs.getDouble(1);
		}
		
		String tekst = "PREDMET: " + predmet + "\nProsek: " + String.valueOf(prosek) +"\nIme: " + niz1[0] + "\nPrezime: " + niz1[1] + "\n"; 
		
		query = "SELECT ocena, opis FROM ocene WHERE iducenika=? AND predmet=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, niz1[2]);
		ps.setString(2, predmet);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String ocena = String.valueOf(rs.getInt(1));
			String opis = rs.getString(2);
			
			tekst += "           Ocena: " + ocena + " --- Opis: " + opis + "\n"; 
		}
		baza.PrekidVeze(con);
		return tekst;
	}
	
	public void Greska(String message) {		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}

}
