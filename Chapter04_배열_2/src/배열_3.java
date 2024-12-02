// 10개의 정수를 임의로 추출(1~100) => max,min
// => max의 위치 / min의 위치
import java.util.Arrays;
public class 배열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100);
		}
		//1. 초기화된 데이터 10개를 출력


		System.out.println(Arrays.toString(arr));
		// 2. 요청 => 최대값, 최소값
		int max=arr[0];
		int min =arr[0];
		for(int i:arr) {
			if(max<i)
				max=i;
			if(min>i)
				min=i;
				
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==max) {
				System.out.println("max는" + i+"번째있습니다.");
			}
			if(arr[i]==min) {
				System.out.println("min은" + i+"번째 있습니다.");
			}
		}

	}

}
