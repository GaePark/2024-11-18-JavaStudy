//국어, 영어, 수학점수 입력 => 평균 , 총점
/*
 * 변수 => 반드시 초기화 (값을 저장) => 사용
 *        ==================
 *        1. 임의로 설정
 *            int a=100;
 *        2. 사용자로부터 입력값을 받아서 처리
 *        	 Scanner
 *        3. 컴퓨터가 임의로 설정 => 난수 (랜덤)
 */

import java.util.Scanner;

public class 연산자_이항연산자_산술연산자_활용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner클래스를 메모리에 저장
		Scanner scan = new Scanner(System.in);
		//입력값을 받아서 => 변수에 저장
		//사용자 입력을 받는다
		System.out.print("국어, 영어, 수학 점수를 입력해주세요(ex: 90 90 90): ");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		//처리 ==> 결과값 출력
		System.out.println("=====결과값=====");
		System.out.println("국어점수는 " + kor + "점입니다.");
		System.out.println("영어점수는 " + eng + "점입니다.");
		System.out.println("수학점수는 " + math + "점입니다.");
		
		// + : 문자열 결합
		System.out.println("총점: "+ (kor + eng + math) );
		// 연산자의 우선 순위 변경
		System.out.printf("평균: %.2f",(kor+eng+math)/3.0);
		
		
	}

}
