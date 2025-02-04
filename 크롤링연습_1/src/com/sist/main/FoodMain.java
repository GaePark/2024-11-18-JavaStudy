package com.sist.main;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
import com.sist.vo.*;
public class FoodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FoodDAO dao = FoodDAO.newInstance();
			for(int i=1;i<=347;i++)
			{
				Document doc = Jsoup.connect("https://www.menupan.com/restaurant/bestrest/bestrest.asp?page="+i+"&trec=8655&pt=rt").get();
				Elements link= doc.select("div.rankingList ul.list p.listName a");
				System.out.println("===== "+i+"page =====");
				for(int j=0;j<link.size();j++)
				{
					try {
					FoodVO vo = new FoodVO(); 
					System.out.println();
					String url = "https://www.menupan.com"+link.get(j).attr("href");
					Document doc2 = Jsoup.connect(url).get();
					Element name = doc2.selectFirst("div.WrapMain div.areaBasic dl.restName dd.name");
					String strName=name.text();
					strName=strName.substring(0,strName.indexOf("["));
					System.out.println(strName);
					Element type = doc2.selectFirst("div.areaBasic dl.restType dd.type");
					System.out.println(type.text());
					Element phone = doc2.selectFirst("div.areaBasic dl.restTel  dd.tel1");
					System.out.println(phone.text());
					Element address = doc2.selectFirst("div.areaBasic dl.restAdd dd.add1");
					System.out.println(address.text());
					Element score = doc2.selectFirst("div.areaBasic dl.restGrade span.total");
					System.out.println(score.text());
					Element theme = doc2.selectFirst("div.areaBasic dl.restTheme dd.Theme");
					System.out.println(theme.text());
					Element price = doc2.selectFirst("div.areaBasic div.restPrice p.price");
					System.out.println(price.text());
					Element time = doc2.selectFirst("div.tabInfo div.infoTable ul.tableTopA dd.txt2");
					System.out.println(time.text());
					Element content = doc2.selectFirst("div.tabInfo div.infoArticle div#info_ps_f");
					System.out.println(content.text());					
					
					Elements tableLR = doc2.select("div.tabInfo ul.tableLR dt");
					Element parking=null;
					for(int k=0;k<tableLR.size();k++)
					{
						String s=tableLR.get(k).text();
						if(s.equals("주차"))
						{
							parking=doc2.select("div.tabInfo ul.tableLR dd").get(k);
							System.out.println(parking.text());
						}
					}
			
					Element poster = doc2.selectFirst("div.areaThumbnail img#rest_bigimg");
					System.out.println(poster.attr("src"));
					
					Elements img = doc2.select("div#id_restphoto_slides img[src*=/restimg/]");
					String images = ""; 
					for(int k=0;k<img.size();k++)
					{
						images+=img.get(k).attr("src")+",";
					}
					images = images.substring(0,images.lastIndexOf(","));
					System.out.println(images);
					
					vo.setName(strName);
					vo.setType(type.text());
					vo.setPhone(phone.text());
					vo.setAddress(address.text());
					vo.setScore(Double.parseDouble(score.text()));
					vo.setParking(parking.text());
					vo.setPoster(poster.attr("src"));
					vo.setImages(images);
					vo.setTime(time.text());
					vo.setContent(content.text());
					vo.setTheme(theme.text());
					vo.setPrice(price.text());
					
					dao.foodInsert(vo);
					}catch(Exception e) { e.printStackTrace();}	
				}
				System.out.println("=================");
			}
			System.out.println("데이터 저장완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
