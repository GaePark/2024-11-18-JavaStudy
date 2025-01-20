package com.sist.vo;
/*
 ID	VARCHAR2(20 BYTE)
PWD	VARCHAR2(10 BYTE)
NAME	VARCHAR2(51 BYTE)
SEX	CHAR(6 BYTE)
EMAIL	VARCHAR2(100 BYTE)
BIRTHDAY	DATE
ADDRESS	VARCHAR2(100 BYTE)
REGDATE	DATE
=> jdbc => 자바 데이터베이스 연결
	=> ava.sql.*
		1. ojdbc8.jar
		2. lombok.jar
		---------------
		1) 오라클에 있는 데이터를 모아서 윈도우/웹에 전송
			--------------------------------------------
			=> ~VO(Value Bbject) => Spring
			=> ~DTO (Data Transfor Object) : Mybatis
			=> ~Bean : JSP
			=> 변수(컬럼) => 데이터의 손실 방지 => 캡슐화
		2) DAO => 데이터베이스 연결
			= Connection : 데이터베이스 연결
			= ResultSet : 결과값을 저장하는 메모리 공간
				결과값을 저장하는 메모리 공간
			= Statement : SQL문장 전송 / 결과값을 받는 역할
			 	= Statement : SQL+데이터 동시전송
			 		"WHERE no="+no => SQL을 완성후 전송
			 	= PreparedStatement => SQL 문장을 전송
			 										   나중에 데이터값을 채운다
					"WHERE name=?"
					=> 가장 많이 사용되는 방식
			 	= CallableStatement : PROCEDURE를 호출
			 									 --------------- 오라클 함수
			 									 PL /SQL => 중복 SQL
			 									 
			 --------------------------------------------------------
			 => 출력된 row가 많은 경우
			 		while(rs.next())
			 		=> 출력된 row가 많은 경우 => 검색 / 목록
			 			while(rs.next())
			 		=> 출력된 row가 1개인 경우 => 상세보기 / 총페이지
			 			rs.next()
			
			코딩
				1) 드라이버 등록 => 한번 사용 (생성자)
					Class.forName("oracle.jdbc.driver.Oracliver
								MYSQL = "com.mysql.cj.jdbc.driver"
								---------- MARIADB
								----------- dirver는 각제 데이터베이스업체에서 받운 받는다.
				2)오라클 연결 / 닫기 => 중복이 많다(메모리처리)
					= 연결
						conn=DriverMangager.getConnection(URL,"username, password);
					=> 닫기
						ps 닫기
				3) Connection 객체 관리 => 가비지컬렉션 (바로 회수(X)
					-------------
						=>반드시 한개만 가지고 사용되는 가능
										---------- 싱글턴 ( 메모리 절약 , 객체 재사용)
										ㅣ데이터베이스 / 서버프로그램
				4) 코딩 순서(모든 개발자 코딩이 거의 유사)
								---------------------------
								ㅣ라이브러리 => Mybatis / JPA
								ㅣ 실무 (Sptring / MyBatis)
											------------------- 통합
					=> 286page => 설명 => 287
					try
					{
					} catch(Exception ex)
					{
					에러 위치 확인 / 에러 확인 => 복구할 ㅅ ㅜ없다
					}
					finally
					{
						오라클 닫기
					}
 */

import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private String id,pwd,name,sex,email,address,msg;
	private Date regdate,birthday;
	
}
