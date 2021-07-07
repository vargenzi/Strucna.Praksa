package ui.Admin;



import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.AdminFunkcionalnost.BrisanjeUc;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class BrisanjeUcenika extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;	
	private PutanjeSlikaIFajlova ps = new PutanjeSlikaIFajlova();
	private BrisanjeUc bu = new BrisanjeUc();



	
	public static void main(String[] args) {
		BrisanjeUcenika bu = new BrisanjeUcenika();
		bu.setSize(800, 600);
		bu.setVisible(true);
		
		
	}
	
	BrisanjeUcenika(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ps.IkonaProzor));
		setTitle("Brisanje - Ucenika");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BRISANJE U\u010CENIKA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 11, 445, 82);
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
		
		JButton btnNewButton = new JButton("POTVRDI\r\n");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(496, 188, 207, 150);
		getContentPane().add(textArea);
		
		JButton btnSauvaj = new JButton("SA\u010CUVAJ");
		btnSauvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					bu.PretragaListeUcenika(textField.getText());
					bu.PretragaListeId(textField.getText());
					bu.BrisanjeOcene(textField.getText());
					bu.UpisUucenika();
					bu.UpisUOcene();
					bu.UpisUId();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				bu.Uspeh();
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
					bu.PunjenjeListeUcenika();
					bu.PunjenjeListeID();
					bu.PunjenjeListeOcena();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
					boolean bul = bu.Provera(id);
					if(bul == true) {
						textArea.setText("Uneti ID je validan.");
						btnSauvaj.setEnabled(true);
						btnNewButton.setEnabled(false);
						textField.setEnabled(false);	
					}
					
					if(bul == false) {
						textArea.setText("Uneli ste neposotjeci ID, \n ili ga niste ni uneli.");
						textField.setText("");
						bu.PraznjenjeListe1();
						bu.PraznjenjeListe2();
						bu.PraznjenjeListe3();
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