package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OceneJednogucenikaIzPredmeta extends JFrame{
	private JTextField textField;
	private ArrayList<String> ars = new ArrayList<String>();
	
	public static void main(String[] args) {
		
	}

	OceneJednogucenikaIzPredmeta(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setResizable(false);
		setTitle("Ocene");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		textArea.setEditable(false);
		textArea.setBounds(10, 248, 774, 301);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(176, 118, 119, 47);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("JMBG:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 97, 199, 76);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String jmbg = textField.getText();
				if(jmbg.equals("")) {
					Greska();
				}
				if(jmbg.equals("") == false) {
					boolean provera = false;
					try {
						provera = Provera(jmbg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(provera == false) {
						Greska();
					}
					if(provera) {
						textField.setEnabled(false);
						lblNewLabel.setEnabled(false);
						btnNewButton.setEnabled(false);
						try {
							PunjenjeListe(jmbg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
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
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						try {
							PunjenjeListe2(jmbg, niz1[0]);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						String tekst = "                Ime: " + ars.get(0) + "\n" + "                Prezime: " + ars.get(1) + "\n"; 
						
						int i = 2;
						System.out.println(ars.size());

						while(i<ars.size()) {
							int s = Integer.parseInt(ars.get(i));
							System.out.println(s);

						if((s>=1)&&(s<=5)) {
							tekst += "                Ocena: " + ars.get(i) + "\n";
						}
						i++;
						}
						ars.clear();
						textArea.setText(tekst);
						
						
						
					}
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton.setBounds(47, 170, 126, 47);
		getContentPane().add(btnNewButton);
		
		JLabel lblOcene = new JLabel("OCENE");
		lblOcene.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcene.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblOcene.setBounds(10, 11, 774, 56);
		getContentPane().add(lblOcene);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnIzlaz.setBounds(647, 170, 126, 47);
		getContentPane().add(btnIzlaz);
		setVisible(true);
		
		
	}
	
	public void Greska() {
		System.out.println("Neuspesno");
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
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
	
	public  void PunjenjeListe(String jmbg) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			if(jmbg.equals(substrings[2])) {
				String ime = substrings[0];
				String prezime = substrings[1];
				ars.add(ime);
				ars.add(prezime);
			}
			
		}
		
		
		br.close();
		
	}
	
	public  void PunjenjeListe2(String jmbg, String jmbgp) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			substrings = linije.split("/", 100);
			System.out.println(jmbgp);

			if(jmbg.equals(substrings[1]) && jmbgp.equals(substrings[0])) {
				String ocena = substrings[3];

				ars.add(ocena);
			}
			
		}
		
		
		br.close();
		
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
	
	
	public String[] TrazenjeJmbgPredmet(String[] niz) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
		String linije;
		String substrings[];
		String random[] = {"0"};

		while((linije = br.readLine())!= null) {
			substrings = linije.split("/", 100);
			if(niz[0].equals(substrings[7])&&niz[1].equals(substrings[8])) {
				String povratni[] = {substrings[2]};
				return povratni;
			}
		}
		
		br.close();
		return random;
	}
	

}
