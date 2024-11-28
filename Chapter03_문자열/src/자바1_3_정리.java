/*
 * 1. 변수 = 한개만 저장하는 공간 , 변경이 가능
 *          => 1. 저장
 *                2. 읽기
 *                3. 수정
 * 		----
 * 		1) 지역변수 : 메소드 안에서 선언되는 변수
 * 		2) 멤버변수
 * 		3) 공유변수
 *      --------------------------------------------------
 *      => 변수를 저장하기 위해서는 반드시 필요한 내용
 *           ---------------------------------------
 *           메모리 크기 결정 / 클래스 (JVM에서 크기를 모른다)
 *                                         ---------------------
 *                                         ㅣ new => 새로운 메모리 생성
 *           기본형
 *           ------
 *           정수 : byte(1byte),***int(4byte),             long(8byte)
 *                    -128~127   -21억4천~21억4천
 *           실수 : ***double(8byte) => 소수점 15자리 이상
 *           논리 : ***boolean(1byte) => true/false
 *           문자 : char(2byte) => 0~65535
 *           ----------------------
 *           참조형 : 배열 / 클래스 (*** String, Integer, ArrayList)
 *                                            문자열,  숫자로 ,    배열         
 *                    오라클 : Connection / Statement / ResultSet
 *           *** 변경이 되는 값
 *                 누적 / 루프
 *                 *** 가독성
 *                       i/j => a/b m/n
 *                   입력값
 *                   
 *      
 *     
 *     메모리 저장
 *     ---------------------------------------------------
 *       methodArea : Method / static
 *     ---------------------------------------------------
 *       Stack : 메모리 자체에서 관리 => 지역변수
 *                  {}이 종료가 된 경우 사라진다
 *     ---------------------------------------------------
 *       Heap : 실제 데이터 공간 : 클래스 / 배열
 *                 자동으로 해제되지 않는다 => 개발자가 처리
 *                 new / delete: => 가비지 컬렉션
 *                                           ㅣ자동 메모리 회수
 *                 => 메모리 저장
 *                      ----------- 확인 int malloc() => new
 *                                    해제  free() => delete
 *     ---------------------------------------------------
 *     
 *     => 사용자 요청에 따른 처리
 *     1) 연산자
 *        단항연산자 (++,--,!,(type))
 *                                 -------- 강제 형변환 => 클래스형변환
 *                                                                클래스의 크기
 *                                                                is-a , has-a
 *                                                                        ㅣ포함 클래스
 *                                                                        ㅣJOIN
 *                             -- true / false만 사용
 *                                true => false , false => true
 *             ++ , -- 반복문
 *             a++ ++a
 *             ----   ----
 *                     증가가 먼저 나중에 다른 연산
 *             다른 연산 처리 => 나중에 증가
 *        이항연산자(+,-,*,/,% => == != < > <= >= => && ||)
 *             1. 모든 연산자 같은 데이터형만 연산이 가능
 *                 10+10.5
 *                 --- 10.0 => 10.0+10.5 ==> 20.5
 *                 + : 산술 / 문자열 결합
 *                              -----
 *                              +
 *                              concat("aaa")
 *                      = String s="Hello";
 *                         String s1=" Java";
 *                         String s2=s+s1; => Hello Java
 *                         String s3=s.concat(s1) => Hello Java
 *                      * 산술규칙
 *                             = 같은 데이터형만 연산이 가능
 *                             = int 이하(byte,shor,char) => 결과값 int로 바뀐다.
 *                      / = 0으로 나눌 수 없다. 정수/정수 = 정수
 *                      % : 남는 부호 => 왼쪽 부호
 *                             -5%2 =-1
 *                             -5%-2=-1
 *                              5%-2= 1
 *                              5%2= 1
 *                        ----------------------------------------------------------------
 *                        ==, !=, < ,> , <= , >=
 *                        ===> boolean : 조건문이나 반복문의 조건에서 주로 사용
 *                        ===> 숫자, boolean : ==, !=
 *                        &&(직렬연산자 ==> 양쪽의 조건이 true)
 *                        ||(병렬연산자 ==> 한쪽의 조건이 true=> true)
 *                        ***  &&연산자 => 범위 포함, 기간 범위
 *                               조건 && 조건
 *                               false ==> 뒤 조건은 수행하지 않는다.
 *                                            효율적인 연산
 *                              ||연산자 => 잘못된 입력 => 범위 초과, 범위 미만
 *                              조건 || 조건
 *                              true   ---- 처리안함
 *                             
 *                    +=, -=, =
 *                    대입 연산자
 *                    += : 여러개 증가
 *                    int a =10;
 *                    a++ => 11;
 *                    a+=5 => 15
 *                    -= : 여러개 감소
 *                    a-=5==> 5 ==> a=a-5
 *                    
 *                    ==> 1씩 증가
 *                    a++ , ++a , a+=1, a=a+1
 *                    ==> 1씩 감소
 *                    a-- , --a, a-=1 , a=a-1
 *                    
 *        삼항연산자 (? :) => JSP에서 주로 사용, 게임
 *          (조건)?  값1: 값2
 *          true => 값1
 *          false =>값2 ====> if ~ else
 *          
 *          curpage>1 => curpage-1:curpage
 *          
 *          <html>
 *          	<body>
 *                <%
 *                    if(curpage>1)
 *                    {
 *                    %>
 *                    <a href="<%=curpage-1%>">이전</a>
 *                    <%
 *                    }
 *                    if(curpage<totalpage)
 *                    {
 *                %>
 *                    <a href="<%=curpage-1%>">이전</a>
 *                    <%
 *                    }
 *                    %>
 *             </body>
 *          </html>
 *          <html>
 *              <body>
 *                 <a href=<%=curpage>1?curpage-1:curpage%>/>
 *              </body>
 *          </html>
 *          
 *     2) 제어문
 *     	    if, if~else
 *           조건문
 *           => if(조건문)
 *           {
 *               조건 true일때 수행
 *           }
 *           => if(조건문)
 *                {
 *                     조건이 true일때 수행
 *                }
 *                else
 *                {
 *                    조건이 false일때 수행
 *                }
 *         for , while
 *             반복문
 *             => for(초기식;조건식;증감식)
 *                  {
 *                      반복 문장
 *                  }
 *             => 초기식
 *                 while(조건식)
 *                 {
 *                 	    반복 문장
 *                     증감식
 *                 }
 *         break
 *         
 *     --------- 묶어서 처리 => 메소드
 *     1. 입력
 *     2. 처리 => 세분화
 *     3. 출력
 *     
 */
import java.util.Scanner;

public class 자바1_3_정리 {
	// 멤버변수 => 자동 초기화
	static int userInput(String s) {
		Scanner scan=new Scanner(System.in);
		System.out.print(s+" 입력:");
		return scan.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//지역변수 => 초기화해야함
//			System.out.println("a=" + a);
//		Scanner scan= new Scanner(System.in);
//		System.out.print("년도 입력:");
//		int year=scan.nextInt();
//		System.out.print("월 입력:");
//		int month=scan.nextInt();
//		System.out.print("일 입력:");
//		int day=scan.nextInt();
		
		int year=userInput("년도");
		int month=userInput("월");
		int day=userInput("일");
		
		System.out.println(year+"년도 "+month+"월 "+day+"일");
	}

}
