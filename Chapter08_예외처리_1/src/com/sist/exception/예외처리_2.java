package com.sist.exception;
/*
 * 예외처리
 *     =>
 *     
 */


public class 예외처리_2 {

	public static void main(String[] args) {
//		try {
//			for(int i=1;i<=10;i++) {
//				int r=(int)(Math.random()*3);
//				
//				int a=i/r;
//				System.out.println("i="+i+", a="+a);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		
//		}
		for(int i=1;i<=10;i++) {
			try {
				int r=(int)(Math.random()*3);
				
				int a=i/r;
				System.out.println("i="+i+", a="+a);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
