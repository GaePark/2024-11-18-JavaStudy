
class Member2{
	int no=100;// Heap => 멤버변수
	Member2() {
	int no=200;// Stack =>지역변수
	System.out.println("no="+(no+this.no)); //변수명이 같을 경우 벰버변수를 가져오려면 this를 사용해야함
	// 1. 지역변수 우선 순위
	// 지역변수,매개변수 => 멤버변수
	// this => 클래스 자신이가지고 멤버(변수,메소드)
}
/*
 * this => 자신의 객체
 * ---- 지역변수와 매개변수 == 멤버변수가 동일한 이름을 가지고 있는 경우
 *                                        구분자
 * ---- 모든 클래스는 this를 가지고 있다
 * 
 * this ==> static 변수
 * 
 */
}

/*
 * int a=10;
 * static int b=20;
 * static void display() => 공통으로 사용하는 기능
 * {
 *     b만 사용이 가능
 * }
 * void display2()
 * {
 *    a,b=> 사용이 가능
 * }
 */
public class 클래스_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member2 m2 = new Member2();
	}

}
