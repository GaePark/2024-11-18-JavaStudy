package com.sist.main;
/*
 * 변경 (수정)
 * ----------- 오버라이딩
 * => 변수 오버라이딩
 * => 메소드 오버라이딩
 */
class Super {// 상속하는 클래스
	String name;
	int age;
	//초기화
	public Super() {
		name="홍길동";
		age=25;
	}
}

class Sub extends Super{//받는 클래스
	String name;
	int age;
	public Sub()
	{
		name="심청이";
		age=27;
	}
	public void display() {
		System.out.println("Super:name=" + super.name);
		System.out.println("Super:age=" + super.age);
		System.out.println("Sub:name=" + this.name);
		System.out.println("Sub:age=" + this.age);
	}
}
public class 상속_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub s = new Sub();
		s.display();
	}

}
