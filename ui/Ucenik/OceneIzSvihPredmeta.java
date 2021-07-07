package ui.Ucenik;



import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.UcenikFunkcionalnosti.OceneSviPredmeti;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OceneIzSvihPredmeta extends JFrame{
	
	private OceneSviPredmeti os = new OceneSviPredmeti();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();

	public OceneIzSvihPredmeta() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
	setTitle("Ocene-Iz-Svih-Predmeta");
	setSize(800, 600);
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("OCENE IZ SVIH PREDMETA");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(140, 11, 634, 60);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("IZLAZ");
	btnNewButton.setFocusable(false);
	btnNewButton.setBorderPainted(false);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	btnNewButton.setBounds(605, 141, 169, 53);
	getContentPane().add(btnNewButton);
	
	JTextArea textArea = new JTextArea();
	textArea.setEditable(false);
	textArea.setBackground(Color.LIGHT_GRAY);
	textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	textArea.setBounds(10, 213, 764, 337);
	getContentPane().add(textArea);
	
	JButton btnNewButton_1 = new JButton("PRIKAZI");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String niz[] = null;
			String nizImeID[] = null;

			try {
				niz = os.CitanjeLogova();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				nizImeID = os.TrazenjeImenaIID(niz);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				os.TrazenjeOcena(nizImeID);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			os.ProlazKrozNiz();
			String tekst = os.Ispis(nizImeID);
			
			textArea.setText(tekst);
			os.als.clear();
			
		}
	});
	btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	btnNewButton_1.setFocusable(false);
	btnNewButton_1.setBorderPainted(false);
	btnNewButton_1.setBackground(Color.WHITE);
	btnNewButton_1.setBounds(605, 82, 169, 53);
	getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			UcenikMeni um = new UcenikMeni();
			um.setSize(800, 600);
			um.setVisible(true);
			dispose();
		}
	});
	btnNewButton_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
	btnNewButton_1_1.setFocusable(false);
	btnNewButton_1_1.setBorderPainted(false);
	btnNewButton_1_1.setBackground(SystemColor.menu);
	btnNewButton_1_1.setBounds(10, 11, 65, 62);
	getContentPane().add(btnNewButton_1_1);
	
	JButton btnNewButton_1_1_1 = new JButton("");
	btnNewButton_1_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			GlavniProzor g = new GlavniProzor();
			g.setSize(800, 600);
			g.setVisible(true);
			dispose();
		}
	});
	btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
	btnNewButton_1_1_1.setFocusable(false);
	btnNewButton_1_1_1.setBorderPainted(false);
	btnNewButton_1_1_1.setBackground(SystemColor.menu);
	btnNewButton_1_1_1.setBounds(85, 11, 65, 62);
	getContentPane().add(btnNewButton_1_1_1);
	
	setVisible(true);	
	}
}

