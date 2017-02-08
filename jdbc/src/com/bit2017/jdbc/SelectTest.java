package com.bit2017.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3.SQL문 실행
			stmt = conn.createStatement();
			String sql = "select employee_id, first_name, last_name, salary from employees";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Long employeeId = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);
				
				System.out.println(employeeId + ": "+ firstName + ": "+lastName + ": " +salary );
			}
			//conn.close();--여기다하면 안됨
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - "+ e );
		} catch(SQLException e){
			System.out.println("error : " + e);
		}finally{ 
			//3.자원정리
			try{
				if(rs!=null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
				conn.close();
			}catch(SQLException e){
				System.out.println("error: " + e );
			}
		}
	}
}
