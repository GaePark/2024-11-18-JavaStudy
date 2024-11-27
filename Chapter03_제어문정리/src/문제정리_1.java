/*
 * 1. String
 *     문자열 저장 클래스 / 일반 데이터형 처럼 사용 가능
 *     String name = "";
 *                          ---
 *     String name = new String("초기값");
 *     
 *     클래스 => 문자열을 제어하는 기능을 제공
 *                                      ---- 메소드
 *             => 완전 표준화(확장 불가능 => 변경해서 사용이 불가능)
 *      메소드
 *      = 결과값 (리턴형)
 *      = 어떤 데이터를 첨부 (매개변수)
 *      = 메소드명
 *      
 *      = 기능             ㅣ매개변수
 *         int = length()
 *                  ㅣ메소드명
 *         ---    ---------
 *         l리턴형
 *         
 *         boolean = equals(String s) => if
 *         String s1 = "";
 *         String s2 = "";
 *         // 아이디 중복체크, 로그인 ....
 *         if(s1.equals(s2)) 같은경우
 *         if(!s1.equals(s2)) 다른경우
 *         
 *         //우편번호 검색
 *         boolean = contains(String s) => 포함된 문자인지 여부
 *         String s1="asdfasdf";
 *         String s2="a";
 *         if(s1.contains(s2)) => s1안에 s2가 포함되어있냐 => 긴문장 안에 짧은문장을 넣어함
 *         
 *         // 서제스트 => 자동완성기
 *         boolean startsWith(String s) => 시작하는 문자열인지 여부
 *         String s1="Hello Java";
 *         String s2 = "He";
 *         String s3 = "Java"
 *         if(s1.startsWith(s2)) => s1이 s2로 시작했는지 확인
 *         if(s1.endWith(s3)) => s1의 끝나는 문자열이 s3인지 확인
 *         
 *         String = toUpperCase() => 대문자로 변환
 *         String s1 = "Hello Java"
 *         s1.toUpperCase() => 대문자 => HELLO JAVA
 *         s1.toLowerCase() => 소문자 => hello java
 *         
 *         
 *         
 * 
 * 
 *         
 */
public class 문제정리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
