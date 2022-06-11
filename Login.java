package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
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
	
	JButton LG = new JButton("로그인");
	JButton Sign = new JButton("가입하기");
	
	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();
	JPanel panel =new JPanel(new GridLayout(3,3,10,10));
	
	JTextField t1 = new JTextField(10);
	JPasswordField t2 = new JPasswordField(10);
	
	
	public start() {
		setTitle("Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new BorderLayout(5,5));
		
		Sign.addActionListener(new ButtonListener());
		LG.addActionListener(new ButtonListener1());
		
		p1.add(ID_t);p2.add(PW_t);p1.add(t1);p2.add(t2);
		t2.setEchoChar('*');
		panel.add(p1);
		panel.add(LG);
		panel.add(p2);
		panel.add(Sign);
		 
		c.add(panel);

		
		setSize(300,150);
		setVisible(true);
	}
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String log = e.getActionCommand();
			if(log.equals("가입하기")) {
				Signup s = new Signup();
			}
		}
	}
	class ButtonListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			database db;
			String si = e.getActionCommand();
			JOptionPane err = new JOptionPane();
			String id = t1.getText();
			String pw = t2.getText();
			String table ="member";
			String[] result; 
			try {
				db = new database();
				result = db.select(table,6,id);
				member.ID=result[2];
				member.name=result[0];
				member.PW = result[3];
				if(si.equals("로그인")) {
					if(t1.getText().equals("")) {
						err.showMessageDialog(null,"아이디를 입력해주세요");
					}
					else if(t2.getText().equals("")){
						err.showMessageDialog(null,"비밀번호를 입력해주세요");
					}
					else {
						int a=db.login_check(table,id, pw);
						if(a==1) {
							Mainscreen m = new Mainscreen();
							dispose();
						}
						else if(a==0) {
							err.showMessageDialog(null, "DB에 그 데이터가 없습니다.");;
						}
					}
			 }
			}catch (SQLException e2) {
				// TODO Auto-generated catch block
					e2.printStackTrace();
			}
		}
	}
}
