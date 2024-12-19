package com.sist.lib;

import java.util.ArrayList;

class Movie{
	private int mno;
	private String title;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Movie(int mno, String title) {
		this.mno = mno;
		this.title = title;
		
	}
	
}
//getClass() => 클래스 타입 (패키지명 클래스명을 찾는 경우)
// => 객체 생성 => 복제 => 소멸
public class 라이브러리_Object_5_1 {
	public static void main(String[] args) {
//		ArrayList<Movie> list = new ArrayList<Movie>();
//		list.add(new Movie(1, "홍길동전"));
//		list.add(new Movie(2, "심청전"));
//		
//		Movie m1=list.get(0);
//		Movie m2 = list.get(1);
//		System.out.println(m1.getTitle());
//		System.out.println(m2.getTitle());
		
		Movie m1 = new Movie(1, "홍길동전");
		System.out.println(m1.getClass());//데이터형 불러오는
		String s="";
		System.out.println(s.getClass());
		System.out.println(m1.getTitle().indexOf("길"));
		
	}
	
}
