package core.ProfesorFunkcionalnosti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Baza;

public class SveOceneJednog {

	private Baza baza = new Baza();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean Provera(String id) throws Exception {
		
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

	public String[] CitanjeLogova() throws IOException, ClassNotFoundException, SQLException {
		Connection con = baza.Konekcija();
		String query = "SELECT email, sifra FROM osoba WHERE log=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 1);
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
	
	public String[] TrazenjeIdPredmeta(String[] niz) throws Exception {
		String email = niz[0];
		String sifra  = niz[1];
		Connection con = baza.Konekcija();
		String query = "SELECT id FROM osoba WHERE email=? AND sifra=?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, sifra);
		ResultSet rs = ps.executeQuery();
		String idprof = "";
		if(rs.next()) {
			idprof = rs.getString(1);
		}
		query = "SELECT predmet FROM dodatnoprofesor WHERE id=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, idprof);
		rs = ps.executeQuery();
		String predmet = "";
		if(rs.next()) {
			predmet = rs.getString(1);
		}
		String content[] = {idprof, predmet};
		return content;
	}
	
	public String[] TrazenjePodatakaOUceniku(String iducenika) throws Exception {
		Connection con = baza.Konekcija();
		String query = "SELECT ime, prezime FROM osoba WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String ime = rs.getString(1);
			String prezime = rs.getString(2);
			String podaci[] = {ime, prezime};
			baza.PrekidVeze(con);
			return podaci;
		}
		baza.PrekidVeze(con);
		return null;
	}
	
	public String Ispis(String predmet, String iducenika) throws Exception {
		
		Connection con = baza.Konekcija();
		String query = "SELECT ocena, opis FROM ocene WHERE predmet=? AND iducenika=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, predmet);
		ps.setString(2, iducenika);
		ResultSet rs = ps.executeQuery();
		String podaci[] = TrazenjePodatakaOUceniku(iducenika);
		String ime = podaci[0];
		String prezime = podaci[1];
				
		String tekst = "PREDMET: " + predmet + "\n";
		tekst += "                Ime: " + ime + "\n" + "                Prezime: " + prezime + "\n";
		if(podaci != null) {
			while(rs.next()) {
					String ocena = String.valueOf(rs.getInt(1));
					String opis = rs.getString(2);
					tekst += "                Ocena: " + ocena + "    " + "    Opis: " + opis + "\n" + "                -------------------------- \n";
				
			}
		}
		return tekst;
	}
}
