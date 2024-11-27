/*
 * 문자열 분리 / 자르기 / 변경 / 찾기
 * = charAt(int index)
 * H e l  l  o    J a v a 
 * 0 1 2 3 4 5 6 7 8 9
 */
// 사용자의 문자열 입력값을 받아서 => a A가 몇개인지 확인
import java.util.Scanner;
public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String data = "Hello Java";
//		
//		System.out.println("첫번째 문자:"+data.charAt(0));
//		System.out.println("마지막 문자:"+data.charAt(data.length()-1));


		Scanner scan = new Scanner(System.in);
		
		
//		int count = 0;
//		for(int i=0;i<data.length();i++) {
//			char ch = data.charAt(i);
//			if(ch=='a' || ch=='A') {
//				count++;
//			}
//		}
		// 지역변수 => {}변수 => {} 끝나면 사라지는 변수
//		System.out.println("a,A포함은 "+count);
		String data="";
		while(true) {
			System.out.print("문자를 입력하세요");
			data = scan.nextLine();
			if(data.length()%2==0) {
				break;
			}
			System.out.println("문자는 짝수여야합니다.");
		}
		
		boolean bCheck = true;
		for(int i=0;i<data.length()/2;i++) {
			char ch1= data.charAt(i);
			char ch2= data.charAt(data.length()-1-i);
			if(ch1!=ch2) {
				bCheck=false;
				break;
			} 
		}
		System.out.println("===== 결과값 =====");
		if(bCheck == true) {
			System.out.println(data + "는(은) 좌우 대칭입니다.");
		} else {
			System.out.println(data + "는(은) 좌우 대칭이 아닙니다.");
		}
	}

}
