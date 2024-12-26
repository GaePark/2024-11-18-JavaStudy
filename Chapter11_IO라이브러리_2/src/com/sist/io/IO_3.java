package com.sist.io;
// 파일 제어 => 파일에 읽기 / 쓰기
//                    ----------------- Reader / Writer
import java.io.*;
import java.util.*;
public class IO_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// FileWriter : 파일에 입력
		FileWriter fw = null; //2byte단위 : 한글은 한글자당 2byte
		try {
			fw=new FileWriter("c:\\java_2\\sawon.txt",true);
			// true => append모드 => 이어서 저장이 가능
			// sawon.txt하일이 없는 경우에는 자동으로 생성
			fw.write("3|박문수|개발부|서울|300\r\n");
			System.out.println("등록 완료");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
