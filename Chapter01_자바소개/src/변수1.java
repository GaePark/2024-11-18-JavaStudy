/*
	프로그램 작성법
	
	아이템 ===> 벤치마킹 ===>요구사항부석 ===> 데이터베이스 설계
							ㅣ
							1. 어떤 데이터
							2. 어떤 기능
	
	화면 UI ===> 기능 구현 ===> 테스트 ===> 배포
	
	1. 프로그램에 필요한 데이터 저장
		=> 한개씩 메모리에 저장 => 변수
		변수: 메모리에 저장되는 공간의 이름
		=== 읽기 (데이터 가지고 오기)
		=== 쓰기 (데이터를 저장) => 수정은 가능 ===> RAM(프로그램 종료시 사라진다)
		메모리
		0=======
		  사용중
		4=======
		  사용중
		8======= ==> 별칭 a
		   10
		12=======
		  사용중
		..======= ==> 별칭 b
		   20
		..=======
		
		변수
		======= 4byte ==> 큰것이 들어 갈 수 있다
		
		=======
		
		=======
		8bit = byte
		
		1byte => 8bit -> bite는 0,1을 채워주는 역할
			==================================
			부호비트ㅣ	ㅣ	ㅣ	ㅣ	ㅣ	ㅣ	ㅣ	ㅣ
			==================================
			   ㅣ
			   1: 음수
			   0: 양수
		2byte => 16bit
			01(15) ==> 32767
		4byte => 32bit ==> 21억 4천
		8byte => 64bit ==> 어마무시
		
		======================== 데이터형
		변수 선언
		=======
		데이터형 변수명
		==> 저장할 메모리 크기 생성 => 별칭을 변수
		==> 변수 : 한개 데이터를 저장하는 메모리 주소의 이름
		==> 모든 프로그램에 변수가 없는 프로그램은 존재하지 않는다
				=========== 은퇴하면 안나옴
				프로그램 : 변수 / 연산자 / 제어문
				========================== 관련된 내용을 묶어서 사용 => class
				(입력 / 처리 / 결과 => 메소드) => class
		자바에서 지원하는 기본형 / 데이터형 / 자료형
		1) 정수 저장
			1byte: byte => 파일읽기 / 네트워크 전송
				저장하는 범위 : -128 ~ 127
			2byte: short => C언어 호환 문제 => 거의 사용안함
				저장하는 범위 : -32768 ~32767
			4byte: int => 기본 : 컴퓨터는 모든 정수는 int로 인식함
						  정수의 디폴트
				저장하는 범위 : -21억4천~21억4천
			8byte: long => 금융권 / 증권 / 공기업
		2) 실수 저장
			float : 4byte => 소수점 : 6자리
			double: 8byte => 소수점 : 15자리
					컴퓨터에서는 디폴트 (모든 실수는 double로 인식)
		3) 문자 저장
			char : 2byte(멀티바이트 => Unicode)
					0~65535
				   1byte => 싱클파이트 => ASC
				   0~255문자만 사용이 가능 => C/C++
				   브라우저 : C로 만들어짐
				   => 한글은 1글자당 2byte
		4) 논리(true / false) : 1byte
			=> true: 1
			=> false : 0
		자바 기본형
		로또 : 당첨금 => long
		
		=================================================
				정수		실수		문자		논리
		=================================================
		1byte  *byte                  * boolean
			   -128~127				  true / false
		=================================================
		2byte  short		   *char : String
			   -32768~32767   0~65535
		=================================================
		4byte  *int    float
			-21억 4천~21억4천	
		=================================================
		8byte *long	 *double(15자리)
			  2^63
		=================================================
			*구분
			 int / long
			 		=> 숫자 뒤(l,L)
			 float / double
					=> 실수(f,F)
			데이터형 크기
			byte < short < int < long < float < double
				   char
			정수보다는 실수가 크다 (byte 크기로 결정되지 않는다)
			=> 수 표현
			
			 
		큰데이터형 = 작은 값 받을 수 있음
		작은데이터형 = 큰 값 받을 수 없음
		
		long = int 가능
		int = long 오류발생
			 
	2. 저장된 데이터 활용
	3. 결과물 출력
	
	
	
	
	1. 변수 => 선언
		데이터형 변수명; ex) int num;
	2. 초기값 설정
		변수명 = 값; ex) num = 10
	3. 변경 가능
		변수명 = 값; ex) num = 12
	4. 출력
		System.out.println(변수명);
		
	1) 변수를 만드는 방법 ===> 26page
		1. 알파벳이나 한글로 시작
			단 알파벳은 대소문자를 구분한다
		2. 숫자 사용이 가능
			(앞에 사용 불가)
		3. 특수문자 사용이 가능(_, $)
			=> _를 주로 사용
			   단어가 두개
			   kor_score
			   _kor: 임시변수(테스트용)
		4. 키워드는 사용 할 수 없다.
			====== 자바에서 사용하는 단어
			ex) int int;
		5. 공백을 사용할 수 없다
			ex) file name
		6. 문법(x) => 변수는 소문자로 시작한다.
		7. 문자의 길이는 상관없다. => 3~7글자 사이면 좋음
		8, 데이터 저장 (변수)
	
	2) 선언하는 방식
		int a;
		int b;
		int c;
		int d;
		int e;
		=> int a,b,c,d,e;
		변수 : 메모리 저장 공간 => 변경이 가능한
*/

public class 변수1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte c = (byte) 500;
		System.out.println(c);
	}

}
