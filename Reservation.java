package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Reservation extends JFrame{
	
	 Container c = getContentPane();
	
	ImageIcon icon = new ImageIcon(new ImageIcon("C:\\jsp-work\\test\\src\\image\\benz.jpg")
            .getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    ImageIcon icon2 = new ImageIcon(new ImageIcon("C:\\jsp-work\\test\\src\\image\\mac.jpg")
            .getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    ImageIcon icon3 = new ImageIcon(new ImageIcon("C:\\jsp-work\\test\\src\\image\\Porsche.jpg")
    		.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    JLabel label1 = new JLabel(icon);
    JLabel label2 = new JLabel(icon2);
    JLabel label3 = new JLabel(icon3);
    JPanel panel = new JPanel(new FlowLayout());
    JButton bak = new JButton("뒤로가기");
    
	public Reservation() {
		setTitle("차량 예약");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 1000, 400);
		
		label1.setSize(300,300);
		label2.setSize(300,300);
		label3.setSize(300,300);
		
		label1.setIcon(icon);
		label2.setIcon(icon2);
		label3.setIcon(icon3);
		
		label1.setHorizontalAlignment(JLabel.LEFT);
		label2.setHorizontalAlignment(JLabel.LEFT);
		label3.setHorizontalAlignment(JLabel.LEFT);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		label1.addMouseListener(new mouse1());
		label2.addMouseListener(new mouse2());
		label3.addMouseListener(new mouse3());
		
		bak.addActionListener(new backs());
		
		c.add(panel,BorderLayout.WEST);
		c.add(bak,BorderLayout.EAST);
		
		setVisible(true);
		setSize(1000,400);
	}
	class backs implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String bak = e.getActionCommand();
			if(bak.equals("뒤로가기")) {
				dispose();
			}
		}
	}
	class mouse1 extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			car_ex c = new car_ex("벤츠 s클래스");
		}
	}
	class mouse2 extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			car_ex c = new car_ex("맥라렌 GT");
		}
	}
	class mouse3 extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			car_ex c = new car_ex("포르쉐 카이엔");
		}
	}
}
