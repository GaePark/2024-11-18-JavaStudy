/*
 * 숫자 야구게임 => 절차적 언어 (main)
 *                   => 메소드형식 변환
 *                   => 객체지향 프로그램으로 변환
 *        ㅣ
 * 1.   	3개 정수 추출 => 1~9 => 중복없는 정수
 * 2.   	사용자 입력
 	3.		난수 입력 값 비교
 	4.		힌트 => 문자열 1S-2B....
 			S: ○
 			B: ○○
 	5. 	종료 여부 확인
 */
import java.util.*;
public class 메소드응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
//			System.out.println(Arrays.toString(com));
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
				//비교
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
				//힌트를 제공
				System.out.println("Input Number: "+input + ", Result: "+s+"s-"+b+"B");
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
				
//				System.out.printf("Input Number: %d, Result: %dS-%dB",input,s,b);
				// 종료 여부 확인
				if(s==3) {
					System.out.println("Game Over!!");
					break;
				}
					
				
			}
			
		
	}

	private static Object input(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
