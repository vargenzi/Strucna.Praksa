package esdnevnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class glavni {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavni window = new glavni();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public glavni() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("ES DNEVNIK");
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.getContentPane().setFont(new Font("Yu Gothic", Font.BOLD, 14));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\REPIC\\Desktop\\esdnevnik.png"));
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton =new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\ucenik.png"));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UcenickiLogin uc_lo = new UcenickiLogin();
					uc_lo.setSize(800, 600);

					uc_lo.setVisible(true);
				}
				
			});
		btnNewButton.setBackground(Color.white);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		
		btnNewButton.setBounds(317, 196, 150, 153);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\profa.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfesorskiLogin pl = new ProfesorskiLogin();
				pl.setSize(800, 600);
				pl.setVisible(true);
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(Color.white);
		
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusPainted(false);
		
		btnNewButton_1.setBounds(101, 197, 150, 150);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\admin.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				AdminLogin ad_lg = new AdminLogin();
				ad_lg.setSize(800, 600);
				ad_lg.setVisible(true);
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.white);
		btnNewButton_2.setFocusTraversalKeysEnabled(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(550, 196, 150, 150);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("DOBRODO\u0160LI");
		lblNewLabel.setForeground(SystemColor.windowText);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 48));
		lblNewLabel.setSize(new Dimension(100, 100));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.activeCaptionText);
		lblNewLabel.setBounds(10, 29, 753, 75);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PROFESORSKI LOGIN");
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(111, 360, 136, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("U\u010CENI\u010CKI LOGIN");
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(335, 360, 136, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(550, 357, 136, 22);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(216, 455, 232, -10);
		frame.getContentPane().add(scrollPane);
	}
}
