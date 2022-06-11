package test;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class database {
	Connection conn;
	Statement st;
	// 처음 데이터 베이스 연결을 위한 메서드
	public database() throws SQLException {
		
	      String user = "root";
	      String password = "1234";
	      String url = "jdbc:mysql://localhost:3306/cardb";
	      conn = DriverManager.getConnection(url, user, password);
	      st = conn.createStatement();
	      System.out.println(conn.toString());
	      
	}
	//로그인 했을때 아이디 체크 메소드
	public int login_check(String table,String id, String pw) throws SQLException{
		
		String sql = "select * from "+ table +" where ID = ? and PW = ?";
		PreparedStatement sm = conn.prepareStatement(sql);
		sm.setString(1, id);
		sm.setString(2, pw);
		ResultSet rs = sm.executeQuery();
		
		if(rs.next()) {
			if(id.equals(rs.getString(3)) && pw.equals(rs.getString(4))) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if(rs != null)
	          rs.close();
	    if(sm != null)
	         sm.close();
	    if(conn != null)
	         conn.close();
		return 0;
		
	}
	//특정 정보를 검색하는 메소드
	public String[] select(String table, int num, String ID) throws SQLException{
		String[] query = new String[num];

		String sql = "select * from "+ table +" where ID = ?";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1, ID);
		ResultSet rs = sm.executeQuery();
		
		while(rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				query[i-1]=rs.getString(i);
			}
		}
	    return query;
	}
	public void insertDB(String table, String name, int RRN,String ID,String PW, 
								String phonenum, String license) throws SQLException
	{
		String sql = "insert into "+table+" values(?,?,?,?,?,?)";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1,name);
		sm.setInt(2, RRN);
		sm.setString(3, ID);
		sm.setString(4, PW);
		sm.setString(5, phonenum);
		sm.setString(6, license);
		
		int rs = sm.executeUpdate();
	}
	public void DeleteDB(String ID,String table) throws SQLException{
		
		String sql = "delete from "+table+" where ID=? ";
		PreparedStatement sm = conn.prepareStatement(sql);
		sm.setString(1, ID);
		
		int rs = sm.executeUpdate();
		
		if(rs>0) {
			System.out.println("삭제되었습니다.");
		}
		else {
			System.out.println("값이 없습니다.");
		}
	}
	public String[] select_car(String name) throws SQLException{
		String[] query = new String[10];

		String sql = "select * from cars as c,opt as o where c.options=o.options and car_name like ?";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1,"%"+name+"%");
		ResultSet rs = sm.executeQuery();
		
		if(rs.next()) {
			query[0] = rs.getString(1);
			query[1] = rs.getString(2);
			query[2] = rs.getString(3);
			query[3] = rs.getString(4);
			query[4] = Integer.toString(rs.getInt(5));
			query[5] = rs.getString(8);
			query[6] = rs.getString(9);
			query[7] = rs.getString(10);
			query[8] = rs.getString(11);
			query[9] = rs.getString(12);
		}
	    return query;
	}
	public void insertDB_time(String ID,String s_time, String e_time,String name) throws SQLException{
		
		String sql = "insert into times values(?,?,?,?)";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1,ID);
		sm.setString(2,s_time);
		sm.setString(3,e_time);
		sm.setString(4, name);
		
		int rs = sm.executeUpdate();
	}
	public String[][] insert_table(String table, int num, String ID) throws SQLException{
		ArrayList<String[]> a = new ArrayList<String[]>();
		String[] q = new String[num];
		String sql = "select * from "+ table +" where ID = ?";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1, ID);
		ResultSet rs = sm.executeQuery();
		
		while(rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				q[i-1]=rs.getString(i);
			}
			a.add(q.clone());
		}
	    return a.toArray(new String[a.size()][]);
	}
	public void update(String table,String ID,String st, String et) throws SQLException{
		String sql = "update "+ table +" set start_time=?, end_time=? where ID=?";
		PreparedStatement sm = conn.prepareStatement(sql);
		
		sm.setString(1,st);
		sm.setString(2, et);
		sm.setString(3, ID);
		
		int rs = sm.executeUpdate();	
	}
}