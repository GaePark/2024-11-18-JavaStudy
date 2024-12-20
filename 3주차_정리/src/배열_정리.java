/*
 * HTML / CSS / JavaScript => 프로젝트
 * ========================
 * 자바(서버 연결) / 자바스크립트(브라우저에서만)
 * 데이터저장 : 변수 => 데이터형
 *                                ㅣ정수 => byte/int/long
 *                                ㅣ실수 => double
 *                                ㅣ논리 => boolean
 *                                ㅣ문자 => char
 *                                ㅣ문자열 => String
 * 데이터 가공 : 연산자 / 제어문
 		1) 연산자
 			=> 단항연산자
 					증감연산자 (++,--) => 한개 증가 / 감소
 					부정연산자 (!) => 예약일이 아닌경우
 					형변환연산자 => 클래스 형변환
 					                       ------------
 											=> 상속 / 포함 / 라이브러리
 					=> UpCasting / DownCasting
 					      -----------   ---------------
 					      ㅣ자동형변환   ㅣ강제형변환
 			=> 이항연산자
 					산술연산자 : +,-,*,/,%
 						1) 자동으로 같은 데이터형으로 변경후에 처리
 						2) int이하 => char, short,byte => 연산이 되면
 						                     결과값이 int
 					
 			=> 삼항연산자 => 웹(JSP => HTML + Java)
 			                          ===============
 			                          ㅣHTML / Java => 분리
 			                          =============== MVC
 			                          
 		2) 제어문
 			1. 조건문
 				단일조건문
 									ㅣ부정연산자 / 논리연산자 / 비교연산자
 							형식) if(조건문)
 									{
 										조건이 true일때 처리
 									}
 									=> 독립문장 => 단점은 속도가 느릴 수 있다.
 						선택조건문 => 조건 true / 조건 false일때 나눠서 처리
 									  => 웹에서 가장 많이 사용되는 문장
 									  => 웹 =< 무조건 결과값을 전송
 									  		로그인 => 성공 / 실패
 									  		
 							 ** 자바에 사용자 요청 처리'
 							  	  			==========메소드
 							      처리결과를 브라우저로 전송==>리턴형은 항상 존재
 	---------------------------------------------------------------------
 	배열 : 데이터를 묶어서 사용
 	문자열 : 문자를 여러개 사용하는 부분
 	메소드 : 관련된 명령문을 묶어서 사용
 	---------------------------------- + 클래스 => 패키지 => 라이브러리
 	
 	-- 변수명이 여러개 있는 경우 => 제어가 어렵다
 	                                           제어문 사용에 문제 발생
 	                                           반복문 사용(데이터)
 	1. 배열
 			=> 관련된 데이터
 			=> 한개이름으로 여러개 제어
 			=> 변수
 			=> 클래스 여러개 (한개 이름으로 제어 => 인터페이스)
 			
 	예)
 		Board => 글쓰기 , 목록 , 상세보기 ,수정 ,찾기 ,삭제
 		                메소드
 		----------클래스
 		Food => 목록(페이징) , 상세보기 , 찜하기 ,예약하기 , 좋아요
 		                                   ㅣ위치 => Map
 		Recipe => 목록 , 쉐프정보 , 레시피 제작 , 구독 , 검색 ....
 		Seoul => 목록 , 여행코스, 인근 맛집 , 숙소 , 렌트카대여
 		
 		배열 (일차배열)
 		= 선언
 			데이터형[] 배열명; => 권장
 			데이터형 배열명[]; => C언어 호환
 		= 초기값 설정
 			=>명시적 초기화
 			=>기본값 초기화
 			=>선언 후 초기화
 			
 		** 연속적으로 메모리 저장
 		     --------------------
 		     ㅣ메모리 크기가 동일 -< 같은 데이터형만 모아서 관리
 		     ** 한번 설정하면 변경이 불가능 => 고정적
 		    	=> 가변형 배열 => 클래스형 (Clooeaction)
 		    			ArrayListt/Mpat/SET
 		** int[] arr=new int[5]
 		
 		
 		1)값 변경 . 초기 값
 			일반 for 문을 이용한다
 			=> 인덱스를 이용
 			2) 값 읽기 for-earch를 주로 사용
 			=> 실제 배열에 저장된 값을 읽기
 		매소드 : 한개 기능을 만들어서 => 재사용
 		
 		= 데이터 수정 / 데이터 출력
 		
 		메소드 : 한개 기능을 만들어서 재사용
 		1. 종류
 			= 사용자 정의 메소드
 				1) 특정 작업을 하기 위한 명령문의 집합
 				                                ------
 				                                ㅣ => ; => 명령문 ...
 				       ㅣ기능 처리
 				       ㅣ--------- 권장 : 한가지 기능만 처리
 				       ㅏ=> 재사용 ,유지보수(수정이 가능)
 				                                       ㅣ오버라이딩
 				                                       ㅣ추가 => 오버로딩
 				        ** 형상관리 : GIT (공통 프로젝트)
 				             => 협업 (면접 필수)
 				             
 			= 라이브러리에서 제공한 메소드(API) => 이후 API이용
 			   mvnrepository.com
 			   
 			   => 객체지향 프로그램 : Actor
 			   => 클래스의 구성 요소
 			   = 변수
 			   		변수의 종류
 			   =생성자
 			   		변수의 초기화 => 초기화 블럭
 			   -메소드
 			   		메소드 종류
 			   
 			   2) 메소드 사용 목적
 			   		1. 반복되는 기능을 제거
 			   		2. 코드관리가 쉽게 => 기능별로 나눠서 처리
 			   		     = 입력 / 처리 / 출력
 			   		3. 소스가 간결하게 제작
 			   		4. 다른 클래스와 연결
 			   		5. 재사용성
 			   	3) 메소드의 종류
 			   		공통메소드 : 자동으로 메모리에 저장
 			   		static
 			   		인스턴스 메소드 : 메모리마다 따로 저장
 			   		new 를 사용해서 저장
 			   		추상메소드 : 선언 => 필요시마다 구현
 			   		                 설계단에서 주로 사용
 			  	4)메소드 만드는 방법
 			  		리턴형 : 사용자 요청시 처리된 결과값
 			  		           --------------------------
 			  		           결과값이 있는 경우
 			  		           ㅣ 기본형, 배열 , 클래스
 			  		           결과값이 없는 경우 => 메소드 자체 처리
 			  		           ㅣ void
 			  		           ** 결과값은 무조건 한개만 사용이 가능
 			  		           
 			  		메소드명 : 변수 식별자
 			  					  알파벳,한글 시작
 			  					  알파벳은 대소문자 구분
 			  					  숫자는 사용 => 앞에서 사용 금지
 			  					  공백 사용이 불가능
 			  					  키워드는 사용금지
 			  					  특수문자($,_)
 			  					  *** 소문자로 시작한다
 			  					  *** 구분자 -> 메소드명은 중복안되게끔
 			  					         약간의 의미만 부여
 			  					  *** 7~15
 			  		매개변수 : 여러개 사용이 가능
 			  						=> 가급적이면 3개이상이면 클래스 / 배열을 사용
 			  						=> 사용자 요청해서 보내주는 값
 			  						로그인
 			  						로그인(String id, String pwd)
 			  		[접근지정어][옵션]리턴형 메소드명(매개변수)
 			  		{
 			  		}
 			  	5) return 사용
 			  	   ---------- 메소드가 종료의미
 			  	   리턴형이 있는 경우엔 반드시 return 값;
 			  	   리턴형이 없는 경우엔 return을 생략할 수 있다.
 			  	        => 자동 컴파일러에 의해 자동 추가
 			  	   *** 반드시 리턴을 사용해야 된다
 			  	   
 			  	   
 			  	   ** return문은 항상 마지막에 코딩하는 것은 아니다
 			  	       => 중간에 처리
 			  	       => 조건마다 return을 사용할 수 있따.
 			   6) 메소드
 			   		1. 동작과정 (행위)
 			   		2. 화면에 출력하는 내용 : 리턴형
 			   		3. 사용자에게 유도: 매개변수	
 			   
 		
 	 */
public class 배열_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
