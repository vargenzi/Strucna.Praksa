package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class BrisanjeOcene extends JFrame{
	private JTextField textField;
	private ArrayList<String[]> als = new ArrayList<String[]>();
	private String ocene[] = {"-", "1", "2", "3", "4", "5"};
	private JTextField textField_1;
	
	public static void main(String[] args) {
		
	}

	
	BrisanjeOcene(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\esdnevnik.png"));
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
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(38, 106, 182, 50);
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
					PunjenjeListe();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				provera = ProveraPosotjanjaId(id);
				if(provera == 100) {
					lblNewLabel_1_1_1.setText("Nepostojeci id.");
				}
				if(provera != 100) {
					
					lblNewLabel_1_1_1.setText("");
					try {
						UpisUFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					String message = "Uspesno obrisana ocena.";
					JFrame jf = new JFrame();
					jf.setSize(300, 300);
					JOptionPane.showMessageDialog(jf, message, "Uspeh", JOptionPane.PLAIN_MESSAGE);
					
					
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
				String jmbg = textField.getText();
				if(jmbg.equals("")) {
					lblNewLabel_2.setText("ID nije unet.");
				}
				if(jmbg.equals("") == false) {
					boolean proverap = false;
					try {
						proverap = ProveraPostojanja(jmbg);
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
							TrazenejOcena(jmbg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int i = 0;
						String tekst = "";
						while(i<als.size()) {
							tekst += "               Predmet: " + als.get(i)[2] + "\n               Ocena:" + als.get(i)[3] + "\n               Opis:" + als.get(i)[4] + "\n               ID:" + als.get(i)[5] + "\n ------------------------------------------------ \n";
							
						
						i++;
						}
						als.clear();
						
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
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\back (1).png"));
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(10, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				glavni g = new glavni();
				g.setSize(800, 600);
				g.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\home.png"));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1_1.setBounds(85, 11, 65, 62);
		getContentPane().add(btnNewButton_1_1_1_1);
		setVisible(true);
		
		
	}
	
	
	public boolean ProveraPostojanja(String jmbg) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ucenicima.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[2].equals(jmbg)) {
				return true;
			}
		}
		
		
		br.close();
		return false;
		
	}

	public void TrazenejOcena(String jmbg) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			if(substrings[1].equals(jmbg)) {
				als.add(substrings);
				System.out.print("\n" + substrings);
			}
		
		}
		
		
		
		br.close();
	}

	public int ProveraPosotjanjaId(String id) {
		
		int i = 0;
		while(i<als.size()) {
			
			if(als.get(i)[5].equals(id)) {
				als.remove(i);
				return i;
			}
			
			i++;
		}
		
	return 100;
	}
	


	public void UpisUFile() throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		int i = 0;
		while(i<als.size()) {
			
			bw.write(als.get(i)[0] + "/" + als.get(i)[1] + "/" +als.get(i)[2] + "/" +als.get(i)[3] + "/" +als.get(i)[4] + "/" +als.get(i)[5]);
			bw.newLine();
			
			
			i++;
		}
		
		als.clear();
		bw.close();
	}
	
	public void PunjenjeListe() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\podaci\\Podaci_o_ocenama.txt"));
		String linije;
		String substrings[];
		while((linije = br.readLine()) != null) {
			substrings = linije.split("/", 100);
			als.add(substrings);
		
		}
		
		
		
		br.close();
	}
}
