// 64page => 계절
// 3,4,5 => 봄
// 6,7,8 => 여름
// 9.10.11 => 가을
//12,1,2 => 겨울
public class 자바선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int month = (int) ((Math.random()*12)+1);
		// 사용자 입력 => 1~2 => 범위를 벗어날 확률 => default
		switch(month) {
		case 3:
		case 4:
		case 5: System.out.println(month + "월은 봄");
				break;
		case 6:
		case 7:
		case 8: System.out.println(month + "월은 여름");
				break;
		case 9:
		case 10:
		case 11: System.out.println(month + "월은 가을");
				break;	
		case 1:		
		case 2:		
		case 12: System.out.println(month + "월은 겨울");
		// default => 생략이 가능 : 필요시에만 사용
		
		}
	}
}
