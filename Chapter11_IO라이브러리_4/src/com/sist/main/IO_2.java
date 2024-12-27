package com.sist.main;
import java.io.*;
import java.util.*;
public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis=new FileInputStream("c:\\java_data\\sawon_info.txt");
			ois =new ObjectInputStream(fis);
			List<Sawon> list = (List<Sawon>) ois.readObject();
			for(Sawon sa:list)
			{
				System.out.println(sa.getSabun() + " "
						+sa.getName() + " "
						+sa.getDept() + " "
						+sa.getJob() + " "
						+sa.getPay());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				ois.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
