package com.sist;
/*
 * 메소드 형식
 * static 리턴형 메소드명(매개변수...) => 선언부
 * {
 * 		=>구현부 =>메모리에 저장
 * }
 * 
 		static 리턴형 메소드명(매개변수...); => 메모리에 저장이 안된다
 		=> 추상메소드 : 설계단
 		
 */
import java.util.Scanner;
import java.io.*;
public class 메소드_1 {
	static String movieData="";
	/*
	 * 예외처리
	 * 		=> 예외 복구 try~catch(복구)
	 * 		=> 예외 회피 => 컴파일러에 예외  => 알려주는 역할
	 * ====> 프로그램을 유지해줌
	 */
	static // 실행시에 자동 인식
	{
		try {
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i=0;//단점 => char (X)m int
			StringBuffer sb = new StringBuffer();
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			movieData=sb.toString();
			fr.close();
		}catch (Exception e) {
			// TODO: handle exception
		}// 예외처리
	}
	// 데이터가 있다는 가정하에
	static void menu() {
		System.out.println("===== Menu =====");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 상세");
		System.out.println("3. 영화 검색(영화명)");
		System.out.println("4. 영화 검색(출연진)");
		System.out.println("5. 종료");
		System.out.println("==============");
		
	}
	static void movieList(int page) {
		String[] movie = movieData.split("\n");
		int i=0;//for 횟수
		int j=0;//20개씩
		final int ROWSIZE=20;//시작점
		int pagecnt=(page*ROWSIZE)-ROWSIZE;
		//                  1page => 0;
		//                  2page => 20;
		
		for(String s: movie)
		{
//			System.out.println(s);
			if(j<20 && i>=pagecnt) {
				String[] md = s.split("\\|");
				System.out.println(md[0] + "." + md[1]);
				j++;
			}
			i++;
		}
	}
	// 상세보기 => 데이터
	static void moviedetail(int movieNo) {
		String[] movie = movieData.split("\n");
		//parseInt() 문자를 숫자로
		String[] detaildb = movie[movieNo-1].split("\\|");
		
		System.out.println("===== 상세정보 =====");
		System.out.println("영화명: "+ detaildb[1]);
		System.out.println("장르: "+ detaildb[2]);
		System.out.println("출연: "+ detaildb[4]);
		System.out.println("개봉일: "+ detaildb[5]);
		System.out.println("등급: "+ detaildb[6]);
		System.out.println("감독: "+ detaildb[7]);
	}
	//영화명 검색
	static void titleFind(String movieName) {
		String[] movie = movieData.split("\n");
		System.out.println("===== 영화검색 =====");
		for(String m : movie ) {
			
			String[] moviedb =	m.split("\\|");
			if(moviedb[1].contains(movieName)) {
				System.out.println(moviedb[0] + "." + moviedb[1]);
			}
			
		}
	}
	
	static void actorFind(String actor) {
		String[] movie = movieData.split("\n");
		System.out.println("===== 배우 검색 =====");
		for(String m : movie ) {
			
			String[] moviedb =	m.split("\\|");
			if(moviedb[4].contains(actor)) {
				System.out.println(moviedb[0] + "." + moviedb[1] + " :: 출연: " +moviedb[4] );
			}
			
		}
	}
	//
	// 조립 ==> 다른 클래스에서 연결해서 사용이 가능
	// 다른 클래스 연결해서 사용 / 재사용
	
	static void processs() {
		//System.out.println(movieData);
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				
				menu();
				System.out.print("메뉴 선택:");
				int m = scan.nextInt();
				if(m==5) {
					System.out.println("프로그램 종료");
					break;
				}
				else if(m==1) {
					System.out.print("페이지 입력:(1~):");
					int page = scan.nextInt();
					movieList(page);
				}
				else if(m==2) {
					System.out.print("영화번호 입력:");
					int movieNo = scan.nextInt();
					moviedetail(movieNo);
				}
				else if(m==3) {
					scan.nextLine();
					System.out.print("영화명 입력:");
					String movieName = scan.nextLine();
					titleFind(movieName);
				}
				else if(m==4) {
					scan.nextLine();
					System.out.print("배우 입력:");
					String actor = scan.nextLine();
					actorFind(actor);
				}
				else {
					System.out.println("잘못입력했습니다!!");
				}
			
			}catch (Exception e) {
				scan.nextLine();
				System.out.println("정수를 입력해주십시오");
				
			}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processs();// 가급적이면 => main에서 소스 코딩을 사용하지 않는다.
	}

}
