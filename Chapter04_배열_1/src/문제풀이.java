import java.util.Arrays;
import java.util.Scanner;

public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//5명의 학생의 국어점수를 받아서 등수를 출력하는 프로그램 작성
		System.out.println("1번 문제");
			int[] kor = new int[5];
			int[] rank = new int[5];
			
			for(int i=0; i<5; i++) {
				kor[i] = (int)(Math.random()*101);
				
			}
			
			for(int i =0;i<5;i++) {
				rank[i]=1;
				for(int j=0;j<5;j++) {
					if(kor[i]<kor[j])
						rank[i]++;
				}
			}
			System.out.println(Arrays.toString(kor));
			System.out.println(Arrays.toString(rank));
		System.out.println();
		//10개의 임의의 정수를 받아서 최대값,최소값(난수)  구하는 프로그램 작성

		System.out.println("2번");
		int[] ran = new int[10];
		int max = 0;
		int min = 100;
			for(int i=0;i<10;i++) {
				ran[i]=(int)(Math.random()*100)+1;
			}
			
			for(int i:ran) {
				if(i>max)
					max=i;
				if(i<min)
					min=i;
				
			}
			System.out.println(Arrays.toString(ran));
			System.out.println("max:"+max);
			System.out.println("min:"+min);
		System.out.println();
		//100 개의 난수(0~9)를 발생하여 빈도수를 구하는 프로그램을 작성하시오

		System.out.println("3번");
			int[] com = new int[10];
			
			for(int i=0;i<100;i++) {
				int random = (int)(Math.random()*10);
				
				com[random]++;
			}
			for(int i=0; i<10; i++) {
				System.out.println(i+"="+com[i]);
			}
			
		//10개의 난수를 발생하여 배열에 저장한 후에 인덱스가 1인 곳의 값을 출력하시오.
		System.out.println("4번");
			int[] a = new int[10];
			
			for(int i=0;i<10;i++) {
				a[i] = (int)(Math.random()*10)+1;
				
			}
			System.out.println(a[1]);
			
		//위 문제 배열 중에서 최대값의 인덱스를 출력하시오. 
		System.out.println("5번");
		System.out.println(a[a.length-1]);
		
		System.out.println("6번");
		int total = 0;
		double avg =0.0;
		int[] b = new int[10];
		for(int i=0;i<10;i++) {
			b[i]=(int)(Math.random()*100)+1;
		}
		for(int i=0;i<b.length;i++) {
			total+=b[i];
		}
		System.out.println("total:" + total);
		System.out.println("avg:" + total/(double) b.length);
	
//		10개의 난수를 배열에 저장 후에 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력하시오
		System.out.println("7번");
		int[] c = new int[10];
		for(int i=0; i<c.length; i++) {
			c[i] = (int)(Math.random()*100)+1;
		}
		for(int i=0; i<c.length;i++) {
			if(i==3)
				continue;
			System.out.println(i+"="+c[i]);
		}
		//5개의 난수를 배열에 저장한 후에 인덱스번호 두개를 받아서 값을 교환하는 프로그램을 작성하시오
		int[] d = new int[5];
		int temp = 0;
		for(int i=0;i<d.length;i++) {
			d[i]=(int)(Math.random()*100)+1;
		}
		while(true) {
			System.out.println(Arrays.toString(d));
			System.out.print("변경할 위치 첫번째를 입력하세요(0~4)");
			int chan1 = scan.nextInt();
			System.out.print("변경할 위치 두번째를 입력하세요(0~4)");
			int chan2 = scan.nextInt();
			if(chan1==chan2) {
				System.out.println("같은 위치는 변경할 수 없습니다");
				continue;
			}
			if(chan1<0 || chan1>4 || chan2<0 || chan2>4) {
				System.out.println("잘못입력했습니다.");
				continue;
			}
			temp=d[chan1];
			d[chan1]=d[chan2];
			d[chan2]=temp;
			break;
		}
		System.out.println("결과" + Arrays.toString(d));
		//char 배열을 생성하여, 알파벳 A~Z까지 대입 후, 출력하시오
		System.out.println("9번");
		char[] ch = new char[26];
		
		for(int i=0; i<ch.length; i++) {
			ch[i]=  (char) (i+'A');
		}
		System.out.println(Arrays.toString(ch));
		System.out.println("10번");
		char[] ch2= new char[26];
		for(int i=0; i<ch2.length;i++) {
			ch2[i]=ch[ch.length-1-i];
		}
		System.out.println(Arrays.toString(ch2));
		//정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하시오

		System.out.println("11번");
		int[] e=new int[10];
		for(int i=0; i<e.length;i++) {
			e[i]=(int) (Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(e));
		for(int i :e) {
			if(i%3==0)
				System.out.println(i);
		}
		//10개의 정수를 입력받아서 짝수의 최대값,홀수의 최대값을 출력하는 프로그램을 작성하시오
		System.out.println("12번");
		int[] f=new int[10];
		for(int i=0;i<f.length;i++) {
			f[i]=(int)(Math.random()*100)+1;

		}
		System.out.println(Arrays.toString(f));
		int aMax=0, sMax=0;
		for(int i=0;i<f.length;i++) {
			if(f[i]%2==0) {
				if(f[i]>sMax)
					sMax=f[i];
			}
			if(f[i]%2==1) {
				if(f[i]>aMax)
					aMax=f[i];
			}
			
				
		}
		System.out.println("짝수최대값:" + sMax);
		System.out.println("홀수최대값:" + aMax);
	}
	

}
