package com.napmkmk.member;

//DAO(Data Access Object) 는 데이터베이스의 data에 접근하기 위한 객체입니다. 
//DataBase에 접근 하기 위한 로직 & 비지니스 로직을 분리하기 위해 사용합니다
import java.sql.*;

public class MemberDao {

	static String driverName = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/serverdb"; 
	static String user = "root";
	static String pass = "12345";
	
	public int insertMember(MemberDto dto) {
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getUsername();
		String email = dto.getEmail();
		
		String sql = "INSERT INTO members(id, pw, username, email) VALUES('"+id+"','"+pw+"','"+name+"','"+email+"')";
	
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
	
	public int idCheck(String id) { //아이디의 기존중복가입여부 (같은 아이디가 이미 존재하는지여부)
		
		int idFlag = 0 ;
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT * FROM members WHERE id=? ";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs =pstmt.executeQuery(); 
			if(rs.next()) { // 참
				idFlag =1; //이미 가입하려는 아이디가 존재함
			}else {
				idFlag = 0 ;//가입하려는 아이디와 같은 아이디가 없으므로 가입가능
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return idFlag; //가입하려는아디기 존재하면 1이 반환, 아니면 0이 반환,
	
	}
	
	public int userCheck(String id, String pw) {
		int userFlag = 0;
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT pw FROM members WHERE id=? ";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs =pstmt.executeQuery(); //rs에는 0이나 1이 2가 있음 
			
			if(rs.next()) { // 참
				String dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) {
					userFlag =1; //아이디 비번이 모두 일치하므로 로그인성공
				} else {
					userFlag =2; //아이디는 존재하지만 비번이 틀림
				}
				
			}else {
				userFlag = 0 ;//아이디가 존재하지 않으므로 비회원
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return userFlag;// 1이 반환되면 로그인 성공, 0이 반환되면 회원아님(id가 존재하지 않음), 2가 반환되면 비밀번호만 틀린경우
		
	}
	public MemberDto getMemberInfo(String id) { //아이디로 테이블을 검색하여 해당 아이디의 모든정보반환
		MemberDto dto  = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT pw FROM members WHERE id=? ";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs =pstmt.executeQuery(); //rs에는 0이나 1이 2가 있음 
			
			
			
			if(rs.next()) { 

				
				dto = new MemberDto();
				String dbID = rs.getString("id");
				String dbPw = rs.getString("pw");
				String dbUsername = rs.getString("username");
				String dbEmail = rs.getString("email");
				String dbSignuptime = rs.getString("signuptime");
				
				dto.setId(dbID);
				dto.setPw(dbPw);
				dto.setUsername(dbUsername);
				dto.setEmail(dbEmail);
				dto.setEmail(dbSignuptime);
				
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}
	public int modyfyMemberInfo(MemberDto dto) { //modify.jpg에서 보내준 수정된 회원 정보를 DB에 다시 넣기(update)
		int updateFlag = 0 ;
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		String sql ="UPDATE members SET pw=?, username=?, email=? WHERE id=?";

		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getId());
			
			pstmt.executeUpdate(sql);
			 
		} catch (Exception e) { //모든에러 잡을수 있는 Exception 으로 변경
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (pstmt != null) {
					pstmt.close();
					
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return updateFlag;// 1이 반환되면 정보수정 성공, 아니면 정보수정 실패
	}
}
