/*
 * 3개의 정수를 받아서 평균/ 총점을  전송하는 메소드
 * 1. 입력
 * 2. 처리 => 평균 / 총점
 *     => 세분화
 * 3. 출력
 * 
 * => 객체지향 => 1) 메소드 , 2) 변수
 */

import java.util.*;
public class 메소드_5 {
	static void total(int[] a) {
		int total = 0;
		for(int i : a) {
			total+=i;
		}
		double avg = total/(double) a.length;
		
		System.out.println("총점: " + total);
		System.out.printf("평균: %.2f ", avg);
		
	}
	static void process () {
		int[] num = new int[3];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<num.length;i++) {
			System.out.print(i+1+"번째 숫자를 입력하세요");
			num[i]=scan.nextInt();
		}
		total(num);
	}
	
	// 절차적 언어 => 한번 사용후 폐기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3개의 정수 받기
		// 평균
		// 총점
		// 출력
		process();
	}

}
