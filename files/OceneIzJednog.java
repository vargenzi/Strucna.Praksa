package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OceneIzJednog extends JFrame{
	private JTextField textField;
	private ArrayList<String[]> als = new ArrayList<String[]>();

	public static void main(String[] args) {
		
	}

	OceneIzJednog(){
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
		
		setSize(800, 600);
		setTitle("Ocene - iz - jednog - predmeta");
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(10, 223, 764, 337);
		
		JLabel lblNewLabel = new JLabel("OCENE IZ JEDNOG PREDMETA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(184, 11, 567, 62);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("PRIKAZI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String predmet = textField.getText();
				if(predmet.equals("")) {
					Greska("Polje je prazno, unesite predmet.");
					
					
				}
				if(predmet.equals("")==false) {
					boolean provera = false;
					try {
						provera = PostojanjePredmeta(predmet);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(provera == false) {
						Greska("Za ovaj predmet ne postoji uneta ocena.");
						textField.setText("");
					}
					if(provera == true) {
						String niz[] = null;
						String niz1[] = null;

						
						try {
							niz = CitanjeLogova();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							niz1 = TrazenjeImenaJmbg(niz);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int k = 3;
						try {
							k = PunjenjeListe(predmet, niz1[0]);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(k == 0) {
							Greska("Nemate ni jednu ocenu iz unetog predmeta.");
						}
						if(k == 1) {
							int i = 0;
							double prosek = Prosek();
							String fprosek = new DecimalFormat("#.00").format(prosek);
							String tekst = "PREDMET: " + predmet + "\nProsek: " + fprosek +"\nIme: " + niz1[1] + "\nPrezime: " + niz1[2] + "\n"; 
							while(i<als.size()) {
								
								tekst += "           Ocena: " + als.get(i)[0] + " --- Opis: " + als.get(i)[1] + "\n"; 
								
								i++;
							}
							textField.setText("");
							textArea.setText(tekst);
							als.clear();
						}
						
						
					}
					
					
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(415, 108, 169, 53);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("IZLAZ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(594, 108, 169, 53);
		getContentPane().add(btnNewButton);
		
		
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("PREDMET");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 103, 163, 67);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(222, 110, 139, 53);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UcenikMeni um = new UcenikMeni();
				um.setSize(800, 600);
				um.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\home.png"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				glavni g = new glavni();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		setVisible(true);
		
		
	}
	
	public void Greska(String message) {
		System.out.println("Neuspesno");
		
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}

	public boolean PostojanjePredmeta(String predmet) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(predmet)) {
				return true;
			}
			
		}
		
		br.close();
		
		return false;
	}

	public String[] CitanjeLogova() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\logovi_ucenici.txt"));
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

	public String[] TrazenjeImenaJmbg(String[] niz) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String linije;
		String substrings[];
		String random[] = null;
		while((linije = br.readLine()) != null) {
			
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[9])&&niz[1].equals(substrings[10])) {
				String ime = substrings[0];
				String prezime = substrings[1];
				String jmbg = substrings[2];
				String podaci[] = {jmbg, ime, prezime};
				return podaci;
				
			}
		}
		
		br.close();

		return random;
	
}

	public int PunjenjeListe(String predmet, String jmbg) throws IOException {
		BufferedReader br;
		br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		int k = 0;
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			System.out.print(substrings[1] + "\n" + substrings[2] + "\n" + "------------- \n" + jmbg + "\n" + predmet);
			if(substrings[1].equals(jmbg) && substrings[2].equals(predmet)) {
				
				String novo[] = {substrings[3], substrings[4]};
				als.add(novo);
				k = 1;
			}
		}
		
	
		br.close();
		return k;
	}

	
	public double Prosek() {
		int i = 0;
		int zbir = 0;
		while(i<als.size()) {
			int ocena = Integer.parseInt(als.get(i)[0]);
			zbir += ocena;
			System.out.println("\n" + zbir);
			i++;
		}
		System.out.println("\n" + i);
		double zbir1 = zbir;
		double prosek = zbir1/i;
		return prosek;
		
	}
}

