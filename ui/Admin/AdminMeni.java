package ui.Admin;


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
import javax.swing.ImageIcon;
import ui.Glavni.*;
import ui.PutanjeSlikaIFajlova;

public class AdminMeni extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	
	public AdminMeni(){
		getContentPane().setForeground(new Color(192, 192, 192));
		getContentPane().setBackground(SystemColor.menu);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
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
				dispose();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(182, 101, 202, 70);
		getContentPane().add(btnNewButton);
		
		JButton btnKreirajProfesora = new JButton("KREIRAJ PROFESORA");
		btnKreirajProfesora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KreiranjeProfesora kp = new KreiranjeProfesora();
				kp.setSize(800, 600);
				kp.setVisible(true);
				dispose();

			}
		});
		btnKreirajProfesora.setBackground(new Color(192, 192, 192));
		btnKreirajProfesora.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnKreirajProfesora.setBounds(394, 101, 202, 70);
		btnKreirajProfesora.setFocusable(false);
		btnKreirajProfesora.setBorderPainted(false);
		getContentPane().add(btnKreirajProfesora);
		
		JButton btnIzmeniPodatkeO = new JButton("PREPRAVI U\u010CENIKA\r\n");
		btnIzmeniPodatkeO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrepravkaUcenika pu = new PrepravkaUcenika();
				pu.setSize(800, 600);
				pu.setVisible(true);
				dispose();

			}
		});
		btnIzmeniPodatkeO.setBackground(new Color(192, 192, 192));
		btnIzmeniPodatkeO.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnIzmeniPodatkeO.setBounds(182, 182, 202, 70);
		btnIzmeniPodatkeO.setFocusable(false);
		btnIzmeniPodatkeO.setBorderPainted(false);
		getContentPane().add(btnIzmeniPodatkeO);
		
		JButton btnIzmeniPodatkeO_1 = new JButton("PREPRAVI PROFESORA");
		btnIzmeniPodatkeO_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrepravkaProfesora pp = new PrepravkaProfesora();
				pp.setSize(800, 600);
				pp.setVisible(true);
				dispose();

			}
		});
		btnIzmeniPodatkeO_1.setBackground(new Color(192, 192, 192));
		btnIzmeniPodatkeO_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIzmeniPodatkeO_1.setBounds(394, 182, 202, 70);
		btnIzmeniPodatkeO_1.setFocusable(false);
		btnIzmeniPodatkeO_1.setBorderPainted(false);
		getContentPane().add(btnIzmeniPodatkeO_1);
		
		JButton btnObriiUenika = new JButton("OBRI\u0160I  U\u010CENIKA\r\n");
		btnObriiUenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeUcenika bu = new BrisanjeUcenika();
				bu.setSize(800, 600);
				bu.setVisible(true);
				dispose();

			}
		});
		btnObriiUenika.setBackground(new Color(192, 192, 192));
		btnObriiUenika.setForeground(Color.BLACK);
		btnObriiUenika.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnObriiUenika.setBounds(182, 263, 202, 70);
		btnObriiUenika.setFocusable(false);
		btnObriiUenika.setBorderPainted(false);
		getContentPane().add(btnObriiUenika);
		
		JButton btnObriiProfesora = new JButton("OBRI\u0160I PROFESORA\r\n");
		btnObriiProfesora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeProfesora bp = new BrisanjeProfesora();
				bp.setSize(800, 600);
				bp.setVisible(true);
				dispose();

			}
		});
		btnObriiProfesora.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnObriiProfesora.setBackground(new Color(192, 192, 192));
		btnObriiProfesora.setBounds(394, 263, 202, 70);
		btnObriiProfesora.setFocusable(false);
		btnObriiProfesora.setBorderPainted(false);
		
		getContentPane().add(btnObriiProfesora);
		
		JLabel lblNewLabel = new JLabel("ADMIN MENI");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(181, 11, 414, 63);
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
		
		JButton btnObriiOcenu = new JButton("OBRI\u0160I OCENU");
		btnObriiOcenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BrisanjeOcene();
				dispose();
			}
		});
		btnObriiOcenu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnObriiOcenu.setFocusable(false);
		btnObriiOcenu.setBorderPainted(false);
		btnObriiOcenu.setBackground(Color.LIGHT_GRAY);
		btnObriiOcenu.setBounds(290, 344, 202, 70);
		getContentPane().add(btnObriiOcenu);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin al = new AdminLogin();
				al.setSize(800, 600);
				al.setVisible(true);
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
		btnNewButton_1_1_1_1.setBounds(85, 12, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		setVisible(true);
		
	}
}
