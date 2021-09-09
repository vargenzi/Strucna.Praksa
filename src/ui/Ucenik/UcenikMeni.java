package ui.Ucenik;

import java.awt.EventQueue;

import javax.swing.JFrame;



	import java.awt.Toolkit;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JComboBox;
	import java.awt.Color;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.SystemColor;
	import javax.swing.ImageIcon;
	import core.UcenikFunkcionalnosti.Meni;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;
	
	public class UcenikMeni extends JFrame{
		private String opcije [] = {
				
				"-", "Ocene iz svih predmeta", "Ocene iz jednog predmeta"
			}; 
		private Meni um = new Meni();
		private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();

		UcenikMeni(){
			setBackground(new Color(240, 240, 240));
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
			setTitle("Ucenik - Meni");
			setSize(800, 600);
			getContentPane().setLayout(null);
			
			JLabel lblUcenickiMeni = new JLabel("UCENICKI MENI");
			lblUcenickiMeni.setHorizontalAlignment(SwingConstants.CENTER);
			lblUcenickiMeni.setFont(new Font("Times New Roman", Font.BOLD, 48));
			lblUcenickiMeni.setBounds(160, 11, 580, 59);
			getContentPane().add(lblUcenickiMeni);
			
			JLabel lblNewLabel_1 = new JLabel("IZBOR:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(23, 182, 227, 72);
			getContentPane().add(lblNewLabel_1);
			
			JComboBox comboBox = new JComboBox(opcije);
			comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			comboBox.setFocusable(false);
			comboBox.setBackground(Color.WHITE);
			comboBox.setBounds(214, 195, 260, 48);
			getContentPane().add(comboBox);
			
			JButton btnNewButton = new JButton("POTVRDI");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cb = comboBox.getSelectedItem().toString();
					if(cb.equals("-")) {
						um.Greska();
					}
					if(cb.equals("-") == false) {
						if(cb.equals("Ocene iz svih predmeta")) {
							new OceneIzSvihPredmeta();
							dispose();
						}
						if(cb.equals("Ocene iz jednog predmeta")) {
							new OceneIzJednogPredmeta();
							dispose();		
						}
					}
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			btnNewButton.setFocusable(false);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setBounds(42, 389, 191, 59);
			getContentPane().add(btnNewButton);
			
			JButton btnIzlaz = new JButton("IZLAZ");
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			btnIzlaz.setFocusable(false);
			btnIzlaz.setBorderPainted(false);
			btnIzlaz.setBackground(Color.WHITE);
			btnIzlaz.setBounds(42, 467, 191, 59);
			getContentPane().add(btnIzlaz);
			
			JButton btnNewButton_1_1 = new JButton("");
			btnNewButton_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login ul = new Login();
					ul.setSize(800, 600);
					ul.setVisible(true);
					dispose();
				}
			});
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
