package com.sist.io;
// => FileInputStream ==> FileReader 형식으로 변경
// seoul_nature
import java.io.*;
public class IO_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("c:\\javaDev\\seoul_nature.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));//FileInputStream을 FileReader로 변환
			
//			int i = 0;
//			while((i=br.read())!=-1) {
//				System.out.print((char)i);
//			}
			while(true)
			{
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);
			}
			fis.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
