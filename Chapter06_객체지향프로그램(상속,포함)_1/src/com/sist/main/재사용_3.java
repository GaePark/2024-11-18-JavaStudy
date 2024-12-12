package com.sist.main;

import java.util.ArrayList;

/*
 * 상속 : 이미 만들어진 클래스 재사용
 *           ------------------------ 기존의 클래스 (사용자 정의 , 라이브러리)
 * 포함 : 재사용
 *         상속 / 포함
 *         ----    ----
 *                    ㅣ 있는 그대로 사용
 *           ㅣ변경해서 사용
 *           ㅣ상속이 안되는 클래스 : final class
 *                                          -----------
 *                                          ㅣString , System, Scanner ...
 * 상속 : 상속을 내리는 클래스
 *          상속을 받는 클래스
 *                  => 유지보수가 편리하다
 *                  => 반복 제거
 *                  => 관리 용이
 *                  => 속도가 느리다
 *                  => 변경이 어렵다
 *                  => 소스를 볼 수 없기 때문에 가독성이 낮다
 *                  => 1) 가독성 2) 최적화
 *                  => 가급적이면 상속을 하지 않는다
 *                        => 웹 ,모바일
 * => 클래스 상속받아서 => 새로운클래스 (기존의 클래스 + 새로운 기능추가/변경)
 * 
 * => 소스를 줄일 수 있다
 * => 여러개 클래스 적용이 가능
 * => 필요시에는 변경해서 사용이 가능
 * => 윈도우 : 기존의 클래스 사용 => JFrame
 *       ------ ERP 
 *       ==> 스프링 => 자바기반 / 코틀린기반
 * => 메모리 => 상속받은 클래스가 크다
 *                      --------------------
 *       실제 크기 => 상속내리는 클래스가 크다
 *       
 *       *** 자바에서 가장 큰 클래스가 있다
 *             Object => 최상위 클래스
 *             => 리턴형 Object
 *             
 *      *** 어떤 클래스로 저장
 *             -----------------
 *             
 */
public class 재사용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		String name = list.get(0);
		System.out.println(name);

	}

}
