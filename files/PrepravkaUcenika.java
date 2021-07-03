package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class PrepravkaUcenika extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<Ucenici> alp = new ArrayList<Ucenici>();

	
	public static void main(String[] args) {
		
	}
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
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
		
		JLabel lblNewLabel_1 = new JLabel("JMBG:\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 111, 136, 41);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox(godine);
		comboBox_1_1_1.setEnabled(false);
		comboBox_1_1_1.setBounds(575, 283, 84, 22);
		
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
					PunjenjeListe();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(textField_1.isEnabled()) {
					
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(textField_1.getText().equals("") == false) {
					ucenik.ime = textField_1.getText();
					alp.set(indeks, ucenik);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					if(textField_1.getText().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(textField_2.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(textField_2.getText().equals("") == false) {
					ucenik.prezime = textField_2.getText();
					alp.set(indeks, ucenik);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					if(textField_2.getText().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				if(rdbtnNewRadioButton.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					String pol = null;
					if(rdbtnNewRadioButton.isSelected() == true) {
	 					pol = "Muski";
	 				}
	 				if(rdbtnZenski.isSelected() == true) {
	 					pol = "Zenski";
	 				}
	 				if(pol == null) {
	 					System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
	 				}
	 				if((pol == null) == false) {
	 				ucenik.pol = pol;
					alp.set(indeks, ucenik);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	 				}
					
				}
				
				
				if(comboBox.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if((comboBox.getSelectedItem().toString().equals("-") || comboBox_1_1.getSelectedItem().toString().equals("-") || comboBox_2.getSelectedItem().toString().equals("-")) == false) {
						ucenik.dan_rodjenja = comboBox.getSelectedItem().toString();
						ucenik.mesec_rodjenja = comboBox_1_1.getSelectedItem().toString();
						ucenik.godina_rodjenja = comboBox_2.getSelectedItem().toString();
						alp.set(indeks, ucenik);
						try {
							

							Cuvanje();
							alp.clear();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}if(comboBox.getSelectedItem().toString().equals("-") || comboBox_1_1.getSelectedItem().toString().equals("-") || comboBox_2.getSelectedItem().toString().equals("-")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				if(comboBox_1_1_1.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(comboBox_1_1_1.getSelectedItem().toString().equals("") == false) {
						
						ucenik.godina_upisa = comboBox_1_1_1.getSelectedItem().toString();
						alp.set(indeks, ucenik);
						try {
							Cuvanje();
							alp.clear();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(comboBox_1_1_1.getSelectedItem().toString().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
				if(textField_3.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(textField_3.getText().equals("") == false) {
					ucenik.email = textField_3.getText();
					alp.set(indeks, ucenik);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					if(textField_3.getText().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
				if(textField_4.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(textField_4.getText().equals("") == false) {
					ucenik.sifra = textField_4.getText();
					alp.set(indeks, ucenik);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					if(textField_4.getText().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(comboBox_1_2.isEnabled()) {
					int indeks = PretragaUcenika(textField.getText());
					Ucenici ucenik;
					ucenik = alp.get(indeks);
					if(comboBox_1_2.getSelectedItem().toString().equals("-")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
					
					if(comboBox_1_2.getSelectedItem().toString().equals("-") == false) {
						ucenik.razred = comboBox_1_2.getSelectedItem().toString();
						alp.set(indeks, ucenik);
						try {
							Cuvanje();
							alp.clear();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						
					}
					
				}
				
				
				
				
				
				
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
					String message = "Niste obelezili opciju, probajte ponovo.";
 					JFrame jf = new JFrame();
 					jf.setSize(300, 300);
 					
 					
 					JOptionPane.showMessageDialog(jf, message, "Greska",
 					        JOptionPane.ERROR_MESSAGE);
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
		
		
		
		
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tfjmbg = textField.getText();
				try {
					boolean bul = ProveraPostojanja(tfjmbg);
					if(bul == true) {
						textArea.setText("Uneti jmbg je validan.");
						comboBox_1.setEnabled(true);
						btnNewButton_1.setEnabled(true);
						btnNewButton.setEnabled(false);
						textField.setEnabled(false);
						
						
					}
					
					if(bul == false) {
						textArea.setText("Uneli ste neposotjeci jmbg.");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(125, 158, 103, 31);
		
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
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(20, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				glavni g = new glavni();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\home.png"));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(95, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		setVisible(true);
		
	}
	
	
	public boolean ProveraPostojanja(String jmbg) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			System.out.println(substrings[2]);
			if(jmbg.equals(substrings[2])) {
				return true;
			}
		}
		br.close();
		return false;
		
		
	}
	
	public void PunjenjeListe() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Ucenici ucenik = new Ucenici(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9], substrings[10]);
			alp.add(ucenik);
		}
		br.close();
	
	}
	
	public int PretragaUcenika(String jmbg) {
		int i = 0;
		int k;
		while(i<alp.size()) {
			if(jmbg.equals(alp.get(i).jmbg)) {
				k = i;
				return k;
			}
			
			i++;
		}
		
		return 123456;
	}
	
	public void Cuvanje() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		int i = 0;
		while(i<alp.size()) {
			
			bw.write(alp.get(i).ime + "/" + alp.get(i).prezime + "/" + alp.get(i).jmbg + "/" + alp.get(i).dan_rodjenja + "/" + alp.get(i).mesec_rodjenja + "/" + alp.get(i).godina_rodjenja + "/" + alp.get(i).pol + "/" + alp.get(i).razred + "/" + alp.get(i).godina_upisa + "/" + alp.get(i).email + "/" + alp.get(i).sifra);
			bw.newLine();
			
			
			i++;
		}
		bw.close();
	}
}
