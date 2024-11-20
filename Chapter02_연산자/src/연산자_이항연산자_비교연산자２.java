
public class 연산자_이항연산자_비교연산자２ {
	public static void display() {
		char a = (char)((int)(Math.random()*26)+65);
		System.out.println(a);
		
		char b = (char)((int)(Math.random()*26)+65);
		System.out.println(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = (char)((int)(Math.random()*26)+65);
		System.out.println(a);
		
		char b = (char)((int)(Math.random()*26)+65);
		System.out.println(b);

		//==
		System.out.println(a==b);
		//!=
		System.out.println(a!=b);
		//<
		System.out.println(a<b);
		//>
		System.out.println(a>b);
		//<=
		System.out.println(a<=b);
		//>=
		System.out.println(a>=b);

	}
		

}
