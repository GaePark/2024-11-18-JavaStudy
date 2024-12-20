package com.sist.math;

public class GoodsUserMain {
	
	public static void main(String[] args) {
		GoodsDAO dao = new GoodsDAO().newInstance();
		
		int count = dao.goodsTotalPage();
		System.out.println(count);
		// newInstance(),getInstance()
		//Calendar cal = Calendar.getInstance()
		int totalPage = (int)(Math.ceil(count/15.0));
		System.out.println("총페이지: " + totalPage);
		
	}
}
