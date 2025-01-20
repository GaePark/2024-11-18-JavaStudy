package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * class : 중복이 가능
		 * id : 중복이 없다
		 */
		String html = "<html>"// HTML 문서 시작
							+"<body>"// 브라우저에 출력
							+"<div id=d1>"
							+"<img src=jsoup />"
							+ "<div>Java</div>" //Element
							+ "<div>Oracle</div>"
							+ "<div>HTML / CSS</div>"
							+"</div>"
							+"<div class=d2>"
							+ "<div>JavaScript</div>"
							+ "<div>JSP</div>"
							+ "<div>Spring</div>"//Elements
							+"</div>"
							+"</body>"// 화면 출력 종료
							+ "</html>";// 문서 종료
		try {
			//Element => test() , atrr() : 속성값
			// html() => HTML 태그, data() : JavaScript 읽기
			// Elements => get() =>태그를 하나씩 가져오기
			//----------- 태그 갯수 확인 => size()
			Document doc = Jsoup.parse(html);
			//System.out.println(doc);
			Elements div = doc.select("div.d2 div");
//			System.out.println(div);
			System.out.println("div몇개?" + div.size());
			for(int i =0;i<div.size(); i++) {
				System.out.println(div.get(i).text());
			}
			Element img = doc.selectFirst("img");//상세보기
			System.out.println(img.attr("src"));
			/*
			 * 1. 읽어 올 태그 => 위에 상위 태그
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
