package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class ReplyBoardDAO {
//연결 => 오라클
	private Connection conn;
	private PreparedStatement ps;
	private static ReplyBoardDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//드라이버 등록
	public ReplyBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static ReplyBoardDAO newInstance() {
		if(dao ==null)
			dao= new ReplyBoardDAO();
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
	////////////////////////////////자바에서 오라클 연동 기본 (공통)
	///////////////////////////////-------------------JDBC
	// JDBC(원시소스) => DBCP => ORM(MyBatis,Hibernate = )
	
	
	
	//기능
	//1. 목록 출력 => 인라인뷰 => 1페이지에 10개
	// => 최신순
	// => INDEX사용은 하지 않는다. => 추가,수정,삭제가 많은경우 속도가 느려진다
	public List<ReplyBoardVO> boardListData(int page)
	{
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		int rowSize = 10;
		int start = (rowSize*page)-(rowSize-1);
		int end = rowSize*page;
		try {
			getConnection();
			String sql = "SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,group_tab,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
					+ "FROM (SELECT no,subject,name,regdate,hit,group_tab "
					+ "FROM replyBoard ORDER BY group_id DESC,group_step ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ReplyBoardVO vo = new ReplyBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
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
	//1-1. 총페이지
	public int boardTotalPage()
	{
		int total=0;
				try {
					getConnection();
					String sql ="SELECT CEIL(COUNT(*)/10.0) FROM replyBoard";
					ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					rs.next();
					total=rs.getInt(1);
					rs.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					disConnection();
				}
				return total;
	}
	//2. 글쓰기 => INSERT
	// 매개변수가 3개이상 => 배ㅕㄹ / VO를 이용한다
	public void boardInsert(ReplyBoardVO vo )
		{
			try
			{
				getConnection();
				String sql = "INSERT INTO replyBoard(no,name,subject,content,pwd,group_id)"
						+ "VALUES(rb_no_seq.nextval,?,?,?,?,"
						+ "(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard))";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setString(4, vo.getPwd());
				ps.executeUpdate();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally
			{
				disConnection();
			}
		}
	//3. 상세보기 =>WHERE
	public ReplyBoardVO boardDetailData(int type, int no)
	{
		ReplyBoardVO vo = new ReplyBoardVO();
		
		try {
			String sql;
			getConnection();
			if(type==1)
			{
			//상세보기 : 반드시 사용자로부터 PRIMARY KEY
			sql = "UPDATE replyBoard SET "
					+ "hit=hit+1 WHERE no="+no;
			
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			}
			sql="SELECT no,name,subject,content,"
					+ "TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit "
					+ "FROM replyBoard "
					+ "WHERE no="+no;
			ps = conn.prepareStatement(sql);
			ResultSet rs  = ps.executeQuery();
			
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
			
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
	//4. 수정 => UPDATE
	public ReplyBoardVO boardUpdateData(int no)
	{
		ReplyBoardVO vo = new ReplyBoardVO();
		try {
			getConnection();
			String sql="SELECT no,name,subject,content "
					+ "FROM replyBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
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
	//4-1 실제 수정
	public boolean boardUpdate(ReplyBoardVO vo)
	{
		boolean bCheck=false;
		/*
		 * 메소드 : 사용자 요청 처리
		 * 1) 사용자 요청값을 받는다
		 * 2) 요청처리후에 결과값
		 * 	=> 경우의 수
		 * 		1. 목록 : List<~VO>
		 * 		2. 상세보기 : ~VO
		 * 		3. 비밀번호 맞다 / 아니다
		 * 						----------------boolean
		 * 		4. 경우의 수가 3개 이상
		 * 			String / int
		 * 			------- 알아볼 수 잇게 처리
		 * 			ㅣ 로그인 처리
		 * 				=> NOID / NOPWD / OK
		 */
		try {
			getConnection();
			String sql = "SELECT pwd FROM replyBoard WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs  = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) {
				bCheck=true;
				sql="UPDATE replyBoard SET "
						+ "name=?, subject=?,content=? "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1,vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3,vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
				
			}
			else {
				bCheck=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return bCheck;
	}
	//5. 답변 => 트랜잭션
	//6. 삭제 => 트랜잭션
	
}
