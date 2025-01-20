package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import java.sql.*;
public class FreeBoardDAO {
	//오라클 연결 객체
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static FreeBoardDAO dao;
	
	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {}
	}
	
	public static FreeBoardDAO newInstance(){
		if(dao==null)
			dao=new FreeBoardDAO();
		return dao;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//1. 목록 (페이징 기법) => 인라인뷰 사용
	public List<FreeBoardVO> getFreeBoardList(int page) {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		int rowSize = 10;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		try {
			getConnection();
			String sql = "SELECT no,name,subject,regdate,hit, num "
					+ "FROM (SELECT no,name,subject,content,pwd,regdate,hit,rownum as num "
					+ "FROM (SELECT no,name,subject,content,pwd,regdate,hit FROM freeboard ORDER BY no DESC))"
					+ " WHERE num BETWEEN "
					+ start + " AND " + end;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				FreeBoardVO vo = new FreeBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return list;
	}
	//총 페이지 구하기
	public int boardTotalPage()
	{
		int total =0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM freeboard";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return total;
	}
	//2 .상세보기 => WHERE
	public FreeBoardVO getFreeBoardDetail(int no) {
		FreeBoardVO vo = new FreeBoardVO();

		try {
			getConnection();
			String sql="UPDATE freeboard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
		ps=conn.prepareStatement(sql);
		ps.executeUpdate();
					
			sql="SELECT no,name,subject,content,regdate,hit "
							+ "FROM freeboard "
							+ "WHERE no=" + no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		return vo;
	}
	//3. 글쓰기 => INSERT
	public void boardInsert(FreeBoardVO vo)
	{
		//리턴형 / 매개변수
		try {
			getConnection();
			String sql = "INSERT INTO freeboard(no,name,subject,content,pwd) "
					+ "VALUES(fb_no_seq.nextval,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
	//4. 수정 => UPDATE => 비밀번호 검사
	public FreeBoardVO boardupdatedata(int no)
	{
		FreeBoardVO vo = new FreeBoardVO();
		try {
			getConnection();
			String sql = "SELECT name,subject,content FROM freeboard WHERE no="+no;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(no);
			vo.setName(rs.getString(1));
			vo.setSubject(rs.getString(2));
			vo.setContent(rs.getString(3));
			rs.close();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return vo;
	}
	
	public boolean boardUpdate(FreeBoardVO vo)
	{
		try {
			getConnection();
			String sql = "SELECT pwd From freeboard WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String pwd = rs.getString(1);
			if(!pwd.equals(pwd))
			{
				return false;
			}
			sql="UPDATE freeboard SET subject=? , content=? WHERE no=" + vo.getNo();
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getSubject());
			ps.setString(2,vo.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return true;
	}
	
	//5.삭제 => DELETE => 비밀번호 검사
	public boolean boardDelete(int pwd,int no)
	{
		try {
			getConnection();
			String sql = "SELECT pwd From freeboard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bpwd = rs.getInt(1);
			if(bpwd!=pwd)
			{
				return false;
			}
			sql="DELETE FROM freeboard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		return true;
	}
	//6.찾기 => LIKE 문장 사용
	public List<FreeBoardVO> boardFindData(String col, String fd)
	{
		//이름 / 제목 / 내용
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		try {
			getConnection();
			String sql = "SELECT no,subject,name,regdate,hit "
					+ "FROM freeboard"
					+ "WHERE REGEXP_LIKE("+col+", ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				FreeBoardVO vo = new FreeBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		
		return list;
	}
	// 6-1
	public int boardFindCount(String col,String fd)
	{
		int count=0;
		try {
		getConnection();
		String sql = "SELECT COUNT(*) "
				+ "FROM freeboard "
				+ "WHERE REGEXP_LIKE("+col+", ?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, fd);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		count=rs.getInt(1);
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally
	{
		disConnection();
	}
		return count;
	}
	//----------------------------------CRUD
}

