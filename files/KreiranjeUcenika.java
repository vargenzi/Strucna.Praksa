package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class KreiranjeUcenika extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	ArrayList<Ucenici> alu = new ArrayList<Ucenici>();
	ArrayList<Ucenici>  alu2 = new ArrayList<Ucenici>();


	
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
			"-", "2001", "2002", "2003", "2004", "2005", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"
	};
	
	private String razredi[] = {
		"-", "Prvi OS", "Drugi OS", "Treci OS", "Cetvrti OS", "Peti OS", "Sesti OS", "Sedmi OS", "Osmi OS", "Prvi SS", "Drugi SS", "Treci SS", "Cetvrti SS"
		
	};
	
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	KreiranjeUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
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
		
		JComboBox comboBox = new JComboBox(datumi);
		comboBox.setBounds(204, 404, 41, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(meseci);
		comboBox_1.setBounds(255, 404, 84, 22);
		getContentPane().add(comboBox_1);
		
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
		
		JComboBox comboBox_1_1 = new JComboBox(godine);
		comboBox_1_1.setBounds(204, 506, 84, 22);
		getContentPane().add(comboBox_1_1);
		
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
			String	tfjmbg = textField_2.getText();
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
			
			
			System.out.print(tfime + "|" + tfprezime + "|" +tfjmbg + "|"+ tfemail +"|"+ tfsifra+ "|" + dan + "|" + mesec + "|" + godina + "|" + godinaUpisa + "|" + Razred + "|" + pol);
			Ucenici ucenik = new Ucenici(tfime, tfprezime, tfjmbg, dan, mesec, godina, pol, Razred, godinaUpisa, tfemail, tfsifra);
			
			
			
			boolean bul = false;
			try {
				bul = ProveraJedinstvenosti(tfjmbg);
				System.out.println(bul);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boolean provera = tfime.equals("") || tfprezime.equals("") || tfjmbg.equals("") || (bul == false) || tfemail.equals("") || tfsifra.equals("") || dan.equals("-") || mesec.equals("-") || godina.equals("-") || godinaUpisa.equals("-") || Razred.equals("-") || (pol == null);
			
			if(provera == true) {
				System.out.println("Neuspesno");
				String message = "Pogresan unos, pokusajte ponovo.";
				JFrame jf = new JFrame();
				jf.setSize(300, 300);
				
				
				JOptionPane.showMessageDialog(jf, message, "Greska",
				        JOptionPane.ERROR_MESSAGE);
				
				
			}
			if(provera == false) {
			
			
			try {
				Cuvanje(ucenik);
			} catch (IOException e1) {
				
				e1.printStackTrace();
					}
			
			String message = "Uspresno sacuvan novi ucenik.";
			JFrame jf = new JFrame();
			jf.setSize(300, 300);
			
			
			JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
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
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
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
	
	//upis u file
	public void Cuvanje(Ucenici ucenik) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt", true)); 
		
		bw.write(ucenik.ime + "/" + ucenik.prezime + "/" +ucenik.jmbg + "/" + ucenik.dan_rodjenja + "/" + ucenik.mesec_rodjenja + "/" + ucenik.godina_rodjenja  + "/" + ucenik.pol + "/" + ucenik.razred + "/" + ucenik.godina_upisa + "/" + ucenik.email + "/" + ucenik.sifra);
		bw.newLine();
		bw.close();
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt", true));
		bw1.write(ucenik.jmbg);
		bw1.newLine();
		bw1.close();
		
		
	}
	//provera jedinstvenosti jmbga
	public boolean ProveraJedinstvenosti(String jmbg) throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt"));
		String linije;
		String vrednosti = "";
		while((linije = br.readLine()) != null){
			
			vrednosti = linije;
			if(vrednosti.equals(jmbg)) {
				
				return false;
			}
		}
		br.close();
		
		return true;
	}
}

