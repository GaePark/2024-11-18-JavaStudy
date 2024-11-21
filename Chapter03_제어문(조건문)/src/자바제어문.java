/*
 * 자바에서 지원하는 제어문
 *    => 프로그램의 흐름 변경 (흐름제어)
 *       1) 필요시에는 건너뛰는 프로그램을 만들 수 있다.: 조건문
 *       2) 반복수행 : 반복문
 *       3) 중간에 정지 :반복 제어문 => ESC
 * = 조건문
 *    => 단일 조건문
 *        => 마우스를 클릭 / 버튼 클릭 / 상세보기
 *    => 선택 조건문 : true/false를 나눠서 처리
 *    => 다중 조건문 :
 *        => 메뉴
 * = 선택문
 *     => switch~case : 값을 1개만 선택해서 처리
 *     => 게임 : 키값에 따라 처리
 * = 반복문
 *     => while
 *     => do~while
 *     => for
 * = 반복제어문
 *     => break
 *     => 특정부분을 제외 : continue
 *     
 * ===> 배열 / 메소드
 *      ==> 변수/연산자/제어문
 * ===> 객체지향 프로그램
 * 
 * 1. 조건문 : 54page
 *     1) 자바
 *        => 형식
 *        => 코딩 순서 , 동작 순서
 *        => 활용
 *        => 응용
 *        
 * 2. 단일조건문
 *    ******* 자바의 모든 제어문은 바로 밑에 있는 문장 1개만 수행한다.
 *    
 *    여러개를 동시에 제어할때는 {}을 활용한다.
 *    if(조건문)
 *    	문장1 ==> if에서 제어하는 문장
 *      ========
 *    	문장2
 *    	문장3
 *      ======== 별도의 문장
 *      
 *    if(조건문)
 *    {
 *    	문장1
 *    	문장2
 *    	문장3 ==> 3문장이 동시에 제어
 *    }
 *    형식)
 *          ㅣ => 연산자 : 부정연산자 / 비교연산자 / 논리연산자
 *          ㅣ => 결과잢이 true/ false만 나와야한다.
 *      if(조건문) 조건이 false면 =< 건너뛴다.
 *      {
 *      	실행문장 ==> 조건이 true일때만 수행
 *      }
 *      
 *      => 단점 : 여러개 사용시에 모든 if문의 조건을 확인
 *    
 *    
 *    1~100 
 *    3배수 15 21
 *    5배수 15
 *    7배수 21
 *    
 *    
 *    
 *    
 *    
 */
public class 자바제어문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 88;
		// 여러문장 동시에 제어 => {}
		if(score >=60) //true => 실행   false => 건너뛴다. 
			System.out.println("합력입니다.");
		
		System.out.println("프로그램 종료!!");// if문과 관련없는 문장 => 실행문장
		
		
	}

}
