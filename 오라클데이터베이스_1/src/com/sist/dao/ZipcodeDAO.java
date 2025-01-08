package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class ZipcodeDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	private static ZipcodeDAO dao;
	//드라이버 등록
	public ZipcodeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// dhfkzmf dusehd
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//오라클 닫기
	public void disConnection()
	{
		try {
			if(conn!=null) conn.close();
			if(ps !=null) ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//싱글턴
	public static ZipcodeDAO  newInstance() {
		if(dao==null)
			dao=new ZipcodeDAO();
		return dao;
	}
	//기능 우편번호 검색
	public List<ZipcodeVO> postFind(String dong)
	{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		try {
			getConnection();
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') FROM zipcode WHERE dong LIKE '%'||?||'%'";//오라클 SQL/JAVASQL
			ps = conn.prepareStatement(sql);
			//?에 값을 채워준다
			ps.setString(1, dong);
			//결과
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ZipcodeVO vo = new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return list;
	}
	public int postFindCount(String dong)
	{
		int count=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM zipcode WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return count;
	}
}
