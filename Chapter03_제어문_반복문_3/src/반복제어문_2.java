/*
 *    for(int i=1;i<=3;i++) {
 *       for(int j=1;j<==3;j++) {
 *          if(j==2)
 *          	break; ==> j가 있는 for문만 제어
 *       }
 *    }
 */
public class 반복제어문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<=3;i++) {
//			for(int j=1; j<=3;j++) {
//				if(j==2)
//					break;
//				System.out.println(i +" " + j);
//			}
////			break; 1차 for문제어
		
//		}
		//이름이 있는 break => 많이 사용 안함
		outer:for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				if(j==2)
					break outer;
				System.out.println("i= " + i + ",j= " + j);
			}
		}
	}

}
