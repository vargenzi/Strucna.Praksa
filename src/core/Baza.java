package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Baza{
	
	public Connection Konekcija() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/podaci";
		String user = "root";
		String pass = "Zoranrepic10";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	
	public void PrekidVeze(Connection con) throws SQLException {
		
		con.close();
	}

	public void UpisUcenika(Ucenik ucenik, Connection con) throws SQLException {
		
		String query = "insert into osoba (id, ime, prezime, email, sifra, DatumRodjenja, pol, log, uloga) values (?, ?, ?, ?, ?, ?, ?, ?, 'ucenik');";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, ucenik.id);		
		ps.setString(2, ucenik.ime);
		ps.setString(3, ucenik.prezime);
		ps.setString(4, ucenik.email);
		ps.setString(5, ucenik.sifra);
		ps.setString(6, ucenik.datum_rodjenja);
		ps.setString(7, ucenik.pol);
		int indikator = 0;
		ps.setInt(8, indikator);
		ps.execute();
		
	}
	
	public void UpisProfesora(Profesor profesor, Connection con) throws SQLException {
		
		String query = "insert into osoba (id, ime, prezime, email, sifra, DatumRodjenja, pol, log, uloga) values (?, ?, ?, ?, ?, ?, ?, ?, 'profesor');";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, profesor.id);		
		ps.setString(2, profesor.ime);
		ps.setString(3, profesor.prezime);
		ps.setString(4, profesor.email);
		ps.setString(5, profesor.sifra);
		ps.setString(6, profesor.datum_rodjenja);
		ps.setString(7, profesor.pol);
		int indikator = 0;
		ps.setInt(8, indikator);
		ps.execute();
		
	}
	
	public void UpisDodatnihPodatakaUc(Ucenik ucenik, Connection con) throws SQLException {
			
			String query = "insert into dodatnoucenik (id, razred, GodinaUpisa) values (?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ucenik.id);		
			ps.setString(2, ucenik.razred);
			ps.setString(3, ucenik.godina_upisa);
			ps.execute();
		}
	
	public void UpisDodatnihPodatakaPr(Profesor profesor, Connection con) throws SQLException {
			
			String query = "insert into dodatnoprofesor (id, predmet) values (?, ?);";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, profesor.id);		
			ps.setString(2, profesor.predmet);
			ps.execute();
		}
		
		
	public String FormiranjeDatuma(String dan, String mesec, String godina){
		String mesec_dek = "";
		
		if(mesec.equals("Januar")) {
			mesec_dek = "01";
		}
		if(mesec.equals("Februar")) {
			mesec_dek = "02";
		}
		if(mesec.equals("Mart")) {
			mesec_dek = "03";
		}
		if(mesec.equals("April")) {
			mesec_dek = "04";
		}
		if(mesec.equals("Maj")) {
			mesec_dek = "05";
		}
		if(mesec.equals("Jun")) {
			mesec_dek = "06";
		}
		if(mesec.equals("Jul")) {
			mesec_dek = "07";
		}
		if(mesec.equals("Avgust")) {
			mesec_dek = "08";
		}
		if(mesec.equals("Septembar")) {
			mesec_dek = "09";
		}
		if(mesec.equals("Oktobar")) {
			mesec_dek = "10";
		}
		if(mesec.equals("Novembar")) {
			mesec_dek = "11";
		}
		if(mesec.equals("Decembar")) {
			mesec_dek = "12";
		}
		if(dan.length() < 2) {
			dan = "0" + dan;
		}
		
		String datum = dan + "/" + mesec_dek + "/" + godina;

		return datum;
	}
	
	public void LogoutProfesor() throws ClassNotFoundException, SQLException {
		
		Connection con = Konekcija();
		String query = "UPDATE osoba SET log=? WHERE log=? AND uloga='profesor';";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 0);
		ps.setInt(2, 1);
		ps.execute();
		PrekidVeze(con);
	}	
	
	public void LogoutSvih() throws ClassNotFoundException, SQLException {
		
		Connection con = Konekcija();
		String query = "UPDATE osoba SET log=? WHERE log=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 0);
		ps.setInt(2, 1);
		ps.execute();
		PrekidVeze(con);
	}
	
	public void LogoutUcenika() throws ClassNotFoundException, SQLException {
		
		Connection con = Konekcija();
		String query = "UPDATE osoba SET log=? WHERE log=? AND uloga='ucenik';";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 0);
		ps.setInt(2, 1);
		ps.execute();
		PrekidVeze(con);
	}	
	
	public void BrisanjeOcenaProseka(String iducenika) throws ClassNotFoundException, SQLException {
		Connection con = Konekcija();
		String query = "DELETE FROM ocene WHERE iducenika=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		ps.execute();
		
		query = "DELETE FROM prosek WHERE iducenika=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		ps.execute();
	}
	
}
