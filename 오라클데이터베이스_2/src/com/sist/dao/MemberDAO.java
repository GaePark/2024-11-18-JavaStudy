package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.vo.*;
//로그인 처리 => COUNT
// 회원가입
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static MemberDAO dao;
	
	//드라이버 등록
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//싱글턴
	public static MemberDAO newInstance() {
			if(dao==null)
				dao = new MemberDAO();
			return dao;
	}
	//연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////////오라클 필수사항
	/////////////////////////////기능 처리
	// COUNT(*) => 로그인
	public MemberVO isLogin(String id, String pwd)
	{
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM member WHERE id=?";
			ps = conn.prepareStatement(sql);
			//?에 값 채운다
			ps.setString(1, id); // 'hong'
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int count = rs.getInt(1);
			rs.close();
			if(count ==0)
			{
				vo.setMsg("NOID");
			}
			else
			{
				sql="SELECT pwd, name , sex, address FROM member WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String sex = rs.getString(3);
				String address = rs.getString(4);
				rs.close();
				
				if(db_pwd.equals(pwd))
				{
					vo.setMsg("OK");
					vo.setName(name);
					vo.setSex(sex);
					vo.setAddress(address);
				}
				else
				{
					vo.setMsg("NOPWD");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		return vo;
	}
	
}

