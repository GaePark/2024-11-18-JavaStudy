//대문자 변환
import java.util.Scanner;
/*
 * 함수 : function
 * 메소드: method
 * =============기능상으로는 동일
 * class종속
 * C/C++/Python => function
 * Java/Kotlin => method
 * 
 * replace(문자, 문자) || (문자열, 문자열)
 *            ---   ---
 *            old  new
 */
public class 문자열_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		System.out.print("문자를 입력하세요:");
//		String str = scan.nextLine();
//		
//		System.out.println("대문자:" + str.toUpperCase());
//		System.out.println("소문자:" + str.toLowerCase());
		// Upper / Lower => 오라클 함수
		// 데이터 관리 => 자바+오라클 => JSP에서 HTML로 변경
		String s = "Hello Java";
		System.out.println(s.replace("a", "k"));
		System.out.println(s.replace("Java", "Oracle"));
		// 오라클 연동
		// 이미지 , 줄거리 , 내용
		// | , &, ' ' => 오라클에서 첨부할 수 없다.
		// & => replace
//		---------------------↓ 오라클에서의 뜻
		// & => Scanner
		// || => 문자열 결합
		// 문자열 => ' '
	}

}
