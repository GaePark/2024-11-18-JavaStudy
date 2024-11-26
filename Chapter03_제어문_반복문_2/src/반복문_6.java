/*
 *    ===========================    ㅣ=> 재사용 => 기업
 *   ㅣ                          ㅣ 컴포넌트 : 클래스
 * 데이터 관리 => 데이터 가공 => 가공된 데이터 출력
 * ========    ========    ============= 요청값 출력
 *               요청에 맞게 가공
 *               ===========
 *                ㅣ연산자 / 제어문
 *                 =========== 명령문
 *                 명령문을 묶어서 => 메소드
 *  데이터를 묶어서 사용
 *  --------------
 *  배열 / 클래스
 *  파일 / RDBMS(오라클)
 *  
 *  데이터베이스
 *  --------- 데이터를 모아서 관리하는 곳
 *  ㅣ 변수
 *  ㅣ char => String
 * 
 *  while => 1차 ========= 1 : 한번만 사용
 *  동작 순서 / 형식 / 사용처
 *  형식) 초기식
 *       while(조건식) ==== 2
 *       {
 *         반복수행문장 ===== 3
 *         증감식 ========= 4 ====> 2번으로 이동
 *                               ====
 *                               false => 종료
 *                               ture => 3번이동
 *       }
 *  
 *  
 *  for() {
 *  	while() {
 *      	if() {
 *              for() {
 *              
 *              }
 *          }
 *  	}
 *  }
 * 
 * 
 */
public class 반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1~100사이의 난수 발생 => 5개
		// 최대값 /최소값
		
//		int a=(int) (Math.random()*100)+1;
//		int b=(int) (Math.random()*100)+1;
//		int c=(int) (Math.random()*100)+1;
//		int d=(int) (Math.random()*100)+1;
//		int e=(int) (Math.random()*100)+1;
//		
//		int max=a, min=a;
//
//		if(max<a)
//			max=a;
//		if(max<b)
//			max=b;
//		if(max<c)
//			max=c;
//		if(max<d)
//			max=d;
//		if(max<e)
//			max=e;
//		
//		if(min>a)
//			min=a;
//		if(min>b)
//			max=b;
//		if(min>c)
//			min=c;
//		if(min>d)
//			min=d;
//		if(min>e)
//			min=e;
//		System.out.printf("%d, %d, %d, %d, %d\n",a,b,c,d,e);
//		System.out.println("max"+ max);
//		System.out.println("min"+ min);
		
		int i = 1;
		int max = 1;
		int min = 100;
		while(i<=5) {
			int a=(int) (Math.random()*100)+1;
			System.out.print(a+ " ");
			if(max<a)
				max=a;
			if(min>a)
				min=a;
			i++;
		}
		System.out.println();
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		// 반복문은 중복 코딩을 제거할 경우에 사용
	}

}
