package ui.Profesor;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.Ocena;
import core.ProfesorFunkcionalnosti.OcenjivanjeUcenika;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Ocenjivanje extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private String ocene[] = {"-", "1", "2", "3", "4",("5")};
	private OcenjivanjeUcenika ou = new OcenjivanjeUcenika();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	
	Ocenjivanje(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setTitle("Ocenjivanje");
		setSize(800, 600);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("OCENJIVANJE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 11, 574, 62);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(355, 119, 188, 57);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(553, 119, 194, 57);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(ocene);
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(221, 285, 74, 28);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("OCENA:");
		lblNewLabel_1_1.setEnabled(false);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(10, 266, 188, 57);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("OPIS:");
		lblNewLabel_1_1_1.setEnabled(false);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(10, 354, 188, 57);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setEnabled(false);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(187, 361, 174, 50);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnIzlaz.setForeground(Color.BLACK);
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setBounds(594, 488, 139, 57);
		getContentPane().add(btnIzlaz);
		
		
		JButton btnSacuvaj = new JButton("SACUVAJ");
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(400, 187, 103, 39);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				boolean provera_unosa = ou.ValidacijUnosa(id);
				if(provera_unosa) {
					boolean provera_postojanja = false;
					try {
						provera_postojanja = ou.ProveraPostojanjaIdUcenika(id);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if(provera_postojanja) {
						btnNewButton.setEnabled(false);
						textField.setEnabled(false);
						lblNewLabel_1.setEnabled(false);
						lblNewLabel_1_1.setEnabled(true);
						lblNewLabel_1_1_1.setEnabled(true);
						comboBox.setEnabled(true);
						textField_1.setEnabled(true);
						btnSacuvaj.setEnabled(true);
					}
					if(provera_postojanja == false) {
						ou.Greska();
					}
				}
				if(provera_unosa == false) {
					ou.Greska();
				}
			}
		});
		getContentPane().add(btnNewButton);
				
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ocena = comboBox.getSelectedItem().toString();
				String opis = textField_1.getText();
				boolean val2 = ou.ValidacijUnosa2(ocena, opis);
				if(val2 == false) {
					ou.Greska();
				}
				if(val2) {	
					String niz[] = null;
					try {
						niz = ou.CitanjeLogova();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					String email = niz [0];
					String sifra = niz [1];
					String nizIdPr[] = null;
					try {
						nizIdPr = ou.IdProfIPredmet(email, sifra);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					String id_prof = nizIdPr[0];
					String predmet = nizIdPr[1];
					String id = textField.getText();
					String idocene = null;

					try {
						Ocena oc = new Ocena(id_prof, id, idocene, predmet, ocena, opis);
						ou.UpisiOcenu(oc);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					textField.setText("");
					textField.setEnabled(true);
					btnNewButton.setEnabled(true);
					lblNewLabel_1_1.setEnabled(false);
					comboBox.setEnabled(false);
					comboBox.setSelectedItem("-");
					lblNewLabel_1_1_1.setEnabled(false);
					textField_1.setEnabled(false);
					textField_1.setText("");
					btnSacuvaj.setEnabled(false);
					lblNewLabel_1.setEnabled(true);
					ou.Uspeh();
				}
			}
		});
		btnSacuvaj.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSacuvaj.setEnabled(false);
		btnSacuvaj.setForeground(Color.BLACK);
		btnSacuvaj.setBackground(Color.WHITE);
		btnSacuvaj.setBounds(594, 412, 139, 57);
		btnSacuvaj.setFocusable(false);
		btnSacuvaj.setBorderPainted(false);
		getContentPane().add(btnSacuvaj);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfesorMeni pm = new ProfesorMeni();
				pm.setSize(800, 600);
				pm.setVisible(true);
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

