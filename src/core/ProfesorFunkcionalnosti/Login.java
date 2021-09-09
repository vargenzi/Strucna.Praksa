package core.ProfesorFunkcionalnosti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import core.Baza;

public class Login {
	
	private Baza baza = new Baza();
	
	public boolean Provera(String email, String sifra)  throws Exception{
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
	
	public void UpisULogove(String email, String sifra) throws IOException, ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "UPDATE osoba SET log=? WHERE email=? AND sifra=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 1);
		ps.setString(2, email);
		ps.setString(3, sifra);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}

}
