// 10개의 정수를 추출해서 최소값, 최대값을 구하는 프로그램
// 1~100 사이
public class 반복문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=1, min=100, count=0;
		
		for(int i = 1; i<=10; i++) {
			int com=(int) (Math.random()*100)+1;
			System.out.print(com + " ");
			
			if(com>max) {
				max=com;
			}
			if(com<min) {
				min=com;
			}
			if(com%3 ==0) {
				count+=1;
			}
			
		}
		System.out.println();
		System.out.println("최대값은" + max);
		System.out.println("최소값은" + min);
		System.out.println("3의 배수의 갯수는" + count);
		
		
	}

}
