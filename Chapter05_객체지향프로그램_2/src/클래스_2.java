// 멤버변수 , 공유 변수의 초기화 => 값 주입
/*
 * 구성요소 => 설계 => 메모리에 저장후에 사용
 *                               -------------------- 객체
 * 클래스
 *     ***= 멤버변수만 가지고 있는 경우 => 데이터형 클래스
 *               사용자 정의 데이터형 : ~VO, ~DTO
 *     ***= 메소드만 가지고 있는 경우 => 액션 클래스 (기능)
 *               연결용 : 오라클 연결 / 브라우저 연결
 *                           ----------  -------------
 *                            ~DAO          ~Model (~Controller, ~Action)
 *               브라우저 ======= 오라클(X)
 *               -------- HTML / CSS => 화면 UI
 *               브라우저 ====== 자바 ===== 오라클
 *                              => React => Class형
 *                              => React => Hooks => function
 *                              => React => Redux
 *                              => React => React-Query
 *                              => React => Next
 *              => Front + Back => Spring-Framework => 3
 *              => Front /  Back             ㅣ지원하지 않는다.
 *                    --------------
 *                                 ㅣSpring-Boot =>4
 *                     l VSCode / Web Storm(AI)
 *                => MyBatis(SQL)  / JPA
 *                => Jquery(Ajax) ==> X => 1차 (JSP)
 *                => VueJS==> 2차
 *                     
 *     = 혼합형 : 변수 + 메소드 (크롤링 , OpenApi)
 *                    ~Manager , ~Service
 *                    
 *     class ClassName {
 *        -------------------
 *          변수 설정 => 클래스안에서 필요한 데이터를 설정
 *          // 기본형 / 클래스 / 배열 / 열거형 ... 
 *        -------------------
 *        변수 => 사용하기 위해서 초기값 (초기화)
 *        1) 명시적 초기화 -- 우선
 *              int a=100;
 *        2) 생성자 
 *            1. 클래스를 메모리에 저장할 때 호출하는 메소드
 *                new 생성자 ()
 *                ----  -------- 초기값을 주입
 *                저장할 메모리 공간 생성
 *                => 멤버변수의 초기화 담당
 *            2. 특징
 *                = 클래스명과 동일
 *                class A => A()
 *                class B => B()
 *                = 리턴형이 없다.
 *                class A
 *                => void A()
 *                => int A()
 *                --------------- 일반 메소드
 *                = 여러개 만들 수 있다
 *                    ----------------- 오버로딩
 *                    오버로딩의 조건
 *                    ---------------
 *                    1) 메소드명이 동일
 *                    2) 리턴형 관계없다.
 *                    3) 매개변수 => 갯수나 데이터형이 다른 경우
 *                    4) 접근지정어는 관계없다.
 *                    5) 한개 클래스안에서 존재
 *                    class A
 *                    => A() ======> A()
 *                    => A(int a)====> A(int) 
 *                    => A(int a, int b)=> A(int,int)
 *                    => A(String s)===>A(String)
 *                 = 상속에서 예외
 *                 = 생성자가 필요한 위치
 *                    A() => 매개변수가 없는 생성자 => 디폴트 생성자
 *                    *** 생성자가 없는 경우에는 컴파일러에 의해 생성
 *                          -------------------- 디폴트 생성자
 *                  class A
 *                  {
 *                     A() {}
 *                  }
 *                  class A
 *                  {
 *                     A(int a) {}
 *                  }
 *                  
 *                  class A
 *                  {
 *                     //A(){} => 첨부
 *                  }
 *                  
 *                  => 웹 => 오라클 연결 (시작과 동시에 연결)
 *                        서버 연결 / 자동 로그인 / 파일 읽어서 데이터를 저장
 *               = 생성자의 용도
 *                   = 변수 초기화 (명시적인 초기화가 안되는 경우)
 *                                      => 구현후에 데이터 처리
 *                   = 시작과 동시에 처리하는 기능이 있는 경우
 *                       윈도우 초기화 (화면 UI) 
 *                       파일 읽기 ...
 *               = 생성자 호출
 *                   new 생성자 () = 메모리가 생성
 *                   new 생성자() = 메모리가 생성
 *                   new 생성자() = 메모리가 생성
 *                   => 한번만 호출
 *        3) 초기화 블록
 *             = 인스턴스 블록
 *             = static 블록
 *        -------------------
 *         메소드 : 기능 처리
 *        -------------------
 *     }
 */
 class Student{
	 // 1. 저장 => 명시적인초기화
	 int hakbun =1;
	 String name="홍길동";
	 String sex="남자";
	 
	 // 초기화
	 // Student() => 자동 생성 => 디폴트 생성자
	 // 변수값 변경 ... 사용자로부터 값을 받아서 저장
	 //2. 생성자
	 Student() {
		 System.out.println("Student() 디폴트 생성자 Call..");
		 hakbun=2;
		 name="심청이";
		 sex="여자";
				 
	 }
	 // => 생성자 여러개 사용이 가능
	 Student(int h, String n , String s){
		 hakbun=h;
		 name=n;
		 sex=s;
	 }
	 Student(int h, String n){
		 // 생성자 => 자신의 생성자 호출
		 this(); // super() => 상속 내린 클래ㅡ의 생성자
		 
		 hakbun=h;
		 name=n;
	 }
	 Student(String n, String s){
		 this();
		 name=n;
		 sex=s;
	 }
	 // student(10.5,'A',100)
	 //오버로딩 기법
	 Student(int a, int b,int c){
		 System.out.println(a);
		 System.out.println(b);
		 System.out.println(c);
	 }
	 Student(char a, double b,int c){
		 System.out.println(a);
		 System.out.println(b);
		 System.out.println(c);
	 }
	 //실행
	 Student(double a, double b,double c){
		 System.out.println(a);
		 System.out.println(b);
		 System.out.println(c);
	 }
 }
public class 클래스_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student hong =new Student();
//		System.out.println(hong.name);
//		System.out.println(hong.hakbun);
//		System.out.println(hong.sex);
		Student hong = new Student(1,"홍길동","남자");
		Student shim = new Student();
		Student park = new Student(3,"박문수","남자");
		
		System.out.println(hong.hakbun);
		System.out.println(hong.name);
		System.out.println(hong.sex);
		
		System.out.println(shim.hakbun);
		System.out.println(shim.name);
		System.out.println(shim.sex);
		
		System.out.println(park.hakbun);
		System.out.println(park.name);
		System.out.println(park.sex);
		
		Student lee=new Student(4,"이순신");
		System.out.println(lee.hakbun);
		System.out.println(lee.name);
		System.out.println(lee.sex);
		
		Student kim = new Student("김두한","남자");
		System.out.println(kim.hakbun);
		System.out.println(kim.name);
		System.out.println(kim.sex);
		Student d = new Student(10.5,'A',100);
		/*
		 * 같거나 작은 데이터형을 보내도 실행됨
		 * 권장 : 같은 데이터 전송
		 */
	}

}
