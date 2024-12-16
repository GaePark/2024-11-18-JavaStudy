package com.sist.execute2;

class Sub {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("Sub..");
		return "";
	}
	//Object => 모든 메소드 사용이 가능
	//Sub sub = new Sub();
	//Object obj = new Sub();

}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Sub();
		// 묶어서 한개로 관리할때만 사용
		obj.toString();
		/*
		 * 상위클래스는 하위 클래스의 추가된 메소드, 변수에 접근을 못한다.
		 */
	}

}
