package core.AdminFunkcionalnost;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Baza;

public class PrepravkaUc {
	
	private Baza baza = new Baza();
	
	public boolean ProveraPostojanjaID(String id) throws ClassNotFoundException, SQLException {
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

	
	public boolean PoklapanjeGodina(String id, String datum, String cont[]) throws ClassNotFoundException, SQLException {
		String godinaUpisa = cont[1];
		String razred = cont[0];
		String godina = datum.split("/", 100)[2];
		
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
	
	public void PostaviGodinuUpisa(String godina, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE dodatnoucenik SET GodinaUpisa=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, godina);
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
		baza.PrekidVeze(con);;
	}
	
	public void PostaviSifru(String sifra, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET sifra=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, sifra);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);;
	}
	
	public void PostaviRazred(String razred, String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE dodatnoucenik SET razred=? WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, razred);
		ps.setString(2, id);
		ps.execute();
		baza.PrekidVeze(con);
	}

	public void Uspeh() {
		String message = "Uspesno prepravljen ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public String[] VratiGodinuRazred(String id) throws SQLException, ClassNotFoundException {
		Connection con = baza.Konekcija();
		String query = "SELECT GodinaUpisa, razred FROM dodatnoucenik WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String razred = "";
		String GodinaUpisa = "";
		if(rs.next()) {
			 razred = rs.getString(2);
			 GodinaUpisa = rs.getString(1);
		}
		String substrings[] = {razred, GodinaUpisa};
		baza.PrekidVeze(con);
		return substrings;
	}
	
	public String VratiDatumRodjenja(String id) throws ClassNotFoundException, SQLException {
		Connection con = baza.Konekcija();
		String query = "SELECT DatumRodjenja FROM osoba WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String datum = "";
		if(rs.next()) {
			datum = rs.getString(1);	
		}
		baza.PrekidVeze(con);
		return datum;
	}
	
}
