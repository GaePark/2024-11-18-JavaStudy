package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
import com.sist.vo.*;
public class ProductMain {
	public static void main(String[] args) {
	     String[] url = {
             "https://www.oliveyoung.co.kr/store/main/getBestList.do?dispCatNo=900000100100001&fltDispCatNo=10000030006&pageIdx=1&rowsPerPage=8&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%B7%A8%EB%AF%B8%2F%ED%8C%AC%EC%8B%9C"};

	     try {
	    	 ProductDAO dao = ProductDAO.newInstance();
	    	  Document doc = Jsoup.connect(url[0]).get();
	         Elements link = doc.select("div.TabsConts div.prd_info a");
	         
	         for(int j=0; j<link.size();j++)
	         {
	            try {
	               ProductVO vo = new ProductVO();
	               String linkurl = link.get(j).attr("href").replace("javascript:;","");
	              System.out.println(linkurl);
	               Document doc2 = Jsoup.connect(linkurl).get();
	               /*
	               PRODUCT_NAME      VARCHAR2(100 BYTE)
	               PRODUCT_INTRO      VARCHAR2(200 BYTE)
	               PRODUCT_POSTER   VARCHAR2(300 BYTE)
	               PRICE                  VARCHAR2(50BYTE)
	               SALE                     VARCHAR2(200 BYTE)
	               DELIVER               VARCHAR2(200 BYTE)
	               CATEGORY            VARCHAR2(30 BYTE)
	               DETAIL_PAGE         VARCHAR2(1000 BYTE)
	                */
	               
	               Element name = doc2.selectFirst("div.prd_detail_box div.right_area p.prd_name");
	               System.out.println(name.text());
	               Element poster = doc2.selectFirst("div.prd_detail_box div.prd_img img#mainImg");
	               System.out.println(poster.attr("src"));
	               Element price = doc2.selectFirst("div.prd_detail_box div.right_area div.price span.price-2");
	               System.out.println(price.text());
	               Element sale = doc2.selectFirst("div.prd_detail_box div.right_area div.price span.price-1");
	               System.out.println(sale.text());
	               Element deliver = doc2.selectFirst("div.prd_detail_box div.right_area div.prd_more_info ul.bl_list li div");
	               System.out.println(deliver.text());
	               String category = "취미";
	               System.out.println(category);

	 
	               vo.setName(name.text());
	               vo.setPoster(poster.attr("src"));
	               vo.setPrice(price.text());
	            vo.setSale(sale.text());
	               vo.setDeliver(deliver.text());
	               vo.setCategory(category);
	               
	               dao.productInsert(vo);
	               
	               
	            }catch(Exception e) {//e.printStackTrace();
	            	}
	            }
	      System.out.println("완료");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	}