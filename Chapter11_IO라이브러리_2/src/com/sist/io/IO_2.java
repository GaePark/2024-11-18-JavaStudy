package com.sist.io;
import java.io.*;
public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 파일 복사 => 파일 전송
			// 파일 자체 제어 => Reader /Writer
			fis=new FileInputStream("c:\\javaDev\\movie.txt");
			fos=new FileOutputStream("c:\\java_2\\movie.txt");
			//                                       => 파일이 없는 경우에 자동으로 생성
			/*
			 * mode
			 *     r  => read
			 *     w => write => create
			 *     a  => append
			 *                lFileOutputStream("c:\\java_2\\movie.txt",true);
			 */
			int i=0;// 1=> 글자 한글자
			// 읽은 바이트수
			byte[] buffer= new byte[1024];
			// read() / read(byte[],start,end)
			while((i=fis.read(buffer,0,1024))!=-1) {
				fos.write(buffer,0,i);
			}
			System.out.println("복사 완료");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fis.close();
				fos.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
