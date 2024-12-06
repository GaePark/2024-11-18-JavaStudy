/*
 * 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
 */
import java.util.*;
public class 메소드_3 {
	// 사용빈도가 많을 수 있다. => 예약 / 개인 일정 .....
	// => 재사용
	static boolean isYear(int year) {
		boolean bCheck=false;
		if((year%4==0 &&year%100!=0)||year%400==0)
			bCheck = true;
		
		return bCheck;
	}
	static void maxPrint(int a, int b) {
		//Math.max(a,b)
		System.out.println(a>b?a:b);//삼항연산자
	}
	static void print(int a) {
		System.out.println(a%2==0?"짝수":"홀수");
	}
	
	static char weekData(int year, int month, int day)
	{
//		char c=' ';
		char[] strWeek= {'일','월','화','수','목','금','토'};
//		//1. 1년도 1월 1일 ~~ 전년도까지의 총날수
//		int total=(year-1)*365
//				      +(year-1)/4
//				      -(year-1)/100
//				      +(year-1)/400;
//		//2. 전달까지의 총날 수
//		int[] lastday = {31,28,31,30,31,30,31,31,30,31,30,31};
//		if(isYear(year))
//			lastday[1]=29;
//		else
//			lastday[1]=28;
//		for(int i=0; i<month-1;i++)
//		{
//			total+=lastday[i];
//		}
//		//3. 입력된 일
//		total+=day;
//		//-------------------------총합 %7
//		int week=total%7;
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month-1);
		cal.set(Calendar.DATE,day);
		
		int week =cal.get(Calendar.DAY_OF_WEEK);
		
		return strWeek[week-1];
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		System.out.print("년도 입력:");
//		int year = scan.nextInt();
//		
//		boolean bCheck=isYear(year);
//		if(bCheck==true)
//			System.out.println(year+"년도는 윤년입니다.");
//		else
//			System.out.println(year + "년도는 윤년이 아닙니다.");
//		System.out.print("a를 입력하세요:");
//		int a = scan.nextInt();
//		System.out.print("b를 입력하세요:");
//		int b = scan.nextInt();
//		
//		maxPrint(a,b);

//		System.out.println("정수를 입력하세요");
//		int a = scan.nextInt();
//		print(a);
		System.out.print("년 월 일을 입력(2024 11 20):");
		int year=scan.nextInt();
		int month=scan.nextInt();
		int day=scan.nextInt();
		
		char c=weekData(year,month,day);
		System.out.println("========결과값========");
		System.out.println(year + "년도 " + month + "월 " + day + "일은 " +c+"요일입니다.");
		
	}
}

