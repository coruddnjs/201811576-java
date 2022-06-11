package test;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class car_ex extends JFrame{
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	JLabel c_n = new JLabel("차 : ");
	JLabel car_name = new JLabel();
	
	JLabel c_f = new JLabel("연료 : ");
	JLabel fuel = new JLabel();
	
	JLabel t_n = new JLabel("종류 : ");
	JLabel type = new JLabel();
	
	JLabel g_n = new JLabel("변속 : ");
	JLabel gear = new JLabel();
	
	JLabel dp_n = new JLabel("비용(km당): ");
	JLabel drive_price = new JLabel();
	
	JLabel op_n = new JLabel("편의기능: ");
	JLabel options = new JLabel();
	
	JLabel s_time = new JLabel("시작 시간: ex)19:00");
	JTextField start = new JTextField(10);
	JLabel e_time = new JLabel("끝 시간: ex)20:00");
	JTextField end = new JTextField(10);
	
	JButton result = new JButton("시간 결정");
	JButton back = new JButton("뒤로가기");
	public car_ex(String name) {
		setSize(650,500);
		setTitle("차량 예약");
				
		c.setLayout(new BorderLayout());
		GridLayout G = new GridLayout(10,1);
		G.setVgap(5);
		G.setHgap(5);
		panel.setLayout(G);
		
		car_name.setText(name);
		
		database db;
		String[] query;
		
		c_n.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(c_n);
		panel.add(car_name);
		
		c_f.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(c_f);
		panel.add(fuel);
		
		t_n.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(t_n);
		panel.add(type);
		
		g_n.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(g_n);
		panel.add(gear);
		
		dp_n.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(dp_n);
		panel.add(drive_price);
		
		op_n.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(op_n);
		panel.add(options);
		
		s_time.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(s_time);
		panel.add(start);
		
		e_time.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(e_time);
		panel.add(end);
		
		panel.add(back);
		panel.add(result);
		
		back.addActionListener(new back());
		result.addActionListener(new select());
		c.add(panel,BorderLayout.CENTER);
		
		setVisible(true);
		try {
			db = new database();
			query = db.select_car(name);
			fuel.setText(query[1]);
			type.setText(query[2]);
			gear.setText(query[3]);
			drive_price.setText(query[4]);
			options.setText(query[5]+" , "+query[6]+" , "+query[7]+" , "+query[8]+" , "+query[9]);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	class select implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			database db;
			String starts = start.getText();
			String ends = end.getText();
			String times = "times";
			String[] result;
			JOptionPane err = new JOptionPane();
			String s = e.getActionCommand();
			if(s.equals("시간 결정")) {
				try {
					db = new database();
					result=db.select(times,4,member.ID);
					if(result[0]==null) {
						db.insertDB_time(member.ID, starts, ends, car_name.getText());
						err.showMessageDialog(null,"예약에 성공 했습니다.");
					}
					else if(result[0].equals(member.ID) && result[3].equals(car_name.getText())){
						System.out.println(result[0]+result[1]+result[2]+result[3]);
						err.showMessageDialog(null,"예약이 되어 있습니다.");
					}
					else {
						err.showMessageDialog(null,"예약이 되어 있습니다.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	class back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
