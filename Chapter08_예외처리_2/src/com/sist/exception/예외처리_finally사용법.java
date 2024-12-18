package com.sist.exception;
//try~catch~finally
// finally는 생략이 가능
// 사용처 => 파일 닫기 , 오라클 연결 해제 , 서버 연결 해제
import java.io.*; //파일 읽기 => CheckException

public class 예외처리_finally사용법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FileReader fr = null;//메모리주소를 가지고 있지 않은 상태
		// 모든 클래스의 초기값은 null
//		StringBuffer data = new StringBuffer("");
//		try {
//			int i = 0;
//			fr = new FileReader("c:\\javaDev\\seoul_nature.txt");
//			while((i=fr.read())!=-1) {
//				data.append((char)i);
//			}
//			System.out.println(data);
//			String[] d = data.s
//			
//			 
//		} catch (IOException e) {//Exception , Throwable
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				fr.close();
//			}catch (IOException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//	}
		try(FileReader fr=new FileReader("c:\\javaDev\\seoul_nature.txt")){
			int i=0;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
