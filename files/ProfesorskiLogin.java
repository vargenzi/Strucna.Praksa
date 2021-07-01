package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ProfesorskiLogin extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
		
	}
	
	ProfesorskiLogin(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		
		setTitle("Profesorksi - Login");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setBounds(10, 11, 764, 62);
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
				char sifar[] =  passwordField.getPassword();
				String sifra = new String(sifar);
				String email = textField.getText();
				
				if(email.equals("") || sifra.equals("")) {
					System.out.println("Neuspesno");
					String message = "Pogresan unos, pokusajte ponovo.";
					JFrame jf = new JFrame();
					jf.setSize(300, 300);
					
					
					JOptionPane.showMessageDialog(jf, message, "Greska",
					        JOptionPane.ERROR_MESSAGE);
				}
				if((email.equals("") || sifra.equals("")) == false) {
					try {
						boolean provera = Provera(email, sifra);
						if(provera) {
							UpisULogove(email, sifra);
							
							PorfesorskiMeni pm = new PorfesorskiMeni();
							pm.setSize(800, 600);
							pm.setVisible(true);
							
							dispose();
						}
						if(provera == false) {
							System.out.println("Neuspesno");
							String message = "Pogresan unos, pokusajte ponovo.";
							JFrame jf = new JFrame();
							jf.setSize(300, 300);
							
							
							JOptionPane.showMessageDialog(jf, message, "Greska",
							        JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(507, 467, 228, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setForeground(Color.RED);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBounds(69, 467, 228, 50);
		getContentPane().add(btnIzlaz);
		setVisible(true);
	}
	
	
	public boolean Provera(String email, String sifra)  throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_profesorima.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine())!=null) {
			
			substrings = linije.split("/", 100);
			if(substrings[7].equals(email) && substrings[8].equals(sifra)) {
				System.out.println("nesto");
				return true;
			}
			
		}
		
		
		
		br.close();
		return false;
	}
	
	public void UpisULogove(String email, String sifra) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\logovi.txt"));
		
		bw.write(email + "/" + sifra);
		
		bw.close();
	}
}

