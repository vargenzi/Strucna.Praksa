package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UcenikMeni extends JFrame{
private String opcije [] = {
			
			"-", "Ocene iz svih predmeta", "Ocene iz jednog predmeta"
	}; 
	
	public static void main(String[] args) {
		
	}

	UcenikMeni(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setTitle("Ucenik - Meni");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblUcenickiMeni = new JLabel("UCENICKI MENI");
		lblUcenickiMeni.setHorizontalAlignment(SwingConstants.CENTER);
		lblUcenickiMeni.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblUcenickiMeni.setBounds(10, 11, 774, 59);
		getContentPane().add(lblUcenickiMeni);
		
		JLabel lblNewLabel_1 = new JLabel("IZBOR:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(23, 182, 227, 72);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(opcije);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setFocusable(false);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(214, 195, 260, 48);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = comboBox.getSelectedItem().toString();
				if(cb.equals("-")) {
					Greska();
					
				}
				if(cb.equals("-") == false) {
					if(cb.equals("Ocene iz svih predmeta")) {
						new OceneSvih();
						
					}
					if(cb.equals("Ocene iz jednog predmeta")) {
						new OceneIzJednog();
						
					}
					

					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(42, 389, 191, 59);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setBounds(42, 467, 191, 59);
		getContentPane().add(btnIzlaz);
		setVisible(true);
		
	}
	
	public void Greska() {
		System.out.println("Neuspesno");
		String message = "Pogresan unos, pokusajte ponovo.";
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		
		
		JOptionPane.showMessageDialog(jf, message, "Greska",
		        JOptionPane.ERROR_MESSAGE);
	}
}
