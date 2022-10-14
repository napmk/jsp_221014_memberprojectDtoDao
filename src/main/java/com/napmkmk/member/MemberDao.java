package com.napmkmk.member;

//DAO(Data Access Object) 는 데이터베이스의 data에 접근하기 위한 객체입니다. 
//DataBase에 접근 하기 위한 로직 & 비지니스 로직을 분리하기 위해 사용합니다
import java.sql.*;

public class MemberDao {

	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/serverdb"; 
	static String user = "root";
	static String pass = "12345";
	
	public int insertMember(String id,  String pw,String name, String email) {
		
		String sql="INSERT INTO members( id, pw,username, email) VALUE('"+id+"','"+pw+"','"+name+"','"+email+"')";
		
		Connection conn =null;
		Statement stmt = null;
		int dbFlag = 0;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			
			stmt = conn.createStatement();
			dbFlag = stmt.executeUpdate(sql); //성공하면 1 반환
		} catch (Exception e) { //모든에러 잡을수 있는 Exception 으로 변경
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (stmt != null) {
					stmt.close();
					
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dbFlag; // 보장이 안된값은 에러남.. try 문에 있어서 초기값 줌.
	
	}
	
}
