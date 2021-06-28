package esdnevnik;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class pocetak_0 {
	
	
	public static void main (String []args) {
		
		System.out.println("Pocetak programa");
		
		JFrame prozor = new JFrame("ES-DNEVNIK");
		FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
		prozor.setSize(800, 600);
		prozor.setBackground(Color.lightGray);
		
		EmptyBorder eb = new EmptyBorder(20, 20, 20, 20);
		LineBorder lb = new LineBorder(Color.BLACK, 15);
		CompoundBorder cb = new CompoundBorder(lb, eb);
		
		
		
		
		JButton b=new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\ucenik.png"));    
		b.setBounds(100,100,150, 153);    
		b.setBackground(Color.WHITE);
		b.setBorder(cb);
		b.setFocusPainted(false);
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new login_ucenik();
				
			}
			
		});
		    
		
		
		
		JButton b2=new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\profa.png"));    
		b2.setBounds(325,100,150, 150);
		
		b2.setBackground(Color.WHITE);

		b2.setBorder(cb);
		b2.setFocusPainted(false);

		
		
		prozor.add(b2);
		prozor.add(b);
		
		
		
		JButton b3=new JButton(new ImageIcon("C:\\Users\\REPIC\\Desktop\\esdnevnik\\src\\esdnevnik\\admin.png"));    
		b3.setBounds(550,100,150, 150);

		
		b3.setBorder(cb);

		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.BLUE);
		b3.setFocusPainted(false);


		prozor.add(b3);

		
		
		JLabel b4=new JLabel("DOBRODOŠLI");    
		Font font = new Font("serif", Font.BOLD, 48);
		b4.setBounds(0,0,800, 100);
		b4.setFont(font);

		
		prozor.add(b4);
		
		
		
		prozor.setDefaultCloseOperation(prozor.EXIT_ON_CLOSE);
		prozor.setLayout(flowlayout);
		prozor.setVisible(true);
		
	}
}
