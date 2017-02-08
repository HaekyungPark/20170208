package com.bit2017.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSearchEmpoyee {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//키워드 입력
		System.out.print("입력> ");
		String keyword = scanner.nextLine();
		
		//검색
		searchEmployees(keyword);
		
		scanner.close();
	}
	
	private static void searchEmployees(String keyword){
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
			String sql="select first_name|| ' ' ||last_name, email, phone_number, to_char(hire_date, 'yyyy-mm-dd') from employees where first_name like ? or last_name like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			//4.데이터 바인딩
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			
			//5.SQL문 실행
			rs = pstmt.executeQuery();
			
			//6.결과 출력
			while(rs.next()){
				String name = rs.getString(1);
				String email = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String hireDate = rs.getString(4);
				
				System.out.println(name+":"+email+":"+phoneNumber+":"+hireDate);
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
