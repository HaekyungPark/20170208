package com.bit2017.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		updateBook(1L, "토지1", true);
		updateBook(2L, "토지2", false);

	}
	public static void updateBook(Long no, String title, boolean rent){
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3.SQL문 실행
			//stmt = conn.createStatement();
			String sql = "update book set title = ?, state = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			//4. 데이터 바인딩
			pstmt.setString(1, title);
			if(rent){
				pstmt.setString(2, "대여중");
			}else{
				pstmt.setString(2, "대여가능");
			}
			pstmt.setLong(3, no);
			
			//5.SQL문 실행
			int count = pstmt.executeUpdate();
			if(count==1){
				System.out.println("Update 성공");
			}
			//conn.close();--여기다 쓰면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
		} catch(SQLException e){
			System.out.println("error : " + e);
		}finally{ 
			//3.자원정리
			try{
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error: " + e );
			}
		}
	}
}

