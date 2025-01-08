package com.sist.vo;
/*
 DEPTNO                                    NOT NULL NUMBER
 DNAME                                              VARCHAR2(20)
 LOC                                                VARCHAR2(20)
 */
public class DeptVO {
	private String dname,loc;
	private int deptno;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
