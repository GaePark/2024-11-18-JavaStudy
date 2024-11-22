/*
 * 자바에서 지원하는 제어문
 * ***= 조건문 : 요청에 맞는 문장만 실행 => 건너뛰는 경우도 있음
 *             => 오류 방지 
 *             ======== if만으로 처리가 어려운 과정 : 예외처리(8장)
 *             => 사전에 방지 => if => 이런경우
 *      단일 조건문
 *        형식)
 *            ㅣ 연산자 => 부정연산자, 비교연산자, 논리연산자 
 *        if(조건문 => true / false) {
 *        	조건문이 true일 경우에만 처리하는 문장
 *        }
 *        false => 건너뛴다
		  => 독립적으로 실행 => if문을 여러개 사용하면 속도가 저하
		  if(a==1)
		  if문장마다 다른 문장으로 되어 있다 => 모든 if의 조건을 검색한다.. => 속도저하
		  if(a==2)
		  if(a==3)
		  if(a==4)
		  if(a==5)
		  
		  => 사용처 : 아이디 중복체크 , 검색 , 상세보기, 예약내용
		
		 55page
		   중첩 if문
		   if() ==> 아이디가 같고
		   {
		   	if() ==> 비밀번호가 같다면
		   	{
		   	}
		   }
		  ==> if( 아이디가 같고 && 비밀번호가 같다면 )
		  
 *      선택 조건문 : 나눠서 처리
 *                 true => 처리
 *                 false => 처리
 *             if(조건문) {
 *              	조건이 true 일떄
 *             } else {
 *             		조건이 false 일때
 *             }
 *             => 두개가 나눠지는 경우
 *                 1. 로그인 => 로그인 된 경우 (main화면 이동) => if
 *                         => 로그인 안된 경우(back, 회원가입창으로 이동) => else
 *                 2. 찜하기 / 좋아요 => if~else
 *                 3. 대문자 / 소문자 , 3의 배수
 *             
 *      다중 조건문
 * = 선택문 => 게임 => 네트워크
 * ***= 반복문
 *    do~while: 무조건 1번이상 수행할때
 *    while: 반복횟수가 없는 경우 => 데이터베이스 / 파일 읽기
 *    ***for: 회수 지정 => 코딩테스트/정보처리실기
 * = 반복제어문
 *   ***break : 반복을 종료
 *   continue : 특정부분을 제외하고 다시 반복시작
 *   
 *   
 *   1. 중첩 조건문
 *      컴퓨터와 사용자의 가위, 바위 보 게임
 *                   ==============가정
 *                   가위(0), 바위(1), 보(2)
 *                   
 *      경우의 수 => if
 *      컴퓨터 가위
 *          = 사용자 가위
 *          = 사용자 바위
 *          = 사용자 
 *          
 *      컴퓨터 바위
 *          = 사용자 가위
 *          = 사용자 바위
 *          = 사용자 보
 *     
 *     컴퓨터 보
 *          = 사용자 가위
 *          = 사용자 바위
 *          = 사용자 보
 *   
 */


import java.util.Scanner; // 이미 만들어져 있는 클래스를 읽어오는 경우
// => 이미 만들어진 클래스 : 라이브러리
// 클래스를 가지고 올때 import

public class 제어문_조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// System.in : 키보드 입력값 => c언어 : scanf()

		System.out.print("가위(0),바위(1),보(2):");
		int user = scan.nextInt(); //0,1,2
		
		//컴퓨터 => 가위 바위 보
		int com = (int)(Math.random()*3);//0,1,2
		
		//1. 출력
		System.out.print("컴퓨터:");
		if(com==0)
			System.out.println("가위");
		if(com==1)
			System.out.println("바위");
		if(com==2)
			System.out.println("보");
		
		System.out.print("플레이어:");
		if(user==0)
			System.out.println("가위");
		if(user==1)
			System.out.println("바위");
		if(user==2)
			System.out.println("보");
		
		System.out.println("=====결과=====");
		
//		if(com==0)// 컴퓨터 가위를 낸 경우
//		{
			if(user==0 && com==0)
				System.out.println("비겼습니다.");
			if(user==1 &&com==0)
				System.out.println("플레이어 Win");
			if(user==2 &&com==0)
				System.out.println("컴퓨터 Win");
			
//		}
//		if(com==1)// 컴퓨터 바위를 낸 경우
//		{
			if(user==0&&com==1)
				System.out.println("컴퓨터 Win");
			if(user==1&&com==1)
				System.out.println("비겼습니다.");
			if(user==2&&com==1)
				System.out.println("플레이어 Win");
			
//		}
//		if(com==2)// 컴퓨터 보를 낸 경우
//		{
			if(user==0&&com==2)
				System.out.println("플레이어 Win");
			if(user==1&&com==2)
				System.out.println("컴퓨터 Win");
			if(user==2&&com==2)
				System.out.println("비겼습니다.");
			
//		}
	}

}
