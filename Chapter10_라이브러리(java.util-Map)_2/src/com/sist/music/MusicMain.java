package com.sist.music;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MusicMain {
	//지니 뮤직
	//멜론
	// => 공통 (교집합)
	public Set<String> genieMusic()
	{
		Set<String> set=new HashSet();
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title = doc.select("table.list-wrap a.title");
			
			for(int i=0;i<title.size();i++) {
				set.add(title.get(i).text());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set;
	}
	
	
	public Set<String> melonMusic()
	{
		Set<String> set=new HashSet();
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title = doc.select("div.service_list_song tr div.rank01 a");
			
			for(int i=0;i<title.size();i++) {
				set.add(title.get(i).text());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicMain mm = new MusicMain();
		Set<String> genie=mm.genieMusic();
		
		for(String music : genie) {
			System.out.println(music);
		}
		System.out.println("==============");
		Set<String> melon = mm.melonMusic();
		for(String music:melon) {
			System.out.println(music);
		}
//		System.out.println("=======차집합=======");
//		//오라클 => MINUS removeAll()
//		genie.removeAll(melon);
//		for(String music: genie) {
//			System.out.println(music);
//		}
		System.out.println("===== 동일곡 출력(교집합) =====");
		//retainAll() => INERSECT
		genie.retainAll(melon);
		System.out.println(genie.size());
		//오라클 => MINUS removeAll()
		for(String music: genie) {
			System.out.println(music);
		}
		System.out.println("===== 멜론 + 지니 =====");
		//UNION => addAll
		// => 중복된 경우에 1개만 첨부
		List<String> list = new ArrayList<String>();
		
		list.addAll(genie);
		list.addAll(melon);
		// UNION ALL
		// 중복이 있어도 데이터 포함
		System.out.println(list.size());
		for(String music: list) {
			System.out.println(music);
		}
		//중복 제거
		Set<String> hap = new HashSet<String>();
		System.out.println("===== 중보없는 곡 =====");
		hap.addAll(list);
		System.out.println(hap.size());
		
		//addAll() : 모든 데이터 (합) / removeAll() : (차집) / retainAll()
		//JOIN
	}

}





