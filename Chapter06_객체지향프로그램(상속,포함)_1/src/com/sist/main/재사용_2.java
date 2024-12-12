package com.sist.main;

class Person {
	String name,sex,address,phone;
	int age;
	
	Person(){
		System.out.println("사람");
	}
}
class Worker extends Person{
	int sabun;
	String dept,job,loc;
	int pay;
	Worker(){
		System.out.println("회사원");
	}
}
public class 재사용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Worker sa = new Worker();
		// 메모리 할당 => 상속 받은 클래스만 이용하는 방법
		// 상속을 내리는 클래스 => 메모리 할당이 가능
		Person a = new Worker();
		// 묵시적 형변환
		// 클래스형 => 변수, 메소드만 사용이 가능
		Person e = new Worker();
		//강제 형변환
		Worker d = (Worker)e;
		Worker c = new Worker();
		Person b = c;
	}

}
