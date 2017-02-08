package com.bit2017.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			System.out.println("연결 성공");
			
			//conn.close(); --여기다 쓰면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
		} catch(SQLException e){
			System.out.println("error : " + e);
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
}
