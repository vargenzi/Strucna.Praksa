package core.AdminFunkcionalnost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Baza;

public class PrepravkaPr {
	private Baza baza = new Baza();
	
	public boolean ProveraPostojanja(String id) throws ClassNotFoundException, SQLException {
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
	
	public void Greska(String poruka) {
		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, poruka, "Greska",
		        JOptionPane.ERROR_MESSAGE);	
	}
	
	public void PostaviIme(String ime, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET ime=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, ime);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviPrezime(String prezime, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET prezime=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, prezime);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviPol(String pol, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET pol=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, pol);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviDanMesecGodinu(String datum, String id) throws ClassNotFoundException, SQLException {
	
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET DatumRodjenja=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, datum);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviEmail(String email, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET email=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviSifru(String sifra, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET sifra=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, sifra);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void PostaviPredmet(String predmet, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE dodatnoprofesor SET predmet=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, predmet);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void Uspeh() {
		String message = "Uspesno prepravljen profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
}
