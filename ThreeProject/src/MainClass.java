/*
 * 1. 자바 설치
 * path : c:\jdk-17.0.2\bin ==> java/javac
 * classpath: 자바에서 지원하는 라이브러리를 사용
 * 				.;c:\jdk-17.0.2\lib
 * 				==> .은 현재 폴더
 * 
 * 2. 이클립스 사용법
 * 		1) File => new => JavaProject
 * 		2) src안에 자바 파일 생성
 * 		
 * 		변수 / 연산자 / 제어문 / 배열
 * 		public class ClassName {
 * 			프로그램의 시작
 * 			public static void main(String[] args)
 * 			{
 * 					//시작 => 코딩
 * 			}
 *		 }
 * 
 * 		3) GIT
 * 			=> team => shareProject
 * 			=> team => commit
 * 
 * 자바 실행
 * ======
 * ** 면접문제1 //컴파일과 인터프리터의 차이
 * 컴파일
 *  => 파일 => 기계언어로 변경 (컴퓨터가 인식하는 언어)
 *     Java / C# / C / C++
 *     인터프리터 : 한줄씩 읽어서 출력
 *     			 HTML / JAVA ....
 *     
 * A.java ===== A.class ===== 화면에 출력
 * 		  javac			java
 * 				0101000001001
 * public class MainClass { 25페이지 참조
 * }
 * 
 * 1995년 5월 23일 자바 탄생
 */

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java!!");
	}

}