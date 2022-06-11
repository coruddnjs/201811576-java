package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import test.Signup.Backs;

import java.sql.*;

public class Delete extends JFrame{
	Container c = getContentPane();
	JPanel panel = new JPanel();
	
	JButton del = new JButton("삭제");
	JButton back = new JButton("뒤로가기"); 
	
	JLabel ID = new JLabel("ID : ");
	JLabel RRN = new JLabel("생년원일 : ");
	JLabel select = new JLabel("");
	JTextField ID_t = new JTextField(10);
	JTextField RRN_t = new JTextField(6);
	
	public Delete() {
		setTitle("회원 탈퇴");
		setSize(400,500);
		c.setLayout(new BorderLayout());
		panel.setLayout(new FlowLayout());
		panel.setBounds(0, 0, 300, 100);
		panel.add(ID);
		panel.add(ID_t);
		panel.add(RRN);
		panel.add(RRN_t);
		panel.add(del);
		panel.add(back);
		c.add(panel,BorderLayout.WEST);
		c.add(select,BorderLayout.WEST);
		back.addActionListener(new backs());
		del.addActionListener(new dels());
		
		setVisible(true);	
	}
	//뒤로가기 버튼 실행
	class backs implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String bak = e.getActionCommand();
			if(bak.equals("뒤로가기")) {
				dispose();
			}
		}
	}
	class dels implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			database db;
			String[] result;
			String IDs = ID_t.getText();
			String table = "member";
			int RRNs = Integer.parseInt(RRN_t.getText());
			JOptionPane err = new JOptionPane();
			String de = e.getActionCommand();
			if(de.equals("삭제")) {
				try {
					db = new database();
					result = db.select(table,6,IDs); 
					if(result[2].equals(IDs) && Integer.parseInt(result[1])==RRNs) {
							select.setText(result[0]+","+result[1]+","+result[2]+","+result[3]+","
									+result[4]+","+result[5]);
							db.DeleteDB(IDs,table);
							err.showMessageDialog(null,"삭제되었습니다.");
							dispose();
							Login l = new Login();
					}
					else {
						err.showMessageDialog(null,"없는 ID입니다.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
}
