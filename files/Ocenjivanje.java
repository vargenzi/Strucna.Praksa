package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Ocenjivanje extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private String ocene[] = {"-", "1", "2", "3", "4",("5")};
	
	public static void main(String[] args) {
		
	}
	
	Ocenjivanje(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setTitle("Ocenjivanje");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("OCENJIVANJE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 11, 320, 122);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JMBG:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 144, 188, 57);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(223, 144, 194, 57);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox(ocene);
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(223, 361, 74, 28);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("OCENA:");
		lblNewLabel_1_1.setEnabled(false);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(10, 346, 188, 57);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("OPIS:");
		lblNewLabel_1_1_1.setEnabled(false);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(10, 438, 188, 57);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setEnabled(false);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(182, 447, 174, 50);
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
		btnNewButton.setBounds(74, 212, 103, 39);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jmbg = textField.getText();
				
				boolean pr = Posotjanje(jmbg);
				if(pr == true) {
					boolean provera = false;
					try {
						 provera = Provera(jmbg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(provera == true) {
						textField.setEnabled(false);
						btnNewButton.setEnabled(false);
						lblNewLabel_1_1.setEnabled(true);
						comboBox.setEnabled(true);
						lblNewLabel_1_1_1.setEnabled(true);
						textField_1.setEnabled(true);
						btnSacuvaj.setEnabled(true);
						
						
						
					}
					if(provera == false) {
						Greska();	
					}
					
					
				}
				if(pr == false) {
					
					Greska();
				}
				
				
			}
		});
		getContentPane().add(btnNewButton);
		
		
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ocena = comboBox.getSelectedItem().toString();
				String opis = textField_1.getText();
				boolean dlju = DaLiJeUneto(ocena, opis);
				if(dlju == false) {
					Greska();
				}
				if(dlju == true) {
					
					String niz[] = null;
					try {
						niz = CitanjeLogova();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String niz1[] = null;
					try {
						niz1 = TrazenjeJmbgPredmet(niz);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String jmbg = textField.getText();
					try {
						UpisivanjeOcene(niz1, jmbg, ocena, opis);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
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
		
		
		
		
		setVisible(true);
		
	}
	public boolean Posotjanje(String jmbg) {
		if(jmbg.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean Provera(String jmbg) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(jmbg)) {
				return true;
			}
		}
		
		
		br.close();
		return false;
	}
	public void Greska() {
		System.out.println("Neuspesno");
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public String[] CitanjeLogova() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\logovi.txt"));
		String linija;
		String email;
		String sifra;
		String substrings[];
		linija = br.readLine();
		substrings = linija.split("/", 100);
		email = substrings[0];
		sifra = substrings[1];
		String niz[] = {email, sifra};
		
		br.close();
		return niz;
	}
	
	public boolean DaLiJeUneto(String ocena, String opis) {
		if(ocena.equals("-")||opis.equals("")) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public String[] TrazenjeJmbgPredmet(String[] niz) throws IOException {
	
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
		String linije;
		String substrings[];
		String random[] = {"0"};

		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[7])&&niz[1].equals(substrings[8])) {
				String povratni[] = {substrings[2], substrings[9]};
				return povratni;
			}
		}
		
		br.close();
		return random;
	}
	
	public void UpisivanjeOcene(String niz[], String jmbg, String ocena, String opis) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt", true));
		bw.write(niz[0] + "/" + jmbg + "/" +  niz[1] + "/" + ocena + "/" + opis);
		bw.newLine();
		
		bw.close();
		
	}
}
