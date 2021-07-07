package ui.Profesor;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import core.ProfesorFunkcionalnosti.OceneSvihIzJednog;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OceneSvihUcenika extends JFrame{

	private OceneSvihIzJednog os = new OceneSvihIzJednog();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	
	OceneSvihUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
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
		lblOcene.setBounds(247, 11, 288, 56);
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
				String nizIdPr[] = null;
				os.praznjenjeListe();

				try {
					niz = os.CitanjeLogova();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					nizIdPr = os.TrazenjeIdIPredmeta(niz);
					if(nizIdPr == null) {
						os.Greska("Nismo supeli da pronadjemo podatke o Vasem predmetu :(");
						dispose();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String predmet = nizIdPr[1];
				try {
					os.PunjenjeListe(nizIdPr);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					os.TrazenjeImena();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String tekst = os.Ispis();
					textArea.setText(tekst);
				
			}
		});
		btnPrikazi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPrikazi.setFocusable(false);
		btnPrikazi.setBorderPainted(false);
		btnPrikazi.setBackground(Color.WHITE);
		btnPrikazi.setBounds(494, 88, 116, 38);
		getContentPane().add(btnPrikazi);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfesorMeni pm = new ProfesorMeni();
				pm.setSize(800, 600);
				pm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavniProzor g = new GlavniProzor();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		setVisible(true);
	}	
}

