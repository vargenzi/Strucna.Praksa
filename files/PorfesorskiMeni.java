package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class PorfesorskiMeni extends JFrame{
	
	private String opcije [] = {
			
			"-", "Upisi ocenu", "Sve ocene jednog ucenika", "Ocene svih ucenika"
	}; 
	

	PorfesorskiMeni(){
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 48));
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
		setSize(800, 600);
		setTitle("Profesorski - Meni");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROFESORSKI MENI");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(156, 11, 628, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IZBOR:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(90, 207, 215, 59);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(opcije);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(315, 219, 191, 38);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = comboBox.getSelectedItem().toString();
				if(cb.equals("-")) {
					System.out.println("Neuspesno");
					String message = "Pogresan unos, pokusajte ponovo.";
					JFrame jf = new JFrame();
					jf.setSize(300, 300);
					
					
					JOptionPane.showMessageDialog(jf, message, "Greska",
					        JOptionPane.ERROR_MESSAGE);
				}
				
				if(cb.equals("-") == false) {
					if(cb.equals("Upisi ocenu")) {
						Ocenjivanje o = new Ocenjivanje();
						o.setSize(800, 600);
						o.setVisible(true);
						dispose();

						
						
					}
					if(cb.equals("Sve ocene jednog ucenika")) {
						
						OceneJednogucenikaIzPredmeta oju = new OceneJednogucenikaIzPredmeta();
						oju.setSize(800, 600);
						oju.setVisible(true);

						dispose();
						
					}
					
					if(cb.equals("Ocene svih ucenika")) {
						new OceneSvihUcenika();
						dispose();

						
					}
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(56, 372, 191, 59);
		getContentPane().add(btnNewButton);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnIzlaz.setBounds(56, 459, 191, 59);
		getContentPane().add(btnIzlaz);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfesorskiLogin pl = new ProfesorskiLogin();
				pl.setSize(800, 600);
				pl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.setBounds(10, 8, 65, 62);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				glavni  g = new glavni();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\home.png"));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(85, 8, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
