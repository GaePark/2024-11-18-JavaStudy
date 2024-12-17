package com.sist.seoul;

import java.io.*;

import com.sist.vo.SeoulVO;

public class Seoul {
	
	public String getFileData(String path) {
		StringBuffer sb = new StringBuffer();
		try {
			
			FileReader fr = new FileReader(path);
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append((char) i);
			}
			fr.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
	
	public SeoulVO[] seoulAllData(int type) {
		SeoulVO[] datas = null;
		String data="";
		if(type==1) {//loacation
			data=getFileData("C:\\javaDev\\seoul_location.txt");
		}else {
			data=getFileData("C:\\javaDev\\seoul_nature.txt");
		}
		String[] seoul = data.split("\n");
		datas=new SeoulVO[seoul.length];
		int i=0;
		for(String s: seoul)
		{
			String[] ss=s.split("\\|");
			datas[i] = new SeoulVO();
			datas[i].setNo(ss[0]);
			datas[i].setName(ss[1]);
			datas[i].setContent(ss[2]);	
			datas[i].setAddress(ss[3]);
			i++;
		}
		return datas;
	}
//	public SeoulVO[] seoulDetailData(int no) {
//		
//	}
//	public SeoulVO[] seoulListData(int page) {
//		seoulVO[] seoul = new SeoulVO[];
//		
//		return seoul;
//	}
//	public seoulVO[] seoulFindData(int type, String findData) {
//		
//	}
}

