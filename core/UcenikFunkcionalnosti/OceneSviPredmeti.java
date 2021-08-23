package core.UcenikFunkcionalnosti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import core.Baza;

public class OceneSviPredmeti {

	private Baza baza = new Baza();

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
	
	public String[] TrazenjeImenaIID(String[] niz) throws Exception {
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
	
	public String Ispis(String[] niz1) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "SELECT prosek FROM prosek WHERE iducenika=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, niz1[2]);
		ResultSet rs = ps.executeQuery();
		double prosekproba = 0.0;
		int i = 0;
		
		while(rs.next()) {
			prosekproba += rs.getDouble(1);
			i++;
		}
		DecimalFormat df = new DecimalFormat(".##");
		double prosek = prosekproba/Double.valueOf(i);
		
		String tekst = "Ime: " + niz1[0] + "\n" + "Prezime: " + niz1[1] + "\nTrenutni uspeh: "+ String.valueOf(df.format(prosek)) + "\n"; 
		
		query = "SELECT predmet, ocena, opis FROM ocene WHERE iducenika=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, niz1[2]);
		rs = ps.executeQuery();

		while(rs.next()) {
			String predmet = rs.getString(1);
			String ocena = String.valueOf(rs.getInt(2));
			String opis = rs.getString(3);
			
			tekst += "         Predmet: " + predmet + " --- Ocena: " + ocena + " --- Opis: " + opis + "\n";
			i++;
		}
		
		return tekst;
	}

}
