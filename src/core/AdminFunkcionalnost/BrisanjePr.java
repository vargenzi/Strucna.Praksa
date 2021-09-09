package core.AdminFunkcionalnost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import core.Baza;

public class BrisanjePr {

	private Baza baza = new Baza();
	
	public boolean ProveraPostojanjaId(String id) throws Exception{
		
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
	
	public void BrisanjeProfesora(String id) throws ClassNotFoundException, SQLException {
		
		Connection con = baza.Konekcija();
		String query = "DELETE FROM osoba WHERE id=? ;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.execute();
		query = "DELETE FROM dodatnoprofesor WHERE id=? ;";
		ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.execute();
		baza.PrekidVeze(con);
	}
	
	public void Uspeh() {
		String message = "Uspesno obrisan profesor.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
	}

}
