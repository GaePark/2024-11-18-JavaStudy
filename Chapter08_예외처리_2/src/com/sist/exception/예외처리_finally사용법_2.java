package com.sist.exception;
import java.sql.*;
import java.io.*;
public class 예외처리_finally사용법_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 반복이 있는 경우 => 메소드
		 * 1. 오라클 연결이 가능하게 드라이브 설정
		 *     Class.forName("드라이버")
		 *     => classNotFoundException : CheckException
		 * 2. 오라클 연동
		 *     Connection : SQLException : CheckException
		 * 3. 오라클로 명령어를 전송
		 *                ------ SQL
		 *     PreparedStatment: SQLException
		 * 4. 결과값을 받는다
		 *     ResultSet => 결과를 메모리 저장
		 * 5. ResultSet 닫기
		 *     PreparedStatment 닫기
		 *     Connection 닫기
		 */
		Connection conn = null;//모든 데이터베이스 연결이 가능 인터페이스여서
		// 인터페이스는 관련된 모든 클래스를 모아서 한개로 제어
		PreparedStatement ps = null;
		// 오라클 송수신 담당'
		ResultSet rs = null;
		//결과값을 저장
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "happy");
			String sql = "SELECT empno,ename,job FROM emp";
			ps = conn.prepareStatement(sql);
			// 실행후에 결과값을 가지고 온다 (메모리에 저장)
			rs = ps.executeQuery();
			
			while(rs.next()) { //rs.previous() => 아래에서 위로
				System.out.println(
						rs.getInt(1) + " "
						+rs.getString(2) + " "
						+rs.getString(3)
						);
			}
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			
		} catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps !=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			
		}
	}

}
