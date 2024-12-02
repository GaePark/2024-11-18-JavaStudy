// char
// 버블정렬
/*
 *  char => 문자열은 불가능
 *               ==== compare() / equals()
 *                              <> 
 *   => 정수형 취급한다
 *         연산자를 사용하면 정수로 변경      
 *         
 *            B C A E D
 *            -  -
 *            C B
 *            -    -
 *            C   A
 *            -        -
 *            E       C
 *            -          -
 *            E         D
 *            ----------------------1round                 
 *            ..
 *            ..
 *            E D C B A
 *
 */
import java.util.Arrays;
public class 배열응용_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


char[] ch = new char[5];
		for(int i=0;i<ch.length;i++) {
			ch[i]= (char) (( (Math.random()*26)+65));
		}
		System.out.println("정렬 전: ");
		for(char i: ch) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0; i<ch.length-1;i++) {
			for(int j=1+i; j<ch.length;j++) {
				if(ch[i] <ch[j]) {
					char temp = ch[i];
					ch[i]=ch[j];
					ch[j]=temp;
				}
			}
			System.out.println(Arrays.toString(ch));
		}
		System.out.println("정렬 후:");
		for(char i: ch) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		Arrays.sort(ch);
		System.out.println("정렬 후:");
		for(char i: ch) {
			System.out.print(i + " ");
		}
		
	}
	

}
