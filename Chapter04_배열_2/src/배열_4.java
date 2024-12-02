// 6개의 난수 발생 => 중복이 없는 데이터 출력(1~45)
// => 피망 => 로직
/*
 * 클래스의 구성요소
 * class ClassName
 * { ↓ 객체지향의 3대 요소
 *    ---------------------
 *       변수 => 멤버변수
 *                   공유변수
 *                   => 일반변수 / 배열 / 클래스 (변수)
 *                   => 변수를 보호 (데이터 보호)
 *                         ============= 캡슐화 / 은닉화
 *    ---------------------
 *       메소드 => 기능 / 재사용
 *          => 유지보수 관련 (수정 , 추가) => 오버라이딩 / 오버로딩
 *    ---------------------
 *       생성자 => 메모리에 클래스 저장 => 생량이 가능
 *    ---------------------
 *    9장 => 조립(사용자 클래스 + 라이브러리)
 *    10~11장
 *    => 데이터가 영구적으로 저장 (x) =< 오라클
 *    => HTML / CSS / JavaScript
 *    => 조립 => JSP => MVC => 1차 프로젝트 (2월~3월초) => AWS
 *                                  Jquery / Ajax
 *    ---------------------------------------------------------
 *    통합 : Spring : 5월 ~ 5월 중순 => 2차 프로젝트 => AWS
 *                               VueJS
 *    --------------------------------------------------------
 *    한달 : 신기술 : Spring-Boot / Django /Python
 *             => React-Query / Redux / NextJS
 *                  ---------------------------------- MSA
 *    => 데이터베이스 연결
 *          JDBC / MyBatis / JPA
 *  }
 */
import java.util.Arrays;
// 재사용 => 메소드화
public class 배열_4 {
	/*
	 * for => 반복횟수 지정
	 * while => 반복 횟수를 모르는 경우
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[6];
		int su=0;
		boolean bCheck =false;
		for(int i=0;i<arr.length; i++) {
//			arr[i]=(int)(Math.random()*45)+1;
			bCheck=true;
			while(bCheck) { // 중복여부 확인 = 횟수가 지정이 안됨
				//난수 발생
				su=(int)(Math.random()*45)+1;
				bCheck=false;
				// 같은 수가 있는지
				for(int j=0;j<i;j++) {
					if(arr[j]==su) { //저장된 데이터중에 난수와 같은 값이 인슨지
						bCheck=true; //while문을 다시 수행
						break;
					}
				}
			}
			arr[i]=su;
			
//			for(int j=0; j<i;j++) {
//				if(arr[i]== arr[j]) {
//					i--;
//					break;
//				}
//			}

			
}		
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
	}

}
