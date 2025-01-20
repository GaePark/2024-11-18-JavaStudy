package com.sist.test;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class CardDAO {
//연결 => 오라클
	private Connection conn;
	private PreparedStatement ps;
	private static CardDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//드라이버 등록
	public CardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static CardDAO newInstance() {
		if(dao ==null)
			dao= new CardDAO();
		return dao;
	}
	
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(URL, "hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection()
	{
		try {
			if(conn!=null) conn.close();
			if(ps!=null) ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//일과처리 방법
	public void cardInsert(String id,int price)
	{
		try {
			getConnection();
			conn.setAutoCommit(false);
			String sql="INSERT INTO myCard "
					+ "VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, price);
			ps.executeUpdate();
			
			sql="INSERT INTO myPoint "
					+ "VALUES(1,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2,price);
			ps.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch(Exception ex) {}
		}finally
		{
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			disConnection();
		}
	}	
public static void main(String[] args) {
	CardDAO dao=CardDAO.newInstance();
	dao.cardInsert("park",3000);
}
}
