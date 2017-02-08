package com.bit2017.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("최소봉급>");
		int minSalary = scanner.nextInt();
		System.out.print("최대봉급>");
		int maxSalary = scanner.nextInt();
		
		System.out.println("===========================================");
		searchEmployeesBySalary(minSalary, maxSalary);
		
		scanner.close();
	}

	private static void searchEmployeesBySalary(int minSalary, int maxSalary) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.JDBC Driver Loading (JDBC Class Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기 (connect to DB)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3.SQL문 준비
			String sql="select first_name||' ' ||last_name, salary from employees where ? < salary and  ? > salary";
			pstmt = conn.prepareStatement(sql);
			
			//4.데이타 바인딩
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			//5.SQL문 실행
			rs = pstmt.executeQuery();
			
			//6.결과 출력
			while(rs.next()){
				String name = rs.getString(1);
				int salary = rs.getInt(2);
				
				System.out.println(name+":"+salary);
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
