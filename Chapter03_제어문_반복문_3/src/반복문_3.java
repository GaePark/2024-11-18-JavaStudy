/*
 * 가위바위보 게임을 10번 수행 => 5승 1무 4패
 */

import java.util.Scanner;

public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//new는 사용시마다 메모리에 저장(할당) = 반복문에서 사용하지 않는다.
		// 클래스는 반복문 밖에서 사용
		int win=0, draw=0, lose=0;
		
		int i =1;
		
		while(i<=10) {
			
			System.out.println("===== " + i + "번째 게임 =====");
			//com는 가위바위보 설정
			int com = (int)(Math.random()*3);
			
			//사용자 가위 바위 보
			System.out.print("가위(0), 바위(1),보(2)를 내세요");
			int user = scan.nextInt();
			
			if(user<0 || user>2 ) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			System.out.print("컴퓨터:");
			if(com ==0)
				System.out.println("가위");
			else if(com==1)
				System.out.println("바위");
			else
				System.out.println("보");
			
			// 사용자 확인
			System.out.print("사용자:");
			switch(user) {
			case 0:
				System.out.println("가위");
			case 1:
				System.out.println("바위");
			case 2:
				System.out.println("보");
			}
			
			int result = com-user;
			
			if(result== 0) {
				System.out.println("비겼습니다.");
				draw++;
			} else if(result == -1 || result == 2) {
				System.out.println("사용자 Win");
				win++;
			} else if(result == 1 || result == -2) {
				System.out.println("컴퓨터 Win");
				lose++;
			}
				
			System.out.println("게임을 종료할까요?(y/n)");
			char c = scan.next().charAt(0);
			if(c=='y') {
				System.out.println("게임을 종료합니다!!");
				break;
			}
			//누가 이겼는지
			i++;
		}
		System.out.println("===== 결과 =====");
		System.out.printf("승:%d 무승부: %d 패:%d",win,draw,lose);
	}

}
