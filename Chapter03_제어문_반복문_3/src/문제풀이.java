import java.util.*;
public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//1번
		System.out.println("1번");
		int x= 15;
		if(x>10 && x<20) {
			System.out.println("true");
		}
		//2번
		System.out.println("2번");
		char ch = 'A';
				if(ch !=' '|| ch!='	') {
					System.out.println("true");
				}
		//3번			
		System.out.println("3번");		
			if(ch=='x' || ch=='X') {
				System.out.println("true");
			}
		//4번
			System.out.println("4번");		

			if(ch>='0' || ch<='9') {
				System.out.println("true");
			}
		//5번
			System.out.println("5번");		

			for(int i=1;i<=6;i++) {
				for(int j=1; j<=6;j++) {
					if(j+i==6) {
						System.out.printf("%d+%d=6\t",j,i);
					}
				}
			}
		//6번
			System.out.println();
			System.out.println("6번");		

			System.out.print("첫번째 정수를 입력하세요");
			int start = scan.nextInt();
			int end = 0;
			while(true) {
				
				System.out.print("두번째 정수를 입력하세요");
				end = scan.nextInt();
				if(start<end)
						break;
			}
			int result1 = 1;
			for(int i = start; i<=end;i++) {
				result1*=i;
			}
			System.out.println(result1);
		//7번
			System.out.println("7번");
			int result2 = 0;
			for(int i = 5; i<=16; i++) {
				result2+=i;
			}
			System.out.println(result2);
		//8번
			System.out.println("8번");
			int result3 = 0;
			for(int i = 3; i<=4462; i++) {
				if(i%2==0) {
					result3+=i;
				}
			}
			System.out.println(result3);
		//9번
			System.out.println("9번");
			int result4=0;
			int result5=0;
			for(int i=0;i<=12; i++ ) {
				if(i%2==0) {
					result4+=i;
				}
				if(i%3==0) {
					result5+=i;
				}
			}
			System.out.printf("2의 배수합: %d 3의 배수합: %d\n",result4,result5);
			
		//10번
			System.out.println("10번");
			int result6 = 0;
			for(int r=1;r<=100;r++) {
				if(r%4==0) {
					result6+=r;
				}
			}
			System.out.println(result6);
			
		//11번
			
			System.out.println("11번");
			int result7=0;
			for(int i=1; i<=10; i++) {
				System.out.print(i+"번째 정수를 입력하세요");
				int user = scan.nextInt();
				if(user%2==0) {
					result7++;
				}
			}
			System.out.println("짝수인 정수는" + result7+ "개입니다.");
		//12번
			System.out.println("12번");
			int result8=0;
			int result9=0;
			for(int i=1; i<=10; i++) {
				System.out.print(i+"번째 정수를 입력하세요");
				int user = scan.nextInt();
				if(user%3==0)
					result8++;
				if(user%5==0)
					result9++;
			}
			System.out.println("3배수:"+result8+", 5배수:"+result9);
			//13번
			System.out.println("13번");
			for(int i=1; i<=5; i++) {
				for(int j=1; j<=10; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			//14번
			System.out.println("14번");
			int z=1;
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5;j++) {
					System.out.print(z);
				}
				System.out.println();
				z++;
			}
			//15번
			System.out.println("15번");
			for(int i=1;i<=5;i++) {
				for(int j=1; j<=5; j++) {
					if(j==i) {
						System.out.print(i);
					} else {
						System.out.print("#");
					}
					
				}
				System.out.println();
			}
			//16번
			System.out.println("16번");
			for(int i=1; i<=5; i++) {
				char c = 'A';
				for(int j=1; j<=5; j++) {
					System.out.print(c++);
				}
				System.out.println();
			}
			//17번
			System.out.println("17번");
			char c = 'A';
			for(int i=1; i<=5; i++) {
				for(int j=1; j<=5; j++) {
					System.out.print(c);
				}
				c++;
				System.out.println();
			}
			
			//
			for(int i=1; i<=5; i++){
				for(int j=1; j<=5; j++){
				if(j==i || j==5-i) {
					System.out.println("★");
				}else {
					System.out.println("☆");
				}
			}
			}
	}

}
