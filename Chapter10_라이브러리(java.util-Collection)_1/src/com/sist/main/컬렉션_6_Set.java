package com.sist.main;

import java.util.HashSet;

import lombok.Data;

/*
 * Set
 * ---- 순서가 없다 / 중복허용을 하지 않는다 
 *       => List에서 중복을 제거하는 역할
 *       => 장르 / 회원명 / 장바구니
 *       => 오라클 : DISTINCT
 *                        ------------ 명령어
 *    ㅣ
 *   HashSet / TreeSet
 *   ---------   ---------
 *   ㅣ저장용        ㅣ 검색
 *   --------
 *   ㅣ웹채팅 => 
 *   ============================
 *   Set (인터페이스)
 *       1) 저장되는 순서가 없다
 *            ------------------ 출력이 다르게 나올수도 있다
 *       2) 중복된 데이터는 허용하지 않는다
 *       -----------------------------------------------
 *       3) HashSet / TeeSet
 *                           ------- 검색 속도가 빠르다
 *       4) 주요 메소드
 *           = add() => 객체 추가 (데이터 추가)
 *           = remove() => 삭제 => remove(Object ob)
 *           = isEmpty() => 데이터 저장 여부
 *           = size() => 데이터 저장 갯수
 *           = iterator() => 순차적으로 데이터를 읽을 경우
 *           = clear() => 모든 데이터 삭제
 *      5) List에서 중복된 데이터를 제거
 *      6) 일반 데이터 => 중복 제거
 *           객체 => 데이터값이 같은 경우에는 데이터를 제거하지 못한다.
 *                           
 */
@Data
//hashCode , equals => 오버라이딩
class Sawon2
{
	private int sabun;
	private String name;
	private String dept;
	
	public Sawon2(int sabun,String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}
}
public class 컬렉션_6_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Sawon2 s1 = new Sawon2(1, "홍길동", "개발");
		Sawon2 s2 = new Sawon2(1, "홍길동", "개발");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		if(s1.equals(s2)) {
			System.out.println("ㅇㅇ");
		}else {
			System.out.println("ㄴㄴ");
		}

	}

}
