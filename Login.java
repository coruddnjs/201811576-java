package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login {	
	public static void main(String[] args) {
		start st = new start();

	}
}


class start extends JFrame{
	Container c = getContentPane();
	JLabel ID_t = new JLabel("ID ");
	JLabel PW_t = new JLabel("PW ");
	
	private JButton LG = new JButton("로그인");
	private JButton Sign = new JButton("가입하기");
	
	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();
	JPanel panel =new JPanel(new GridLayout(3,3,10,10));
	
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	
	
	
	public start() {
		setTitle("Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new BorderLayout(5,5));
		Sign.addActionListener(new ButtonListener());
		p1.add(ID_t);p2.add(PW_t);p1.add(t1);p2.add(t2);
		panel.add(p1);
		panel.add(LG);
		panel.add(p2);
		panel.add(Sign);
		
		c.add(panel);

		//LG.addActionListener(new ButtonListener());
		
		setSize(300,150);
		setVisible(true);
	}
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Signup s = new Signup();
		}
	}
}

