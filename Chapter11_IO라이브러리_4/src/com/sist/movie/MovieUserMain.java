package com.sist.movie;
import java.io.*;
import java.util.*;
public class MovieUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieSystem ms = new MovieSystem();
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			// 키보드 입력값을 읽어온다
			while(true)
			{
				System.out.println("===== MENU =====");
				System.out.println("1. 영화목록");
				System.out.println("2. 영화 상세보기");
				System.out.println("3. 영화 검색");
				System.out.println("9. 종료");
				System.out.println("==============");
				System.out.print("메뉴 입력: ");
				String menu = in.readLine();
				int m =Integer.parseInt(menu);
				System.out.println("==============");
				//BufferedReader = 값을 읽을때 문자열로 가지고 온다
				// 필요한 데이터형으로 변환 => Wrapper
				if(m==9) {
					System.out.println("프로그램 종료합니다.");
					System.exit(0);
				}
				if(m==1)
				{
					List<Movie> list = ms.movieListData();
					for(Movie mo: list)
					{
						System.out.println(mo.getMno() + "." + mo.getTitle());
					}
				}
				else if(m==2)
				{
					System.out.print("영화 번호 입력(1~1938:");
					String mno = in.readLine();
					int mm= Integer.parseInt(mno);
					Movie mo = ms.movieDetailData(mm);
					System.out.println("영화번호: "+ mo.getMno());
					System.out.println("영화명: "+ mo.getTitle());
					System.out.println("출연: "+ mo.getActor());
					System.out.println("감독: "+ mo.getDirector());
					System.out.println("등급: "+ mo.getGrade());
					System.out.println("장르: "+ mo.getGenre());
				}
				else if(m==3)
				{
					System.out.print("검색어 입력: ");
					String find = in.readLine();
					List<Movie> list = ms.movieFindData(find);
					
					for(Movie mo:list)
					{
						System.out.println(mo.getMno() + "." + mo.getTitle());
					}
				}
				else
				{
					System.out.println("없는 메뉴입니다.");
				}
			}
		}catch(Exception e) {}
	}

}
