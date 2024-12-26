package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;
public class Container {
	// 클래스를 모아서 관리 => 관련된 클래스가 여러개 있는 경우
	// Model (브라우저 전송) , DAO => 스프링
	
	private Map<String, I> clsMap = new HashMap<String, I>();
	public Container() {
//		clsMap.put("a", new A());
//		clsMap.put("b", new B());
//		clsMap.put("c", new C());
//		clsMap.put("d", new D());
//		clsMap.put("e", new E());
//		clsMap.put("f", new F());
//		clsMap.put("g", new G());
		File dir = new File("C:\\javaDev\\javaStudy\\Chapter11_IO라이브러리_1\\src\\com\\sist\\model");
		String pack = "com.sist.model";
		File[] files = dir.listFiles();
		
		for(File f:files) {
			if(f.isFile()) {
				try {
					String name = f.getName();
					String n=name.substring(0,name.lastIndexOf("."));
					String cls = pack+"."+n;
					Class clsName=Class.forName(cls);
					Object obj = clsName.getDeclaredConstructor().newInstance();
					clsMap.put(n.toLowerCase(), (I) obj);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}
	
	//요청시마다 클래스를 찾아주는 역할
	public I getBean(String key) {
		return (I) clsMap.get(key);
	}
			
}
