package com.sist.main;
import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		DataBase db=new Emp();
		db.listPrint();
		System.out.println("=================");
		db = new Dept();
		db.listPrint();
	}

}
