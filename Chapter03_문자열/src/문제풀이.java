// 1. 대소문자가 있는 문자열을 입력받아서
// 대묹는 소문자로 소문자는 대문자로 변경
// 예) abdDef ==> ABDdEf
//2 문자열을 입력받아서 역순으로 출력하는 프로그램 작성
//예) abcde => edcba
import java.util.Scanner;
import java.util.regex.Pattern;
//toString() : 객체의 주소 => 오버라이딩
/*
 * length()
 * subString()
 * equals()
 * contains()
 * indexOf()
 * valueOf()
 * trim()
 *--------------------------------------
 * replace()
 *--------------------------------------
 * split()
 * --------------------------------------필요적으로 암기
 * AI==> 데이터 수집 ==> 데이터 분석 ==> 교육
 *            -----------------전처리기
 */
public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str ="";
		String text1 = "";
		String text2="";
		while(true) {
			System.out.print("문자를 입력하시오");
			str = scan.nextLine();
			if(Pattern.matches("^[a-zA-Zㄱ-ㅎ가-힣ㅏ-ㅣ]*$",str)) {
				break;
			}
		}
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==str.toLowerCase().charAt(i)) {
				text1+=str.toUpperCase().charAt(i);
			}
			else {
				text1+=str.toLowerCase().charAt(i);
			}
		}
		System.out.println(text1);
		for(int i=str.length()-1;i>=0;i--) {
			text2+=str.charAt(i);
		}
		System.out.println(text2);

	}
	

}
