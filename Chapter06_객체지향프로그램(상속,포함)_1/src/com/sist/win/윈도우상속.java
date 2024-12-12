package com.sist.win;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*; //윈도우 관련
/*
 * 상속 => 기존의 클래스를 재사용 => 추가 , 변경해서 사용
 *             ------------
 *             사용자 정의
 *             라이브러리 => 변경해서 사용하는 상속이 많다
 *             => 코드의 재사용성 높다 => 최적화에 문제
 *                   ------------- 개발 속도가 빠르다
 *             => 코드 관리가 용이하다
 *             => 코드가 간결해진다 => 코드를 볼 수 없다 (가독성)
 *             => 기존의 클래스 이미 검증된 상태 : 신뢰성이 높다
 *        상속 : is-a => 변경후 사용
 *        포함 : has-a => 있는 그대로 사용(***)
 *        
 *     객체지향 => 권장(캡슐화, 재사용(상속) , 변경 , 추가가 쉽게)
 *                                                                   ------------
 *                                                                   오버라이딩,오버로딩
 *     *** 상속의 문제점
 *             = 결합성이 높다 (다른 클래스에 영향이 크다)
 *             예) 상속받는 클래스 => 상속을 내리는 클래스(변경)
 *             = 제약조건이 많다
 *             = 메모리 커진다 => 속도 늦다
 *             = 윈도우 사용하지 않는 이유 => 속도가 느리다
 *    특징)
 *        1. 단일 상속만 가능
 *        2. 상속 기호 : extends : 클래스를 확장해서 사용
 *                           --------
 *             예) class A extends B
 * 3. 상속 => 특별한 경우가 아니면 모든 변수 , 메소드 상속
 * 
 *      => 특별한 경우 (예외)
 *          static : => 공유 (여러개의 객체가 공동 사용)
 *                      => 사용이 가능하게 만든다
 *          생성자
 *          초기화블록
 *          private : 상속은 내려간다 => 접근이 불가능
 *          --------------> setter/getter
 *                   
 */
//class A{
//	int a,b;
//}
//class B extends A{
//	public B() {
//		this.a=10;
//		this.b=20;
//		super.a=100;
//		super.b=200;
//	}
//}  
public class 윈도우상속 extends JFrame{
	//윈도우 설정
	JButton b1= new JButton("North"); // 포함 클래스
	JButton b2= new JButton("East"); // 포함 클래스
	JButton b3= new JButton("west"); // 포함 클래스
	JButton b4= new JButton("South"); // 포함 클래스
	JButton b5= new JButton("Center"); // 포함 클래스
	public 윈도우상속() {
//		//레이아웃
		setLayout(new GridLayout(1,5));
//		setLayout(new FlowLayout());
		add(b1);add(b2);add(b3);add(b4);add(b5);
		//BorderLayout => default
//		add("North",b1);
//		add("South",b4);
//		add("Center", b5);
//		add("East", b2);
//		add("West",b3);
	    //크기 결정
		setSize(640,400);
		//윈도우 보여달라
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 윈도우상속();
//		A a = new A();
//		B b= new B();
//		
//		System.out.println(b.a);
//		System.out.println(b.b);
//		System.out.println(a.a);
//		System.out.println(a.b);
//	}

}
}