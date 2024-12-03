import java.util.*;
public class 문자열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] ids= {"admin","hong","park","kim","shin"};
		int[] pwds= {1234,1234,1234,1234,1234};
		String[] names= {"이순신,홍길동,박문수,김두한,심청이"};
				
		System.out.print("ID를 입력:");
		String id = scan.next();
		scan.nextLine();
		System.out.print("비밀버호를 입력:");
		int pwd = scan.nextInt();
		// 1.id 체크
		int count =0; //반복문은 무조건 처음부터 ~~ 디폴트를 설정한다.
		// hong
		int index=0;
		for(int i=0;i<ids.length;i++)
		{
			if(ids[i].equals(id)){
				count++;
				index=i;
				break;
			}
		}

		
		if(count ==0) {
			System.out.println("아이디가 존재하지 않습니다.");
		} else {
			if(ids[index].equals(id)&&pwds[index]==pwd) {
				System.out.println(names[index]+"로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
	}
}
