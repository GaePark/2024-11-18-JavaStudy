/*
 * 3명의 학생
 *   => 국어 영어 수학점수를 입력 받아서
 *   => 총점 / 평균 / 학점 / 등수
 */
import java.util.Scanner;
public class 배열응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [][] arr = new int [5][7];
		Scanner scan = new Scanner(System.in);
		final int INDEX = 3;
		int[] kor = new int[INDEX];//000
		int[] eng = new int[INDEX];// 1번/ 2번 / 3번 => 인덱스번호 일괄
		int[] math = new int[INDEX];
		
		int[] total = new int[INDEX];
		double[] avg = new double[INDEX];
		char[] score = new char[INDEX];
		int[] rank = new int[INDEX];
		
		for(int i=0;i<INDEX;i++) {
			System.out.print(i+1+"번 학생의 국어점수를 입력하세요");
			kor[i] = scan.nextInt();
			System.out.print(i+1+"번 학생의 영어점수를 입력하세요");
			eng[i] = scan.nextInt();
			System.out.print(i+1+"번 학생의 수학점수를 입력하세요");
			math[i] = scan.nextInt();
			
			total[i]=kor[i] + eng[i] + math[i];
			avg[i]= total[i]/3.0;
			
			switch(total[i]/30) {
			case 10: case 9: 
				score[i]='A';
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
					score[i]='F';
			}
		}
		
		for(int i=0; i<INDEX; i++) {
			rank[i] = 1;
			
			for(int j=0;j<INDEX; j++) {
				if(total[i]<total[j])
					rank[i]++;
			}
			
		}
		
		for(int i=0;i<INDEX;i++) {
			// 출력 서식을 만드는 메소드 => 원하는 스타일로 출력
			
			//-5d ==> 왼쪽 정렬 => 공백을출력 => 3자리
			// JDK 1.5이상에서만 사용이 가능 =>
			// C언어와 동일하게 => exe파일 => C언어에서 도입
			// 썬 => 순수하게 자바로만 라이브러리 추가
			// 오라클에서 자바인수 => C언어 => C언어로 변경이 되는 경향
			// 람다식 (함수 포인트) , NIO
			System.out.printf(i+1+"번 학생: %-5d%-5d%-5d%-7d%-7.2f%3c%5d등\n", kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);
		}
		
	}

}
