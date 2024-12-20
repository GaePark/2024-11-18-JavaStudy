package com.sist.math;
/*
 * 데이터형
 *     => 기본형
 *     => 참조형
 *           ------ 클래스 / 배열
 *                    ------
 *                    ㅣ라이브러리
 *                    ㅣ사용자 정의
 *     멤버변수 => 기본형 / 클래스 / 배열
 */
import java.sql.*;
public class GoodsDAO {
	//클래스 전체 영역에서 사용하는 변수 / 클래스 / 배열 => 멤버변수
	private Connection conn;//오라클 연결
	private PreparedStatement ps; // 오라클 명령문
	// => 변경이 되면 안되는 값 : 상수 => 오라클 주소
	// hr1 hr2 hr3 hr4
	private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
	/*
	 * 오라클 실행 명령어
	 * ---------------- SQL
	 * 
	 * DQL : 데이터 검색 => 데이터 읽기
	 *          => SELECT
	 * DML : 데이터 조작
	 *          => UPDATE => 데이터를 수정
	 *          => INSERT => 데이터를 오라클에 추가
	 *          => DELETE => 데이터 삭제
	 * DCL : 데이터 제어 언어
	 *          => GRANT : 권한 부여
	 *          => REVOKE : 권한 해제
	 * DDL : 저장장소 , 함수 제작
	 *          => CREATE
	 *          => ALTER
	 *          => DRP
	 *          => RENAME
	 *          => TRANCATE
	 * TCL : 트랜잭션 제어
	 *          => COMMIT : 정상 저장
	 *          => ROLLBACK : 모든 명령어 취소
	 * => JOIN / Subquery
	 */
	// 오라클 연결 => 드라이버 설치 => 생성자 1번만 수행
	// 싱글턴 => 데이터베이스는 싱글턴이다
	
	private static GoodsDAO dao;
	
	
	public GoodsDAO() {
		// TODO Auto-generated constructor stub
		try {//CheckException
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//GoodsDAO dao = new GoodsDAO.newInstance();
	// 싱글턴 패턴
	public static GoodsDAO newInstance() {
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	// 자바 => 오라클 / 스프링 => 단순화 라이브러리 (Mybatis, JPA)
	// 공통모듈 => 메소드마다 공통으로 사용
	// => 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// => 오라클 닫기 ==> 반복 코딩 => 메소드화
	public void disConnection()
	{
		try {
			if(ps !=null) ps.close();
			if(conn !=null) ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// => 자동화 (스프링 => AOP) => 실시간 처리 Task
	// 기능 제작!
	// 총페이지 
	public int goodsTotalPage() {
		int count=0;
		// selectList(String sql)=> Mybatis
		try {
			//1. 연결
			getConnection();
			//2.오라클 명령문 전송
			String sql="SELECT COUNT(*) FROM goods_all";
			// 3. 오라클로 전송
			ps = conn.prepareStatement(sql);
			// 4. 실행 결과값 읽기
			ResultSet rs = ps.executeQuery();
			// 5. 데이터가 있는 메모리 위치에 커서를 이동
			rs.next();
			// 6. 읽어온 값을 저장
			count = rs.getInt(1);
			//7. ResultSet 닫기
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return count;
	}
	// 목록
	// 추가
	
}
