// 메소드형 숫자야구 게임
import java.util.*;
public class 메소드응용_변경 {
	// 중복없는 난수 (3개 정수)
	static int[] rand() {
		int[] com = new int[3];
		
		for(int i=0;i<com.length;i++) {
			com[i] = (int)(Math.random()*9)+1;
			
			for(int j=0;j<i;j++) {
				//중복되어 있는지 검사
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		return com;
	}
	// 사용자 입력 => 유효성 검사
	static int[] player() {
		int[] user = new int[3];
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("정수 3자리를 입력해주세요:");
			int input = scan.nextInt();
			if(input<100 || input>999)
			{
				System.out.println("세자리 정수만 입력해야 됩니다.");
				continue;
			}
			
			for(int i=user.length-1;i>=0;i--) {
				user[i]=input%10;
				input/=10;
			}
			
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2]) {
				System.out.println("중복된 숫자는 사용할 수 없습니다.");
				continue;
			}
			if(user[0]==0 || user[1]==0 || user[2]==0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			break;
		}
		return user;
		
	}
	// 힌트 제공
	static int hint(int[] com, int[] user) {
		int s=0, b=0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(com[i]==user[j]) {
					if(i==j) 
						s++;
					else
						b++;
				}
			}
		}
		hints(s,b,user);
		return s;
	}
	
	//힌트를 제공
	static void hints(int s, int b, int[] user) {
	System.out.println("Input Number: "+user[0]+user[1]+user[2]);
	System.out.println("=== 전광판 ===");
	System.out.print("S:");
	for(int i=0;i<s;i++) {
		System.out.print("●");
	}
	System.out.println();
	System.out.print("B:");
	for(int i=0;i<b;i++) {
		System.out.print("○");
	}
	System.out.println("\n==========");
	}
	// 종료 여부 확인
	static boolean finish(int s) {
		if(s==3)
			return true;
		return false;
	}
	// 전체 조립 => 새로운 게임여부 확인
	static void process() {
		Scanner scan = new Scanner(System.in);
		int[] com = rand();
		int[] user = new int[3];
		while(true) {
			
			user = player();
			int s =hint(com, user);
			if(finish(s)) {
				System.out.println("게임을 다시 하시겠습니까?(y/n):");
				char c=scan.next().charAt(0);
				if(c=='y' || c=='Y') {
					System.out.println("★★★★★ 새 게임을 시작합니다 ★★★★★");
					process();
				}
				else {
					System.out.println("Game Over!!");
					System.exit(0);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		process();
	}

}
