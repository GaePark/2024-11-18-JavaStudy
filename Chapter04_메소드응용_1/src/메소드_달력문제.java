import java.util.*;

public class 메소드_달력문제 {
	//알고싶은 년도 입력
	static int input(String s) {
		Scanner scan = new Scanner(System.in);
		System.out.print(s + " 입력:");
		return scan.nextInt();
		
	}
	//요일 출력
	static int week(int year, int month,  int[] lastday) {
		//1. ~전년도까지 총날수
		int total=(year-1)*365+
				       (year-1)/4 -
				       (year-1)/100+
				       (year-1)/400;

		if((year%4==0&&year%100!=0) || (year%400==0)) 
			lastday[1]=29;
		else
			lastday[1]=28;
		for(int i=0;i<month;i++) {
			total+=lastday[i];
		}
		total++;
		
		int week=total%7;
		return week;
		
		        
		
	}
	// 달력 출력
	static void calendar(char[] strWeek,int[] lastday, int week,int month) {
		for(int i=0; i<strWeek.length;i++) {
			if(i==0)
			System.err.print(strWeek[i]+ "\t");
			else
				System.out.print(strWeek[i]+ "\t");
		}
		System.out.println();
		for(int i =1; i<=lastday[month];i++) {
			if(i==1)//for문 시작
			{
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}

				System.out.printf("%2d\t",i);//출력
				
			week++;//요일변경
			if(week>6) {
				week=0;
				System.out.println();//다음줄에 출력
			}
		}
	}
	
	
	static void process() {
		char strWeek[] = {'일','월','화','수','목','금','토'};
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		int year = input("년도");
		int month = input("달")-1;
		int week = week(year, month,lastday);
		System.out.println();
		System.out.println(year + "년 " + (month+1)+"월 달력");
		calendar(strWeek,lastday,week,month);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
