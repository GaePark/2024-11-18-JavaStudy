package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dept extends DataBase{
	//driverConfig(),getConnection() => 사용이 가능하면 그냥사용
	//listPrint(), findPrint() => 반드시 구현해야함
	public void listPrint() {
		driverConfig();
		Connection conn = getConnection();
		try {
			//오라클 전송
			String sql="SELECT * FROM dept";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(
						
						rs.getInt(1) + " "
								+rs.getString(2) + " "
								+rs.getString(3)
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void findPrint() {
		
	}
}
