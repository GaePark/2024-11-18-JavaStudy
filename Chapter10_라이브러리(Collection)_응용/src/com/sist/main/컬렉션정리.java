package com.sist.main;
/*
 * DAO => 오라클연결 , Manager => 파일읽기
 * --------------------------------------------
 * => 예외처리
 * => 사용자 정의 데이터형 => VO => 캡슐화
 * => 멤버변수 / 상수 / static
 * => 메소드
 *       ------ 리턴형 / 매개변수
 *                ------   -------- 사용자가 보내 준값
 *                결과값 =>
 *                              1. 목록 ===> List
 *                              2. 상세보기 => VO
 *                              3. 총페이지 => int
 *                              -------------------
 *      컬렉션
 *      ------ IO => 2차 (문법 => 형식) => DAO (웹)
 *                                                          ----------- JSP / Spring
 * 컬렉션 (Collection)
 *     => 배열 (고정적) => 데이터추가 => 새로운 배열
 *         => 동적 배열 => 저장 갯수 확인
 *         ------------------------------- 가변
 *     => 많은 데이터를 저장 할 수 있다
 *     => 표준화 => 개발자 모두가 같은 코딩을 한다
 *     => 단점 : 모든 데이터를 저장할 수 있다
 *                    ---------- 데이터형이 틀린 경우도 있다
 *                    => 형변환 / 제어문이 어렵다
 *                    => 같은 데이터만 첨부 => 배열
 *                          ----------------
 *                          명시적 => 어떤 데이터가 들어가는지 알려준다
 *                          ------
 *                          제네릭 => List<String> : 가독성이 좋다
 *                          ==> 저장되는 모든 데이터가 통일된다
 *                     Colletion(CRUD) => 자료구조
 *                          ㅣ
 *             ----------------------------
 *             l              l                      l
 *         List           Set                  Map
 *     =ArrayList   =HashSet        =HashMap
 *     l단순한 목록     ㅣ장바구니           ㅣ관리(클래스 관리, 회원관리) key value
 *                           중복이 없는데이터
 *    List
 *        **add() : 추가
 *        remove() : 삭제
 *        set() : 수정
 *        ***get() : 데이터 가져오기
 *        isEmpty() : 데이터가 있는지
 *        ***clear() : 전체 삭제
 *        ***size() : 저장 갯수
 *    
 *    Set
 *        **add() : 추가
 *        remove() : 삭제
 *        **isEmpty()
 *        **clear()
 *        **size()
 *        
 *    Map
 *        put() : 추가
 *        get() : 값읽기
 *        isEmptyis()
 *        clear()
 *        size()
 *        keySet()
 *        values(): 저장된 값
 *    ---------------------------------------
 *    복사 => addAll() : Set / List
 *    교집합 => retainAll()
 *    차집합 => removeAll()
 *    --------------------------------------
 *    
 *    java.lang
 *        Object / String / StringBuffer
 *        Wrapper / System / Math
 *    java.util
 *         Date / Calendar / StringTokenizer
 *         ArrayList / HashSet / HashMap
 *    java.text
 *        SimpleDateFormat => 날짜 변환
 *        DecimalFormat => 숫자 변환
 *    ------------여까지 배움
 *    ***java.io : 파일 입출력 => 다운로드 / 업로드
 *    ***java.sql : 데이터베이스 입출력
 *    java.net : 네트워크 입출력 => 인코딩 들어가있음
 *                   => 웹(네트워크) => 한글변환 UTF-8
 *                         ? => 인코딩방법 공부해야함
 *    
 */
import java.util.*;
public class 컬렉션정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add("aa");
		list.add(10);
		list.add('A');
		list.add(120.5);
		list.add("aa");
		list.add(10);
		list.add('A');
		list.add('A');
		list.add(120.5);
		

	}

}
