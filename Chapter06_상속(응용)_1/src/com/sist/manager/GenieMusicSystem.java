package com.sist.manager;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.*;
public class GenieMusicSystem {
	MusicVO[] music = new MusicVO[50];
	// 인스턴스 초기화 블록 => 호출(X) , 상속(X)

		{
		try {
			Document doc= Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title = doc.select("tr.list a.title");
			Elements singer = doc.select("tr.list a.artist");
			Elements album = doc.select("tr.list a.albumtitle");
			
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
		public MusicVO[] musicAllData() {
			return music;
		}
		
		
		public MusicVO[] musicFindData(String fd) {
			
			int count=0;
			for(MusicVO vo: music)
			{
				if(vo.getTitle().contains(fd)) {
					count++;
				}
			}
			//동적 배열 생성 => 가변 Collection
			MusicVO[] data = new MusicVO[count];
			int index = 0;
			for(MusicVO vo:music) {
				if(vo.getTitle().contains(fd)) {
					data[index]=vo;
					index++;
				}
				
			}
			
			return data;
		}
}
