package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

/*
 * 오라클 => SQL
 *               ----- 자바에서 실행여부 => 자바에서 오라클 SQL문장 정리
 * => 오라클 / 자바 => 숙지
 *       ------------
 *       ㅣ자바스크립트
 *       -------------------------------통합해서 사용 (Spring)
 */
public class EmpDAO {
	private PreparedStatement ps;
	private Connection conn;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	//XE => 데이터베이스명 => 모든 테이블이 들어가 있따
	// => 폴더 (파일 여러개)
	
	private static EmpDAO dao;
	//드라이브 연결
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch(Exception e) {}
	}
	// 싱글턴 => 메모리 공간 / 재사용
	// newInstance() / getInstance()
	//Calendar.getInstance()
	public static EmpDAO newInstance() {
		if(dao == null)
			dao=new EmpDAO();
		return dao;
	}
	//오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//-------------------공통사항
		/*
		 * DAO ====> 테이블 1개에 대한 제어
		 * 	    => BoardDAO
		 *     => 
		 * SERVER ====> 테이블 여러개에 대한 제어
		 *     => BoardService : Board/Reply
		 */
	}
	//오라클 해제
	public void disConnection() {
		try {
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//1. 기능
	/*
	 * 사원(사원,이름,직위,입사일,급여)
	 * 부서(부서명,근무지)
	 * 등급(등급)
	 * --------------------------테이블 3개에서 출력에 필요한
	 *                                     데이터 추출 : 조인
	 */
	public List<EmpVO> empJoinAllData() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,TO_CHAR(sal,'$999,999'),dname,loc,grade"
								+" FROM emp JOIN dept ON emp.deptno = dept.deptno"
								+" JOIN salgrade ON sal BETWEEN losal AND hisal";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setStrSal(rs.getString(5));
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));
				vo.getSvo().setGrade(rs.getInt(8));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		return list;
	}
	
	public EmpVO empDetail(int empno) {
		EmpVO vo = new EmpVO();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,TO_CHAR(sal,'$999,999'),dname,loc,grade"
								+" FROM emp JOIN dept ON emp.deptno = dept.deptno"
								+" JOIN salgrade ON sal BETWEEN losal AND hisal"
								+ " AND empno="+empno;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				rs.next();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setStrSal(rs.getString(5));
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));
				vo.getSvo().setGrade(rs.getInt(8));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		return vo;
	}
}
