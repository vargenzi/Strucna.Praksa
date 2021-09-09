package ui.Admin;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;
import core.Baza;
import core.Ucenik;
import core.AdminFunkcionalnost.KreiranjeUc;

public class KreiranjeUcenika extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private KreiranjeUc al = new KreiranjeUc();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private Baza baza = new Baza();
	
	public static void main(String[] args) {
		
	}
	
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
			"-", "2002", "2003", "2004", "2005", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"
	};
	
	private String razredi[] = {
		"-", "Prvi OS", "Drugi OS", "Treci OS", "Cetvrti OS", "Peti OS", "Sesti OS", "Sedmi OS", "Osmi OS", "Prvi SS", "Drugi SS", "Treci SS", "Cetvrti SS"
		
	};
	
	private String[] godineU = {
			"-", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"
	};
	
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	KreiranjeUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setSize(800, 600);
		setTitle("Kreiranje - Ucenika");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KREIRANJE U\u010CENIKA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 11, 444, 62);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IME:\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 84, 172, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("E - MAIL:");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(448, 84, 172, 44);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_7 = new JLabel("\u0160IFRA:");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setBounds(448, 285, 172, 44);
		getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("PREZIME:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 174, 172, 44);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(10, 285, 172, 44);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DATUM RO\u0110ENJA");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(10, 391, 172, 44);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("RAZRED:");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(448, 391, 172, 44);
		getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("POL:");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setBounds(448, 174, 172, 44);
		getContentPane().add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("GODINA UPISA:");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_7_1.setBounds(10, 493, 172, 44);
		getContentPane().add(lblNewLabel_1_7_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(204, 84, 146, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(204, 172, 146, 34);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(204, 285, 146, 34);
		getContentPane().add(textField_2);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox = new JComboBox(datumi);
		comboBox.setBounds(204, 404, 41, 22);
		getContentPane().add(comboBox);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1 = new JComboBox(meseci);
		comboBox_1.setBounds(255, 404, 84, 22);
		getContentPane().add(comboBox_1);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_2 = new JComboBox(godine);
		comboBox_2.setBounds(349, 404, 61, 22);
		getContentPane().add(comboBox_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(611, 84, 146, 34);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(611, 285, 146, 34);
		getContentPane().add(textField_4);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1_1 = new JComboBox(godineU);
		comboBox_1_1.setBounds(204, 506, 84, 22);
		getContentPane().add(comboBox_1_1);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1_2 = new JComboBox(razredi);
		comboBox_1_2.setBounds(611, 404, 127, 22);
		getContentPane().add(comboBox_1_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("mu\u0161ki");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(611, 187, 61, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnZenski = new JRadioButton("\u017Eenski");
		buttonGroup.add(rdbtnZenski);
		rdbtnZenski.setBounds(674, 187, 61, 23);
		getContentPane().add(rdbtnZenski);
		
		JButton btnNewButton = new JButton("SA\u010CUVAJ");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String	tfime = textField.getText();
				String	tfprezime = textField_1.getText();
				String	tfid = textField_2.getText();
				String	tfemail = textField_3.getText();
				String tfsifra = textField_4.getText();
				String dan = comboBox.getSelectedItem().toString();
				String mesec = comboBox_1.getSelectedItem().toString();
				String godina = comboBox_2.getSelectedItem().toString();
				String godinaUpisa = comboBox_1_1.getSelectedItem().toString();
				String Razred = comboBox_1_2.getSelectedItem().toString();
				String pol = null;
				if(rdbtnNewRadioButton.isSelected() == true) {
					pol = "Muski";
				}
				if(rdbtnZenski.isSelected() == true) {
					pol = "Zenski";
				}
				
				boolean provera = al.ValidacijaUnosa(tfime, tfprezime, tfid, pol, dan, mesec, godina, godinaUpisa, Razred, tfemail, tfsifra);
				if(provera == true) {
					al.Greska();
						
				}
				if(provera == false){
				
				boolean bul = false;
				try {
					bul = al.ProveraJedinstvenostiID(tfid);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				boolean jedinstvenost = false;
				try {
					jedinstvenost = al.JedinstvenostEmailSifra(tfsifra, tfemail);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				boolean poklapanje_godina = al.PoklapanjeGodina(godinaUpisa, godina, Razred);
				if(bul||jedinstvenost||poklapanje_godina) {
					al.Greska();
				}
				if((bul||jedinstvenost||poklapanje_godina) == false) {
					Ucenik ucenik;
					try {
						String datum = baza.FormiranjeDatuma(dan, mesec, godinaUpisa);
						ucenik = new Ucenik(tfime, tfprezime, tfid, datum, pol, Razred, godinaUpisa, tfemail, tfsifra);
						al.Cuvanje(ucenik);
					} catch (IOException | ClassNotFoundException | SQLException | ParseException e1) {
						
						e1.printStackTrace();
							}
					al.Uspeh();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					comboBox.setSelectedItem("-");
					comboBox_1.setSelectedItem("-");
					comboBox_2.setSelectedItem("-");
					comboBox_1_1.setSelectedItem("-");
					comboBox_1_2.setSelectedItem("-");
					rdbtnNewRadioButton.setSelected(false);
					rdbtnZenski.setSelected(false);
				}
					
			}
		}
	});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(580, 495, 138, 44);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.setBackground(Color.LIGHT_GRAY);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnIzlaz.setBounds(399, 493, 138, 44);
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		getContentPane().add(btnIzlaz);
		
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
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
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
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("8 i vise karaktera");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(612, 325, 145, 14);
		getContentPane().add(lblNewLabel_2);
		setVisible(true);
		
	}
	

	
	
	

	
	
}
