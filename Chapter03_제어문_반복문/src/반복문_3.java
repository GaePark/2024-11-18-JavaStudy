// 사용자로부터 값을 받아서 => 해당 구구단을 출력
/*
 * >>5
 * 5*1 =5
 * 5*2=10
 * ..
 * ..
 * 5*9=45
 * 
 * 맛집이미지 레시피이미지 상품이미지
 * 맛집이미지 레시피이미지 상품이미지
 * 맛집이미지 레시피이미지 상품이미지
 * 
 */


import java.util.Scanner;

public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("구구단 단수를 입력하세요(1~9):");
		
		int num = scan.nextInt();
		
		System.out.println("===== 요청 결과값 ====");
		for(int i = 1; i<=9; i++) {
			System.out.println(num + "*" + i + "=" + num*i);
		}
	}

}
