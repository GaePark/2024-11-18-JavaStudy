package com.sist.execute;

import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// => A=1,B=2,C=3,D=4
		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호 입력:");
		int num = scan.nextInt();
		I[] i = {null, new A(), new B(), new C() , new D()};
		//
		i[num].execute();
		
//		if(num==1) {
//			A a = new A();
//			a.execute();
//		} else if(num ==2) {
//			B a = new B();
//			a.execute();
//		} else if(num ==3) {
//			C a = new C();
//			a.execute();
//		}else if(num ==4) {
//			D a = new D();
//			a.execute();
//		} else {
//			System.out.println("잘못입력함");
//		}



	}
}
