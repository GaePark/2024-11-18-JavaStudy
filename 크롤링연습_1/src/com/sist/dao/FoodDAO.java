package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FoodDAO {
	private PreparedStatement ps;
	private Connection conn;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static FoodDAO dao;
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static FoodDAO newInstance() {
		if(dao==null)
			dao= new FoodDAO();
		return dao;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
	/*
 	fno
	name 
	type 
	phone 
	address 
	score 
	theme 
	poster 
	images 
	time 
	parking
	content 
	hit
	price

 */
	public void foodInsert(FoodVO vo)
	{
		try {
			getConnection();
			String sql = "INSERT INTO food_menupan VALUES(fm_fno_seq.nextval,"
					+ "?,?,?,?,?,?,?,?,?,?,?,0,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getType());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getAddress());
			ps.setDouble(5, vo.getScore());
			ps.setString(6,vo.getTheme());
			ps.setString(7, vo.getPoster());
			ps.setString(8, vo.getImages());
			ps.setString(9, vo.getTime());
			ps.setString(10, vo.getParking());
			ps.setString(11, vo.getContent());
			ps.setString(12, vo.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
}
