package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.MusicVO;

public class MelonMusicSystem extends GenieMusicSystem{
//	MusicVO[] music = new MusicVO[50];
	// 인스턴스 초기화 블록 => 호출(X) , 상속(X)
	{
		try {
			Document doc= Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title = doc.select("div.wrap_song_info div.rank01");
			Elements singer = doc.select("div.wrap_song_info div.rank02");
			Elements album = doc.select("div.wrap_song_info div.rank03");
			
			for(int i=0;i<50;i++) {
					music[i] = new MusicVO();
					music[i].setNo(i+1);
					music[i].setTitle(title.get(i).text());
					music[i].setSinger(singer.get(i).text());
					music[i].setAlbum(album.get(i).text());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		

	}

}
