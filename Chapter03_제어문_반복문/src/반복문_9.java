//10개의 알파벳을 추출 => 대문자 몇개 , 소문자 몇개
public class 반복문_9 {
	public static void main(String[] args) {
		int up=0,low=0;
		//대부분은 0 초기화
		for(int i = 1; i<=10; i++) {
			char c= 'A';
			int no = (int) (Math.random()*2);
			//0,1
			if(no==0)
				c=(char)((Math.random()*26)+65);
			else
				c=(char)((Math.random()*26)+97);
			
			System.out.print(c+ " ");
			
			if(c>='A' && c<='Z')
				up++;
			else
				low++;
		}
		System.out.println();
		System.out.println("소문자 갯수: "+ low);
		System.out.println("대문자 갯수: "+ up);
	}
}
