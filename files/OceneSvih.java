package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OceneSvih extends JFrame{
	private ArrayList<String[]> als = new ArrayList<String[]>();
	private ArrayList<Double> ald = new ArrayList<Double>();
	private ArrayList<String> als1 = new ArrayList<String>();



	
	public static void main(String[] args) {
		
	}
	OceneSvih(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
	setTitle("Ocene-Iz-Svih-Predmeta");
	setSize(800, 600);
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("OCENE IZ SVIH PREDMETA");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(140, 11, 634, 60);
	getContentPane().add(lblNewLabel);
	
	JButton btnNewButton = new JButton("IZLAZ");
	btnNewButton.setFocusable(false);
	btnNewButton.setBorderPainted(false);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	btnNewButton.setBounds(605, 141, 169, 53);
	getContentPane().add(btnNewButton);
	
	JTextArea textArea = new JTextArea();
	textArea.setEditable(false);
	textArea.setBackground(Color.LIGHT_GRAY);
	textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	textArea.setBounds(10, 213, 764, 337);
	getContentPane().add(textArea);
	
	JButton btnNewButton_1 = new JButton("PRIKAZI");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
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
			try {
				TrazenjeOcena(niz1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int i = 0;
			while(i<als.size()) {
				int k = 0;
				int brojac = 0;
				String p = als.get(i)[2];
				int zbir = 0;
				boolean prov = false;

				while(k<als.size() && Ponavljanje(p)) {
					if(p.equals(als.get(k)[2])) {
						zbir += Integer.parseInt(als.get(k)[3]);
						brojac++;
						prov = true;
					}
					
					k++;
				}
				if(prov == true) {
				als1.add(p);
				double zbir1= zbir;
				double prosek = zbir1/brojac;
				System.out.println("\n" + prosek + "\n");
				ald.add(prosek);
				}
				
				
				i++;
			}
			i = 0;
			double prosek = Prosek();
			ald.clear();
			als1.clear();
			String fprosek = new DecimalFormat("#.00").format(prosek);
			String tekst = "Ime: " + niz1[1] + "\n" + "Prezime: " + niz1[2] + "\nTrenutni uspeh: "+ fprosek + "\n"; 
			while(i<als.size()) {
				
				tekst += "         Predmet: " + als.get(i)[2] + " --- Ocena: " + als.get(i)[3] + " --- Opis: " + als.get(i)[4] + "\n";
				i++;
			}
			
			textArea.setText(tekst);
			als.clear();
			
			
			
		}
	});
	btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	btnNewButton_1.setFocusable(false);
	btnNewButton_1.setBorderPainted(false);
	btnNewButton_1.setBackground(Color.WHITE);
	btnNewButton_1.setBounds(605, 82, 169, 53);
	getContentPane().add(btnNewButton_1);
	
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
	btnNewButton_1_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			glavni g = new glavni();
			g.setSize(800, 600);
			g.setVisible(true);
			dispose();
		}
	});
	btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\home.png"));
	btnNewButton_1_1_1.setFocusable(false);
	btnNewButton_1_1_1.setBorderPainted(false);
	btnNewButton_1_1_1.setBackground(SystemColor.menu);
	btnNewButton_1_1_1.setBounds(85, 11, 65, 62);
	getContentPane().add(btnNewButton_1_1_1);
	setVisible(true);
		
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
	
	public void TrazenjeOcena(String[] niz1) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			
			substrings = linije.split("/", 100);
			if(niz1[0].equals(substrings[1])) {
				
				String predmet = substrings[2];
				String ocena = substrings[3];
				String opis = substrings[4];
				String novo[] = {niz1[1], niz1[2], predmet, ocena, opis};
				als.add(novo);
				
			}
				
				
		}
	
	
	
	br.close();
	}
	public double Prosek() {
		int  i = 0;
		double zbir = 0.0;
		while(i<ald.size()) {
			zbir += ald.get(i);
			i++;
		}
		double prosek = zbir/i;
		return prosek;
		
	}

	public boolean Ponavljanje(String predmet) {
		int i = 0;
		while(i<als1.size()) {
			
			if(als1.get(i).equals(predmet)) {
				return false;
			}
			
			i++;
		}
		
		
		return true;
	}

}
