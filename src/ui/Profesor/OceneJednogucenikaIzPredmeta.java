package ui.Profesor;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.ProfesorFunkcionalnosti.SveOceneJednog;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class OceneJednogucenikaIzPredmeta extends JFrame{
	private JTextField textField;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private SveOceneJednog oj = new SveOceneJednog();

	OceneJednogucenikaIzPredmeta(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setResizable(false);
		setTitle("Ocene - Jednog - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBounds(10, 248, 774, 301);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(177, 118, 119, 47);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
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
				
				String id = textField.getText();
				if(id.equals("")) {
					oj.Greska();
					textField.setText("");
				}
				if(id.equals("") == false) {
					boolean provera = false;
					try {
						provera = oj.Provera(id);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if(provera == false) {
						oj.Greska();
						textField.setText("");
					}
					if(provera) {
						textField.setEnabled(false);
						lblNewLabel.setEnabled(false);
						btnNewButton.setEnabled(false);
						String niz[] = null;
						try {
							niz = oj.CitanjeLogova();
						} catch (IOException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}	

						String nizIdPr[] = null;
						try {
							nizIdPr = oj.TrazenjeIdPredmeta(niz);
						} catch (Exception e2) {
							e2.printStackTrace();
						}

						String predmet = nizIdPr[1];
						String tekst = "";
						try {
							tekst = oj.Ispis(predmet, id);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						textField.setText("");
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
		lblOcene.setFont(new Font("Times New Roman", Font.BOLD, 46));
		lblOcene.setBounds(160, 11, 415, 56);
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
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfesorMeni pm = new ProfesorMeni();
				pm.setSize(800, 600);
				pm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavniProzor g = new GlavniProzor();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		setVisible(true);	
	}
}
