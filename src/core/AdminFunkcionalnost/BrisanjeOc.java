package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.PutanjeSlikaIFajlova;
import core.Baza;
import core.Ocena;
import core.Ucenik;

public class BrisanjeOc {

	private Baza baza = new Baza();

	public boolean ProveraPostojanja(String id) throws Exception {
		
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
	
	public String TrazenejOcena(String id) throws Exception {
		Connection con = baza.Konekcija();
		String tekst = "";
		String query = "SELECT predmet, ocena, opis, idocene FROM ocene WHERE iducenika=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String idocene = String.valueOf(rs.getInt(4));
			tekst += "               Predmet: " + rs.getString(1) + "\n               Ocena:" + rs.getString(2) + "\n               Opis:" + rs.getString(3) + "\n               ID:" + idocene + "\n ------------------------------------------------ \n";
		}
		return tekst;
	}
	
	public String TrazenjePodataka(String iducenika, String idocene) throws Exception {
		Connection con = baza.Konekcija();
		String query = "SELECT predmet FROM ocene WHERE iducenika=? AND idocene=?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		int idocenei = Integer.parseInt(idocene);
		ps.setInt(2, idocenei);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {		
			String predmet = rs.getString(1);
			baza.PrekidVeze(con);
			return predmet;
		}
		baza.PrekidVeze(con);
		return "";
	}
	
	public boolean ProveraPosotjanjaId(String idocene, String iducenika) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "SELECT * FROM ocene WHERE iducenika=? AND idocene=?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		int idocenei = Integer.parseInt(idocene);
		ps.setInt(2, idocenei);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			baza.PrekidVeze(con);
			return true;
		}
		baza.PrekidVeze(con);
		return false;
	}
	
	public void Brisanje(String idocene, String predmet, String iducenika) throws Exception {
		Connection con = baza.Konekcija();
		String query = "SELECT ocena FROM ocene WHERE idocene=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		int idocenei = Integer.parseInt(idocene);
		ps.setInt(1, idocenei);
		ResultSet rs = ps.executeQuery();
		int ocena = 0; 
		if(rs.next()) {
			ocena = rs.getInt(1);
		}
		
		query = "DELETE FROM ocene WHERE idocene=?;";
		ps = con.prepareStatement(query);
		ps.setInt(1, idocenei);
		ps.execute();
		
		double content[] = VratiPodatke(predmet, iducenika);
		int zbir = (int)content[1];
		int brojocena = (int) content[2];
		double prosek = content[0];
		
		int novizbir = zbir - ocena;
		brojocena -= 1;
		double noviprosek = Double.valueOf(novizbir)/Double.valueOf(brojocena);
		if(brojocena <= 0) {
			novizbir = 0;
			brojocena = 0;
			noviprosek = 0;
		}
		RegulisiProsek(brojocena, novizbir, noviprosek, predmet, iducenika);
	}
	
	public double[] VratiPodatke(String predmet, String iducenika) throws SQLException, ClassNotFoundException {
		
		Connection con = baza.Konekcija();
		String query = "SELECT prosek, brojocena, zbir FROM prosek WHERE iducenika=? AND predmet=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, iducenika);
		ps.setString(2, predmet);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			double prosek = rs.getDouble(1);
			double zbir = rs.getInt(3);
			double brojocena = rs.getInt(2);
			double[] content =  {prosek, zbir, brojocena};
			return content;

		}
		return null;
	}
	
	public void RegulisiProsek(int brojocena, int zbir, double prosek, String predmet, String iducenika) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE prosek SET prosek=?, brojocena=?, zbir=? WHERE iducenika=? AND predmet=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setDouble(1, prosek);
		ps.setInt(2, brojocena);
		ps.setInt(3, zbir);
		ps.setString(4, iducenika);
		ps.setString(5, predmet);
		ps.execute();
	}
	
	public void Uspeh() {
		String message = "Uspesno obrisana ocena.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
		
}
