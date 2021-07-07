package ui.Admin;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.AdminFunkcionalnost.BrisanjeOc;
import ui.PutanjeSlikaIFajlova;
import ui.Glavni.GlavniProzor;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class BrisanjeOcene extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private PutanjeSlikaIFajlova bs = new PutanjeSlikaIFajlova();
	private BrisanjeOc bo = new BrisanjeOc();
	
	public static void main(String[] args) {
		
	}

	
	BrisanjeOcene(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(bs.IkonaProzor));
		setTitle("Brisanje - Ocene");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BRISANJE OCENE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 401, 84);
		getContentPane().add(lblNewLabel);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setFont(new Font("MS Gothic", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(312, 177, 410, 357);
		
		JLabel lblNewLabel_1 = new JLabel("ID UCENIKA:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 106, 182, 50);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(181, 114, 128, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(181, 330, 88, 36);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(192, 209, 165, 34);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID OCENE:");
		lblNewLabel_1_1.setEnabled(false);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(10, 323, 182, 50);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setEnabled(false);
		lblNewLabel_1_1_1.setBounds(141, 377, 128, 20);
		
		JButton btnNewButton = new JButton("POTVRDI");
		
		JButton btnSacuvaj = new JButton("SACUVAJ");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField_1.getText();
				int provera;
				try {
					bo.PunjenjeListe();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				provera = bo.ProveraPosotjanjaId(id);
				if(provera == 100) {
					lblNewLabel_1_1_1.setText("Nepostojeci id.");
				}
				if(provera != 100) {
					lblNewLabel_1_1_1.setText("");
					try {
						bo.UpisUFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					btnSacuvaj.setEnabled(false);
					lblNewLabel_1_1.setEnabled(false);
					textField_1.setText("");
					textField_1.setEditable(false);
					textField.setEnabled(true);
					textField.setText("");
					lblNewLabel_1.setEnabled(true);
					btnNewButton.setEnabled(true);
					lblNewLabel_1_1_1.setText("");
					lblNewLabel_1_1_1.setEnabled(false);
					textArea.setText("");
					lblNewLabel_2.setEnabled(true);
					bo.Uspeh();
				} 
				
			}
		});
		
		btnSacuvaj.setEnabled(false);
		btnSacuvaj.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSacuvaj.setFocusable(false);
		btnSacuvaj.setBorderPainted(false);
		btnSacuvaj.setBackground(Color.WHITE);
		btnSacuvaj.setBounds(38, 404, 121, 52);
		
		
		
		
		
		
		
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(id.equals("")) {
					lblNewLabel_2.setText("ID nije unet.");
				}
				if(id.equals("") == false) {
					boolean proverap = false;
					try {
						proverap = bo.ProveraPostojanja(id);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(proverap == false) {
						lblNewLabel_2.setText("Pogresan ID.");
					}
					if(proverap != false) {
						textField.setEnabled(false);
						btnNewButton.setEnabled(false);
						lblNewLabel_2.setText("");
						lblNewLabel_2.setEnabled(false);
						btnSacuvaj.setEnabled(true);
						lblNewLabel_1_1.setEnabled(true);
						textField_1.setEnabled(true);
						textArea.setEnabled(true);
						lblNewLabel_1_1_1.setEnabled(true);
						
						try {
							bo.TrazenejOcena(id);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						String tekst = bo.IspisOcena();
						bo.alo.clear();
						textArea.setText(tekst);
	
					}
				}
			}
		});
		
		
		
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(181, 167, 121, 43);
		getContentPane().add(btnNewButton);
		
		
		getContentPane().add(lblNewLabel_2);
		
		
		getContentPane().add(btnSacuvaj);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzlaz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnIzlaz.setFocusable(false);
		btnIzlaz.setBorderPainted(false);
		btnIzlaz.setBackground(Color.WHITE);
		btnIzlaz.setBounds(38, 467, 121, 52);
		getContentPane().add(btnIzlaz);
		
		
		getContentPane().add(textArea);
		
		
		getContentPane().add(lblNewLabel_1_1);
		
		
		getContentPane().add(textField_1);
		
		
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMeni am = new AdminMeni();
				am.setSize(800, 600);
				am.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(bs.IkonaNazad));
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
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(bs.IkonaHome));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		
		setVisible(true);
	}
	
}