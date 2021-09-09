package core.UcenikFunkcionalnosti;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Meni {

	public void Greska() {
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
}
