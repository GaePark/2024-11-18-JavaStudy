/*
 * while문 : 반복횟수가 지정이 안된 상태
 * 
 * 형식)
 *      초기값 ======== 1
 *       초기값 ㅣ
 *           조건식
 *            ㅣ false ==> 종료
 *     while(조건식){ = 2
 *            ㅣ true 문장 수행
 *         반복수행문장 = 3
 *         증감식 ===== 4
 *     }
 *     
 *     사용처 : 데이터베이스 , 서버(자바서버 => 인트라넷)
 *                            ㅣ사내 메신저
 *                            ㅣ게임
 *           => 무한루프 while(true)
 *              ㅣ Front 
 *     while문은 실행이 안되는 경우 => 선조건
 *     
 *     초기식 ========== 1
 *     do{
 *         반복수행문장 == 2
 *         증감식 ====== 3
 *     }while(조건식) == 4 ==>후조건 : 무조건 1번 이상 수행
 *     
 *     
 */
public class 반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~10 => 2중 while문은 사용안함
		int i = 1;
		while(i<=10) {
			System.out.print(i++ + " "); //반복 수행문
		}
		//for(int i=1;i<=10;i++)
	}

}
