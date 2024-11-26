import java.util.Scanner;
public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com = (int)(Math.random()*100)+1;
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		while(true) { // 항상 종료시점을 정해야함
			System.out.print("숫자를 입력하세요(1~100):");
			int num = scan.nextInt();
		
			if(num<0 || num >100) {
				System.out.println("잘못입력했습니다.");
				continue;
			}
			if(num>com) {
				System.out.println("DOWN");
				count++;
			} else if(num<com) {
				System.out.println("UP");
				count++;
			} else if(num==com) {
				System.out.println(count+"번만에 정답입니다.");
				break;// 프로그램 종료
			}
			
		}

	}

}
