package com.sist.lib;
/*
 * hashCode() => 객체의 구분자
 * ***toString() => 오버라이딩 => 객체의 주소값을 출력
 * ***clone() => 복제해서 새로운 메모리에 저장
 * ***equals() => 객체 비교 (주로 주소값 => 재정의 : 맴버변수가 같은지)
 * finalize() => 소멸자 함수 (객체 메모리 해제 => 자동 호출)
 * hashCode() => 객체마다 구분 번호를 가지고 있다
 * 
 * 
 * 
 * 
 */
class Member2{
	private int mno;
	private String name;
	
public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// 초기화
	public Member2 (int mno, String name) {
		this.mno = mno;
		this.name = name;
	}
	public void print() {
		System.out.println("회원번호:" +mno);
		System.out.println("이름:" + name);
	}

}


public class 라이브러리_Object_5 {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member2 m1 = new Member2(1, "박문수");
		Member2 m2 = new Member2(1, "박문수");
		
		System.out.println("m1:" + m1);
		System.out.println("m2:" + m2);
		
		System.out.println("m1: "+m1.hashCode());
		System.out.println("m2: "+m2.hashCode());
		
	}
	
	

}
