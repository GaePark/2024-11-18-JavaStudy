import java.util.Scanner;
//C/C++ => include, C# => using, python import => from
// => 라이브러리, 사용자 정의 클래스 (다른 폴더에 있는 경우)
//                              --------패키지
/*
 * 자바의 기본 형식
 * package 위치 지정 => 한번만 사용이 가능
 * import ... => 여러번 사용이 가능
 * => 모든 프로그램은 main을 한개 이상을 가지고 있어야 한다.
 * public class ClassName => ClassName.java
 * {
 *     =======================
 *        맴버변수 => 전역변수
 *     =======================
 *        생성자 () => 맴버변수 초기화
 *     =======================
 *        사용자 정의 메소드
 *     =======================
 *        main() =>
 *     =======================
 * 
 * }
 * class ClsName1
 * {
 * }
 * 
 * 
 * 
 */

public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번
		System.out.println("1번");
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세요");
		int score = scan.nextInt();
		switch(score/10) {
		case 10: case 9:
			System.out.println("A입니다");
			break;
		case 8:
			System.out.println("B입니다");
			break;
		case 7:
			System.out.println("C입니다");
			break;
		case 6:
			System.out.println("D입니다");
			break;
			default:
				System.out.println("F입니다.");
		}
		
		//2번
		System.out.println("2번");
		System.out.print("첫번째 정수 입력:");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수 입력:");
		int num2 = scan.nextInt();
		
		System.out.print("+,-,*,/: ");
		
		switch(scan.next()) {
		case("+"):
			System.out.println(num1+num2);
			break;
		case("-"):
			System.out.println(num1-num2);
			break;
		case("*"):
			System.out.println(num1*num2);
			break;
		case("/"):
			if(num2 != 0) {
				System.out.println(num1/(double)num2);
				break;
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			}
		default:
			System.out.println("잘못입력했습니다.");
		}
		
		//3번
		System.out.println("3번");
		int a2 = 0;
		for(int i = 2; i<=100; i+=2) {
			a2+=i;
		}
		System.out.println(a2);
		
		//4번
		System.out.println("4번");
		for(int i = 5; i<=50; i+=5)
		{
			if(i>45)
				System.out.print(i);
			else	
				System.out.print(i + ",");
		}
		System.out.println();
		
		//5번
		System.out.println("5번");
		for(char i ='B'; i<='N'; i+=2)
			System.out.print(i + " ");
		System.out.println();
		
		//6번
		System.out.println("6번");
		System.out.print("한개의 정수를 입력하세요");
		int num3 = scan.nextInt();
		int te = 0;
		for(int i=1; i<=num3; i++) {
			te+=i;
		}
		System.out.println(te);
		
		//7
		System.out.println("7번");
		for(int i=2; i<=30; i+=2) {

			System.out.printf("%02d\t",i);
			if(i%3==0) {
				System.out.println();
			}
		}
		System.out.println();
		
		//8
		System.out.println("8번");
		int test = 0;
		for(int i=1; i<=10; i++) {
			if(i%2==1) {
				test+=i;
			} else {
				test-=i;
			}
		}
		System.out.println(test);
		
		//9번
		System.out.println("9번");
		for(int i=1; i<=10; i++) {
			if(!(i%3==0))
				System.out.print(i + " ");
		}
		
	}
}
