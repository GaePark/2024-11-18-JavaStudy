
public class 연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=5; i++){
			for(int j=1; j<=5; j++){
			if(j==i || j==6-i) {
				System.out.print("★");
			}else {
				System.out.print("☆");
			}
			
	}
			System.out.println();

		}
		System.out.println();
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if((i==1 && j==1) ||(i==5 && j==5)||(i==1 && j==5)||(i==5 && j==1)) {
					System.out.print("★");

				} else {
					System.out.print("☆");

				}
			}
			System.out.println();
		}
	}
}