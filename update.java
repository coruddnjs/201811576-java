package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import test.Signup.Backs;

public class update extends JFrame{
	database db;
	Container c = getContentPane();
	
	private JTable table;
	private JScrollPane scroll;
	private String[] columnType = {"ID","시작 시간","반납 시간","차종류"};
	private DefaultTableModel model;
	private String[][] result;
	private JLabel IDs = new JLabel("아이디 : ");
	private JTextField ID_n = new JTextField(10);
	private JLabel st = new JLabel("시작 시간: ");
	private JTextField st_n = new JTextField(10);
	private JLabel et = new JLabel("반납 시간: ");
	private JTextField et_n = new JTextField(10);
	private JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JButton results = new JButton("예약 변경");
	private JButton bak = new JButton("뒤로가기");
	int num;
	
	public update() {
		setTitle("예약 변경");
		setSize(600,300);
		c.setLayout(new BorderLayout());
		GridLayout G = new GridLayout(6,1);
		G.setVgap(5);
		G.setHgap(5);
		p.setLayout(G);
		p1.setLayout(new FlowLayout());
		try {
			db = new database();
			result = db.insert_table("times",4,member.ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model = new DefaultTableModel(columnType,0);
		num =model.getRowCount();
		for(int i =0;i<result.length;i++) {
			model.addRow(new Object[] {result[i][0],result[i][1],result[i][2],result[i][3]});
		}
		table = new JTable(model);
		scroll = new JScrollPane(table);
		p1.add(scroll);
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		IDs.setHorizontalAlignment(JLabel.RIGHT);
		p.add(IDs);
		p.add(ID_n);
		
		st.setHorizontalAlignment(JLabel.RIGHT);
		p.add(st);
		p.add(st_n);
		
		et.setHorizontalAlignment(JLabel.RIGHT);
		p.add(et);
		p.add(et_n);
		p.add(bak);
		p.add(results);
		
		c.add(p,BorderLayout.WEST);
		c.add(p1,BorderLayout.CENTER);

		results.addActionListener(new Updat());
		bak.addActionListener(new Backs());
		setVisible(true);
	}
	class Backs implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	class Updat implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String c = e.getActionCommand();
			String ID = ID_n.getText();
			String s_time = st_n.getText();
			String e_time = et_n.getText();
			if(c.equals("예약 변경")) {
				try {
					db.update("times",ID , s_time, e_time);
					model.setValueAt(s_time,num, 1);
					model.setValueAt(e_time,num, 2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
