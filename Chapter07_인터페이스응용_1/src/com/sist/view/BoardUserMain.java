package com.sist.view;
import com.sist.controller.*;
import java.util.*;
public class BoardUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Controller c = new Controller();
		System.out.println("list,detail,write,detail,update,delete,find:");
		String cmd = scan.next();
		c.service(cmd);
	}

}
