package com.sist.music;
/*
 * 1. 파일 => IP
 * 2. URL => URL주소
 * 3. SQL => 네트워크
 * --------------------- CheckException
 *                               -----------------
 *                               컴파일시에 예외처리 확인
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * top50
 * 가요
 * 팝
 * OST
 * 트롯
 * JAZZ
 * CLASSIC
 */
public class MusicSystem {
	private String[] url = {
			"",
			"https://www.genie.co.kr/chart/top200",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0100",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0200",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0300",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0107",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0500",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0600"
	};
	public MusicVO[] musicData(int type) {
		MusicVO[] music = new MusicVO[50];
		try {
			Document doc = Jsoup.connect(url[type]).get();
			Elements title = doc.select("table.list-wrap tr.list a.title");
			Elements artist = doc.select("table.list-wrap tr.list a.artist");
			Elements album = doc.select("table.list-wrap tr.list a.albumtitle");
			
			for(int i =0;i<music.length;i++) {
				music[i] = new MusicVO();
				music[i].setAlbum(album.get(i).text());
				music[i].setTitle(title.get(i).text());
				music[i].setSinger(artist.get(i).text());
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return music;
	}
	
}
