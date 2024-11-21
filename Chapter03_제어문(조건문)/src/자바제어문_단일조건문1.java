/*
 * 단일 조건문
 * 1) 형식
 * 		if(조건문)
 *      {
 *      	실행문장 : 조건문이 true일때만 실행
 *                   false면 실행이 안된다.
 *      }
 */
// 정수 입력 => 짝수 / 홀수
import java.util.Scanner;
public class 자바제어문_단일조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력:");
		int num = scan.nextInt();
		//명령문
		/*
		 * 
		 */
		/*if(num%2==0) // 짝수라면
		{
			System.out.printf("%d는(은) 짝수입니다.", num);
		};
		if(num%2==1) // num% !=0 홀수면
		{
			System.out.printf("%d는(은) 홀수입니다.", num);
			
		};
		3 => 0,1,2
		5%3 ==>2
		*/
		if(num%3==0)
		{
			System.out.printf("%d는(은) 3의 배수입니다.", num);
		}
		if(num%3!=0)
		{
			System.out.printf("%d는(은) 3의 배수가 아닙니다.", num);
		}
	}

}
