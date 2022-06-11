package test;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class check extends JFrame{
	database db;
	Container c = getContentPane();
	private JPanel  a = new JPanel(new FlowLayout());
	private JTable table;
	private JScrollPane scroll;
	private String[] columnType = {"ID","시작 시간","반납 시간","차종류"};
	private DefaultTableModel model;
	private String[][] result;
	JButton can = new JButton("예약 취소");
	JButton bak = new JButton("뒤로가기");
	JOptionPane err = new JOptionPane();
	
	public check() {
		try {
			db = new database();
			result = db.insert_table("times",4,member.ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("예약 확인");
		setSize(600,500);
		c.setLayout(new BorderLayout());
		
		model = new DefaultTableModel(columnType,0);
		for(int i =0;i<result.length;i++) {
			model.addRow(new Object[] {result[i][0],result[i][1],result[i][2],result[i][3]});
		}
		a.setLayout(new FlowLayout());
		a.setBounds(0, 0, 300, 100);
		
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		a.add(scroll);
		a.add(can);
		a.add(bak);
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setFillsViewportHeight(true);
		
		table.setAutoCreateRowSorter(true);
		
		can.addActionListener(new cancel());
		bak.addActionListener(new Backs());
		
		c.add(a,BorderLayout.EAST);
		
		setVisible(true);
	}
	class Backs implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	class cancel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String c = e.getActionCommand();
			if(c.equals("예약 취소")) {
				try {
					db = new database();
					if(result[0][0].equals(member.ID)) {
						db.DeleteDB(member.ID,"times");
						dispose();
						check c1 = new check();
					}
					else {
						err.showMessageDialog(null,"예약한 차량이 없습니다.");
						dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
