package com.sist.main;
import java.util.*;
public class 컬렉션_5_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		
		names=new LinkedList<String>();
		
		names = new Vector<String>();
		
		//인터페이스 => MyBatis / JPA => 리턴형 => List
		//데이터를 모아서 순차적으로 접근 => 크롤링
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Oracle");
		list.add("HTML");
		list.add("JavaScript");
		list.add("JSP");
		list.add("Spring");
		list.add("Python");
		list.add("ElasticSearch");
		list.add("AWS");
		
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("===================");
		//데이터 모아서 순차적으로 출력
//		Iterator<String> iter = list.iterator(); // Set or Map에서 사용
//		while(iter.hasNext()) {
//			System.out.println(iter.next()); //데이터를 가져오는 함수
//		}
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("=================");
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		//next()로  읽으면 두번 읽지 못한다
//		while(iter.hasNext()) {
//			System.out.println(iter.next()); //데이터를 가져오는 함수
//		}
		
	}

}
