package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

/*
	오라클 / 자바 / 자바스크립트 / HTML / CSS
	-------------------------------------------
		ㅣ     l         l                -----------------<iframe>, ThymeLeaf
		            Function
			class/Method
	PROCEDURE
	=> 반복이 많다 => 반복 제거
 */
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private DataBase db=new DataBase();
	private static EmpDAO dao;
	
	//싱글턴
	public static EmpDAO newInstance() {
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	
	//기능 => 전체 목록 출력
	public List<EmpVO> empListData() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn=db.getConnection();
			String sql = "SELECT empno,ename,job,hiredate,dname,loc "
								+ "FROM emp JOIN dept "
								+ "ON emp.deptno= dept.deptno";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			db.disConnection(conn, ps);
		}
		return list;
	}
	//상세보기
	public EmpVO empDetaildata(int empno)
	{
		EmpVO vo = new EmpVO();
		try {
			conn=db.getConnection();
			String sql = "SELECT e1.empno,e1.ename,e1.job,NVL(e2.ename,'사수없음'),e1.hiredate,e1.sal,NVL(e1.comm,0),dname,loc,grade,e1.deptno "
								+ "FROM emp e1,emp e2,dept d, salgrade s "
								+ "WHERE e1.mgr=e2.empno(+) "
								+ "AND e1.deptno=d.deptno "
								+ "AND e1.sal BETWEEN losal AND hisal "
								+ "AND e1.empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMname(rs.getString(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getInt(6));
			vo.setComm(rs.getInt(7));
			vo.getDvo().setDname(rs.getString(8));
			vo.getDvo().setLoc(rs.getString(9));
			vo.getSvo().setGrade(rs.getInt(10));
			vo.setDeptno(rs.getInt(11));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			db.disConnection(conn, ps);
		}
		return vo;
	}
	//검색
	public List<EmpVO> empFIndData(String col, String fd)
	{
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 이름, 입사일 ,직위 , 부서명 근무지
			conn=db.getConnection();
			String sql = "SELECT empno,ename,job,hiredate,dname,loc "
								+ "FROM emp JOIN dept "
								+ "ON emp.deptno=dept.deptno "
								+ "AND REGEXP_LIKE("+col+",UPPER(?))";
			ps=conn.prepareStatement(sql);
			ps.setString(1,fd.toUpperCase());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			db.disConnection(conn, ps);
		}
		return list;
	}
}
