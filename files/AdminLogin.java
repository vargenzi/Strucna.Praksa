package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame{
	private JPasswordField passwordField;
	private JTextField textField;

	
	public static void main(String[] args) {
		AdminLogin al = new AdminLogin();
		al.setSize(800, 600);
		al.setVisible(true);
		
	}

	AdminLogin(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Admin Login");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 764, 55);
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
		btnNewButton.setBackground(Color.BLACK);
		
		
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String input = textField.getText();
					char[] pass = passwordField.getPassword();
					String sifra = new String(pass);
					String user = input;
					boolean provera = sifra.equals("Vargenzi10");
					boolean provera2 = user.equals("zoranrepic");			

					if ((provera && provera2) == false) {
						System.out.println("Neuspesno");
						String message = "Pogresan unos, pokusajte ponovo.";
						JFrame jf = new JFrame();
						jf.setSize(300, 300);
						
						
						JOptionPane.showMessageDialog(jf, message, "Greska",
						        JOptionPane.ERROR_MESSAGE);
												
					}
					if(sifra.equals("Vargenzi10") && user.equals("zoranrepic")) {
						AdminMeni am = new AdminMeni();
						am.setSize(800, 600);
						am.setVisible(true);
						dispose();
					}
					
				}
			});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(492, 443, 190, 68);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ\r\n");
		btnIzlaz.setBackground(Color.BLACK);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setForeground(Color.RED);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBounds(111, 443, 190, 68);
		getContentPane().add(btnIzlaz);
		
		
		setVisible(true);
		
		
		
	}
	
	
	

}
