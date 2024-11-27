// replaceAll("", " ")
public class 문자열_9 {
	public static void main(String[] args) {
		String data="Hello 자바 123";
		
		//한글만
		System.out.println(data.replaceAll("[^가-힣]", "")); //^제외라는 뜻 => 한글만 제외
		
		//영어만
		System.out.println(data.replaceAll("[^A-Za-z]", "")); 
		
		//숫자만
		System.out.println(data.replaceAll("[^0-9]", "")); 
		
	}
}
