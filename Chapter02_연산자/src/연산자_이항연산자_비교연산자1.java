/*
 * 비교연산자 => 숫자, 논리만 비교
 * 		   => ""=="" => equals()
 *    ㅣ
 *   ==: 같다
 *   !=: 같지 않다
 *   ======================== 오라클 : = , <> => JavaScript : === , !==
 *   == 왼쪽 기준
 *   <:  작다
 *   >:  크다
 *   <=: 작거나 같다
 *   >=: 크거나 같다
 *   
 *   ==> 결과값은 true / false ===> 조건문
 */
public class 연산자_이항연산자_비교연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(6==7);
		System.out.println(6!=7);
		System.out.println(6<7);
		System.out.println(6>7);
		System.out.println(6<=6);
		System.out.println(6>=7);
		
		System.out.println("==========");
		char c= 'A';
		int a =65;
		//char는 연산처리되면 정수로 변경
		/*
		 *  'A' => 65 'B' => 66
		 *  'a' => 97 'B' => 98
		 *  '0' => 48 '1' => 49
		 */
		System.out.println(c==a);
		c ='0';
		a=0;
		System.out.println((int) 'A');
		System.out.println((int) '0');
		System.out.println(c==a);
		System.out.println((int) '+');
		System.out.println((int) '*');
		System.out.println((int) '/');
		System.out.println((int) '-');
		// 유니코드 => 0~65535
		
		
		boolean bCheck1 = false;
		boolean bCheck2 = true;
		// ==> ==, !== (<,>,<=,>= 사용할 수 없다.)
		System.out.println(bCheck1 == bCheck2);
		System.out.println(bCheck1 != bCheck2);
		
//		String s1 = new String("Hello");
//		String s2 = new String("Hello");
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s1.equals(s2));

		int x=10;
		int y=9;
//		System.out.println(x==y++); 비교후에 증가

		System.out.println(x==++y); //증가후에 비교
		
		// 비교연산자 => 조건문 , 반복문
		// ========= 로그인 , 아이디 중복, 우편번호 검색, 검색처리
		
		
		
	}

}
