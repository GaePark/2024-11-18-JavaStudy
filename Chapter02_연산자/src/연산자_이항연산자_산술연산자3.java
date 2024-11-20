// => 임의로 변수 초기화
// => 난수 => math.random()
/*
 * math.random() ==> double
 * 					0.0 ~ 0.99
 * 1~100
 * (int)(Math.random()*100)+1
 * ======================
 * 0.0~99.0 ==> 0~99 => 1~100
 */
public class 연산자_이항연산자_산술연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = (int)(Math.random()*100)+1; //게임
		int b = (int)(Math.random()*100)+1;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(b+a);
	}

}
