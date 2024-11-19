//초기값 => 데이터를 저장하는 방법
/*
	자바에서 사용하는 표현법
	
	1. 정수
		byte / short / int => 숫자 사용 (범위만 초과하지 않는다)
		숫자표현
		  10 => 10진법
		  *** 012 => 8진법
		  날짜
		  	=> 2024-09-20 (시간)
		  			=== 8진법 => error
		  	
		  0x12 => 16진법
		  
		long 표현
			10L, 10l
		실수표현
			10.5 => double
			10,5f => float
			
		문자형
			한글자만 저장이 가능
			'A' = 문자      "" => 문자열 => 여러개문자 사용이 가능 "ABCD..."
		논리형
			true / false
		
		데이터 저장 방법
		1) 명시적 초기화
			int a = 10;
		2) 입력을 받아서 초기화
		3) 난수발생
		
		변수 선언
		선언과 동시에 값을 저장
		데이터형 변수명 = 값; (사용빈도가 많다)
		
		선언 후
		데이터형 변수명;
		변수명 = 값;
		
		*** 변수 선언만 하고 사용하면 => error 발생 (값이 들어가 있어야한다)
		
*/
public class 변수_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수
		byte byteVal = 127; //-128~127
		/*
		 * ======
		 * 	127 ==> byteVal
		 * ====== 1byte
		 */
		short shortVal= 32767; //-32768~32767
		 
		 /*
		 	========
		 	32767 => 별칭 => shortVal
		 	======= 2byte
		 */
		 
		 int intVal = 2140000000;
		 /*
		  * int
		  * 4byte 메모리 공간을 만들어라 명령
		  * => 2140000000을 저장해라..
		  * => 이 메모리를 사용하려면 intVal을 이용한다
		  * => 수정이 가능하다
		  */
		 long longVal = 3000000000L;//long표현
		 /*
		  * 8byte 메모리 공간을 만들어라 명령
		  * => 3000000000을 저장해라
		  * => 사용시에는 longVal을 이용한다
		  * 
		  * => 변수
		  * 	1) 저장
		  * 	2) 값 읽기
		  * 	3) 수정
		  */
		 // 수정
		 longVal = 100L;
		 // 값 읽기
		 System.out.println(longVal);
		 // 큰데이터형에는 작은값을 저장이 가능
		 long a = 100;// 100L
		 System.out.println(a);
		 
		 int b = 'a';
		 
		 System.out.println(b);
		 
		 char c = 97;
		 System.out.println(c);
		 // 'A' = 65 , 'a' = 97 , '0' = 48
		 //System.out.println((byte) '홍');
		 
		 boolean boo = false;
		 System.out.println(boo); // 조건문 ==> 제어문
	
		 float f =10.5f;
		 System.out.println(f);
		 
		 double d = 10;
		 System.out.println(d);
		 // 왼쪽에 있는 데이터형이 크거나 같아야 저장이 가능
		 /*
		  * 데이터는 선언된 데이터형을 따라간다
		  * 
		  * byte = byte만
		  * short = short,byte
		  * int = int, short,byte,char
		  * long = long,int,short,byte,char
		  * float = long,int,short,byte,char, float
		  * double = long,int,short,byte,char, float, double
		  * 
		  * 자동 형변환
		  * 
		  * (int)10.5 => 10
		  * (double) 10 => 10.0
		  * (int) 'A' => 65
		  * (char) 65 => 'A'
		  * (double) 'A' => 65.0
		  * (float)'A' => 65.0f
		  * 
		  */
		 System.out.println(10/3);
		 System.out.println(10/(double) 3);
		 System.out.println("뭐지" + (int) 10.0/3.0);
		 
		 int num = 10;
		 double dou = 3;
//		 int res = num / dou;
		 System.out.println(num/dou);
		 
//		  int / long / double / char / boolean
	}

}
