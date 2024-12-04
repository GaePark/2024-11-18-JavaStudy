// 사칙연산자 ==> 4개의 메소드
// 회원가입 - 회원탈퇴
import java.util.*;
public class 메소드_2 {
	// 1) 리턴형 / 매개변수 => o
	// + 
	static int plus(int a, int b) {
		int result = a+b;
		return result;
	}
	//-
	static int minus(int a, int b) {
		int c=a-b;
		return c;
	}
	static int multiply(int a, int b) {
		int c=a*b;
		return c;
	}
	static String divide(int a, int b) {
		String result = "";
		if(b==0)
			result = "0으로 나눌 수 없다.";
		else
			result=String.valueOf(a/(double)b);
		return result; // 리턴형에 선언된 데이터형과 일치
	}
	//조립 => 다른 클래스에서 사용이 가능
	static void process() {
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수 입력");
		int num2 = scan.nextInt();
		
		System.out.print("연산자 입력(+,-,*,/): ");
		String op = scan.next();
		
		//switch , 다중조건문
		if(op.equals("+")) {
			System.out.println(num1 + "+"+num2+"="+plus(num1,num2));
		}
		else if(op.equals("-"))
		{
			System.out.println(num1 + "-"+num2+"="+minus(num1,num2));

		}
		else if(op.equals("*"))
		{
			System.out.println(num1 + "*"+num2+"="+multiply(num1,num2));

		}
		else if(op.equals("/"))
		{
			System.out.println(num1 + "/"+num2+"="+divide(num1,num2));

		}
		else {
			System.out.println("연산자가 잘못되었습니다.");
		}
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
