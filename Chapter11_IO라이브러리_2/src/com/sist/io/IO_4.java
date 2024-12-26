package com.sist.io;
import java.util.*;
import java.io.*;

public class IO_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		FileWriter fw = null; //파일 저장
//		FileReader fr = null; //파일 읽기
		
		// 한글로 된 파일 제어 => 2byte => Reader / Writer
		try {


			//ObjectInputStream / ObjectOutputStream
			// => List가 통쨰로 저장이 가능
			while(true) {
				System.out.println("===== Menu =====");
				System.out.println("1. 사원 목록");
				System.out.println("2. 사원 등록");
				System.out.println("3. 프로그램 종료");
				System.out.println("==============");
				System.out.print("메뉴 선택");
				int menu = scan.nextInt();
				
				if(menu==3) {
					System.out.println("프로그램 종료합니다!");
					System.exit(0);
				}
				else if(menu ==1)
				{

					FileReader fr = new FileReader("c:\\java_2\\sawon2.txt");
					int i = 0;
					String data="";
					while((i=fr.read())!=-1) {
						data+=(char)i;
					}
					String[] sawons=data.split("\n");
					
					for(String sa:sawons) {
						if(sa==null||sa.equals("")){
							System.out.println("등록된 사원이 없습니다.");
							break;
						}
						String[] sawon=sa.split("\\|");
						System.out.println("사번:" +sawon[0] );
						System.out.println("이름:" +sawon[1] );
						System.out.println("부서:" +sawon[2] );
						System.out.println("직위:" +sawon[3] );
						System.out.println("근무지:" +sawon[4] );
						System.out.println("연봉:" +sawon[5] );
						fr.close();
					}
				}
				else if(menu ==2)
				{
					FileWriter fw = new FileWriter("c:\\java_2\\sawon2.txt",true);
					Sawon sawon = new Sawon();
					System.out.print("이름 입력");
					sawon.setName(scan.next());
					System.out.print("부서 입력");
					sawon.setDept(scan.next());
					System.out.print("직위 입력");
					sawon.setJob(scan.next());
					System.out.print("근무지 입력");
					sawon.setLoc(scan.next());
					System.out.print("연봉 입력");
					sawon.setPay(scan.nextInt());
					
					String msg=maxSabun()+"|"
							+sawon.getName() + "|"
							+sawon.getDept() + "|"
							+sawon.getJob()+"|"
							+sawon.getLoc()+"|"
							+sawon.getPay()+"\r\n";
					fw.write(msg);
					fw.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static int maxSabun()
	{
		int max =0;
		FileReader fr =null;
		try {
			fr=new FileReader("c:\\java_2\\sawib2.txt");
			int i=0;
			String data="";
			
			while((i=fr.read())!=-1) {
				data+=(char)i;
			}
			String[] datas=data.split("\n");
			for(String s:datas) {
				if(s==null || s.equals("")) break;
				String[] sawon = s.split("\\|");
				if(max<Integer.parseInt(sawon[0]))
					max=Integer.parseInt(sawon[0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fr.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return max+1;
	}

}
