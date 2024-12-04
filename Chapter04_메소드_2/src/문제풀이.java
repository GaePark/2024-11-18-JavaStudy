import java.util.Calendar;
import java.util.Scanner;

public class 문제풀이 {
	//1. 1-10까지 출력하는 메소드를 구현하시오
	static void test1() {
		System.out.println("1번");
		for(int i=1;i<=10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	//2. 1~10까지 합을 구하는 메소드를 구현하시오
	static int test2() {
		int a=0;
		for(int i=1; i<=10;i++) {
			a+=i;
		}
		return a;
	}
	
	//3. 1~n까지 합을 구하는 메소드를 구현하시오
	static int test3(int c) {
		int a=0;
		for(int i=1; i<=c; i++) {
			a+=i;
		}
		return a;
	}
	//4 두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
	static String test4(int a, int b) {
		String s = String.valueOf(a/(double) b);
		return s;
	}
	//문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오

	static String test5(String s) {
		return s.toUpperCase();
	}
	
	//문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
	static boolean test6(String s) {
		boolean result = false;
		if(s.length()%2==0) {
			for(int i=0; i<s.length()/2-1;i++) {
				result = true;
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					result=false;
					break;
				}
			}
		}
		return result;
	}
	//7. 문자열을 거꾸로 출력하는 메소드를 구현하시오
	// 거꾸로 출력하는 라이브러리
	//new StringBuilder(s).reverse()
	static void test7(String s) {
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	//8. 학점을 구하는 메소드를 구현하시오
	static char test8(int a) {
		int b = a/10;
		if(b ==10 || b==9) {
			return 'A';
		} else if(b==8)
			return 'B';
		else if(b==7)
			return'C';
		else if(b==6)
			return 'E';
		else
			return 'F';
				
	}
	static boolean test9(int a) {
		if((a%4==0 && a%100 !=0)||(a%400==0)) {
			return true;
		}
		return false;
	}
	//두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
	static void test10(int a, int b) {
		if(a>b)
			System.out.println(a);
		else
			System.out.println(b);
	}
	//입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
	static String test11(int a) {
		if(a%2==0)
			return "짝수";
		else
			return "홀수";
	}
	//3의 배수를 판별하는 메소드를 구현하시오
	static boolean test12(int a) {
		if(a%3==0)
			return true;
		return false;
	}
	//년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
	static char test13() {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력: ");
		int yyyy = scan.nextInt();
		System.out.print("월 입력: ");
		int mm = scan.nextInt();
		System.out.print("일 입력: ");
		int dd = scan.nextInt();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, yyyy);
		cal.set(Calendar.MONTH, mm-1);
		cal.set(Calendar.DATE, dd);
		
		char[] strWeek= {' ','일','월','화','수','목','금','토'};
		int week = cal.get(Calendar.DAY_OF_WEEK);
		return strWeek[week];
	}
	
	//메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요
	static StringBuilder test14(int a) {
		String b= String.valueOf(a);
		return new StringBuilder(b).reverse();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		System.out.println(test2());
		test3(5);
		System.out.println(test4(10, 9));
		System.out.println(test5("Java Script"));
		System.out.println(test6("teet"));
		test7("Java");
		System.out.println();
		System.out.println(test8(60));
		System.out.println(test9(2011));
		test10(14,10);
		test11(10);
		test12(9);
		System.out.println(test13());
		System.out.println(test14(156156));
		
	}

}
