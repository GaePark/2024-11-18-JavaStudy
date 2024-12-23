package com.sist.emp;
import java.util.*;
public class EmpUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao= new EmpDAO().newInstance();
		
		HashSet<String> set = dao.empGetJobs();
		
		System.out.println("저장갯수: " + set.size());
		for(String job:set) {
			System.out.println(job);
		}
		
		System.out.println();
		System.out.println("이름");
		TreeSet<String> names=dao.empGetNames();
		System.out.println("이름 갯수: " + names.size());
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println("===== 한명 퇴사 =====");
		names.remove("SCOTT");
		for(String name: names) {
			System.out.println(name);
		}
		
		System.out.println();
		System.out.println(names.subSet("K","WARD"));
		
	}

}
