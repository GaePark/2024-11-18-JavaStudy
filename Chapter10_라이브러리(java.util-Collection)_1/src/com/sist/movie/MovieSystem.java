package com.sist.movie;
// 영화데이터 관리 => 오라클 제어
import java.util.*;
import java.io.*;
// 모든 사용자에게 공통으로 사용되야 된다
public class MovieSystem {
	//static은 메모리 공간이 한개만 사용 => 모든 사용자가 공유
	private static ArrayList<Movie> movieList = new ArrayList<Movie>();
	// 초기화
	static {
		try {
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			StringBuffer sb = new StringBuffer();
			while(( i= fr.read())!=-1) { //-1=EOF
				sb.append((char)i);
			}
			fr.close();
			//데이터분리
			String[] movieAll = sb.toString().split("\n");
			for(String ma : movieAll) {
				Movie mo = new Movie();
				String[] ss = ma.split("\\|");
				mo.setMno(Integer.parseInt(ss[0]));
				mo.setTitle(ss[1]);
				mo.setGenre(ss[2]);
				mo.setPoster(ss[3]);
				mo.setActor(ss[4]);
				mo.setRegdate(ss[5]);
				mo.setGrade(ss[6]);
				mo.setDirector(ss[7]);
				
				movieList.add(mo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 전체 목록
	public ArrayList<Movie> movieListData(){
		return movieList;
	}
	// 상세보기
	public Movie movieDetailData(int mno) {
		Movie m = new Movie();
		for(Movie mm : movieList) {
			if(mm.getMno() ==mno) {
				m=mm;
				break;
			}
		}
		return m;
	}
	// 검색 => 제목
	public ArrayList<Movie> movieFindTitle(String title) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		for(Movie m: movieList) {
			if(m.getTitle().contains(title)) {
				list.add(m);
			}
		}
		return list;
	}
	// 검색 => 출연진
	public ArrayList<Movie> movieFindActor(String actor){
		ArrayList<Movie> list = new ArrayList<Movie>();
		for(Movie m : movieList) {
			if(m.getActor().contains(actor)) {
				list.add(m);
			}
		}
		return list;
	}
	// 검색 => 장르
	public ArrayList<Movie> movieFindGenre(String genre){
		ArrayList<Movie> list = new ArrayList<Movie>();
		for(Movie m : movieList) {
			if(m.getGenre().contains(genre)) {
				list.add(m);
			}
		}
		return list;
	}
}
