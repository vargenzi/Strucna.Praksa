package ui.Admin;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

import core.Baza;
import core.Profesor;
import core.AdminFunkcionalnost.*;

public class KreiranjeProfesora extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private KreiranjePr kp = new KreiranjePr();
	private Baza baza = new Baza();

	private String godine[] = {
			"-", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997"
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
 		
 	KreiranjeProfesora(){
 		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
 		setResizable(false);
 		setTitle("Kreiranje - Profesora");
 		setSize(800, 600);
 		getContentPane().setLayout(null);
 		
 		JLabel lblNewLabel_1 = new JLabel("IME:\r\n");
 		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1.setBounds(10, 85, 172, 44);
 		getContentPane().add(lblNewLabel_1);
 		
 		JLabel lblNewLabel_1_1 = new JLabel("PREZIME:");
 		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_1.setBounds(10, 177, 172, 44);
 		getContentPane().add(lblNewLabel_1_1);
 		
 		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
 		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_1_1.setBounds(10, 282, 172, 44);
 		getContentPane().add(lblNewLabel_1_1_1);
 		
 		JLabel lblNewLabel_1_1_2 = new JLabel("DATUM RO\u0110ENJA");
 		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
 		lblNewLabel_1_1_2.setBounds(10, 391, 172, 44);
 		getContentPane().add(lblNewLabel_1_1_2);
 		
 		JLabel lblNewLabel_1_5 = new JLabel("E - MAIL:");
 		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_5.setBounds(466, 85, 172, 44);
 		getContentPane().add(lblNewLabel_1_5);
 		
 		JLabel lblNewLabel_1_1_4 = new JLabel("POL:");
 		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_1_4.setBounds(466, 177, 172, 44);
 		getContentPane().add(lblNewLabel_1_1_4);
 		
 		JLabel lblNewLabel_1_7 = new JLabel("\u0160IFRA:");
 		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_7.setBounds(466, 282, 172, 44);
 		getContentPane().add(lblNewLabel_1_7);
 		
 		JLabel lblNewLabel_1_1_3 = new JLabel("PREDMET:");
 		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		lblNewLabel_1_1_3.setBounds(466, 391, 172, 44);
 		getContentPane().add(lblNewLabel_1_1_3);
 		
 		textField = new JTextField();
 		textField.setHorizontalAlignment(SwingConstants.CENTER);
 		textField.setColumns(10);
 		textField.setBounds(203, 95, 146, 34);
 		getContentPane().add(textField);
 		
 		textField_1 = new JTextField();
 		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
 		textField_1.setColumns(10);
 		textField_1.setBounds(203, 177, 146, 34);
 		getContentPane().add(textField_1);
 		
 		textField_2 = new JTextField();
 		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
 		textField_2.setColumns(10);
 		textField_2.setBounds(203, 282, 146, 34);
 		getContentPane().add(textField_2);
 		
 		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox = new JComboBox(datumi);
 		comboBox.setBounds(203, 404, 41, 22);
 		getContentPane().add(comboBox);
 		
 		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1 = new JComboBox(meseci);
 		comboBox_1.setBounds(254, 404, 84, 22);
 		getContentPane().add(comboBox_1);
 		
 		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_2 = new JComboBox(godine);
 		comboBox_2.setBounds(348, 404, 61, 22);
 		getContentPane().add(comboBox_2);
 		
 		textField_3 = new JTextField();
 		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
 		textField_3.setColumns(10);
 		textField_3.setBounds(628, 85, 146, 34);
 		getContentPane().add(textField_3);
 		
 		textField_4 = new JTextField();
 		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
 		textField_4.setColumns(10);
 		textField_4.setBounds(628, 282, 146, 34);
 		getContentPane().add(textField_4);
 		
 		JRadioButton rdbtnNewRadioButton = new JRadioButton("mu\u0161ki");
 		buttonGroup.add(rdbtnNewRadioButton);
 		rdbtnNewRadioButton.setBounds(628, 183, 61, 23);
 		getContentPane().add(rdbtnNewRadioButton);
 		
 		JRadioButton rdbtnZenski = new JRadioButton("\u017Eenski");
 		buttonGroup.add(rdbtnZenski);
 		rdbtnZenski.setBounds(691, 183, 61, 23);
 		getContentPane().add(rdbtnZenski);
 		
 		textField_5 = new JTextField();
 		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
 		textField_5.setColumns(10);
 		textField_5.setBounds(628, 392, 146, 34);
 		getContentPane().add(textField_5);
 		
 		JButton btnIzlaz = new JButton("IZLAZ");
 		btnIzlaz.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {

				dispose();

 			}
 		});
 		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		btnIzlaz.setFocusable(false);
 		btnIzlaz.setBorderPainted(false);
 		btnIzlaz.setBackground(Color.LIGHT_GRAY);
 		btnIzlaz.setBounds(390, 506, 138, 44);
 		getContentPane().add(btnIzlaz);
 		
 		JButton btnNewButton = new JButton("SA\u010CUVAJ");
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				String	tfime = textField.getText();
 				String	tfprezime = textField_1.getText();
 				String	tfid = textField_2.getText();
 				String	tfemail = textField_3.getText();
 				String tfsifra = textField_4.getText();
 				String tfpredmet = textField_5.getText();
 				String dan = comboBox.getSelectedItem().toString();
 				String mesec = comboBox_1.getSelectedItem().toString();
 				String godina = comboBox_2.getSelectedItem().toString();
 				String pol = null;
 			
 				if(rdbtnNewRadioButton.isSelected() == true) {
 					pol = "Muski";
 				}
 				if(rdbtnZenski.isSelected() == true) {
 					pol = "Zenski";
 				}
 				
 				
 			
 				boolean jdSE = false;
 				boolean jdID = false;
 				boolean provera = kp.ValidacijaUnosa(tfime, tfprezime, tfid, pol, dan, mesec, godina, tfpredmet, tfemail, tfsifra);
 				if(provera == true) {
 					kp.Greska();

 				}
 				if(provera == false) {
 					try {
						jdID = kp.ProveraJedinstvenostiID(tfid);
						jdSE = kp.JedinstvenostEmailSifra(tfsifra, tfemail);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
 					
 					if(jdID || jdSE) {
 						kp.Greska();
 					}
 					if((jdID || jdSE) == false) {
 						try {
 							String datum = baza.FormiranjeDatuma(dan, mesec, godina);
 							Profesor profesor = new Profesor(tfime, tfprezime, tfid, datum, pol, tfemail, tfsifra, tfpredmet);
							kp.Cuvanje(profesor);
						} catch (IOException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
 						kp.Uspeh();
 					}
 				
 				}
 				
 				textField.setText("");
 				textField_1.setText("");
 				textField_2.setText("");
 				textField_3.setText("");
 				textField_4.setText("");
 				textField_5.setText("");
 				comboBox.setSelectedItem("-");
 				comboBox_1.setSelectedItem("-");
 				comboBox_2.setSelectedItem("-");
 				rdbtnNewRadioButton.setSelected(false);
 				rdbtnZenski.setSelected(false);
 					
 					}

 		});
 		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
 		btnNewButton.setFocusable(false);
 		btnNewButton.setBorderPainted(false);
 		btnNewButton.setBackground(Color.LIGHT_GRAY);
 		btnNewButton.setBounds(587, 506, 138, 44);
 		getContentPane().add(btnNewButton);
 		
 		JLabel lblKreiranjeProfesora = new JLabel("KREIRANJE PROFESORA");
 		lblKreiranjeProfesora.setHorizontalAlignment(SwingConstants.CENTER);
 		lblKreiranjeProfesora.setFont(new Font("Times New Roman", Font.BOLD, 36));
 		lblKreiranjeProfesora.setBounds(173, 11, 457, 62);
 		getContentPane().add(lblKreiranjeProfesora);
 		
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
 		btnNewButton_1_1_1.setBounds(10, 12, 65, 62);
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
 		btnNewButton_1_1_1_1.setBounds(85, 12, 65, 62);
 		getContentPane().add(btnNewButton_1_1_1_1);
 		
 		JLabel lblNewLabel_2 = new JLabel("8 i vise karaktera");
 		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel_2.setForeground(Color.RED);
 		lblNewLabel_2.setBackground(SystemColor.menu);
 		lblNewLabel_2.setBounds(628, 325, 145, 14);
 		getContentPane().add(lblNewLabel_2);
 		setVisible(true);
 	}
 	
}
