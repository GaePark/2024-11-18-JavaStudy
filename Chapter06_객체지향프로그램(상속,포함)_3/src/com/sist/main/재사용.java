package com.sist.main;

import java.util.ArrayList;

/*
 * 포함 : has-a : 클래스안에 클래스를 포함
 * --------------------------------------- 클래스 크기
 * 객체 전체가 4byte를 가지고 있따
 * => 형변환
 *      ------
 *         자동 형변환 (묵시적 형변환)
 *         상위클래스 객체 = new 하위클래스생성자()
 *         double d=10 => 10.0;
 *         ----------------------------------------
 *         => 라이브러리는 클래스를 리턴할 경우
 *               -----------------------------------
 *                            ㅣObject / 메개변수가 Object
 *                            ㅣCollection
 */
class Sawon{
	String name, dept, loc;
	
	public void display() {
		System.out.println("이름:" + name);
		System.out.println("부서:" + dept);
		System.out.println("근무지:" + loc);
	}
}
public class 재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Sawon> list  = new ArrayList<Sawon>();
		Sawon s1=new Sawon();
		s1.name = "홍길동";
		s1.dept = "개발부";
		s1.loc = "서울";
		list.add(s1);
		
		Sawon s= list.get(0);
		s.display();
	}

}
