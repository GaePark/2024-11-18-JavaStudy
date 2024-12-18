package com.sist.exception;

import java.util.Scanner;

public class 예외처리_멀티예외처리_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 정수 입력:");
			String num1 = scan.next();
			
			System.out.print("두번째 정수 입력:");
			String num2 = scan.next();
			
			//정수변환
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			
			System.out.println(n1/n2);
			
		}
		catch(NumberFormatException | ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
		
//		catch (NumberFormatException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		} catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
	}

}
