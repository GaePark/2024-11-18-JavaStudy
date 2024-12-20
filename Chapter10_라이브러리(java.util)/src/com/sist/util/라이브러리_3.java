package com.sist.util;

import java.util.*;


public class 라이브러리_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String color = "red|yello|grean|pink|magenta|blue|black|cyan";
			
			StringTokenizer st  = new StringTokenizer(color, "|");
			while(st.hasMoreElements()) {
				System.out.println(st.nextToken());
			}
	}

}
