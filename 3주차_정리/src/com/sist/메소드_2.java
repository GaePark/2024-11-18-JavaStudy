package com.sist;
import java.util.*;
import java.io.*; // 파일 , 네트워크 전송 : 읽기/ 쓰기
// Input / Output => io => 반드시 예외처리
/*
 * 마지막장 12장
 * -------
 * ㅣ 자바 관련 모든 문법 => 응용
 * 		= 데이터 베이스 (o) => 웹
 * 		= 네트워크 => ㅇㄴ라인 게임
 * 		웹 => 쓰레드. 네트워크 => 흐름
 *               ㅣ면접
 */

public class 메소드_2 {
	static String seoulData ;
	// 초기화 (자동) => 초기화 블럭 => 자동 로그인 / 쿠키 읽기 / 오라클 연동
	
	static {
		try {
			int i =0;
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			StringBuffer sb = new StringBuffer();
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			seoulData = sb.toString();
			fr.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void seoulList(int num) {
		int a = 0;//for
		int b = 0;//20개씩
		final int ROWSIZE = 20;
		int pagecnt = ROWSIZE*num-ROWSIZE;
		String[] seoulDB = seoulData.split("\n");
		for(String s : seoulDB) {
			if(b<ROWSIZE && a>=pagecnt) {
				String[] db = s.split("\\|");
				System.out.println(db[0] + "." + db[1]);
				b++;
			}
			a++;
		}
	}
	static String[] find(int type,String findData) {
		String[] datas = seoulData.split("\n");
		int count = 0;
		for(String seoul:datas) {
			String[] sd = seoul.split("\\|");
			String ss="";
			if(type ==1) {
				ss=sd[1];
			}
			else
			{
				ss=sd[3];
			}
			
			if(ss.contains(findData)) {
				count++;
			}
			
		}
		//확인 =>검색된 갯수?
		String[] data=new String[count];
		int i=0;
		for(String seoul:datas) {
			String[] sd = seoul.split("\\|");
			String ss="";
			if(type ==1) {
				ss=sd[1];
			}
			else
			{
				ss=sd[3];
			}
			
			if(ss.contains(findData)) {
				data[i] = sd[1] + "--" + sd[3];
				i++;
			}
			
		}
		return data;
	}
	static void seoulDetail(int seoulNo) {
		String[] seoulDB = seoulData.split("\n");
		
		System.out.println("===== 상세정보 =====");
		String[] db = seoulDB[seoulNo-1].split("\\|");
		System.out.println("명소명:" + db[1]);
		System.out.println("설명:" + db[2]);
		System.out.println("주소:" + db[3]);
	}
	
	static void Search(int type,String findData) {
		String[] seoulDB = seoulData.split("\n");
		
		System.out.println("===== 명소명 검색 =====");
		for(String i : seoulDB) {
			String[] db = i.split("\\|");
			if(type==1? db[1].contains(findData) : db[3].contains(findData)) {
				System.out.println(db[1]+" -- "+db[3]);
			}
			
		}
	}
	
	static void menu() {
		System.out.println("===== menu =====");
		System.out.println("1. 서울 명소 목록");
		System.out.println("2. 서울 명소 상세");
		System.out.println("3. 명소검색");
		System.out.println("4. 종료");
		System.out.println("==============");
	}
	static void process() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				menu();
				System.out.print("입력: ");
				int m = scan.nextInt();
				
				switch(m) {
				case 4: {
					System.out.println("종료합니다.");
					System.exit(0);
				}
				case 1: {
					System.out.print("페이지를 입력해주세요(1~):");
					int page = scan.nextInt();
					seoulList(page);
					break;
				}
				case 2: {
					System.out.print("명소번호를 입력해주세요:");
					int num = scan.nextInt();
					seoulDetail(num);
					break;
				}
				case 3:{
					System.out.print("명소(1),주소(2):");
					int type=scan.nextInt();
					System.out.print("검색어 입력:");
					String st = scan.next();
					Search(type,st);

					break;
				}
			
			}
				
			}catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
				System.out.println("잘못 입력하셨습니다.");
			}

		}
	}
	// 시작 => 자동호출=>
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
