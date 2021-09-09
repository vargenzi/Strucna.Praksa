package core.AdminFunkcionalnost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.Baza;
import ui.PutanjeSlikaIFajlova;

public class Login {
	
	private PutanjeSlikaIFajlova pf = new PutanjeSlikaIFajlova();
	private Baza baza = new Baza();
	
	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
		
	}
	
public boolean ProveraAdmina(String user, String sifra) throws IOException, ClassNotFoundException, SQLException {
		
	Connection con = baza.Konekcija();
	String query = "SELECT * FROM osoba WHERE email=? AND sifra=? ;";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, user);
	ps.setString(2, sifra);
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		baza.PrekidVeze(con);
		return true;
	}
	baza.PrekidVeze(con);
	return false;
	}
	
}
