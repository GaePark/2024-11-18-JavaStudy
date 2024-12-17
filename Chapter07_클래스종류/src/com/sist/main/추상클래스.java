package com.sist.main;
/*
 * 추상클래스
 *     = 주 목적
 *         관련된 클래스를 모아서 한개의 객체명으로 관리
 *         (서로 다른 클래스를 연결해서 사용)
 *     에)
 *         게시판
 *         ------ 쓰기 읽기 수정 삭제 목록 검색
 *         ㅣ 묻고답하기 : 답하기
 *         ㅣ 자료실 : 다운로드 / 업로드
 *         ㅣ 댓글형 게시판 : 댓글
 *         ㅣ 갤러리 게시판 : 이미지
 *         
 *         => 요구사항 분석 / 설계
 *     = 단점
 *         = 단일 상속만 가능
 *         = 미완성 (메소드구현이 안될 시)
 *             new를 이용해서 객체를 생성할 수 없다.
 *         = 상속을 받아서 메소드를 구현 후에 사용
 *             new 구현된 클래스의 생성자()
 *             ----------------------------> 오버라이딩
 *         = 선언된 메소드 + 선언 안된 메소드
 *     = 형식)
 *         => 유지보수가 어려운 프로그램
 *         => 설계
 *         public abstract class ClassName
 *         {
 *             ------------------------------
 *             변수 : 멤버변수
 *             ------------------------------
 *             생성자
 *             ------------------------------
 *             메소드 : 구현 메소드
 *             ------------------------------
 *             메소드 : 미구현 메소드 선언 => 상속받는 클래스의 공통적인 부분
 *             ------------------------------
 *             
 *         }
 *         
 *         public abstract class A
 *         public class B extends A
 *         {
 *         
 *         }
 *         A a=new B();
 *         
 *         추상클래스 => 공통점을 가지고 있는 클래스
 *                            --------------------------
 *                            
 *         추상클래스의 대표적
 *         동물
 *         ---- 먹는다 / 걷는다 / 말한다 ...
 *         
 *         사람
 *         개
 *         소
 *         돼지
 *         말 ...
 *         
 *         => 관련된 클래스를 묶어서 처리
 *         
 *     예)
 *         버튼 클릭()
 *         더블 크랙()
 *         
 *         로그인 버튼
 *         계산기 버튼
 *         검색 버튼
 *         
 *     => 다중상속
 *     => 구현이 안된 메소드만 사용
 *     => 변수 => 상수
 *     => 다른 클래스에 영향이 없게
 *     ----------------------------
 */
import java.util.Scanner;
abstract class 도형
{
	public abstract void draw();//추상메소드
	// 상속받는 클래스는 무조건 구현해서 사용
	// default
	public void colorSelect()
	{
		System.out.println("검정");
	}
	
	
}
class 네모 extends 도형 {
	public void draw() {
		System.out.println("네모");
	}
}
class 삼각 extends 도형 {
	public void draw() {
		System.out.println("삼각");
	}
}
class 원 extends 도형{
	public void draw() {
		System.out.println("원");
	}
	public void colorSelect() {
		System.out.println("빨강");
	}
}
public class 추상클래스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 관련된 클래스를 모아서 한개 객체명으로 제어
//		도형 a=new 네모() ;
		//        ------------ 상속받아서 메소드를 구현한 클래스
		// 오버라이딩 : 기능을 변경해서 사용
		/*
		 * 오버라이딩
		 * 1) 상속 => 익병의 클래스 (상속없이 사용)
		 * 2) 메소드명 , 매개변수 
		 * 3) 접근지정어는 확대만 가능
		 * 4) 유지보수에서 주로 사용
		 * 5) 웹 => 유사한 기능이 많다
		 *     회원가입 / 로그인 / 로그아웃
		 *     게시판 / 공지사항 / 목록 => 상세보기
		 *     댓글 ....
		 *     예약 / 추천 / 결제....
		 *     여행 => 코스
		 *     
		 * 
		 */
//		a.draw();
//		a.colorSelect();
//		
//		a=new 삼각() ;
//		a.draw();
//		a.colorSelect();
//		
//		a=new 원() ;
//		a.draw();
//		a.colorSelect();
		도형 a= null;
		Scanner scan=new Scanner(System.in);
		System.out.println("도형 선택:네모(1),삼각형(2),원(3)");
		int mode = scan.nextInt();
		
		if(mode==1)
			 a = new 네모();
		else if(mode==2) 
			 a = new 삼각();
		else if(mode==2) 
			a = new 원();
		a.colorSelect();
		a.draw();
	}

}
