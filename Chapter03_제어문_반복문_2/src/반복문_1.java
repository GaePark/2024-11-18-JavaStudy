/*
 * 웹개발 ==> 데이터베이스 (SQL)
 * = server단 : Back => 자바 / 스프링 / 데이터베이스 연동
 * = db단
 * = view단 : Front => 자바스크립트
 *                    Jquery => VueJS => React => Next
 *                    ------ 4,5 동시에 출시
 *          MSA / DevOps / AWS
 *          => Spring Cloud
 *          자바 / 파이썬 => 데이터 분석(Numpu, Pandas, Matplotilib)
 *                        =< DJango <==> Spring
 *                        => ElasticSearch : NoSQL
 *                        ---------------- google
 *                        => 코딩테스트
 *          ---- Full Stack
 * 
 * 
 * 조건문 : ** 단일조건문 / ** 선택조건문 / 다중조건문
 *         형식) 다일 조건문 => 독립문장
 *         if(조건문)
 *         {
 *         		조건문이 true일때 수행=> false면 건너뜀
 *         }
 *         => 오류처리 -> 8장 예외처리
 *         => 비정상 종료를 방지하고 프로그램을 유지
 *         => if: 유효성 검사
 *         선택 조건문 => true일때 false일때 처리를 나눠서 처리
 *         
 *         if(조건문)
 *         {
 *         		조건이 true일때 처리
 *         }
 *         else
 *         {
 *         		조건이 false일때 천송
 *         }
 *         웹 => 무조건 결과값 전송
 *              아이디 중복체크 / 우편번호 검색
 *         다중조건문 : 1개의 조거남ㄴ 수행
 *         => menu / 카테고리
 *         if(조거문)
 *         {
 *         		조건 true일때 수행 => 종류
 *         } else if(조건문) {
 *         		조건 true일때 수행 => 종류
 *         } else {
 *         		해당 조건이 없는 경우 수행 => 종류
 *         		=> 생략 가능
 *         }
 *         
 * 선택문 : switch~case
 *        다중 조건문과 유사
 *        ======== 범위를 지정, 값을 한개만 선택(게임,어플)
 *        형식)
 *             1. case안에 중복괸 값이 있으면 안된다
 *             2. default는 생략 가능
 *             3. 문자 => ''
 *             4. 문자열 => ""
 *             switch(문자/정수/문장ㄹ)
 *             {
 *                 case 값:
 *                    실행문장;
 *                    break;
 *                 case 값:
 *                    실행문장;
 *                    break;
 *                 case 값:
 *                    실행문장;
 *                    break;
 *                 case 값:
 *                    실행문장;
 *                    break;
 *                 default
 *                    실행문장;
 *             }
 * 반복문 : ** for / ** while / do~while
 *           for : 반복 횟수가 지정된 경우 => 웹(반복횟수)
 *                 => 화면 UI => 목록 / 슬라이드
 *                 => Front
 *           while : 반복 횟수가 없는 경우
 *                  => 데이터베이스 / 파일 읽기
 *                  => Back
 *           do~while : 후조건 => 먼저 반복문장을 1번 수행
 *                      => 반드시 한번 이상 수행
 *          형식)
 *              for
 *                         ㅣ false => 반복 종료
 *                   1     2     4 
 *              for(초기식; 조건식;증감식)
 *              {          ㅣ true
 *              	반복 수행문장
 *                      3
 *              }
 *              초기식은 한번 수행
 *              조건식 => false까지
 *              증가식은 조건식에 있는 변수를 변경 => false가 되게 만든다.
 *              
 *              => 무한루프 : for(;;)
 *              
 *              => for(여기부터 시작;여기까지 도달;증가/감소)
 *                                         =======
 *                                         ++,  --
 *                                         +=,  -=
 *            ---------------------------------------------------
 *            
 *            68page => 중첩 for (이중 for)
 *            형식)
 *                     1     2   4
 *                for(초기식;조건식;증감식){
 *                           ㅣ true
 *                           1   2     4
 *                		for(초기식;조건식;증감식){
 *                		           ㅣ true
 *                		       반복 수행문장 3
 *                		}
 *                }
 *                
 *            
 * 반복제어문 : ** break, continue 
 */
public class 반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i<=5; i++) { // 줄수
			// 이차 for문 종료되면 일차 증가식으로 이동
			for(int j = 1;j<=5-i; j++) {//화면 출력
				System.out.print(" ");
			}
			for(int j=1; j<=(i*2)-1; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		 *  i=1 => j=1~j=5
		 *  i=2 => j=1~j=5
		 *  i=3 => j=1~j=5
		 */

	}

}
