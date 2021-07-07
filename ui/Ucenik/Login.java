package ui.Ucenik;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import core.UcenikFunkcionalnosti.UcenikLogin;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Login extends JFrame{
	private JPasswordField passwordField_1;
	private JTextField textField;
	private UcenikLogin login = new UcenikLogin();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();

	
	public Login(){
		setResizable(false);
		setSize(800, 600);
		setTitle("Ucenik - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 11, 659, 62);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-MAIL");
		lblNewLabel_1.setBackground(SystemColor.windowBorder);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(144, 135, 198, 72);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(144, 272, 198, 72);
		getContentPane().add(lblNewLabel_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setForeground(Color.BLACK);
		passwordField_1.setBounds(493, 272, 216, 50);
		getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				char pass[] = passwordField_1.getPassword();
				String sifra = new String(pass);
				
				if(login.Provera(email, sifra)) {
					login.Greska();
				}
				if(login.Provera(email, sifra) == false) {
					boolean provera = false;
					try {
						provera = login.ProveraPostojanja(email, sifra);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(provera) {
						try {
							login.UpisULogove(email, sifra);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						new UcenikMeni();
						dispose();
					}
					if(provera == false) {
						login.Greska();
						passwordField_1.setText("");
						textField.setText("");
					}
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		
		btnNewButton.setBounds(481, 461, 228, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setForeground(Color.BLACK);
	
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnIzlaz.setBounds(144, 461, 228, 50);
		getContentPane().add(btnIzlaz);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(493, 135, 216, 50);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		setVisible(true);
	}
}
