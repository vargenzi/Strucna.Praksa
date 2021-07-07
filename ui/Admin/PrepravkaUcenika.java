package ui.Admin;



import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

import core.Ucenik;
import core.AdminFunkcionalnost.*;

public class PrepravkaUcenika extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private PrepravkaUc pu = new PrepravkaUc();
	
	private String opcije[] = {
			"-", "Promeni ime", "Promeni prezime", "Promeni pol", "Promeni God. Upisa", "Promeni Datum Rodjenja", "Promeni email", "Promeni sifru", "Promeni razred"
	};
	
	private String datumi[] =  {
			"-", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "19", "20", "21", "22", "23", "24", "25", "26",
			"27", "28", "29", "30", "31"
				};
	
	private String meseci[] = {
			"-", "Januar", "Februar", "Mart", "April", "Maj", "Jun", "Jul", "Avgust", "Septembar", "Oktobar", "Novembar", "Decembar"
	};
	
	private String godine[] = {
			"-", "2001", "2002", "2003", "2004", "2005", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"
	};
	private String razredi[] = {
			"-", "Prvi OS", "Drugi OS", "Treci OS", "Cetvrti OS", "Peti OS", "Sesti OS", "Sedmi OS", "Osmi OS", "Prvi SS", "Drugi SS", "Treci SS", "Cetvrti SS"
			
		};

	
	PrepravkaUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setTitle("Prepravka - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(296, 107, 192, 75);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("PREPRAVKA U\u010CENIKA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 11, 496, 69);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 107, 161, 38);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 111, 136, 41);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox(godine);
		comboBox_1_1_1.setEnabled(false);
		comboBox_1_1_1.setBounds(575, 283, 84, 22);
		
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(125, 158, 103, 31);
		
		JButton btnNewButton_1_2 = new JButton("IZLAZ");
		btnNewButton_1_2.setFocusable(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(20, 519, 103, 31);
		
		
		
		JComboBox comboBox_1_2 = new JComboBox(razredi);
		comboBox_1_2.setEnabled(false);
		comboBox_1_2.setBounds(575, 471, 127, 22);
		
		JComboBox comboBox_2 = new JComboBox(godine);
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(326, 471, 61, 22);
		
		JComboBox comboBox_1_1 = new JComboBox(meseci);
		comboBox_1_1.setEnabled(false);
		comboBox_1_1.setBounds(232, 471, 84, 22);
		
		JComboBox comboBox = new JComboBox(datumi);
		comboBox.setEnabled(false);
		comboBox.setBounds(181, 471, 41, 22);
		
		JRadioButton rdbtnZenski = new JRadioButton("\u017Eenski");
		rdbtnZenski.setEnabled(false);
		buttonGroup.add(rdbtnZenski);
		rdbtnZenski.setBounds(188, 402, 61, 23);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("mu\u0161ki");
		rdbtnNewRadioButton.setEnabled(false);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(125, 402, 61, 23);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(575, 394, 161, 38);
		
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(575, 327, 161, 38);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 327, 161, 38);
		
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(125, 272, 161, 38);
		
		JComboBox comboBox_1 = new JComboBox(opcije);
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(644, 115, 130, 22);
		
		
		
		
		
		JLabel lblNewLabel_1_9 = new JLabel("ODABIR IZMENA:");
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_9.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_9.setBounds(498, 104, 136, 41);
		
		JLabel lblNewLabel_1_8 = new JLabel("RAZRED:");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_8.setBounds(412, 460, 136, 41);
		
		JLabel lblNewLabel_1_7 = new JLabel("SIFRA:");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(412, 391, 136, 41);
		
		
		JLabel lblNewLabel_1_6 = new JLabel("EMAIL:");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(412, 324, 136, 41);
		
		JLabel lblNewLabel_1_5 = new JLabel("GODINA UPISA:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(412, 272, 136, 41);
		
		JLabel lblNewLabel_1_4 = new JLabel("DATUM RODJENJA:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 461, 161, 38);
		
		JLabel lblNewLabel_1_3 = new JLabel("POL:\r\n");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 391, 136, 41);
		
		JLabel lblNewLabel_1_2 = new JLabel("PREZIME:\r\n");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 324, 136, 41);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("IME:\r\n\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 272, 136, 41);
		
		
		JButton btnNewButton_1_1 = new JButton("SACUVAJ");
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pu.PunjenjeListeUcenika();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(textField_1.isEnabled()) {
					
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(textField_1.getText().equals("")) {
						pu.Greska("Pogresan unos.");
					}
					if(textField_1.getText().equals("") == false) {
						pu.PostaviIme(textField_1.getText(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}						
						textField_1.setText("");
						textField_1.setEnabled(false);
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
				}
				
				if(textField_2.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(textField_2.getText().equals("")) {
						pu.Greska("Pogresan unos.");
					}
					if(textField_2.getText().equals("") == false) {
						pu.PostaviPrezime(textField_2.getText(), indeks, ucenik);;
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						textField_2.setText("");
						textField_2.setEnabled(false);
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
					
				}
				
				
				if(rdbtnNewRadioButton.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					String pol = null;
					if(rdbtnNewRadioButton.isSelected() == true) {
	 					pol = "Muski";
	 				}
	 				if(rdbtnZenski.isSelected() == true) {
	 					pol = "Zenski";
	 				}
	 				if(pol == null) {
	 					pu.Greska("Pogresan unos.");
	 				}
	 				if((pol == null) == false) {
		 				pu.PostaviPol(pol, indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						rdbtnNewRadioButton.setEnabled(false);
						rdbtnNewRadioButton.setSelected(false);
						rdbtnZenski.setEnabled(false);
						rdbtnZenski.setSelected(false);
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
	 				}
					
				}
				
				
				if(comboBox.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(comboBox.getSelectedItem().toString().equals("-") || comboBox_1_1.getSelectedItem().toString().equals("-") || comboBox_2.getSelectedItem().toString().equals("-")) {
						pu.Greska("Pogresan unos.");
					}
					
					if((comboBox.getSelectedItem().toString().equals("-") || comboBox_1_1.getSelectedItem().toString().equals("-") || comboBox_2.getSelectedItem().toString().equals("-")) == false) {
						pu.PostaviDanMesecGodinu(comboBox.getSelectedItem().toString(), comboBox_1_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						comboBox_1.setSelectedItem("-");
						comboBox.setSelectedItem("-");
						comboBox_1_1.setSelectedItem("-");
						comboBox_2.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
				}
				
				if(comboBox_1_1_1.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(comboBox_1_1_1.getSelectedItem().toString().equals("")) {
						pu.Greska("Pogresan unos.");
					}
					
					if(comboBox_1_1_1.getSelectedItem().toString().equals("") == false) {
						
						pu.PostaviGodinuUpisa(comboBox_1_1_1.getSelectedItem().toString(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						btnNewButton_1_1.setEnabled(false);
						comboBox_1_1_1.setSelectedItem("-");
						comboBox_1_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
					
				}
				if(textField_3.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(textField_3.getText().equals("")) {
						pu.Greska("Pogresan unos.");
					}	
					if(textField_3.getText().equals("") == false) {
						pu.PostaviEmail(textField_3.getText(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						textField_3.setText("");
						textField_3.setEnabled(false);
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
					
				}
				if(textField_4.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					
					if(textField_4.getText().equals("")) {
						pu.Greska("Pogresan unos.");
					}
					
					if(textField_4.getText().equals("") == false) {
						pu.PostaviSifru(textField_4.getText(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						String message = "Uspesno prepravljen ucenik.";
						JFrame jf = new JFrame();
						jf.setSize(300, 300);
						JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
						
						textField_4.setEnabled(false);
						textField_4.setText("");
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						
					}
					
				}
				
				if(comboBox_1_2.isEnabled()) {
					int indeks = pu.PretragaUcenika(textField.getText());
					Ucenik ucenik;
					ucenik = pu.VratiUcenika(indeks);
					if(comboBox_1_2.getSelectedItem().toString().equals("-")) {
						pu.Greska("Pogresan unos.");
					}
					if(comboBox_1_2.getSelectedItem().toString().equals("-") == false) {
						pu.PostaviRazred(comboBox_1_2.getSelectedItem().toString(), indeks, ucenik);
						try {
							pu.Cuvanje();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						comboBox_1_2.setEnabled(false);
						comboBox_1_2.setSelectedItem("-");
						btnNewButton_1_1.setEnabled(false);
						comboBox_1.setSelectedItem("-");
						textField.setText("");
						textField.setEnabled(true);
						textArea.setEditable(true);
						btnNewButton.setEnabled(true);
						pu.Uspeh();
					}
					
				}
				
				
				textField.setText("");
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(658, 519, 103, 31);
		
		JButton btnNewButton_1 = new JButton("POTVRDI");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tfopcija = comboBox_1.getSelectedItem().toString();
				if(tfopcija.equals("-")) {
					pu.Greska("Pogresan unos.");
				}
				if(tfopcija.equals("-") ==  false) {
					
					comboBox_1.setEnabled(false);
					btnNewButton_1.setEnabled(false);
					if(tfopcija.equals("Promeni ime")) {
						textField_1.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni prezime")) {
						textField_2.setEnabled(true);						
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni pol")) {
						rdbtnNewRadioButton.setEnabled(true);
						rdbtnZenski.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni God. Upisa")) {
						
						comboBox_1_1_1.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni Datum Rodjenja")) {
						comboBox.setEnabled(true);
						comboBox_1_1.setEnabled(true);
						comboBox_2.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);	
					}
					if(tfopcija.equals("Promeni email")) {
						textField_3.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni sifru")) {
						textField_4.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					if(tfopcija.equals("Promeni razred")) {
						comboBox_1_2.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					
				}
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(498, 151, 103, 31);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tfid = textField.getText();
				try {
					pu.PunjenjeListeUcenika();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				boolean provera = pu.ProveraPostojanjaID(tfid);
				if(provera == false) {
					textArea.setText("           Unet je nepostojeci ID");
				}
				if(provera) {
					textArea.setText("           Uneti ID je validan.");
					comboBox_1.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton.setEnabled(false);
					textField.setEnabled(false);
				}
			}	
		});
		
		
		getContentPane().add(btnNewButton);
		
		
		getContentPane().add(lblNewLabel_1_1);
		
		
		getContentPane().add(lblNewLabel_1_2);
		
		
		getContentPane().add(lblNewLabel_1_3);
		
		
		getContentPane().add(lblNewLabel_1_4);
		
		
		getContentPane().add(lblNewLabel_1_5);
		
		
		getContentPane().add(lblNewLabel_1_6);
		
		
		getContentPane().add(lblNewLabel_1_7);
		
		
		getContentPane().add(lblNewLabel_1_8);
		
		
		getContentPane().add(lblNewLabel_1_9);
		
		
		getContentPane().add(comboBox_1);
		
	
		getContentPane().add(btnNewButton_1);
		
		
		getContentPane().add(textField_1);
		
		
		getContentPane().add(textField_2);
		
		
		getContentPane().add(textField_3);
		
		
		getContentPane().add(textField_4);
		
		
		getContentPane().add(rdbtnNewRadioButton);
		
		
		getContentPane().add(rdbtnZenski);
		
		
		getContentPane().add(comboBox);
		
		
		getContentPane().add(comboBox_1_1);
		
		
		getContentPane().add(comboBox_2);
		
		
		getContentPane().add(comboBox_1_2);
		
		
		getContentPane().add(btnNewButton_1_1);
		
		
		getContentPane().add(btnNewButton_1_2);
		
		
		getContentPane().add(comboBox_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMeni am = new AdminMeni();
				am.setSize(800, 600);
				am.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(20, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GlavniProzor g = new GlavniProzor();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(95, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		setVisible(true);
		
	}
	
}

