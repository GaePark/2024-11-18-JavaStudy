package com.sist.main;
/*
 * 자바에서 지원하는 라이브러리
 *                        ---------- 프로그램에 필요한 클래스를 모아서 개발시에 사용이 가능
 * => 라이브러리중심 => 조립
 * => Scanner / System / String ...
 * 
 * => 가장 많이 사용하는 라이브러리
 *     1) 자바에서 지원
 *         java.lang = 9 
 *             Object
 *             System
 *             String
 *             StringBUffer
 *             Math
 *             Wrapper : 데이터형을 클래스화
 *             ---------
 *                 ***=> Integer
 *                 ***=> Double
 *                 ***=> Boolean
 *                 => Byte
 *                 => Float
 *                 ***=> Long
 *                 ....
 *         java.util   = 10
 *             => Scanner
 *             => Date / Calender
 *             => Collection
 *                   ----------> 배열 대체
 *                   List / Set / Map
 *                   ----------------- interface
 *                   List : ***ArrayList,Vector,LinkedList,Stack
 *                                                             l
 *                                                         Queue
 *                   Set : TreeSet /*** HashSet : 중복없는 데이터
 *                   Map :*** HashMap / Hashtable
 *         java.io     = 11
 *              => FileReader / FileWriter
 *              => InputStream / OutputStream
 *              => BufferedReader / BufferedWriter
 *              => BufferedInputStream / BufferedOutputStream
 *              => 입출력 : 파일 / 메모리 / 네트워크
 *              => ~Stream , Reader / Writer
 *                  -----------   -----------------
 *                  1byte              2byte(한글포함)
 *                     ㅣ네트워크 , 파일업로드 / 다운로드
 *             => File
 *         java.sql   = 12
 *             => Connection
 *             => Statement
 *             => ResultSet
 *         ----------------------------
 *         java.net
 *             => URL / ServerSocket / Socket
 *         java.text
 *             => SimpleDateFormat / MessageFormat / DecimalFormat
 *         java.lang.reflect
 *             => 리플렉션 => 메소드 /클래스 / 변수 / 생성자 제어
 *         *** Annotation, 열거형
 *               -------------
 *         J2SE
 *         웹 라이브러리 : JSP / SErvlet / Spring => 2차 자바
 *         J2EE
 *         
 *         J2ME (X) ==대체==> Kotlin => Dart(Flutter)
 *         ----------------------------
 *         javax.swing(X) => 한번사용후 버림
 *         ----------------------------1.0
 *         => javax.http
 *         => javax.servlet.http
 *         ----------------------------2.0
 *         => org.springframework
 *         
 *         java / Oracle / JSP / Spring / Spring-Boot
 *         --------------------------------------------- Back
 *         HTML / CSS / JavaScript => TypeScript
 *         ---------------------------Front
 *                                      l
 *                                 JQuery / VueJS / ReactJS / NodeJS / NextJS
 *                                 -------------------------------------------------
 *         1. 데이터 문석 : 파이썬 (넘파이 , 판다스 , Matplotlib)
 *                               Spring <==> 파이썬
 *         2. 검색엔진 : ElasticSearch : CRUD / 검색
 *         
 *     2) 외부업체 지원 : Jsoup / lombok / Spring 
 *         => mvnrepository.com
 *         => simple-json / bson ....
 *     3) 사용자 정의 : 잘만들어진 클래스 / 자주 사용하는 클래스
 *         => .jar
 *         => 1차 => JSP(MBC=>Spring형식)
 * ====== ================================
 * 9장
 *     java.lang패키지
 *     1) import를 생략할 수 있다 => 자동 추가
 *         => 가장 많이 사용 라이브러리
 *     2) 대표 클래스
 *         = Object : 모든 클래스의 상위 클래스
 *                         ----------- Object 상속을 받는다
 *         = 모든 클래스에서 사용하는 기능 (메소드)
 *         = toString() : 객체 주소
 *             => 명시적 / 묵시적
 *                  A a = new A();
 *                  =>System.out.println(a.toString())
 *                  =>System.out.println(a)
 *             => 자주 사용이 된다 / 객체의 값이 정상적으로 처리 확인
 *             => 객체를 문자열화 시킨다
 *         => clone() : 객체를 복제할 경우
 *             => 객체 복사
 *                   얕은 복사 => 같은 주소를 이용
 *                   -------- Call By Reference
 *                   깊은 복사 => clone => 새로운 메모리에 저장
 *                   -------- 게임 (아바타) => prototype
 *         = finalize() : 소멸자 => 메모리 해제시에 자동 호출된다
 *            ------------ System.gc() : 바로 회수
 *            ------------ 프로그램 종료시에 회수
 *         = equals() => 객체 비교
 *         = hashcode() => 비교
 *          
 */
class Student
{
	private String name,phone,address;
	
	public Student(String name, String phone, String address) {
			this.name=name;
			this.phone=phone;
			this.address = address;
	}
	public void print()
	{
		System.out.println("이름:" + name);
		System.out.println("주소:" + address);
		System.out.println("전화:" + phone);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("이름:" + name);
		System.out.println("주소:" + address);
		System.out.println("전화:" + phone);
		return super.toString();
	}
	
	
}
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("홍길동", "010-1111-1111", "서울");
		Student s2 = new Student("심청이", "010-2222-2222", "경기");
		
//		s1.print();
		System.out.println(s1.toString());
//		s2.print();
		System.out.println(s2);
		
	}

}
