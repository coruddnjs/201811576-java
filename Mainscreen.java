package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainscreen {
	public static void main(String[] args) {
		Screen sc = new Screen();
	}
}
class Screen extends JFrame{
	Container c = getContentPane();
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	ImageIcon img = new ImageIcon(new ImageIcon("C:\\jsp-work\\test\\src\\image\\Porsche.jpg")
			.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	ImageIcon img1 = new ImageIcon(new ImageIcon("C:\\jsp-work\\test\\src\\image\\benz.jpg")
			.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	
	JButton b1 = new JButton("포르쉐",img);
	JButton b2 = new JButton("벤츠",img1);
	
	
	public Screen() {
		setTitle("welcome"); 
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new BorderLayout());
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		
		p1.setSize(150,150);
		p2.setSize(150,150);
		
		b1.addActionListener(new Button());
		b1.setLocation(0, 10);
		b1.setSize(150,150);
		
		b2.setLocation(170,10);
		b2.setSize(150,150);
		
		p1.add(b1);
		p2.add(b2);
		c.add(p1);
		c.add(p2);
		
		setVisible(true);
		
	}
	class Button implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String car1 = e.getActionCommand();
			if(car1.equals("포르쉐")) {
				Signup s = new Signup();
			}
		}
	}
}