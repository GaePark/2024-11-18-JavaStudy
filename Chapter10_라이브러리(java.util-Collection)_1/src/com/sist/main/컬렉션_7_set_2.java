package com.sist.main;
import java.util.*;
public class 컬렉션_7_set_2 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();// => 일반 클래스
		// Set set = new HashSet() => 인터페이스
		// 1. 저장 => add()
		// 2. 콤보박스 => 부서명 / 장르 / 검색 ....
		// 근무지
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		//실제 저장은 5개만 저장됨
		System.out.println("실제 저장"+set.size());
//		Iterator<String > iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		//람다식
		set.forEach(name->System.out.println(name));
		// 저장된 데이터 출력
//		for(String color: set) {
//			System.out.println(color);
//		}
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(set);
		System.out.println(list.size());
		for(String color: list) {
			System.out.println(color);
		}
		// 삭제
		System.out.println("===== 삭제 =====");
		set.remove("yellow");
		System.out.println("실제 저장"+set.size());
		// 저장된 데이터 출력
		for(String color: set) {
			System.out.println(color);
		}
		System.out.println("===== 전체 삭제 =====");
		set.clear();
		System.out.println("실제 저장"+set.size());
		// 저장된 데이터 출력
		for(String color: set) {
			System.out.println(color);
		}
		
		if(set.isEmpty()) {
			System.out.println("비워있음");
		} else {
			System.out.println("ㄴㄴ 있음");
		}

	
	}
}
