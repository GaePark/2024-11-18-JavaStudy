package com.sist.main;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 제네릭 / 어노테이션 / 열거형 / 리플렉션
//            ---------------------------- JSP (웹)

@Data
@AllArgsConstructor //매개변수가 있는 생성자
@NoArgsConstructor// 매개변수가 없는 생성자
class Member {
	private int mno;
	private String name,sex,address,phone;
}
public class 제네릭_Collection_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		for(int i=0; i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("홍길동");
//		list.add("심청이");
//		list.add("강감찬");
//		
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member(1,"홍길동","남자","서울","010-1111-1111"));
		list.add(new Member(2,"심청이","여자","경기","010-2222-2222"));
		list.add(new Member(3,"강감찬","남자","인천","010-3333-3333"));
		list.add(new Member(4,"이순신","남자","강원","010-4444-4444"));
		list.add(new Member(5,"김문수","남자","부산","010-5555-5555"));
		
		System.out.println("인언 수: "+list.size());
		for(Member i : list) {
			System.out.println("번호: "+i.getMno());
			System.out.println("이름: "+i.getName());
			System.out.println("성별: "+i.getSex());
			System.out.println("주소: "+i.getAddress());
			System.out.println("번호: "+i.getPhone());
			System.out.println();
		}
	}

}
