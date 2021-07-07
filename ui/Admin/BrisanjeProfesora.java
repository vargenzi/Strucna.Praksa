package ui.Admin;


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
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;
import core.AdminFunkcionalnost.*;

public class BrisanjeProfesora extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;	
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private BrisanjePr bp = new BrisanjePr();

	
	public static void main(String[] args) {
		
		
		
	}
	
	BrisanjeProfesora(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setTitle("Brisanje - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BRISANJE PROFESORA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(212, 11, 462, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
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
		
		JButton btnNewButton = new JButton("POTVRDI\r\n");
		
		JButton btnSauvaj = new JButton("SA\u010CUVAJ");
		btnSauvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					bp.PretragaListeProfesora(textField.getText());
					bp.PretragaListeId(textField.getText());
					bp.UpisUProfesora();
					bp.UpisUId();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				bp.Uspeh();
				textArea.setEnabled(true);
				btnSauvaj.setEnabled(false);
				btnNewButton.setEnabled(true);
				textField.setText("");
				textArea.setText("");
				textField.setEnabled(true);

			}
		});
		btnSauvaj.setEnabled(false);
		btnSauvaj.setForeground(Color.BLACK);
		btnSauvaj.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnSauvaj.setBackground(Color.WHITE);
		btnSauvaj.setBounds(215, 363, 233, 44);
		getContentPane().add(btnSauvaj);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				try {
					bp.PunjenjeListeProfesora();
					bp.PunjenjeListeID();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
					boolean bul = bp.Provera(id);
					if(bul == true) {
						textArea.setText("Uneti ID je validan.");
						btnSauvaj.setEnabled(true);
						btnNewButton.setEnabled(false);
						textField.setEnabled(false);
							
					}
					
					if(bul == false) {
						textArea.setText("Uneli ste neposotjeci ID, \n ili ga niste ni uneli.");
						textField.setText("");
						bp.alid.clear();
						bp.alp.clear();
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
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaNazad));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(25, 11, 65, 62);
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
		btnNewButton_1_1_1_1.setBounds(100, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		
		
		
		setVisible(true);
		
		
	}
	
}