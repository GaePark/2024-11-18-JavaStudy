/*
 * 중첩 조건문
 *    3개의 점수를 받아서 총점, 평균, 학점
 *        => 97이상 A+, 94이상 A0, 90이상 A-,
 */
import java.util.Scanner;
public class 제어문_조건문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 점수 입력:");
		int kor = scan.nextInt();
		
		System.out.print("영어 점수 입력:");
		int eng = scan.nextInt();
		
		System.out.print("수학 점수 입력:");
		int math = scan.nextInt();
		
		//총점 구하기
		int total = kor+eng+math;
		//평균
		double avg = total/3.0;
		//학점 구하기
		char score = 'A',opt = '+';//초기화
		// -->A~F    --> +,0,-
		int avg2=(int) avg;
		//avg2 => 100
		if(avg2>=90 && avg<=100) {
			score = 'A';
					if(avg2>=90 && avg2<=100)
						opt='+';
					if(avg2>=94 && avg2<97)
						opt='0';
					if(avg2<94)
						opt='-';
		}
		if(avg2>=80 && avg<90) {
			score = 'B';
					if(avg2>=87 && avg2<90)
						opt='+';
					if(avg2>=84 && avg2<87)
						opt='0';
					if(avg2<84)
						opt='-';
		}
		if(avg2>=70 && avg<80) {
			score = 'C';
					if(avg2>=77 && avg2<80)
						opt='+';
					if(avg2>=74 && avg2<77)
						opt='0';
					if(avg2<64)
						opt='-';
		}
		if(avg2>=60 && avg<70) {
			score = 'D';
					if(avg2>=67 && avg2<70)
						opt='+';
					if(avg2>=64 && avg2<77)
						opt='0';
					if(avg2<64)
						opt='-';
		}
		if(avg2<60) {
			score = 'F';
		}
		System.out.println("===== 결과값 =====");
		System.out.println("국어 점수:" + kor);
		System.out.println("영어 점수:" + eng);
		System.out.println("수학 점수:" + math);
		System.out.println("총점:" + total);
		System.out.printf("평균: %.2f\n", avg);
		System.out.println("학점:"+score+""+opt);
		
	}

}
