// => 변수 => 배열 =>
// => 연산처리 / 제어문처리 => 사용자 요청 =>메소드
//------------------------------------------------- 클래스 구성요소
// 객체지향언어 => 자바 시작 (5장)
// 사용자 정의
// 1. 정수를 입력을 받아서 ==> 2진법 출력 10 ==> 0000 0000 0000 1010
// 16bit => 2byte => 32767
import java.util.Arrays;
import java.util.Scanner;
public class 배열_생성_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int INDEX=16;
		Scanner scan = new Scanner(System.in);
		System.out.print("0~32767 사이의 정수 입력");
		int num=scan.nextInt();
		// 저장 공간 0,1 => 16개;
		int[] binary= new int[INDEX];
		// 앞에서 => inex=0, 뒤에서 index=15
		// index=0 ==> 15==0부터 출력 FIFO => Queue
		// index=15 ==> 15부터 출력 LIFO => Stack
		
		int index=INDEX-1; // 저장위치
		// 요청 처리 => 제어문 / 연산자
		//      num>0
		while(true) {
			
//			if(num%2==1)
//				binary[index]=1;
//			index--;
//			num/=2;
			binary[index]=num%2;
			num/=2;
			if(num==0)
				break;
			index--;
		}
		System.out.println(Arrays.toString(binary));
		for(int i=0;i<INDEX; i++) {
			//              배열의 갯수
			if(i!=0 && i%4==0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		
	}

}
