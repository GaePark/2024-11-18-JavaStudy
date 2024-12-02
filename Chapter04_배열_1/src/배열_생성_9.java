// 1.~10까지 난수 발생 => 배열[] => 중복없이 저장

import java.util.Arrays;

public class 배열_생성_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		// 0 1 2
		// 1 3 
		int[] arr=new int[5];
		// => Set,Cookie
		//초기화 => 중복
		//i=1
		
		for(int i=0; i<arr.length;i++)
		{
			for(int j=0;j<=i;j++)
			
			System.out.println();
			
			arr[i]=(int)(Math.random()*5)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					System.out.println();
					i--;
					break;
					
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
