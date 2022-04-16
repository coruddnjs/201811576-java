package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mainscreen extends JFrame{
	Container c = getContentPane();
	int size=90;
	
	JButton b1 = new JButton("차량 예약");
	JButton b2 = new JButton("예약 확인");
	JButton b3 = new JButton("예약 취소");
	JButton b4 = new JButton("차량 검색");
	
	
	
	public Mainscreen() {
		setTitle("welcome"); 
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		
		b1.setLocation(100,10);
		b1.setSize(size,20);
		b1.setHorizontalAlignment(JButton.LEFT);
		c.add(b1);
		
		b2.setLocation(100,50);
		b2.setSize(size,20);
		b2.setHorizontalAlignment(JButton.LEFT);
		c.add(b2);
		
		b3.setLocation(100,90);
		b3.setSize(size,20);
		b3.setHorizontalAlignment(JButton.LEFT);
		c.add(b3);
		
		b4.setLocation(100,130);
		b4.setSize(size,20);
		b4.setHorizontalAlignment(JButton.LEFT);
		c.add(b4);
		
		b1.addActionListener(new Button1());
		b2.addActionListener(new Button2());
		b3.addActionListener(new Button3());
		b4.addActionListener(new Button4());
		setVisible(true);
		
	}
	class Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("차량 예약")) {
				Signup a = new Signup();
			}
		}
	}
	class Button2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("예약 확인")) {
				Signup a = new Signup();
			}
		}
	}
	class Button3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("예약 취소")) {
				Signup a = new Signup();
			}
		}
	}
	class Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("차량 검색")) {
				Signup a = new Signup();
			}
		}
	}
}
