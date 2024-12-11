class B
{
	int a;
	int b;
}
public class 객체지향_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=a; // b=10 => 주소를 이용하는것이 아니라 값만 이용
		B aa = new B();
		aa.a=100;
		aa.b=200;
		// => 웹 / 윈도우
		// MVC => SpringMVC
		/*              request
		 *        사용자 요청 ===> 요청값 받는다 ===> 요청 처리
		 *       결과값 브라우저 전송  <=== 결과값을 받는다 <=== 처리 완료
		 */
		
		B bb=aa; // 별칭 => 같은 주소를 가지고 있으면 같은 주소를 제어
		System.out.println(aa);
		System.out.println(bb);
		// 주소참조해서 제어 => Call By Reference
		// 클래스나 배열 => 주소를 넘겨주면 => 같은 메모리 제어
		// => 클래스에서 제외 => String => 일반 변수 취급
		System.out.println("bb.a="+bb.a);
		System.out.println("bb.b="+bb.b);
		
		//같은 주소를 제어 / 다른 메모리 생성 => new / clone
	}

}
