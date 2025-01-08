package com.sist.vo;
//사원 정보를 모아서 관리 => 사원 한명
// => 모아서 한번에 윈도우나 브라우저 전송하는 목적
/*
  EMPNO                                     NOT NULL NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)
 
 => 테이블 여러개 컬럼을 섞어서 사용
 	   -----------------------------
 	      ㅣ한개의 테이블로 변경 => View (가상테이블)
 */

import java.util.Date;
import lombok.Data;
// => 테이블 연동 : 다른 테이블의 컬럼을 추가하면 안된다.
@Data
public class EmpVO {
	private int empno,comm,deptno,mgr,sal;
	private String ename,job;
	private Date hiredate;
	private String strSal;
	
	//조인 => 포함 클래스
	private DeptVO dvo = new DeptVO();
	private SalVO svo=new SalVO();
	
}
