// 1~100까지의 합 => 67page
public class 반복문_4 {
    // 짝수합, 홀수합 , 총합
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0; //누적변수 => 초기값은 0, 누적곱 => 초기값은 1
		int sum1 =0, sum2 = 0;
		for(int i=0; i<=100; i++) {
			if(i%2 ==0) {
				sum1 += i;				
			} else {
				
				sum2 += i;
			}

			sum = sum1+sum2;
		}
		System.out.println(sum1 + "l"+ sum2 + "l"+ sum);
		System.out.println(sum1 + "l"+ sum2 + "l"+ sum);
		System.out.println(sum1 + "l"+ sum2 + "l"+ sum);
		

	}

}
