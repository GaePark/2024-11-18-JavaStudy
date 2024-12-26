package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;

public class IO_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container con = new Container();
			Scanner scan = new Scanner(System.in);
			System.out.println("입력: ");
			String type = scan.next();
			
			I i =con.getBean(type); //클래스를 모아서 관리 => Map
			i.excute();
			// 한개의 클래스를 통일 
	}

}
