// char 배열사용법 / double / String
// 응용 => 정렬/달력... / 중복없는 난수
// => 지니뮤직 , 서울 여행 , 맛집
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha = new char[26];
				//초기화
		char c='A';
				
				for(int i=0;i<alpha.length; i++) {
					alpha[i]+=c++;
				}
				//처리
				//출력
				for(char cc:alpha)
					System.out.print(cc + " ");
				
				System.out.println();
				// => 'K'가 있는 인덱스번호를 출력하시오
				for(int i=0;i<alpha.length; i++) {
					if(alpha[i]=='K') {
						System.out.println(i + "번째");
						break;
					}
				
	}
	}
}
