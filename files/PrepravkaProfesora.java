package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class PrepravkaProfesora extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<Profesori> alp = new ArrayList<Profesori>();
	
	
	private String opcije[] = {
			"-", "Promeni ime", "Promeni prezime", "Promeni pol",  "Promeni Datum Rodjenja", "Promeni email", "Promeni sifru", "Promeni predmet"
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
				"-", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997"
		};
	
	

	
	public static void main(String[] args) {
		
	}

	PrepravkaProfesora(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
		setResizable(false);
		
		setTitle("Prepravka - Profesora");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblPrepravkaProfesora = new JLabel("PREPRAVKA PROFESORA");
		lblPrepravkaProfesora.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrepravkaProfesora.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblPrepravkaProfesora.setBounds(181, 11, 541, 64);
		getContentPane().add(lblPrepravkaProfesora);
		
		JLabel lblNewLabel_1 = new JLabel("JMBG:\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 103, 136, 41);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 106, 161, 38);
		getContentPane().add(textField);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(311, 103, 192, 75);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_9 = new JLabel("ODABIR IZMENA:");
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_9.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_9.setBounds(513, 103, 136, 41);
		getContentPane().add(lblNewLabel_1_9);
		
		JComboBox comboBox_1 = new JComboBox(opcije);
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(654, 114, 130, 22);
		getContentPane().add(comboBox_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("IME:\r\n\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 270, 136, 41);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PREZIME:\r\n");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 334, 136, 41);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("POL:\r\n");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 394, 136, 41);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("DATUM RODJENJA:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 448, 161, 38);
		getContentPane().add(lblNewLabel_1_4);
		
		JButton btnNewButton_1_2 = new JButton("IZLAZ");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1_2.setFocusable(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(10, 515, 103, 31);
		getContentPane().add(btnNewButton_1_2);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 273, 161, 38);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(140, 334, 161, 38);
		getContentPane().add(textField_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("mu\u0161ki");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBounds(140, 405, 61, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnZenski = new JRadioButton("\u017Eenski");
		buttonGroup.add(rdbtnZenski);
		rdbtnZenski.setEnabled(false);
		rdbtnZenski.setBounds(218, 405, 61, 23);
		getContentPane().add(rdbtnZenski);
		
		JComboBox comboBox = new JComboBox(datumi);
		comboBox.setEnabled(false);
		comboBox.setBounds(194, 458, 41, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1_1 = new JComboBox(meseci);
		comboBox_1_1.setEnabled(false);
		comboBox_1_1.setBounds(245, 458, 84, 22);
		getContentPane().add(comboBox_1_1);
		
		JComboBox comboBox_2 = new JComboBox(godine);
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(339, 458, 61, 22);
		getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("PREDMET:\r\n");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(445, 270, 136, 41);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("EMAIL:");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(445, 334, 136, 41);
		getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("SIFRA:");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(445, 394, 136, 41);
		getContentPane().add(lblNewLabel_1_7);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(604, 334, 161, 38);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(604, 394, 161, 38);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(604, 273, 161, 38);
		getContentPane().add(textField_5);
		
		
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
					
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if(textField_1.getText().equals("") == false) {
						profesor.ime = textField_1.getText();
					alp.set(indeks, profesor);
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
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if(textField_2.getText().equals("") == false) {
						profesor.prezime = textField_2.getText();
					alp.set(indeks, profesor);
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
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
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
	 					profesor.pol = pol;
					alp.set(indeks, profesor);
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
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if((comboBox.getSelectedItem().toString().equals("-") || comboBox_1_1.getSelectedItem().toString().equals("-") || comboBox_2.getSelectedItem().toString().equals("-")) == false) {
						profesor.dan_rodjenja = comboBox.getSelectedItem().toString();
						profesor.mesec_rodjenja = comboBox_1_1.getSelectedItem().toString();
						profesor.godina_rodjenja = comboBox_2.getSelectedItem().toString();
						alp.set(indeks, profesor);
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
				
				
				
				
				
				if(textField_3.isEnabled()) {
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if(textField_3.getText().equals("") == false) {
						profesor.email = textField_3.getText();
					alp.set(indeks, profesor);
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
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if(textField_4.getText().equals("") == false) {
						profesor.sifra = textField_4.getText();
					alp.set(indeks, profesor);
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
				
				if(textField_5.isEnabled()) {
					int indeks = PretragaProfesora(textField.getText());
					Profesori profesor;
					profesor = alp.get(indeks);
					if(textField_5.getText().equals("") == false) {
						profesor.predmet = textField_5.getText();
					alp.set(indeks, profesor);
					try {
						Cuvanje();
						alp.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					if(textField_5.getText().equals("")) {
						System.out.println("Neuspesno");
	 					String message = "Pogresan unos, pokusajte ponovo.";
	 					JFrame jf = new JFrame();
	 					jf.setSize(300, 300);
	 					
	 					
	 					JOptionPane.showMessageDialog(jf, message, "Greska",
	 					        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
			});
		getContentPane().add(btnNewButton_1_1);
		
		
		
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
					
					if(tfopcija.equals("Promeni predmet")) {
						textField_5.setEnabled(true);
						btnNewButton_1_1.setEnabled(true);
					}
					
					
				}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(513, 147, 103, 31);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(658, 519, 103, 31);
		getContentPane().add(btnNewButton_1_1);

		
		
		
		
		JButton btnNewButton = new JButton("POTVRDI");
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
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(140, 155, 103, 31);
		getContentPane().add(btnNewButton);
		
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
		btnNewButton_1_1_1.setBounds(10, 13, 65, 62);
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
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);

		
		
		setVisible(true);
		
	}
		
	
	
	public boolean ProveraPostojanja(String jmbg) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
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
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Profesori profesor = new Profesori(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9]);
			alp.add(profesor);
		}
		br.close();
	
	}
	
	
	public int PretragaProfesora(String jmbg) {
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
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
		int i = 0;
		while(i<alp.size()) {
			
			bw.write(alp.get(i).ime + "/" + alp.get(i).prezime + "/" + alp.get(i).jmbg + "/" + alp.get(i).dan_rodjenja + "/" + alp.get(i).mesec_rodjenja + "/" + alp.get(i).godina_rodjenja + "/" + alp.get(i).pol + "/" + alp.get(i).email + "/" + alp.get(i).sifra + "/" + alp.get(i).predmet);
			bw.newLine();
			
			
			i++;
		}
		bw.close();
	}
}

		
	

