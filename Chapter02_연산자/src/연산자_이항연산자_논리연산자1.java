/*
 * && ||
 * (조건) && (조건) => true/false => 범위, 기간안에 있는 경우
 *                             a>1 && a<=100 ====> 직렬연산자
 * -----    -----
 *   ㅣ        ㅣ
 *   ----------
 *       ㅣ
 *      결과값
 *      
 * (조건) || (조건)  => true/false =>  범위밖에 있는 경우
 *                              a<1 || a>100 ====> 병렬연산자
 * -----    -----
 *   ㅣ        ㅣ
 *   ----------
 *       ㅣ
 *      결과값
 *      
 *       조건 && 조건
 *  --------------------
 *  true        true        true
 *  --------------------
 *  true        false       false
 *  --------------------
 *  false       true        false
 *  --------------------
 *  false       false       false
 *  --------------------
 *  
 *  
 *         조건 || 조건
 *  --------------------
 *  true        true        true
 *  --------------------
 *  true        false       true
 *  --------------------
 *  false       true        true
 *  --------------------
 *  false       false       false
 *  --------------------
 *  
 *  int x=10;
 *  int y=9;
 *  
 *  
 *  && => 앞에 조건 ===> false면 종료
 *  
 *  x<y && x==++y => false
 *         ====== 연산(x) => 효율적인 연산
 *  x=? => 10
 *  y=? => 9
 * 
 * 
 * || => 앞에 조건 ==> true
 *  x<y || x==++y => true
 *         ====== 연산(o)
 *  x=? => 10
 *  y=? => 10
 * 
 * 
 *  
 */
public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 9;
		
//		boolean bCheck = x < y && x == ++y;
//		// true ==> true확인
//		// false ==> 확인 안함
//		System.out.println(bCheck);
//		System.out.println(y);
		
		boolean bCheck = x < y || x == ++y;
		// true ==> 확인 안함
		// false ==> true확인
		System.out.println(bCheck);
		System.out.println(y);

		// && => 예약일 , 체크인
		// 좌석 x
		// || => 유효성 검사
		/*
		 * 국어 , 영어, 수학 입력 => 총점, 평균
		 * => int kor = 입력
		 * =>int eng = 입력
		 * =>int math = 입력
		 * 
		 * 	int total = kor+eng+math
		 * double avg=total/3.0
		 * 
		 * 문자열 입력
		 * => ABBA
		 * 
		 * 
		 */
		System.out.println(534%30);
	}

}
