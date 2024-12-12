package com.sist.main;
/*
 * 메소드 오버라이딩 => 메소드의 기능 변경 => 유지보수
 * ---------------------------------------------------
 * 오버라이딩의 조건***** 인터페이스
 * 1. 상속 => 상속받은 메소드를 변경해서 사용
 * 2. 메소드명이 동일하다
 * 3. 매개변수가 동일
 * 4. 리턴형이 동일
 * 5. 접근지정어가 확대는 가능하지만 축소는 불가능
 * 
 * => 실무 (입사)
 *       ----------
 *       1) 배열
 *       2) 연산자
 *       3) 제어문
 *       4) 메소드
 *       5) 멤버변수
 *       6) 생성자
 *       ***7) 오버라이딩
 *       ***8) 인터페이스
 *       ***9) 예외처리
 */
class A{
	int a= 10;
	public void display() {
		System.out.println("a");
	}
}
class B extends A{
	int a=20;
	public void display() {
		System.out.println("b");
	}
}
class C extends A {
	int a =30;
	public void display() {
		System.out.println("c");
	}
}
public class 상속_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();
		System.out.println(a.a);
		a.display();
		a = new C();
		System.out.println(a.a);
		a.display();
		/*
		 * 변수 찾기
		 * --------- 선언되는 클래스형
		 * 메소드 찾기
		 * --------- 생성자
		 */
		

	}

}
