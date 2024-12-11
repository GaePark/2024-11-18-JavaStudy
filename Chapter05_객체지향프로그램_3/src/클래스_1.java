/*
 *      구성요소
 *          => 멤버변수
 *                 ㅣ공통으로 사용하는 변수여부 (static)
 *                 ㅣ정보 전체 / 데이터관리 => 오라클 (static)
 *                                                       ㅣ공유된 데이터
 *          => 생성자 / 초기화 블럭
 *                ------ 생략이 가능 / 오라클 연동 (드라이버 등록)
 *                          윈도우의 레이아웃
 *                          웹 => 자동 로그인
 *               static 블럭 : MyBatis 연동
 *          => 활용 => 메소드 ***
 *                              ㅣ다른 클래스 연동 (메세지)
 *                              ㅣ기능 처리 => 재사용
 *                웹(JSP / Spring)
 *                    => 1. 변수 , 2. 메소드, 3. 생성자, 4. 인터페이스, 5. 라이브러리
 *                          => 인스턴스
 *                          => 공통으로 사용되는 부분 : static
 *                               Header / Footer
 *                    -------------------------------------------------------------
 *                1. 메소드 형식
 *                    [접근지정어][제어어] 리턴형 메소드명(매개변수.....)
 *                                                                       ㅣ 0이상 => 여러개 사용이 가능
 *                                                           ㅣ 변수 => 식별자
 *                                                                => 소문자 시작
 *                                                                => 약간의 의미만 부여
 *                                                                => 두개의 단어를 이용
 *                                                                       파일 이름을 가지고 온다
 *                                                                                        ---------
 *                                                                           getFileName() => 헝거리식 표기법
 *                                                                           get_file_name()
 *                                                  ㅣ사용자가 요청한 결과값
 *                                                     반드시 한개값만 설정
 *                                                     -없는 경우에는 void
 *                                                     -기본형/배열/클래스
 *                                       => static : 공통으로 적용되는 메소드
 *                                       => final : 종단 메소드 => 확장 , 변경이 불가능
 *                                       => abstract : 선언만 할때 
 *                                             ---------
 *                                             프로그램에 맞게 구현해서 사용
 *                                             => 버튼 => click();
 *                                             => 추상클래스 / 인터페이스
 *                                             => 설계
 *                    => 다른 클래스와 연결 => 공개 (public)
 *                    ㅣpublic/protected/private/default
 *                                                              ㅣ같은 폴더 안에서만 접근
 *                                                   ㅣ자신의 클래스영역에서만 사용이 가능 (은닉화)
 *                                    ㅣ같은 폴더 (패키지)
 *                                      상속받은 클래스
 *                       모든 클래스 사용이 가능 
 *                       리턴형 메소드명(매개변수...) => 선언부
 *                       {
 *                       			구현부
 *                                 return 값; => void일때는 생략이 가능
 *                                                       ㅣ컴파일러가 자동으로 호출
 *                       }
 *                       리턴형
 *                       return 값 => 데이ㅓ형 동일 (권장)
 *                                     => 리턴형이 큰 데이터형을 사용
 *                2. 메소드 호출
 *                    인스턴스 메소드 => 객체명.메소드명(값....)
 *                    static 메소드  => 클래스명.메소드명(값...)
 *                    
 *                    new A().display();//약식 표현
 *                    ------------------------------------------------
 *              Date date = new Date();
 *              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd")
 *              String today=sdf.format(date)
 *              
 *              String today = new SimpleDateFormat("yyy-mm-dd").format (new Date)
 *                    
 *                3. 메소드 종류
 *      
 *      
 */

public class 클래스_1 {
	int a = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new 클래스_1().a);

	}

}
