import java.util.Scanner;

public class 자바제어문_문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//9번
		System.out.print("정수 입력:");
		int num1 = scan.nextInt();
		System.out.printf(num1>=0? "%d는(은) 양수\n": "%d는(은) 음수\n",num1);
		//10번
		System.out.print("정수 입력: ");
		int num2 = scan.nextInt();
		System.out.printf(num2%3==0 ?"%d는(은) 3의배수 입니다.\n": "%d는(은) 3의 배수가 아닙니다.\n",num2);
		//11번
		System.out.print("2자리 수 정수 입력(10~99):");
		int num3 = scan.nextInt();
		int num4 = num3/10;
		int num5 = num3%10;
		System.out.println(num3);
		System.out.println(num4==num5? "10자리와 1자리가 같습니다.": "10자리와 1자리가 같지 않습니다.");
		System.out.println(num3%11==0? "10자리와 1자리가 같습니다.": "10자리와 1자리가 같지 않습니다.");
		
		//12
		System.out.print("달을 입력하세요(1~12): ");
		int month = scan.nextInt();
		if(month>=3 &&month<=5)
			System.out.println("봄");
		if(month>=6 &&month<=8)
			System.out.println("여름");
		if(month>=9 &&month<=11)
			System.out.println("가을");
		if(month==12 ||month==1 || month==2)
			System.out.println("겨울");
		
	}

}
