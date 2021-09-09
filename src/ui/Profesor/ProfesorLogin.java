package ui.Profesor;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import core.ProfesorFunkcionalnosti.Login;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import ui.PutanjeSlikaIFajlova;
import ui.Glavni.*;
import core.Baza;

public class ProfesorLogin extends JFrame{

	private JTextField textField;
	private JPasswordField passwordField;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private Baza baza = new Baza();
	
	public ProfesorLogin(){
		
		try {
			baza.LogoutProfesor();
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		
		setTitle("Profesorksi - Login");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setBounds(85, 11, 632, 62);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-MAIL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_1.setBackground(SystemColor.windowBorder);
		lblNewLabel_1.setBounds(69, 136, 198, 72);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_1_1.setBounds(69, 289, 198, 72);
		getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(342, 158, 216, 50);
		getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(342, 297, 216, 50);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char pass[] =  passwordField.getPassword();
				String sifra = new String(pass);
				String email = textField.getText();
				Login login = new Login();
				boolean provera1 = email.equals("") || sifra.equals("");
				
				if(provera1) {
					login.Greska();
				}
				if(provera1 == false) {
					try {
						boolean provera = login.Provera(email, sifra);
						if(provera) {
							login.UpisULogove(email, sifra);
							
							ProfesorMeni pm = new ProfesorMeni();
							pm.setSize(800, 600);
							pm.setVisible(true);
							
							dispose();
						}
						if(provera == false) {
							login.Greska();
							textField.setText("");
							passwordField.setText("");
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(507, 467, 228, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					baza.LogoutProfesor();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}  
				dispose();
				
			}
		});
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setForeground(SystemColor.desktop);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBounds(69, 467, 228, 50);
		getContentPane().add(btnIzlaz);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavniProzor g = new GlavniProzor();
				g.setSize(800, 600);
				g.setVisible(true);
				try {
					baza.LogoutProfesor();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(ps.IkonaHome));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		setVisible(true);
	}
	
}

