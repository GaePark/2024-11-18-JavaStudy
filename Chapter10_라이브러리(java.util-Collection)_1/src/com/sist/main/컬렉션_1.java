package com.sist.main;
/*
 * 335page
 *     자바컬렉션
 *     ----------
 *     1. 프로그램 => 데이터관리 (효율적)
 *                          ------------------
 *                          1) 스프링 / JSP(MVC) => 데이터관리
 *                              => 데이터베이스 (오라클,MySql)
 *                          2) VueJS/React/Next/Node
 *                              => 상태관리 (데이터가 변경시마다)
 *     2. 데이터베이스 : 데이터를 저장하는 공간
 *         ------------
 *         변수/상수 => 데이터 한개 저장 => 데이터가 많으면 관리가 힘듬
 *         ------------
 *         배열 => 고정적 / 데이터가 증가되면 다른 배열을 생성
 *         ------------
 *         *** 가변적 : 데이터가 증가되면 자동으로 메모리 공간 확장 => 컬렉션
 *         ----------------------------->메모리 공간 (데이터가 사라진다)
 *         ------------
 *         파일 => 종속적이다 다른 파일을 연결해서 사용하기 어렵다.
 *         ------------
 *         *** RDBMS => 오라클 (관계형 데이터베이스 => 연결성)
 *         ------------
 *         => 웹에서 가장 많이 사용되는 클래스 : ArrayList / String / Integer
 *         => ArrayList는 데이터를 메모리에 저장후에 브라우저로 전송
 *         => 웹은 대부분이 Map형식으로 반들어져 있따
 *               request / response / session / cokkie
 *                                                             -------- 브라우저에 저장
 *                                              --------- 서버에 저장
 *                             ----------- 응답
 *               --------요청
 * 1. Collection 개요
 *     => 배열의 단점을 보완한 클래스 (고정 => 가변)
 *     데이터를 효율적으로 저장하고 관리하기 위한 라이브러리
 *     표준화가 되어있다 (모든 개발자가 같은 메소드를 사용)
 *     ------- 개발이 쉽다
 *     ------- 프레임 워크 Mybatist/JPA
 *     ------- 장바구니 / 예약
 *     
 *     컬렉션은 저장 => Object만 저장 (객체만 저장)
 *                             --------------
 *                             최상위 데이터형 => 항상 형변환
 *                                                       -----------
 * 2. Collection 종류
 *     Interable
 *          l
 *     Collection
 *          l
 *     -----------------------------------
 *     l                         l                     l
 *  List                       set                 Map => interface
 *     l
 *  AccrayList          HashSet            HashMap
 *  Ventor               TreaeSet            Hashtable
 *  ListkedList                                        l
 *                                                     ProperTies => XML
 *                                                     
 * *** List=> 337페이지
 *     1) 순서가 존재( 자동으로 인덱스를 설정)
 *     2) 제이터 중복 허용
 *     3) 가장 많이 사용되는 컬렉션
 *     4) 비동기적인 방식
 *         => 데이터베이스 연결시 가장 잘 어울림 (오라클)
 *         => 접근 속도가 빠름
 *     5) 단점 : 데이터가 많은 경우에 추가 / 삭제 => 속도가 늦다
 *                    => 인덱스번호 조절
 *                    => 추갓에 마지마에 추가하는 것을 권장
 * => Vector => 보완 (Array List)
 *      => 동기적 => 네트워크 사용자 정보 저장
 * => LinkedList
 *           => 데이터에 접근하는 소도가 늦다
 *           => 추가 / 삭제가 빠르다
 *           => 게시판
 * =================List라는 인터페이스 구현 (메소드가 동일)
 * *** List list = new ArrayList : 데이터베이스 연동
 * 
 *  list = new LinkedList() : 파일 연동
 *  
 *  list =  new Vector() : 네트워크에서 주로 사용
 * 3. 제네릭스                                    
 * 4. 활용 => 크롤링 / 중복제거 / ArrayList와 ArrayList
 *                                          -----------------------
 *                                          1. 교집합 2. 차집합 3. 합집합
 *                                              => Intersect, Minus , Union
 *                                              => 자바 메소드로 되어 있다
 *                                              
 *                                              => 멜론 / 지니뮤직
 *                                                                  
 *                                          => 멜론 / 지니뮤직
 *                                ArrayList              LinkedList
 *                                -------------------------------
 * 데이터 접근 속도            빠름                       느림
 * 데이터 (추가/삭제)         느림                       빠름
 * 메모리 사용                  효율적                     비효율적
 * 구조                           배열기반                  연결리스트 기반
 *                                                              C언어 개발자 => 자바
 *                -------------
 *                객체주소
 *                -------------
 * 
 *                                                             -------------
 *                                                             이전 객체 주소
 *                                                             -------------
 *                                                                 데이터
 *                                                             -------------
 *                                                             다음 객체 주소
 *                                                             -------------
 *                                                             
 *     ArrayList의 주요 메소드
 *     341page
 *     1) 데이터 추가
 *         add(Object obj)
 *         add(int index, Object obj) => 원하는 인덱스에 추가
 *     2) 저장된 갯수 : int size()
 *     3) 데이터 추출 => Object get(int index)
 *     5) 데이터를 삭제 => remove(int index)
 *     6 데이터를 수정 => set(int index, Object obj)
 *     ==> CRUD : 자료구조 (효율적으로 사용)
 *     ==> import를 사용한다
 *             java.util.ArrayList
 *     ==> List => 구현한클래스 변경이 쉽게 인터페이스를 이요하는 경우
 *             ----- Mybatis / JPA
 *     ==> 단점은 형변환
 *              Object => 최상위 클래스
 *                         => 데이터형중에 가장 큰 데이터형
 */
// ArrayList 사용법
import java.util.*;
public class 컬렉션_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		//경고 => 제네릭스 => 모든 return / 매개변수가 Object
		//추가
		list.add("홍길동");
		list.add("심청이");
		list.add("강감찬");
		list.add("김두한");
		list.add("박문수");
		
		//출력 => size() => get()
		System.out.println("현재 등록된 인원"+list.size());
		for(int i=0;i<list.size();i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
		System.out.println("===== 원하는 위치에 데이터 추가 =====");
		
		list.add(2,"쿠쿠");
		System.out.println("현재 등록된 인원"+list.size());
		for(int i=0;i<list.size();i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
		System.out.println("===== 삭제 =====");
		list.remove(3);
		System.out.println("현재 등록된 인원"+list.size());
		for(int i=0;i<list.size();i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
		// 인덱스번호는 자동 처리
		// => 오라클은 자동 처리가 안됨 (출력)
		System.out.println("===== 수정 =====");
		list.set(2, "크흠");
		System.out.println("현재 등록된 인원"+list.size());
		for(int i=0;i<list.size();i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
		System.out.println("===== 전체 삭제 =====");
		list.clear();
		System.out.println("현재 등록된 인원"+list.size());
		
		System.out.println("===== 데이터 존재 여부 =====");
		if(list.isEmpty()) {
			System.out.println("저장공간이 비어있다.");
		}else {
			System.out.println("저장공간에 데이터가 존재합니다.");
		}
		/*
		 * 메소드
		 *     1) 데이터 추가 => add()
		 *     2) 데이터 갯수 => size()
		 *     3) 데이터 읽기 => get(int index)
		 *     4) 데이터 존재 여부 => isEmpty()
		 *     5) 데이터 수정 => set(int index, 데이터)
		 *     6) 데이터 삭제 => remove(int index)
		 *     7) 데이터 전체 삭제 => clear()
		 */
		

	}

}
