package ui.Admin;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.AdminFunkcionalnost.Login;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import ui.Glavni.*;
import ui.PutanjeSlikaIFajlova;

public class AdminLogin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textField;
	private Login al = new Login();
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();

	
	public static void main(String[] args) {
		
		
	}

	public AdminLogin(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Admin Login");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 11, 462, 55);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(111, 152, 202, 55);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(111, 281, 202, 55);
		getContentPane().add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setBounds(444, 281, 238, 55);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(444, 157, 238, 55);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(SystemColor.text);
		
		
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String input = textField.getText();
					char[] pass = passwordField.getPassword();
					String sifra = new String(pass);
					
					boolean provera = false;
					try {
						provera = al.ProveraAdmina(input, sifra);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							

					if ((provera) == false) {
						al.Greska();
						textField.setText("");
						passwordField.setText("");
						
												
					}
					if(provera) {
						AdminMeni am = new AdminMeni();
						am.setSize(800, 600);
						am.setVisible(true);
						dispose();
					}
					
				}
			});
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(492, 443, 190, 68);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ\r\n");
		btnIzlaz.setBackground(SystemColor.text);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setForeground(SystemColor.desktop);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBounds(111, 443, 190, 68);
		getContentPane().add(btnIzlaz);
		
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