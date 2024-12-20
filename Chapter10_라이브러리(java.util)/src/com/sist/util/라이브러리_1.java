package com.sist.util;
/*
 * java.lang : 자바 기본이 되는 클래스의 집합
 * ---------- Object / String / StringBuffer
 *                Math/Wrapper(Integer/Double/Boolean)
 * java.util : 프로그램에서 많이 사용되는 유용한 클래스의 집합
 *     => 반드시 import를 사용한다
 *     1) 날짜
 *         Date => Calendar(보완해서 처리)
 *         -----       ------------------------
 *     2) 무자열 분리
 *         StringTokenizer : split => 정규식 => split은 정규식을 사용해야하고 StringTokenizer은 정규식 없이 분리가 가능하여 좀더 편함
 *     3) 랜덤
 *         Random
 *     4) Collection => 자료 구조 => 배열 사용안함
 *             Collection
 *                  l
 *      --------------------------
 *      l                l                  l
 *    List           Set              Map
 *      l                l                  l
 *                                    ***HashMap / Hashtable
 * **ArrayList      ***HashSet/TreeSet 
 * LinkedList-Queue
 * Vector
 * java.io : 입출력 (메모리 / 네트워크 / 파일)
 * java.net : 네트워크 (Socket,URL)
 * java.text : 변환 (문자열 , 날짜 ,숫자)
 * java.lang.reflect : 정규식
 * java.sql : 데이터베이스 연동
 * ---------------------------------------------------------
 * 웹 / 오픈 소스 (외부 라이브러리)
 *             org / com
 * 
 * Collection List를 사용하면 자동으로 인덱스가 늘어나고 줄어든다
 * list.add("a") 0
 * list.add("a") 1
 * list.add("a") 2
 * list.add("a") 3
 * list.add("a") 4
 * 
 */
import java.util.*;
// Scanner(X)
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r= new Random();
		/*
		 * r.nextInt() => int 전체
		 * r.nextInt(100) => 0~99
		 *               ----- 100 제외
		 * Math.random() 이제 사용 안함
		 */
//		int i=r.nextInt(100)+1;
//		System.out.println(i);
		//게임 / 예약일 
		int[] com = new int[6];
		for(int i=0;i<com.length;i++) {
			com[i]=r.nextInt(45)+1;
			//nextInt(int bount) => 범위지정
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(com); // 배열에 대한 제어
		// => java.util
		// => ORDER BY no DESC(또는 ASC) => SQL명령어
		// => 50:50;
		// => 자바라이브러리 / 오라클라이브러리 반반사용하면서 웹을 제작해야한다
		for(int i: com) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=com.length-1;i>=0;i--) {
			System.out.print(com[i] + " ");
		}
	}

}
