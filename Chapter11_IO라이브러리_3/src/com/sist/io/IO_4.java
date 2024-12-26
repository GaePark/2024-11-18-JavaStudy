package com.sist.io;
// 파일 출력 => FileOutputStream / FileWriter
// 필터             BufferedOutputStream / BufferedWriter
//                   => Byte(1글자 저장)           Char => 여러문장열 저장이 가능
import java.io.*;
public class IO_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\java_2\\student.txt");
			//파일이 없는 경우에는 자동으로 생성
			// 파일이 있는 경우에는 글쓰기가 된다
//			fos.write('A');
//			fos.write('B');
//			fos.write('C');
//			fos.write('D');
//			fos.write('E');
			String msg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			fos.write(msg.getBytes());
			//단위 byte => byte[] => getBytes()
			fos.close();
			System.out.println("저장완료!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
