// 정수를 입력을 받아서 짝수/ 홀수
//random() => 1~100
//random() => 두개 발생(1~100)
// => 최대값 / 최소값을 출력하는 프로그램을 만든다
public class 제어문_선택조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 정수를 받는다
//		int num = (int)(Math.random()*100)+1;
//		
//		if(num%2==0) {
//			System.out.println(num + "는(은) 짝수입니다.");
//		} else {
//			System.out.println(num + "는(은) 홀수입니다.");
//		}
		
		int num1 = (int)(Math.random()*100)+1;
		int num2 = (int)(Math.random()*100)+1;
		
		int max=0, min=0;
		
		int a=0;

		if(num1 >= num2) {
			max=num1;
			min=num2;
					
		} else {
			max=num2;
			min=num1;
		}
		
		System.out.println("=====최대값=====");
		System.out.println(max + "은(는) 최대값이고" + min + "은(는) 최소값입니다.");
		System.out.println("최대값: " + Math.max(num1, num2));
		System.out.println("최대값: " + Math.min(num1, num2));
	}

}
