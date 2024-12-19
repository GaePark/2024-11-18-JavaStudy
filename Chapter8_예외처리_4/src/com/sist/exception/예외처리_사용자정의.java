package com.sist.exception;

import java.util.Scanner;

// 사용자 정의 예외처리 => 호출 => throw
// => 1. 기존에 만들어져 있는 예외처리 , 사용자 정의는 찾지 못한다

class MyExceotuib extends Exception{
	public MyExceotuib(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
public class 예외처리_사용자정의 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("점수 입력");
			int score = scan.nextInt();
					if(score<0 || score>100) {
						throw new MyExceotuib("잘못된 입력");
					}
				} catch (MyExceotuib e) {
					System.out.println(e.getMessage());
			// TODO: handle exception
		}

	}

}
