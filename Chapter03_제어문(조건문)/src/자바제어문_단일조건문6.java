// if문 줄일때 삼항연산자를 사용할 수도 있다.
public class 자바제어문_단일조건문6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = (int) (Math.random()*101);
		if(score>=60)
			System.out.println("합격");
		if(score<60)
			System.out.println("불합격");
		System.out.println(score>=60? "합격":"불합격");
		

	}

}
