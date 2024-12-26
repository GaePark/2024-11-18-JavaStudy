package com.sist.io;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class IO_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 일일박스오피스
		 * 실시간 예매율
		 * 좌석점유율
		 * 
		 */
		String[] strUrl = {
			"",
			"searchMainDailyBoxOffice.do",
			"searchMainRealTicket.do",
			"searchMainDailySeatTicket.do"
		};
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("===== MENU =====");
			System.out.println("1. 일일바스오피스");
			System.out.println("2. 실시간 예매율");
			System.out.println("3. 좌석점유율");
			System.out.println("==============");
			System.out.print("번호 입력:");
			int num = scan.nextInt();
			String path="https://www.kobis.or.kr/kobis/business/main/";
			//.do => MVC구조 => URL 주소는 마음대로 변경이 가능
			path+=strUrl[num];
			Document doc = Jsoup.connect(path).get();
			System.out.println(doc.toString());
			
			// Document doc = Jsoup.connect()
//			URL url = new URL(path);
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection();//URL접속
//			if(conn!=null)// 접소이 되었다면
//			{
//				BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				// 전송 => 1byte , 받은 경우 => 2byte로 변환후 전송
//				// 한글이 깨진다 => UTF-8
//				// 네트워크의 단점 : 전송시 byte(1byte)
//				// => byte
//				// 네트워크 : Oracle, 웹
//				// => 주소 / PORT
//				//       URL
//				while(true)
//				{
//					String msg=br.readLine();
//					if(msg==null) break;
//					System.out.println(msg);
//				}
//			}
//				conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
