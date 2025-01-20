package com.sist.main;
import com.sist.dao.*;
public class EmpUserMain {
	public static void main(String[] args) {
		EmpDeptDAO dao = EmpDeptDAO.newInstace();
		
		dao.sqlExecute();
		System.out.println("===================================");
		dao.viewExecute();
	}
}	
