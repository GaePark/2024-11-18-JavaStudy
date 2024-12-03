/*
 * 변수 => 데이터를 모아서 관리 => 배열 / 클래스
 * 연산자 / 제어문
 * => 연산자 응용 => 제어문
 * =>제어문 응용 =>배열
 * => 배열 응용 => 메소드
 * => 메소드 => 클래스
 * => 클래스 => 라이브러리
 * -----------------------------------------------
 * => 처리하는 기능이 많은 경우 => 소스코딩이 많다
 *                                              -------------- 조립
 * 
 * 1. 문자열 => 웹, 윈도우 프로그램은 대부분 문자열로 만들어 진다
 *                    가장 많이 사용되는 데이터
 *                    문자 여러개를 모아서 저장
 *                    ---------- char[] => String
 * 2. String : 일반 데이터형 / 클래스형
 *     사용하는 방법
 *     = 일반 데이터형 (가장 많이 사용)
 *         String 변수명="";
 *     = 클래스형
 *         String 변수명 = new String("", "UTF-8")
 *         ---------------------------------- 한글변환 (브라우저 => char => 1byte)
	3) String의 디폴트는 nnull (주소가 없는 상태)
	    => 모든 클래스의 디폴트 => NullPointerExeption
	4) String 기능 (메소드)
	    ** String,Math,Scanner,System => final class
	                                                        -----------
	                                                        ㅣ 변경을 할 수 없다
	                                                        ㅣ 있는 그대로 사용
	                                                        ㅣ 표준화
	  ** Java.lang.* => import를 생략할 수 있다
	  = 변환
	      toUpperCase() : 대문자 변화
	      => 메소드
	            결과값 : String
	            매개변수 : X
	            메소드명 : toUpperCase
	            기능
	             => String toUpperCase() => 원형
	             => String name = toUpperCase
	      toLowerCase() : 소문자 변환
	      valueOf() : 모든 데이터형을 문자열로 변환
	           String ValueOf(int)
	           String ValueOf(char)
	           String ValueOf(double)
	                      ------- 오버로딩
	           
	      replace() : 문자, 문자열 변환
	      replaceAll() : 패턴을 이용한 문자열 변환    
	                          ------------ regex(정규식)
	  = 문자 분해
	     substring() : 문자를 자르는 경우
	     split() : 단여별로 나눠서 배열 저장
	     
	  = 비교
	      equals() : 같은경우 true
	      startsWith() : 시작하는 문자열이 같은 경우
	      endsWith() : 끝나는 문자열이 같은 경우
	      ***contains() : 포함되어 있는 경우
	      => 주로 if문에서 사용
	      
	  = 위치찾기
	     *** indexOf() : 앞에서부터 찾기 
	      ***lastIndexOf() : 뒤에서부터 찾기
	      
	  = 문자열 결합
	     concat() : 문자열 결합
	         +       : 문자열 결합
	  
	  = 기타
	      ***trim() : 좌우 공백 제거
	      charAt() : 문자의 위치 => 문자읽기
	      toCharArray() : String을 char[]로 변경
	 
	 => 문자열 배열
	 형식) 
	      String[] arr = {"","","",""} => 명시적 초기화
	      String[] arr = split()
	      
 */
import java.util.Scanner;
public class 문자열배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언> 선언과 동시에 초기화
		Scanner scan  = new Scanner(System.in);
		String[] names= {"홍길동","심청이","박문수","이순신","강값찬"};
		System.out.print("이름 입력:");
		String name = scan.next();
;		for(String n: names) {
			if(n.contains(name))//   equals 같은 경우 / 대소문자 구분
					{
			System.out.print(n + " ");
					}
		}
		
	}

}
