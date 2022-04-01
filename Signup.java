package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup extends JFrame{
	String license[] = {"1종","2종","대형"};
	String com[] = {"SKT","KT","LGU+"};
	int size=100;
	
	JComboBox<String> cb = new JComboBox<String> (license);
	JComboBox<String> co = new JComboBox<String> (com);
 	
	Container c = getContentPane();
	
	JLabel name = new JLabel("이름: ");
	JLabel ID_t = new JLabel("ID: ");
	JLabel PW_t = new JLabel("PW: ");
	JLabel Int = new JLabel("생년월일: ");
	JLabel Phone = new JLabel("휴대번호: ");
	JLabel cb_n = new JLabel("운전면허유무: ");
	JLabel das = new JLabel("-");
	JLabel das1 = new JLabel("-");
	
	JButton Back = new JButton("뒤로가기");
	JButton Sign = new JButton("가입하기");
	
	JTextField ID_d = new JTextField(10);
	JPasswordField PW_d = new JPasswordField(10);
	JTextField name_d = new JTextField(4);
	JTextField Int_d = new JTextField(6);
	JTextField P1 = new JTextField(3);
	JTextField P2 = new JTextField(4);
	JTextField P3 = new JTextField(4);
	
	public Signup() {
		c.setLayout(null);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name.setLocation(10,10);
		name.setSize(size,20);
		name.setHorizontalAlignment(JLabel.LEFT);
		
		name_d.setLocation(60,10);
		name_d.setSize(size,20);
		name_d.setHorizontalAlignment(JLabel.LEFT);
		
		ID_t.setLocation(10,50);
		ID_t.setSize(size,20);
		ID_t.setHorizontalAlignment(JLabel.LEFT);
		
		ID_d.setLocation(60,50);
		ID_d.setSize(size,20);
		ID_d.setHorizontalAlignment(JLabel.LEFT);
		
		PW_t.setLocation(10,90);
		PW_t.setSize(size,20);
		PW_t.setHorizontalAlignment(JLabel.LEFT);
		
		PW_d.setLocation(60,90);
		PW_d.setSize(size,20);
		PW_d.setHorizontalAlignment(JLabel.LEFT);
		PW_d.setEchoChar('*');
		
		Int.setLocation(0,130);
		Int.setSize(size,20);
		PW_t.setHorizontalAlignment(JLabel.LEFT);
		
		Int_d.setLocation(60,130);
		Int_d.setSize(size,20);
		PW_d.setHorizontalAlignment(JLabel.LEFT);
		
		Back.setLocation(10, 270);
		Back.setSize(size,20);
		Back.setHorizontalAlignment(JLabel.LEFT);
		
		Sign.setLocation(130,270 );
		Sign.setSize(size,20);
		Sign.setHorizontalAlignment(JLabel.LEFT);
		
		Phone.setLocation(0, 200);
		Phone.setSize(size,20);
		Phone.setHorizontalAlignment(JLabel.LEFT);
		
		P1.setLocation(130, 200);
		P2.setLocation(175, 200);
		P3.setLocation(240, 200);
		P1.setSize(30,20);
		P2.setSize(50,20);
		P3.setSize(50,20);
		P1.setHorizontalAlignment(JLabel.LEFT);
		P2.setHorizontalAlignment(JLabel.LEFT);
		P3.setHorizontalAlignment(JLabel.LEFT);
		das.setLocation(165, 200);
		das.setSize(50,20);
		das.setHorizontalAlignment(JLabel.LEFT);
		das1.setLocation(230, 200);
		das1.setSize(50,20);
		das1.setHorizontalAlignment(JLabel.LEFT);
		
		cb.setBounds(100,170,90,20);
		cb_n.setLocation(0, 170);
		cb_n.setSize(size,20);
		cb_n.setHorizontalAlignment(JLabel.LEFT);
		co.setBounds(60, 200, 60, 20);
		
		
		Back.addActionListener(new Backs());
		
		c.add(co);
		c.add(das);
		c.add(das1);
		c.add(cb_n);
		c.add(cb); 
		c.add(Phone);
		c.add(P1);
		c.add(P2);
		c.add(P3);
		c.add(name_d);
		c.add(name);
		c.add(ID_t);
		c.add(ID_d);
		c.add(PW_t);
		c.add(PW_d);
		c.add(PW_t);
		c.add(Int);
		c.add(Int_d);
		c.add(Back);
		c.add(Sign);
		
		setSize(330, 350);
		setVisible(true);
		
	}
		class Backs implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}
}
