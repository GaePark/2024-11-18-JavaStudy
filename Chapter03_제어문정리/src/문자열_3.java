/*
 * 문자열 정보
 *   => laength() : 문자의 갯수
 *   => 비밀번호는 8자리 이상...
 *   next() => 공백전까지
 *   nextLine() => 공백까지 포함
 *   
 */
import java.util.*;
// 사용자가 입력하 문자의 갯수 확인 => 공백 포함
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 입력하세요");
		
		String str = scan.nextLine();
		
		System.out.println(str.length());

	}

}
