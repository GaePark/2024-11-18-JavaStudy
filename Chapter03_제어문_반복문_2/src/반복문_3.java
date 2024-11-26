
// => 정렬 , 빈도수 구하기 => 알고리즘

/*
 * ★
 * ★★
 * ★★★
 * ★★★★
 * 
 * 주사위 2개를 던짐 => 6이 나올 경우의 수
 */
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char c = 'A';
//		for(int i = 1; i<=4; i++) {
//			for(int j=1; j<=4; j++) {
//				System.out.print(c++);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for(int i = 1; i<=4; i++) {
//			for(int j=1; j<=4; j++) {
//				System.out.print((char)(j+64));
//			}
//			System.out.println();
//		}
//		char c= 'A';
//		for(int i=1; i<=4; i++) {
//			for(int j=1; j<=4; j++) {
//				System.out.print(c);
//				
//			}
//			System.out.println();
//			c++;
//		}
//		for(int i=1;i<=4; i++) {
//			for(int j=1; j<=4; j++) {
//				if(i==j) {
//					System.out.print("#");
//				} else
//					System.out.print(j);
//				
//			}
//			System.out.println();
//		}
//		for(int i=1; i<=4; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
//		
//		for(int i=4; i>=0; i--) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
		
//		int a=0,b=0;
//		double c = 0.0;
//		for(int i=1; i<=6; i++) {
//			for(int j=1; j<=6; j++) {
//				if(i+j==6) {
//					System.out.printf("%d+%d = %d \t",i,j,(i+j));
//				}
//			}
//		}
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
