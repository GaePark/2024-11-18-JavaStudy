package com.sist.dao;
import java.util.*;
import java.sql.*;

public class EmpDeptDAO {
	private PreparedStatement ps;
	private Connection conn;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDeptDAO dao;
	
	public EmpDeptDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static EmpDeptDAO newInstace() {
		if(dao ==null)
			dao=new EmpDeptDAO();
		return dao;
	}
	
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
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
	
	//일반 SQL 사용
	public void sqlExecute()
	{
		try {
			getConnection();
			String sql = "SELECT empno,ename,job,hiredate,sal,rank,dname,loc,grade "
					+ "FROM (SELECT empno,ename,job,hiredate,sal,"
					+ "	RANK() OVER(ORDER BY sal DESC) rank, dname, loc, grade"
					+ "	FROM emp,dept,salgrade"
					+ "	WHERE emp.deptno = dept.deptno"
					+ "	AND sal BETWEEN losal AND hisal)";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(
						"empno=" +rs.getInt(1) + "\n"
						+"ename="+rs.getString(2)+ "\n"
						+"job="+rs.getString(3)+ "\n"
						+"hiredate=" + rs.getDate(4).toString()+ "\n"
						+"sal=" + rs.getInt(5)+ "\n"
						+"rank="+rs.getInt(6)+ "\n"
						+"dname=" + rs.getString(7)+ "\n"
						+"loc=" + rs.getString(8)+ "\n"
						+"grade=" + rs.getInt(9)+ "\n"
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
	//view 사용
	public void viewExecute()
	{
		try {
			getConnection();
			String sql = "SELECT * FROM empAllData";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(
						"empno=" +rs.getInt(1) + "\n"
						+"ename="+rs.getString(2)+ "\n"
						+"job="+rs.getString(3)+ "\n"
						+"hiredate=" + rs.getDate(4).toString()+ "\n"
						+"sal=" + rs.getInt(5)+ "\n"
						+"rank="+rs.getInt(6)+ "\n"
						+"dname=" + rs.getString(7)+ "\n"
						+"loc=" + rs.getString(8)+ "\n"
						+"grade=" + rs.getInt(9)+ "\n"
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
}
