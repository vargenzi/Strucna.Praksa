package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class KreiranjeProfesora extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	


 static void main(String[] args) {
	 
		
	}
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
		ArrayList<Profesori> alp = new ArrayList<Profesori>();
 		
 	KreiranjeProfesora(){
 		setResizable(false);
 		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
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
 		
 		JLabel lblNewLabel_1_1_1 = new JLabel("JMBG:");
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
 		
 		JComboBox comboBox = new JComboBox(datumi);
 		comboBox.setBounds(203, 404, 41, 22);
 		getContentPane().add(comboBox);
 		
 		JComboBox comboBox_1 = new JComboBox(meseci);
 		comboBox_1.setBounds(254, 404, 84, 22);
 		getContentPane().add(comboBox_1);
 		
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
 				String	tfjmbg = textField_2.getText();
 				String	tfemail = textField_3.getText();
 				String tfsifra = textField_4.getText();
 				String tpredmet = textField_5.getText();
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
 				
 				System.out.print(tfime + "|" + tfprezime + "|" +tfjmbg + "|"+ tfemail +"|"+ tfsifra+ "|" + dan + "|" + mesec + "|" + godina + "|" + pol + "|" + tpredmet);
 				Profesori prof = new Profesori(tfime, tfprezime, tfjmbg, dan, mesec, godina, pol, tfemail, tfsifra, tpredmet);
 				
 				boolean bul = false;
 				try {
 					bul = ProveraJedinstvenosti(tfjmbg);
 					System.out.println( "\n" + bul);
 				} catch (IOException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 				boolean provera = tfime.equals("") || tfprezime.equals("") || tfjmbg.equals("") || (bul == false) || tfemail.equals("") || tfsifra.equals("") || dan.equals("-") || mesec.equals("-") || godina.equals("-") ||  (pol == null) || tpredmet.equals("");
 				
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
 					Cuvanje(prof);
 				} catch (IOException e1) {
 					
 					e1.printStackTrace();
 						}
 					
 					}
 				
 				
 				
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
 		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
 		btnNewButton_1_1_1.setFocusable(false);
 		btnNewButton_1_1_1.setBorderPainted(false);
 		btnNewButton_1_1_1.setBackground(SystemColor.menu);
 		btnNewButton_1_1_1.setBounds(10, 12, 65, 62);
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
 		btnNewButton_1_1_1_1.setBounds(85, 12, 65, 62);
 		getContentPane().add(btnNewButton_1_1_1_1);
 		setVisible(true);
 	}
 	public void Cuvanje(Profesori prof) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt", true)); 
		bw.write(prof.ime + "/" + prof.prezime + "/" +prof.jmbg + "/"+ prof.dan_rodjenja +"/"+ prof.mesec_rodjenja+ "/" + prof.godina_rodjenja + "/" + prof.pol + "/" + prof.email + "/" + prof.sifra + "/" + prof.predmet);
		bw.newLine();
		
		bw.close();
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt", true)); 
		bw1.write(prof.jmbg);
		bw1.newLine();
		bw1.close();
		
	}
 	
 	public boolean ProveraJedinstvenosti(String jmbg) throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt"));
		String linije;
		String vrednosti = "";
		while((linije = br.readLine()) != null){
			
			vrednosti =  linije;
			if(vrednosti.equals(jmbg)) {
				
				return false;
			}
		}

		
		return true;
	}
}
