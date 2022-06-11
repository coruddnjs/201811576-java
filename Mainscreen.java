package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mainscreen extends JFrame{
	Container c = getContentPane();
	int size=90;
	
	JButton b1 = new JButton("차량 예약");
	JButton b2 = new JButton("예약 확인");
	JButton b4 = new JButton("예약 변경");
	JButton b5 = new JButton("회원 탈퇴");
	
	
	
	public Mainscreen() {
		setTitle("MAIN"); 
		setSize(300,300);
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
		
		
		b4.setLocation(100,90);
		b4.setSize(size,20);
		b4.setHorizontalAlignment(JButton.LEFT);
		c.add(b4);
		
		b5.setLocation(100,130);
		b5.setSize(size,20);
		b5.setHorizontalAlignment(JButton.LEFT);
		c.add(b5);
		
		b1.addActionListener(new Button1());
		b2.addActionListener(new Button2());
		b4.addActionListener(new Button4());
		b5.addActionListener(new Button5());
		setVisible(true);
		
	}
	class Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("차량 예약")) {
				Reservation R = new Reservation();
			}
		}
	}
	class Button2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("예약 확인")) {
				check c = new check();
			}
		}
	}
	class Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("예약 변경")) {
				update u = new update();
			}
		}
	}
	class Button5 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String del = e.getActionCommand();
			if(del.equals("회원 탈퇴")) {
				Delete D = new Delete();
				
			}
		}
	}
}