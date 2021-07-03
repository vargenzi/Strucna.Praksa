package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
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

public class BrisanjeUcenika extends JFrame{
	private JTextField textField;	
	ArrayList<Ucenici> alp = new ArrayList<Ucenici>();
	ArrayList<String> alj = new ArrayList<String>();


	
	public static void main(String[] args) {
		BrisanjeUcenika bu = new BrisanjeUcenika();
		bu.setSize(800, 600);
		bu.setVisible(true);
		
		
	}
	
	BrisanjeUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
		setTitle("Brisanje - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BRISANJE U\u010CENIKA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 11, 445, 82);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JMBG:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 188, 252, 69);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBounds(215, 194, 233, 69);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(496, 188, 207, 150);
		getContentPane().add(textArea);
		
		JButton btnSauvaj = new JButton("SA\u010CUVAJ");
		btnSauvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PunjenjeListe1();
					PunjenjeListe2();
					int p1 = Pretraga1(textField.getText());
					int p2 = Pretraga2(textField.getText());
					alp.remove(p1);
					alj.remove(p2);
					Brisanje1();
					Brisanje2();
					System.out.println("Uspresno obrisano.");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSauvaj.setEnabled(false);
		btnSauvaj.setForeground(Color.BLACK);
		btnSauvaj.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnSauvaj.setBackground(Color.WHITE);
		btnSauvaj.setBounds(215, 363, 233, 44);
		getContentPane().add(btnSauvaj);
		
		
		
		
		JButton btnNewButton = new JButton("POTVRDI\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tfjmbg = textField.getText();
				try {
					boolean bul = Provera(tfjmbg);
					if(bul == true) {
						textArea.setText("Uneti jmbg je validan.");
						btnSauvaj.setEnabled(true);
						btnNewButton.setEnabled(false);
						textField.setEnabled(false);
						
						
					}
					
					if(bul == false) {
						textArea.setText("Uneli ste neposotjeci jmbg, \n ili ga niste ni uneli.");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
		});
		btnSauvaj.setFocusable(false);
		btnSauvaj.setBorderPainted(false); 
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(215, 292, 233, 44);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setForeground(Color.BLACK);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setBounds(25, 492, 166, 44);
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
		btnNewButton_1_1_1.setBounds(25, 11, 65, 62);
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
		btnNewButton_1_1_1_1.setBounds(100, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		
		
		
		setVisible(true);
		
		
	}
	
	public boolean Provera(String jmbg) throws IOException {
		
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
	
	String linije;
	String vrednosti[];
	while((linije = br.readLine()) != null) {
		vrednosti = linije.split("/", 100);
		if(jmbg.equals(vrednosti[2])) {
			
			return true;
		}
		
		
	}
	br.close();
	
	return false;
	}
	

	
	
	public void PunjenjeListe1() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String vrednosti;
		String substrings[];
		while((vrednosti = br.readLine())!= null) {
			substrings = vrednosti.split("/", 100);
			Ucenici ucenik = new Ucenici(substrings[0], substrings[1], substrings[2], substrings[3], substrings[4], substrings[5], substrings[6], substrings[7], substrings[8], substrings[9],substrings[10]);
			alp.add(ucenik);
		}
		br.close();
	
	}
	
	public void PunjenjeListe2() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt"));
		String vrednosti;
		while((vrednosti = br.readLine())!= null) {
			
			alj.add(vrednosti);
		}
		br.close();
	
	}
	
	public int Pretraga1(String jmbg) {
		int i = 0;
		int k;
		while(i<alp.size()) {
			if(alp.get(i).jmbg.equals(jmbg)) {
				k = i;
				return k;
			}
			
			i++;
		}
			
		return 132456;
	}
	
	public int Pretraga2(String jmbg) {
		int i = 0;
		int k;
		while(i<alj.size()) {
			if(alj.get(i).equals(jmbg)) {
				k = i;
				return k;
			}
			
			i++;
		}
			
		return 132456;
	}
	
	
public void Brisanje1() throws IOException {
	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
	int i = 0;
	while(i<alp.size()) {
		
		bw.write(alp.get(i).ime + "/" + alp.get(i).prezime + "/" + alp.get(i).jmbg + "/" + alp.get(i).dan_rodjenja + "/" + alp.get(i).mesec_rodjenja + "/" + alp.get(i).godina_rodjenja + "/" + alp.get(i).pol + "/" + alp.get(i).razred + "/" + alp.get(i).godina_upisa + "/" + alp.get(i).email + "/" + alp.get(i).sifra);
		bw.newLine();
		
		
		i++;
	}
	alp.clear();
	bw.close();
	}


public void Brisanje2() throws IOException {
	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Popis_jmbg.txt"));
	int i = 0;
	while(i<alj.size()) {
		
		bw.write(alj.get(i));
		bw.newLine();
		
		
		i++;
	}
	alj.clear();
	bw.close();
	}
	
	
}
