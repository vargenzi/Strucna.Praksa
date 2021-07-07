package ui.Ucenik;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import core.UcenikFunkcionalnosti.OceneJedanPredmet;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

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

public class OceneIzJednogPredmeta extends JFrame{
	private JTextField textField;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private OceneJedanPredmet oj = new OceneJedanPredmet();


	OceneIzJednogPredmeta(){
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		
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
					oj.Greska("Polje je prazno, unesite predmet.");
				}
				if(predmet.equals("")==false) {
					boolean provera = false;
					try {
						provera = oj.PostojanjePredmeta(predmet);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if(provera == false) {
						oj.Greska("Za ovaj predmet ne postoji uneta ocena.");
						textField.setText("");
					}
					if(provera == true) {
						String niz[] = null;
						String niz1[] = null;
						
						try {
							niz = oj.CitanjeLogova();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						try {
							niz1 = oj.TrazenjeImenaJmbg(niz);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						int k = 3;
						try {
							k = oj.PunjenjeListe(predmet, niz1[0]);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						if(k == 0) {
							oj.Greska("Nemate ni jednu ocenu iz unetog predmeta.");
						}
						if(k == 1) {
							String tekst = oj.Ispis(predmet, niz1);
							oj.PraznjenjeListe();
							textField.setText("");
							textArea.setText(tekst);
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
		btnNewButton_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavniProzor g = new GlavniProzor();
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
}
