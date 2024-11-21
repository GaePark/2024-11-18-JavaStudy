import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) { 
			System.out.print("가위바위보를 시작하겠습니까?(1: 예, 2: 아니오): ");
			String choose = scan.nextLine();			scan.nextLine();
			
			if(choose.equals("1")) {
				int com = (int) (Math.random()*3);
				System.out.print("선택하세요(가위, 바위, 보): ");
				String player = scan.nextLine();
				
				if(player.equals("가위" )) {
					if(com == 0) {
						System.out.println("비겼습니다.");
					} else if(com == 1) {
						System.out.println("졌습니다");
					} else {
						System.out.println("이겼습니다..");
					}
				} else if(player.equals("바위" )) {
					if(com == 0) {
						System.out.println("이겼습니다.");
					} else if(com == 1) {
						System.out.println("비겼습니다.");
					} else {
						System.out.println("졌습니다..");
					}
				} else if(player.equals("보" )) {
					if(com == 0) {
						System.out.println("졌습니다.");
					} else if(com == 1) {
						System.out.println("이겼습니다.");
					} else {
						System.out.println("비겼습니다.");
					}
				} else {
					System.out.println("잘못 입력하습니다.");
				}
				
				
			} else if (choose.equals("2") ) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			
		}
	}
}
