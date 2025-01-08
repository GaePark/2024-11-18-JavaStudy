package com.sist.dao;
/*
 *  => 자바 12장
 *  오라클 연동
 *  -----------
 *  1.드라이버 설정
 *  	=> 한번만 설정
 *  	=> 생성자 이용
 *  	=> Class.forname("드라이버명")
 *  								------------- orcle.jdbc.driver.OracleDriver
 *  								------------- com.mysql.cj.jdbc.Driver
 *  2.	 오라클 연결
 *      Connection conn = DriverManager.getConnection(URL,"hr","happy")
 *  3. 오라클로 SQL문장 전송
 *                 -------------
 *      	PreparedStatement ps = conn.preparedStatement(sql)
 *  4. 오라클에서 SQL실행하고 결과값 요청
 *         ResultSet rs = ps.executeQuery();
 *         
 *         rs
 *         --------------------------------
 *                id        pwd       name
 *         --------------------------------
 *               aaa      1234       홍길동     ㅣ => next() ==> 가장 많이 사용
 *         --------------------------------
 *               bbb      1234       심청이
 *         --------------------------------
 *               ccc      1234       박문수
 *         --------------------------------
 *               ddd     1234       이순시      ㅣ => previous()
 *         --------------------------------
 *         ㅣ cursor위치
 *         => rs.close()
 *         => ps.close()
 *         => conn.close();
 *         
 *         *** rs.next() => record단위 =< 한줄의 모든 데이터를 읽는다
 *   
 */

import java.sql.*;
import java.util.*;
import com.sist.vo.*;
/*
 * => SQL => ;을 사용하면 안됨
 * => 변경 => LIKE
 * => LIKE '%'||문자열||'%' => 무자열 결합
 *  	  LIKE CONCAT('%',문자열,'%') => MYSQL
 *  => JOIN => Oracle JOIN / ANSI JOIN
 *                                          --------------
 */


public class EmpDAO {
	// 1. 오라클 연결 객체
	private Connection conn;
	// 2. 오라클 SQL 송수신 객체
	private PreparedStatement ps;
	/*
	 * SQL문장을 전송
	 * 오라클 실행 결과 읽기
	 * --------------------
	 * Statement : 데이터와 동시에 SQL문장을 전송
	 * PreparedStatem : SQL먼저 전송
	 *                            나중에 데이터를 채운다 (***)
	 * CallableStatement : procedure호출 => 함수
	 *                                ㅣSQL문장이 노출되지 않는다
	 *                                ㅣ 보안
	 *                                ㅣ ERP => 관리 프로그램
	 *                                    E4NET
	 * EmpVO
	 * String sql="INSER INTO emp VALUES("
	 *                   +vo.getEmpno()+"','" +vo.getEname()
	 *                   +"','"+vo.getJob()....;
	 *                   
	 * String sql="INSERT INTO emp VALUES(?,?,?,?,?,...)"
	 *             => MyBatis / JPA
	 */
	// => 클래스 전체에서 사용
	// 3. DAO => 오라클 연동 => 사용자 한명당 1개만 사용 (싱글턴)
	private static EmpDAO dao;
	//3-1
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// => TCP => Socket을 이용해서 오라클로 SQL문장을 전송
	// => 오라클 서버 => 자바응용프로그램 : Client
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 4. 기능
	// 모든 메소드에서 공통으로 사용되는 기능
	//4-0 : 오라클 연결 /오라클 연결 해제
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			
			if(ps!=null) ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//4-0-1 : 싱글턴 => 메모리공간 한개만 생성 (static)
	public static EmpDAO newINstance() {
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	//-------------------------------항상 들어가는 부분 => jar로 묶을 예정
	// 2차 => JSP : MyBatis(XML) => JQuery,Ajax
	// 3차 => Spring : MyBatis(Annotation) => VueJS
	// 4-1 : 목록 => SELECT column_list
	public List<EmpVO> empListData(int type) {
		List<EmpVO> list = new ArrayList<EmpVO>();
		String order="";
		if(type==1)
			order="ORDER BY empno ASC";
		else if(type==2)
			order = "ORDER BY sal DESC";
		else if(type==3)
			order = "ORDER BY ename ASC";
		try {
			getConnection();
			//2. SQL문장 제작
			String sql="SELECT empno,ename,job,hiredate FROM emp "+order;
			System.out.println(sql);
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	// 4-2 : 정렬 => ORDER BY
	// 4-3 : 상세보기 => WHERE 
	/*
	 * List ==> 여러명
	 * EmpVO ==> 1명 => 상세보기
	 * 
	 * 이상현상 (수정,삭제) => 기본키 => 숫자
	 */
	public EmpVO empDEtailData(int empno)
	{
		EmpVO vo = new EmpVO();//한명의 데이터를 담는다
		try {
			getConnection();
			String sql = "SELECT * FROM emp WHERE empno="+empno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMgr(rs.getInt(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.setDeptno(rs.getInt(8));
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
	
	
	
}
