package com.bit2019.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2017.jdbc.vo.AuthorVo;

public class AuthorDao {
	
	public boolean delete(Long no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3.SQL문 준비
			String sql = "delete from AUTHOR where no=? ";
			pstmt = conn.prepareStatement(sql);
			
			//4.데이터 바인딩
			pstmt.setLong(1, no);
			
			//5.execute SQL
			int count =pstmt.executeUpdate();
			boolean result = (count==1);
			return result;
			
			//conn.close(); --여기다 쓰면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
			return false;
		} catch(SQLException e){
			System.out.println("error2-1 : " + e);
			return false;
		}finally{ 
			//3.자원정리
			try{
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error2-2: " + e );
			}
		}	
	}
	public boolean insert(AuthorVo authorVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3.SQL문 준비
			String sql = "insert into AUTHOR VALUES (author_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.데이터 바인딩
			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getDescription());
			
			//5.execute SQL
			int count =pstmt.executeUpdate();
			boolean result = (count==1);
			return result;
			
			//conn.close(); --여기다 쓰면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
			return false;
		} catch(SQLException e){
			System.out.println("error 1: " + e);
			return false;
		}finally{ 
			//3.자원정리
			try{
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error: " + e );
			}
		}	
	}
	public List<AuthorVo> getList(){
		List<AuthorVo> list = new ArrayList<AuthorVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3.SQL문 준비
			stmt = conn.createStatement();
			String sql = "select no, name, description from author";
			
			rs = stmt.executeQuery(sql);
			
			//4.결과 처리
			while(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				
				AuthorVo authorVo = new AuthorVo();
				authorVo.setNo(no);
				authorVo.setName(name);
				authorVo.setDescription(description);
				
				list.add(authorVo);
			}
			//conn.close(); --여기다 쓰면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
		
		} catch(SQLException e){
			System.out.println("error : " + e);
		}finally{ 
			//3.자원정리
			try{
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error: " + e );
			}
		}	
		return list;
	}
}
