/*
 *  중복없는 난수 => 3개 발생 (1~9)
 *  ===================
 *  사용자 입력
 *  3자리 입력 => 맞추는 프로그램 : 숫자 야구게임
 *  힌트
 *    369
 *    123 =>0S-1B
 *    346 => 1S-1B
 */
import java.util.Arrays;
import java.util.Scanner;
public class 배열_생성_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// 컴퓨터 중복없는 난수 3자리 발생
		int[] com = new int[3];
		// 사용자 입력
		int[] user = new int[3];
		
		
		// 초기화
		for(int i=0;i<3;i++) {
			com[i] = (int) (Math.random()*9)+1;
			
			for(int j=0;j<i;j++) {
				
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(com));
		while(true) {
			// 난수와 사용자 입력 비교
			System.out.print("3자리 정수 입력:");
			int num = scan.nextInt();
			if(num<100 || num>999)
			{
				System.out.println("잘못된 입력입니다!!");
				continue;
			}
			//세자리 정수가 입력된 상태
			user[0] =num/100;
			user[1] =(num%100)/10;
			user[2] = num%10;
			
			if(user[0]==user[1]||
			   user[1]==user[2] ||
			   user[0]==user[2] 	) 
			{
				System.out.println("중복된 수는 사용할 수 없습니다.");
				continue; //처음부터 다시 입력
			}
			// 문제 발생 ==> 0을 제외
			if(user[0]==0 || user[1] ==0 ||user[2]==0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			//오류 처리 => 조건문 역할 : 오류를 방지 => if을 사용한다.
			
			// 힌트
			int s = 0;
			int b = 0;
			
			for(int i=0;i<3;i++) {
				for(int j=0; j<3;j++) {
					if(com[i]==user[j]) {
						if(i==j)
							s++; //같은 자리수인지
						else
							b++; //다른 자리에 있다.
					}
				}
			}
			System.out.printf("Number:%d, Result:%ds-%db\n",num,s,b);
			
			if(s==3)
			{
				System.out.println("Game Over!!");
				break;
			}
			
		}
		//종료여부 확인 => S=3

	}

}
