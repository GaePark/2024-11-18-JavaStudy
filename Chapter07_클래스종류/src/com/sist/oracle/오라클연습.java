package com.sist.oracle;
import java.sql.*;

public class 오라클연습 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn =
				DriverManager.getConnection(url,"hr","happy");
		
		String sql="SELECT * FROM emp";
		//오라클 => SQL문장 전송
		// SQL
		PreparedStatement ps = conn.prepareStatement(sql);
		//실행 결과
		ResultSet rs =ps.executeQuery();
		
		//rs안에 실행된 모든 데이터가 들어가 있따
		
		while(rs.next())//데이터가 시작 ~ 끝까지 읽어온다
		{
			System.out.println(
					rs.getInt(1)+" "
							+rs.getString(2)+" "
							+rs.getString(3)
					);
		}
	}	
}

