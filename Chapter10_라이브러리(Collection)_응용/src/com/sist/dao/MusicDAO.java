package com.sist.dao;
/*
 * Collection
 * ----------
 *     => 단순 목록 : ArrayList
 *                         => 수정 / 삭제 => 속도가 느림
 *                         => 가변형
 * 1. 목록 => 페이지 나누기 => ArrayList
 * 2. 상세보기 => MusicVO
 *                       => 버튼 클릭 => 동영상 실행
 * 3. 검색 => ArrayList
 * 4. 게시판 => LinkedList
 *                       => 수정 / 삭제 => 빠르다
 * 5. 구매 => Map
 *                 => 두개 저장
 * 6. 찜하기 => Set
 *                    => 한사람당 1개만
 * => 프로젝트 : 크롤링 => 오라클
 * -----------------------------------------------
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.MusicVO;
public class MusicDAO {
	// 연결 객체
	private Connection conn;
	// SQL 문장 전송 객체
	private PreparedStatement ps;
	// URL을 등록
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	//싱글턴
	private static MusicDAO dao;

	//1. 드라이버 등록
	public MusicDAO () {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//2. 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//3.  오라클 닫기
	public void disConnection() {
		try {
			if(ps != null)
				ps.close();
			if(conn !=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * DAO는 사용자당 한개씩만 사용이 가능하게 만든다
	 * => 싱글턴
	 */
	/*
	 * 디자인 패턴
	 *     => 싱글턴 => static
	 *     => 팩토리 패턴 => Map
	 *     => MV 패턴 => JSP(Java+HTML)
	 *                                     l          l
	 *                                 Model    View
	 *           ---------
	 *     => MVC 패턴
	 *           ---------
	 *     => Observer
	 *     => Prototype
	 */
	public static MusicDAO newInstance () {
		if(dao==null) 
			dao=new MusicDAO();
		return dao;
	}
	////////////////////////////////////데이터베이스 사용시 공통 기반
	//4. 뮤직 목록 출력
	public List<MusicVO> musicList() {
		List<MusicVO> list = new ArrayList<MusicVO>();
		try {
			getConnection();
			String sql = "SELECT DISTINCT * FROM GENIE_MUSIC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnection();
		}
		return list;
	}
	//5. 뮤직 상세보기
	//6. 뮤직 검색
	//DAO => 공용 (웹, 윈도우 , 애플리케이션)
	public List<MusicVO> musicFindData(String fd) {
		List<MusicVO> list = new ArrayList<MusicVO>();
		try {
			//1 오라클 연결
			getConnection();
			// 2. 오라클 연결 문장
			String sql = "SELECT DISTINCT mno,title,singer,album,poster FROM genie_music WHERE title LIKE '%'||?||'%' ";
			//contains() => LIKE => REGEXP_LIKE
			//3. sql 전송
			ps = conn.prepareStatement(sql);
			//4. ?에 값을 채운다
			ps.setString(1, fd);
			//5. 실행후 결과값 가져오기
			ResultSet rs = ps.executeQuery();
			//6. list에 값 채워넣기
			while(rs.next())//처음부터 끝까지 읽기
			{
				MusicVO vo = new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSinger(rs.getString(3));
				vo.setAlbum(rs.getString(4));
				vo.setPoster(rs.getString(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	// 동영상 키
	public String getKey(int mno)
	{
		String key="";
		
		try
		{
			getConnection();
			//DISTINCT 데이터중복 제거 Set
			String sql = "SELECT DISTINCT key FROM genie_music WHERE mno="+mno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			key=rs.getString(1);
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return key;
	}
}
