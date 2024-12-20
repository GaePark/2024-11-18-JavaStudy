package com.sist.util;
import java.util.*;
public class 라이브러리_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar today= Calendar.getInstance();
		// 오늘날짜 읽기
		System.out.println(today.get(Calendar.YEAR));
		System.out.println((today.get(Calendar.MONTH)+1));
		System.out.println(today.get(Calendar.DATE));
		
		System.out.println(today.get(Calendar.HOUR));
		System.out.println(today.get(Calendar.MINUTE));
		System.out.println(today.get(Calendar.SECOND));
		System.out.println(today.getActualMaximum(Calendar.DATE));
		
	}

}
