package com.sist.music;

import java.util.Scanner;

public class MusicUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		MusicSystem ms = new MusicSystem();
		while(true) {
			System.out.println("===== 장르별 메뉴 =====");
			System.out.println("1. TOP 50");
			System.out.println("2. 가요");
			System.out.println("3. POP");
			System.out.println("4. OST");
			System.out.println("5. 트롯");
			System.out.println("6. JAZZ");
			System.out.println("7. CLASSIC");
			System.out.println("8. 종료");
			System.out.println("================");
			System.out.print("입력:");
			int type = scan.nextInt();
			if(type ==8){
				System.out.println("프로그램 종료합니다");
				System.exit(0);
			}
			MusicVO[] music=ms.musicData(type);
			
			System.out.println("===== 화면 출력 =====");
			int a = 1;
			for(MusicVO i:music) {
				System.out.println(a+"."+i.getTitle() + " l " + i.getSinger());
				a++;
			}
			System.out.println("===============");
			
		}
	}

}
