/*
 * 문자의 위치 찾기
 * indexOf(문자) 앞에서부터 몇번쨰 => 0부터 시작
 * lastIndexOf(문자) 뒤에서부터 몇번째 => 1부터시작
 * => 확장자?
 * 
 * Hello Java
 */


public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			String data = "Hello Java";
			// 웹에서 등장 " URL => 마지막 파일명을 찾아서 처리
			// 
			int a=data.indexOf("a");//7
			int b = data.lastIndexOf("a");//9
			int c=data.indexOf("c");//-1
			
			System.out.println("a=" +a);
			System.out.println("c=" +b);
			System.out.println("c=" +c);
	}

}
