package com.sist.main;
/*
 * 자바의 기본 형식
 * package =>1번만 가능 => 첫줄에
 * import => 여러번 가능
 * public class ClassName => 여러번가능
 * {
 *      멤버변수 / 정적 변수 => x, 여러개
 *      생성자=> 필요시에 사용
 *      매소드 => 필요시에 사용
 *      main() {} => 반드시 한개가 필요=> 프로그램 시작지점
 * }
 * => 제어어
 *       static : 공통적인
 *       final : 마지막인 => 상수 / 변경하지 않는 메소드
 *       abstract: 추상적인 => 공통 기반
 *       syschronize : 동기적인 => 쓰레드
 *       
 *       -------
 *       async
 *       sync
 *       ------- JavaScript => Ajax=> web2.0에서 유행 => web3.0에서 시들시들함
 *       ------- Jquery(ajax) 3에서 멈췄었음 => React => Vue => React => Next 순으로 유행
 *                  Jquery => 4,5버전 개발중
 *                  
 * 상속 (웹 , 스프링 => 사용빈도 거의 없다)
 * -----------------------------------------
 * 상속 : 목적 / 형식 / 메모리 구조
 * => 목적
 * 기존의 클래스(이미 만들어져 있는 클래스) =>신뢰성이 뛰어나다
 *     = 라이브러리 클래스
 *     = 사용자정의 클래스
 * 재사용 할때 / 변경 사용 , 추가사용
 * => 반복 제거 / 소스를 줄이는 경우
 * => 상속에서는 예외조건
 *      1. 생성자 , 2. static 3. 초기화블럭
 *      ** 상속은 되는데 사용을 못하는 것 => private (protected)
 * => 형식 
 *       class A
 *       class B extends A => A클래스를 확장해서 사용
 *       
 *       =>상속을 내린 클래스
 *              부모클래스 , 슈퍼클래스 , 베이스 클래스
 *       => 받은 클래스
 *              자식클래스 , 서브클래스 , 파생 클래스
 *              
 *        => 클래스의 크기가 결정 => 형변환 가능
 * ------------------------------------------
 * 
 * 1) 단일 상속 => 수정가능 (변수오버라이딩,메소드 오버라이딩)
 * 2) 상속 : extends : 한개만 사용이 가능
 * 3) 상속을 두개 이상 받는 경우
 *      class A
 *      class B extends A => A,B
 *      class C extends B => A,B,C 다 받을 수 있음
 *      
 *      => 여러개를 받는 방법 => 클래스는 기존
 *            ----------------- 인터페이스
 *            
 *      생물                                => 위로 올라갈수록 클래스가 커진다
 *       ㅣ                                  => 공통점이 많다(추상화)
 * --------------                       => 내려갈 수록 구체화
 * ㅣ               ㅣ
 * 동물           식물
 *  ㅣ              ㅣ
 *  -------     ------
 *  ㅣ     ㅣ    ㅣ    ㅣ
 *  포유류 조류 나무 꽃
 * 
 * 등등
 *                        상속을 받아서 메모리 할당
 *                        1) 상위 클래스 (상속 내린 클래스)
 *                        2) 하위 클래스 (상속을 받은 클래스)
 *                        => 속도가 느려진다
 *                        => 영향력이 많이 존재
 *                        => 공통점을 추출
 *                              ------
 *                              
 * 
 */
class Sawon{
	public Sawon() {
		System.out.println("Sawon 객체 생성!!");
		
		
	}
	public void display() {
		System.out.println("display 실행");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("객체소멸");
	}
	
}

public class 재사용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sa=new Sawon();
		sa.display();
		sa=null;
		System.gc();//메모리를 회수해라...

		
	}

}
