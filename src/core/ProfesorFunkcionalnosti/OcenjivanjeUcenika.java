package core.ProfesorFunkcionalnosti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Ocena;
import core.Baza;

public class OcenjivanjeUcenika {
	
	private Baza baza = new Baza();
	
	public boolean ValidacijUnosa(String id) {
		if(id.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean ProveraPostojanjaIdUcenika(String id) throws Exception {
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
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean ValidacijUnosa2(String ocena, String opis) {
		if(ocena.equals("-")||opis.equals("")) {
			return false;
		}else {
			return true;
		}
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
	
	public void Uspeh() {
		String message = "Uspesno ocenjen ucenik.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}
	
	public String[] IdProfIPredmet(String email, String sifra) throws Exception {
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
	
	public void UpisiOcenu(Ocena ocena) throws Exception {
		Connection con = baza.Konekcija();
		String query = "insert into ocene (iducenika, idprofesora, ocena, opis, predmet) values (?, ?, ?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, ocena.id_ucenika);		
		ps.setString(2, ocena.id_profesora);
		ps.setString(3, ocena.ocena);
		ps.setString(4, ocena.opis);
		ps.setString(5, ocena.predmet);
		ps.execute();
		
		query = "SELECT * FROM prosek WHERE iducenika=? AND predmet=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, ocena.id_ucenika);
		ps.setString(2, ocena.predmet);
		ResultSet rs = ps.executeQuery();
		boolean provera = rs.next();
		
		if(provera) {
			
			query = "SELECT brojocena, zbir FROM prosek WHERE iducenika=? AND predmet=? ;";
			ps = con.prepareStatement(query);
			ps.setString(1, ocena.id_ucenika);
			ps.setString(2, ocena.predmet);
			ResultSet rs1 = ps.executeQuery();
			int brojocena = 0;
			int zbir = 0;
			if(rs1.next()) {
				brojocena = rs1.getInt(1);
				zbir = rs1.getInt(2);
			}
			zbir += Integer.parseInt(ocena.ocena);
			brojocena+=1;
			double prosek = Double.valueOf(zbir)/Double.valueOf(brojocena);
			
			query = "UPDATE prosek SET prosek=?, brojocena=?, zbir=? WHERE iducenika=? AND predmet=? ;";
			ps = con.prepareStatement(query);
			ps.setDouble(1, prosek);
			ps.setInt(2, brojocena);
			ps.setInt(3, zbir);
			ps.setString(4, ocena.id_ucenika);
			ps.setString(5, ocena.predmet);
			ps.execute();
		}
		if(provera == false) {
			
			query = "insert into prosek (iducenika, predmet, prosek, brojocena, zbir) values (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, ocena.id_ucenika);
			ps.setString(2, ocena.predmet);
			Double prosek = Double.valueOf(ocena.ocena);
			int zbir = Integer.parseInt(ocena.ocena);
			ps.setDouble(3, prosek);
			ps.setInt(4, 1);
			ps.setInt(5, zbir);
			ps.execute();
		}

		baza.PrekidVeze(con);
	}
}
