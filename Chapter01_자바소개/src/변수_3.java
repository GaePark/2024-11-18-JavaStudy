// 수정 => 다시 저장
public class 변수_3 {
	public static void main(String[] args) {
		int a = 100;
		//a(100)
		System.out.println(a);
		
		a=200;
		System.out.println(a);
		a=1000;
		System.out.println(a);
		// 같은 블럭안에선 같은 변수명을 사용할 수 없다.
		/*
		 * 		학생 1명
		 * 		국어점수 : 90
		 * 		수학점수 : 90
		 * 		영어점수 : 90
		 * 		총점 : 270
		 * 		평균 : 90.0
		 * 		학점 : A
		 * 		등수 : 2
		 */
		int kor= 90;
		int eng = 90;
		int math = 90;
		int total = kor + eng + math;
		double avg =(double) total / 3;
		char score= 'A';
		int rank = 2;
		
		System.out.println("========= 결과값 =========");
		System.out.println("국어점수: " + kor + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("수학점수: " + math + "점");
		System.out.println("총점: " + total + "점");
		System.out.println("평균: " + avg + "점");
		System.out.println("학점: " + score);
		System.out.println("등수: " + rank + "등");

	}
}
