package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMeni extends JFrame{

	

	
	public static void main(String[] args) {
		
		AdminMeni am = new AdminMeni();
		am.setSize(800, 600);
		am.setVisible(true);
		
		
	}

	AdminMeni(){
		getContentPane().setForeground(new Color(192, 192, 192));
		getContentPane().setBackground(SystemColor.menu);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		setResizable(false);
		setTitle("Admin - Meni");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(141, 212, 132, -92);
		getContentPane().add(desktopPane);
		
		
		
		
		JButton btnNewButton = new JButton("KREIRAJ U\u010CENIKA");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KreiranjeUcenika ku = new KreiranjeUcenika();
				ku.setSize(800, 600);
				ku.setVisible(true);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(182, 131, 202, 70);
		getContentPane().add(btnNewButton);
		
		JButton btnKreirajProfesora = new JButton("KREIRAJ PROFESORA");
		btnKreirajProfesora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KreiranjeProfesora kp = new KreiranjeProfesora();
				kp.setSize(800, 600);
				kp.setVisible(true);
			}
		});
		btnKreirajProfesora.setBackground(new Color(192, 192, 192));
		btnKreirajProfesora.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnKreirajProfesora.setBounds(394, 131, 202, 70);
		btnKreirajProfesora.setFocusable(false);
		btnKreirajProfesora.setBorderPainted(false);
		getContentPane().add(btnKreirajProfesora);
		
		JButton btnIzmeniPodatkeO = new JButton("PREPRAVI U\u010CENIKA\r\n");
		btnIzmeniPodatkeO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrepravkaUcenika pu = new PrepravkaUcenika();
				pu.setSize(800, 600);
				pu.setVisible(true);
			}
		});
		btnIzmeniPodatkeO.setBackground(new Color(192, 192, 192));
		btnIzmeniPodatkeO.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnIzmeniPodatkeO.setBounds(182, 236, 202, 70);
		btnIzmeniPodatkeO.setFocusable(false);
		btnIzmeniPodatkeO.setBorderPainted(false);
		getContentPane().add(btnIzmeniPodatkeO);
		
		JButton btnIzmeniPodatkeO_1 = new JButton("PREPRAVI PROFESORA");
		btnIzmeniPodatkeO_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrepravkaProfesora pp = new PrepravkaProfesora();
				pp.setSize(800, 600);
				pp.setVisible(true);
				
			}
		});
		btnIzmeniPodatkeO_1.setBackground(new Color(192, 192, 192));
		btnIzmeniPodatkeO_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIzmeniPodatkeO_1.setBounds(394, 236, 202, 70);
		btnIzmeniPodatkeO_1.setFocusable(false);
		btnIzmeniPodatkeO_1.setBorderPainted(false);
		getContentPane().add(btnIzmeniPodatkeO_1);
		
		JButton btnObriiUenika = new JButton("OBRI\u0160I  U\u010CENIKA\r\n");
		btnObriiUenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeUcenika bu = new BrisanjeUcenika();
				bu.setSize(800, 600);
				bu.setVisible(true);
			}
		});
		btnObriiUenika.setBackground(new Color(192, 192, 192));
		btnObriiUenika.setForeground(Color.BLACK);
		btnObriiUenika.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnObriiUenika.setBounds(182, 342, 202, 70);
		btnObriiUenika.setFocusable(false);
		btnObriiUenika.setBorderPainted(false);
		getContentPane().add(btnObriiUenika);
		
		JButton btnObriiProfesora = new JButton("OBRI\u0160I PROFESORA\r\n");
		btnObriiProfesora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeProfesora bp = new BrisanjeProfesora();
				bp.setSize(800, 600);
				bp.setVisible(true);
			}
		});
		btnObriiProfesora.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnObriiProfesora.setBackground(new Color(192, 192, 192));
		btnObriiProfesora.setBounds(394, 342, 202, 70);
		btnObriiProfesora.setFocusable(false);
		btnObriiProfesora.setBorderPainted(false);
		
		getContentPane().add(btnObriiProfesora);
		
		JLabel lblNewLabel = new JLabel("ADMIN MENI");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 774, 63);
		getContentPane().add(lblNewLabel);
		
		JButton btnIzlaz = new JButton("IZLAZ\r\n");
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setForeground(Color.BLACK);
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBackground(Color.LIGHT_GRAY);
		btnIzlaz.setBounds(34, 470, 157, 70);
		getContentPane().add(btnIzlaz);
		setVisible(true);
		
	}
}
