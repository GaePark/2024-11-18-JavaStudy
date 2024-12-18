package com.sist.exception;

import java.lang.reflect.Method;

// Class.forName("") => ClassNotFoundException
//CheckException => 반드시 예외처리후 사용
class Movie{
	public void display() {
		System.out.println("Movie:display() call...");
	}
public class 예외처리_메모리할당_리플렉션 {
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Movie m = new Movie();
//		m.display();
//		try {
//			Class clsName= Class.forName("com.sist.exception.movie");
//			Object obj=clsName.getDeclaredConstructor().newInstance();
//			Method[] methods = clsName.getDeclaredMethods();
//			
//			Methods[0].invoke(obj,null);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
	}

}
