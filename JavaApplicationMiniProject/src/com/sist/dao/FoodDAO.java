package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public FoodDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	//WEB => JDBC => DBCP
	//DBCP => 미리 연결하는 방식을 사용하는 방식으로 작동된다 => 재사용 (반환) => WEB에서 일반화
	//JDBC => 연결 /닫기 => 연결에 시간소모가 있다
	//2. Connection을 한개만 생성
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	//3. 연결
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//4. 닫기
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//기능
	//1. 전체 목록 출력 => 인라인뷰
	public List<FoodVO> FoodListData(int page)
	{
		List<FoodVO> list = new ArrayList<FoodVO>();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end = page*rowSize;
		try
		{
			getConnection();
			String sql = "SELECT fno,name,poster,num FROM (SELECT fno,name,poster,rownum as num "
					+ "FROM (SELECT /*+INDEX_ASC(food_menupan fm_fno_pk)*/ fno,name,poster "
					+ "FROM food_menupan)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("http://menupan.com"+rs.getString(3));
				list.add(vo);
				
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		return list;
	}
	public int foodTotalPage()
	{
		int total =0;
		try
		{
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/12.0) FROM food_menupan";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			disConnection();
		}
		return total;
	}
	//2. 상세보기 => 조회수 증가 / WHERE
	//=> 홈 / 맛집 / 맛집 검색 => 상세보기
	/*
	 * INSERT / UPDATE /DELETE
	 * --------------------------------게시판
	 * --------------------------------답변형 게시판
	 * 댓글/ 장바구니 / 예약/ 결제 => DML 사용
	 */
	
	//3. 장르별 출력
	
	public List<FoodVO> FoodGenreData(int page, String genre){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			int rowSize= 12;
			int start = (rowSize*page) - (rowSize-1);
			int end = (rowSize*page);
			getConnection();
			String sql = "SELECT fno,name,poster,num FROM (SELECT fno,name,poster,rownum as num FROM "
					+ "(SELECT /*+INDEX_ASC(food_menupan fm_fno_pk)*/  fno,name,poster "
					+ "FROM food_menupan WHERE REGEXP_LIKE(type,?))) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setInt(2, start);
			ps.setInt(3, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo =new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("https://www.menupan.com"+rs.getString(3));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		
		return list;
	}

	//3-1
	public int foodGenreTotalPage(String genre)
	{
		int total =0;
		try
		{
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/12.0) FROM food_menupan WHERE REGEXP_LIKE(type,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			disConnection();
		}
		return total;
	}
	
	//4. 검색 => 주소
	public List<FoodVO> foodFindData(String address)
	{
		List<FoodVO> list = new ArrayList<FoodVO>();
		
		try
		{
			getConnection();
			String sql="SELECT fno,poster,name,address,type,score,rownum "
						+ "FROM food_menupan "
						+ "WHERE REGEXP_LIKE(address,?)  AND rownum<=10"
						+ "ORDER BY score DESC";
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster("https://www.menupan.com"+rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setAddress(rs.getString(4));
				vo.setType(rs.getString(5));
				vo.setScore(rs.getDouble(6));
				list.add(vo);
			}
			rs.close();
		}catch (Exception e) {}
		finally
		{
			disConnection();
		}
		return list;
	}
	

/*
 FNO	NUMBER
NAME	VARCHAR2(500 BYTE)
TYPE	VARCHAR2(100 BYTE)
PHONE	VARCHAR2(20 BYTE)
ADDRESS	VARCHAR2(700 BYTE)
SCORE	NUMBER(2,1)
THEME	CLOB
POSTER	VARCHAR2(300 BYTE)
IMAGES	VARCHAR2(4000 BYTE)
TIME	VARCHAR2(100 BYTE)
PARKING	VARCHAR2(200 BYTE)
CONTENT	CLOB
HIT	NUMBER
PRICE	VARCHAR2(30 BYTE)
 */
	public FoodVO foodDetailData(int fno)
	{
		FoodVO vo = new FoodVO();
		try {
			getConnection();
			String sql="SELECT name,type,phone,address,score,theme,poster,images,time,parking,content,price FROM food_menupan WHERE fno="+fno;
			ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			vo.setName(rs.getString(1));
			vo.setType(rs.getString(2));
			vo.setPhone(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setScore(rs.getDouble(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster("https://www.menupan.com"+rs.getString(7));
			vo.setImages(rs.getString(8));
			vo.setTime(rs.getString(9));
			vo.setParking(rs.getString(10));
			vo.setContent(rs.getString(11));
			vo.setPrice(rs.getString(12));
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
	
	//=> 웹(장르별,이름...) : 지도 출력(주소) => 카카오
	//JEditPane : HTML출력
	// JDBC연동
	// => DAO / VO
	
}
