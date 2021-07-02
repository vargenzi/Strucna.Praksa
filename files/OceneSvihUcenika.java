package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OceneSvihUcenika extends JFrame{
private ArrayList<String[]> als = new ArrayList<String[]>();
	
	public static void main(String[] args) {
		
	}

	OceneSvihUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setTitle("Ocene - Svih - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setEditable(false);
		textArea.setBounds(10, 151, 764, 399);
		getContentPane().add(textArea);
		
		
		
		
		
		
		JLabel lblOcene = new JLabel("OCENE");
		lblOcene.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcene.setFont(new Font("Times New Roman", Font.BOLD, 46));
		lblOcene.setBounds(10, 11, 774, 56);
		getContentPane().add(lblOcene);
		
		JButton btnIzadji = new JButton("IZLAZ");
		btnIzadji.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnIzadji.setBackground(Color.WHITE);
		btnIzadji.setFocusable(false);
		btnIzadji.setBorderPainted(false);
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(632, 88, 116, 38);
		getContentPane().add(btnIzadji);
		
		JButton btnPrikazi = new JButton("PRIKAZI");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String niz[] = null;
				String niz1[] = null;

				try {
					niz = CitanjeLogova();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					niz1 = TrazenjeJmbgPredmet(niz);
					if(niz1 == null) {
						Greska();
						dispose();
						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String predmet = niz1[1];
				try {
					PunjenjeListe(niz1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					TrazenjeImena();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int i = 0;
				String tekst = "PREDMET: " + predmet + "\n";
				while(i<als.size()) {
					tekst += "              Ime: " + als.get(i)[3] + " -- Prezime: " + als.get(i)[4] + " -- Ocena: " + als.get(i)[1] + " -- Opis:" + als.get(i)[2] + "\n";
					
					i++;
				}
				
				
				textArea.setText(tekst);
				als.clear();
			}
		});
		btnPrikazi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPrikazi.setFocusable(false);
		btnPrikazi.setBorderPainted(false);
		btnPrikazi.setBackground(Color.WHITE);
		btnPrikazi.setBounds(494, 88, 116, 38);
		getContentPane().add(btnPrikazi);
		setVisible(true);
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
		String random[] = null;

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

public void PunjenjeListe(String niz1[]) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
	String linije;
	String substrings[];
	while((linije = br.readLine())!=null) {
		substrings = linije.split("/", 100);
		if(substrings[0].equals(niz1[0])) {
			String jmbg = substrings[1];
			String ocena = substrings[3];
			String opis = substrings[4];
			String podaci[] = {jmbg, ocena, opis};
			als.add(podaci);
		}
		
	}
	
	
	
	br.close();
}


public void TrazenjeImena() throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
	String linije;
	String substrings[];
	while((linije = br.readLine()) != null) {
		substrings = linije.split("/", 100);
		int i = 0;
		while(i<als.size()) {
			String podaci[] = als.get(i);
			if(substrings[2].equals(podaci[0])) {
				String novo[] = {podaci[0], podaci[1], podaci[2], substrings[0], substrings[1]};
				als.set(i, novo);
			}
			
			
			i++;
		}
	}	
	
br.close();
}


public void Greska() {
	System.out.println("Neuspesno");
	String message = "Pogresan unos, pokusajte ponovo.";
	JFrame jf = new JFrame();
	jf.setSize(300, 300);
	
	
	JOptionPane.showMessageDialog(jf, message, "Greska",
	        JOptionPane.ERROR_MESSAGE);
}
	
	
	
}
