import com.sist.data.*; // 사용자 정의
import java.util.Scanner;
public class 문자열배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터 읽기
		String[] fdata = ArrayData.korEng;
		Scanner scan = new Scanner(System.in);
		System.out.print("과일명을 입력:");
		String f=scan.next();
		for(String a : fdata) {
			if(a.contains(f)) {
				String change=a.substring(a.indexOf(":")+1);
				System.out.println(f + "는(은) 영어는 " + change);
				break;
			}
		}
	}

}
