/*
 *  문자 자르기
 *  ***** X 10000000
 *  
 *  substring : 문자열을 자르기
 *  ㅣ 지정된 위치부터 마지막까지자르기
 *     Hello Java
 *     0123456789
 *     substring(6) => Java
 *     
 *  ㅣ 중간에서 자르기
 *     substring(1,4) => ell
 *                     --endIndex-1 
 *     공백 제거 : trim()
 *  ---------------------------------- javaScript 동일
 *                     
 */
//import java.util.Scanner;

public class 문자열_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 원본 그래도 유지
		
//		Scanner scan = new Scanner(System.in);
//		
//		String data = scan.nextLine();
//		
//		int ch = data.lastIndexOf(".")+1;
//		String str = "";
//		
//		//파일값 찾기
//		for(int i=ch; i<data.length();i++) {
//			str+=data.charAt(i);
//		}
//		System.out.println(data.substring(ch));
//		System.out.println(str);
		
		String data="ID:admin,Pwd:1234";
		
		String id = data.substring(data.indexOf(":")+1,data.indexOf(","));
		System.out.println("ID:" + id);
		String pwd = data.substring(data.lastIndexOf(":")+1);
		
		System.out.println("PWD:" + pwd);
		
		String address = "서울 동대문구 회기동 346-14[새주소] 서울 동대문구 경희대로4길 76";
		
		String oldAd = address.substring(0, address.indexOf("]")+1);
		String newAd = address.substring(address.indexOf("]")+1);
		System.out.println("oldAd:"+oldAd);
		System.out.println("newAd:"+newAd.trim()); //trim 좌우 공백 제거
		
		String s="Hello Java";
		String ss=s.substring(s.indexOf(" ")+1);
		System.out.println(s);
		System.out.println(ss);
	}

}
