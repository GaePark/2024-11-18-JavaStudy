package com.sist.dao;
import java.sql.*;
public abstract class DataBase {
	// 기능 설정
	// => 같은 기능 => 구현
	public void driverConfig()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			conn = DriverManager.getConnection(url, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	// => 기능은 같다 => 구현해야하는 내용 틀림 => 미구현
	public abstract void listPrint();
	public abstract void findPrint();
}
