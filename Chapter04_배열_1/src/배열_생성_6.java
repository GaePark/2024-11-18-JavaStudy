import java.util.Arrays;
import java.util.Scanner;
// 국어점수 입력 => 5 rank => 5
public class 배열_생성_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int INDEX = 5;
		int[] kor = new int[INDEX];
		int[] rank = new int[INDEX];
		// => index 번호 = 정보를 매칭
		
		for(int i=0;i<INDEX;i++) {
			kor[i] = (int) (Math.random()*101);
		}
		
		System.out.println(Arrays.toString(kor));
		for(int i=0;i<INDEX;i++) {
			rank[i]=1;
			for(int j=0; j<INDEX;j++) {
				if(kor[i]<kor[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
	}

}
