package com.sist.exception;
import java.util.InputMismatchException;
/*
 * 임의 발생은 한개만 사용 => if문
 */
import java.util.Scanner;
public class 예외처리_임의발생_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("국어점수입력");
			int kor = scan.nextInt();
			if(kor<0 || kor>100) {
				throw new IllegalArgumentException("점수는 0이상 100이하");
			}
		} catch (IllegalArgumentException e) {
			// 매개변수에 전송값이 다른경우
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}

}
