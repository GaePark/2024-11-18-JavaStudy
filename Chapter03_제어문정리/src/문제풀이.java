import java.util.Scanner;
import java.util.regex.Pattern;

public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println(Pattern.matches("^[a-zA-Z]*$", "gk"));
		
		//1 구구단 단수
		int a = 1;
		int num = 0;
		while(true) {
			System.out.print("원하는 단수 입력 (1~9)");
			num = scan.nextInt();
			if(num >0 && num<=9)
							break;
		}
		while(a<=9) {
			System.out.printf("%d*%d=%d\n",num,a,num*a);
			a++;
		}
		//2 1~100사이 정수 중에서 8의 배수 출력하기
		int b=1;
		while(b<=100) {
			if(b%8==0) {
				System.out.print(b+" ");
			}
			b++;
			}
		System.out.println();
		
		//3 1~100사이 정수 중에서 4의 배수이거나 7의 배수인 정수를 출력하기
		int c =1;
		while(c<=100) {
			if(c%4==0) {
				System.out.print(c+" ");
			}
			if(c%7==0) {
				System.out.print(c+" ");
			}
			c++;
			}
		System.out.println();
		//4 1~100사이 정수중에서 일의 자리 수가 3 또는 6 또는 9인 정수를 출력하기
		int d = 1;
		while(d<=100) {
			if(d%10==3 || d%10==6 || d%10==9) {
				System.out.print(d + " ");
			}
			d++;
		}
		System.out.println();
		//5. 사용자에게 문자열을 입력받아 모음의 개수를 출력하기 (a, e, i, o, u)
		scan.nextLine();
		int count1 = 0;
		String str1 = "";
		while(true) {
			System.out.print("영어 문자를 입력하세요");
			str1= scan.nextLine();
			if((Pattern.matches("^[a-zA-Z]*$", str1)) ) {
				break;
			}
		}
		for(int i=0; i<str1.length();i++) {
			if(str1.charAt(i)=='a' || str1.charAt(i)=='e' ||str1.charAt(i)=='i'||str1.charAt(i)=='o' || str1.charAt(i)=='u') {
				count1++;
			}
		}
		System.out.println("모음 갯수:" + count1);
		
		//사용자에게 1 ~ 9사이의 정수를 입력받아 2자리의 자연수 중 각 자리수의 합이 입력값과 동일한 수 출력하기
		//입출력예) 6 => 15 24 33 42 51 60 
		System.out.print("1~9사이의 정수를 입력하시오:");
		int user1 = scan.nextInt();
		int i = 10;
		while(i<=99) {
			int first = i/10;
			int second = i%10;
			int test = first+second;
			if(test==user1)
				System.out.print(i + " ");
			i++;
		}
		
		//7. 10부터 20까지 순서대로 출력 
		int e = 10;
		while(e<=20) {
			System.out.print(e + " ");
			e++;
		}
		System.out.println();
		//8. 10부터 20까지 역순으로 출력 
		int f=20;
		while(f>=10) {
			System.out.print(f + " ");
			f--;
		}
		System.out.println();
		
		//9. 사용자가 입력한 5개의 정수 중 가장 큰 값을 출력하기
		int g = 1;
		int big = 0;
		while(g<=5) {
			System.out.println(g+"번째 정수 입력하세요");
			int num1 = scan.nextInt();

			if(num1>big) {
				big=num1;
			}
			g++;
		}
		System.out.println("가장큰 정수는" + big);
		//10. 사용자에게 문자열 3개를 입력받아
	    //길이값의 합을 출력하고, 가장 긴 문자열을 출력하기
		scan.nextLine();
		int h=1;
		int tall = 0;
		String tallstr = "";
		while(h<=3) {
			System.out.print(h + "번째 문자열을 입력하세요");
			String str2 = scan.nextLine();
			
			if(Pattern.matches("^[0-9]*$", str2)) {
					continue;
			}
			
			if(tallstr.length()<str2.length()) {
				tallstr=str2;
			}
				tall+=str2.length();
			h++;
		}
		System.out.println("길이값의 합:" + tall);
		System.out.println("가장 긴 문자열은:" + tallstr);

		
		//----------------------
	}

}
