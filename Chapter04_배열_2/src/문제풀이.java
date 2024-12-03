/*
 * 배열 : 관련된 데이터를 여러개 모아서 메모리에 저장
 *          ---------------------------
 *          2) 같은 데이터형 2) 연속적인 메모리
 *          => 한개의 이름으로 관리
 *                -----------
 *                배열명 => 구분자 (인덱스)
 *          3) 배열을 선언하면 고정적이다 => 추가, 삭제가 불가능
 *              => 현재 배열보다는 큰 배열을 다시 생성한다 (추가)
 *                     int[] arr=new int[5]; => 7
 *                     int[] arr_ext = new int[7]
 *                     => 동적으로 생성은 가능 (메소드)
 *              => 현재 배열보다는 작은 배열을 다시 생성한다 (삭제)      
 *         4) 인덱스번호 => 0부터 ~
 *              => 배열에 저장된 갯수 => 배열명.length
 *         5) 배열선언 / 배열 초기화
 *             데이터형[] 배열명={}
 *             데이터형[] 배열명 = new 데이터형[]
 *                    ------배열기호 => 숫자를 사용할 수 없다.
 *   
 *   배열 제어 => 값을 변경, 값을 저장 / 값을 읽기
 *       => 일반 for
 *       => for-each => 값을 읽어서 출력
 *       변수 => 저장 / 읽기 / 변경
 */
import java.util.Arrays;

public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 다음 중 배열 선언이 잘못된 것은?4번
		//2. 배열을 선언하고 생성하는 다음 물음에 답하라.
		//    1) char[] c = new char[10]
		//    2) int[] n = {0,1,2,3,4,5}
		//    3) char[] day = {'일','월','화','수','목','금','토'}
		//    4) boolean[] bool = {true,false,false,true}
		//3. int i=0;i<alpha.length;i++
		//4. 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
		int[] n = new int[10];
		for(int i = 0;i<n.length;i++) {
			n[i]= (int)(Math.random()*100)+1;
		}
		
		for(int i=0; i<n.length;i++) {
			if(n[i]%3==0)
				System.out.print(n[i] + " ");
		}
		System.out.println();
		//5. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 
		//    그리고 배열에 든 숫자들과 평균을 출력하라. 
		int[] s = new int[10];
		int total = 0;
		for(int i = 0;i<s.length;i++) {
			s[i]= (int)(Math.random()*100)+1;
		}
		for(int ss:s) {
			total+=ss;
		}
		System.out.println(Arrays.toString(s));
		System.out.printf("평균: %.2f",total/10.0 );
		/*
		 * 1. 저장하는 공간(메모리)
		 *    => 한개,두개 => 일반 변수
		 *    => 3개 이상 => 배열
		 *    => 웹 : 사용자가 보내준 데이터 읽기
		 * 2. 초기화
		 * 3. 처리 내용 => 평균, 갯수, 인덱스 위치....
		 *     => 데이터베이스(오라클) 검색, 저장...
		 * 4. 결과값 출력
		 *   => 브라우저로 전송 setAttribute("id","admin")
		 *         sendJson()
		 *         
		 *  [],List ==> 자바스크립트에서는 데이터형(X)
		 *  --------JSON => React/Vue.Ajax
		 *  List ==> []
		 *  클래스 ==> {}
		 *  String / StringBuffer
		 */

		 
		// 6.   다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
		int[] num = { 94, 85, 95, 88, 90 };
		
		int max = num[0];
		int min = num[0];
		
		for(int i=1;i<num.length;i++) {
			if(max<num[i])
				max=num[i];
			if(min>num[i])
				min=num[i];
		}
		System.out.println();
		System.out.println("max:" + max);
		System.out.println("min:" + min);

		//7/
		int[] m = new int[10];
		int mtotal = 0;
		for(int i = 0;i<s.length;i++) {
			m[i]= (int)(Math.random()*10)+1;
		}
		for(int ss:m) {
			mtotal+=ss;
		}
		System.out.println(Arrays.toString(m));
		System.out.printf("평균: %.2f",mtotal/10.0 );
		System.out.println();
		//8.arr 배열 중에서 인덱스가 1인 곳의 값을 출력해보자.
		int[] arr = {10,20,30,50,3,60,-3};
		System.out.println(arr[1]);
		//9.  arr 배열 중에서 값이 60인 곳의 인덱스를 출력해보자. 
		int[] arr2 = {10,20,30,50,3,60,-3};
		for(int i = 0; i<arr2.length;i++)
			if(arr2[i]==60) {
				System.out.println(i);
				break;
			}
	}
	/*
	 * 지역변수 > 블럭변수 => 메모리에서 사라진다
	 * {} => 메모리 자체에서 관리
	 *           ----------- Stack : 지역변수 / 매개변수
	 */

}
