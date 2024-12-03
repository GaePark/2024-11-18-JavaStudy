import java.util.Arrays;

public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. (1차배열)1번 학생 100점 2번 학생 90점 3번학생 85점이다. 점수를 score 배열 변수에 저장하 고 1) 아래와 같이 출력하시오.

		int[]score = {100,90,85};
		int total = 0;
		//1)
		for(int i=0;i<score.length;i++) {
			System.out.println(i+1+"학생: " + score[i]+"점");
			total+=score[i];
		}
		//2)
			System.out.println("총점: " + total);
			
			
		//2.1월달 사원(1번부터 5번사원)의 실적이 50 45 35 12 70 이다. (실적 0~100)
			int[] arr1 = {50,45,35,12,70}; 
			int total1 = 0;
			
			//1) 사번별 실적
			for(int i=0; i<arr1.length;i++) {
				System.out.printf("사원 (%d) %d\n",i+1,arr1[i]);
				total1+=arr1[i];
			}
			//2)
				System.out.println("총점: "+ total1);
				System.out.println("평균: "+total1/(double) arr1.length);
			//3)
				int max= arr1[0];
				int maxIndex=0;
				int min = arr1[0];
				int minIndex=0;
				for(int i=1; i<arr1.length;i++) {
					if(max<arr1[i]) {
						max=arr1[i];
						maxIndex=i+1;
					}
					if(min>arr1[i]) {
						min=arr1[i];
						minIndex=i+1;
					}
				}
				System.out.println("가장큰 실적: " + maxIndex+" " + max);
				System.out.println("가장작은 실적: " + minIndex +" "+ min);
			
		//3. 크기가 10인 정수형 배열을 생성하고 여기에 0부터 9까지의 값으로 배열을 채우는 프로그램 만들기
			int[] com = new int[10];
			for(int i=0;i<com.length;i++) {
				com[i]=(int)(Math.random()*10);
			}
			System.out.println(Arrays.toString(com));
			
		//4. 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오
			int[] arr2 = {10, 20, 30, 40, 50};
			int sum = 0;
			for(int i=0;i<arr2.length;i++) {
				sum+=arr2[i];
			}
			System.out.println(sum);
		//5. 1~100사이의 정수를 10개 저장하고  
		//	  정수형 변수 evenTotal 에 배열 내의 데이터 짝수 합 계산하여 저장
		// 	  정수형 변수 oddTotal 에 배열 내의 데이터 홀수 합 계산하여 저장
			int[] ran = new int[10];
			int evenTotal = 0;
			int oddTotal = 0;
			for(int i=0; i<ran.length;i++)
				ran[i]=(int)(Math.random()*100)+1;
			for(int i : ran) {
				if(i%2==0)
					evenTotal+=i;
				else
					oddTotal+=i;
			}
			System.out.println("짝수 총합: " + evenTotal);
			System.out.println("홀수 총합: " + oddTotal);

			//6. 0~9사이의 난수를 100개 발생해서 
			//   빈도를 구해서 출력하시오 
			int[] go = new int[10];
			for(int i=0;i<100;i++) {
				int v=(int)(Math.random()*10);
				for(int j=0;j<go.length;j++)
				{
					if(j==v) {
						go[j]++;
						break;
					}
				}
			}
			//result[arr[i]]++ 랜던값 100개 정하고 한번더 100번 돌려서 arr[i]값 0~9를 바로 빈도수에 적용시킨다. 더 빠름
			for(int i=0;i<go.length;i++) {
				System.out.println(i+"의 갯수:" + go[i]);
			}
			//7. 임의의 문자 5개를 저장하고 정렬해서 출력하시오 
			char[] on = new char[5];
			for(int i=0;i<on.length;i++) {
				on[i]=(char)((Math.random()*26)+65);
			}
			for(int i=0;i<on.length;i++) {
				for(int j=i+1;j<on.length;j++) {
					if(on[i]>on[j]) {
						char temp =  on[i];
						 on[i] =on[j];
						on[j] = temp;
					}
				}
			}
			System.out.println("오른차순");
			for(char o : on) {
				System.out.print(o + " ");
			}
	}

}
