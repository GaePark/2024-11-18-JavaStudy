package com.sist.io;
import java.io.*;
import java.util.*;
//BufferedInputStream / BuffredOutputStream
// String StringBuffer
//파일 자체 제어 => FileReader / FileWriter => 한글
//                   => BufferedReader / BufferedWriter
//                   => 한줄씩 일기 , 한줄씩 저장
//                   => readLine(), writeLine()
//필터시스템으로 더 빨라짐

public class IO_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// jar / zip / png/ mp3 ....
			FileInputStream fis = new FileInputStream("c:\\javaDev\\mydata3.jar");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("c:\\java_2\\mydata3.jar");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int i =0;
			byte[] buffer = new byte[1024];
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer,0,i);
			}
			fis.close();
			bis.close();
			fos.close();
			bos.close();
		} catch (Exception e) {
			
		}
	}

}
