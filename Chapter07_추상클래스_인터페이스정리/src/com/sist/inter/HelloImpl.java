package com.sist.inter;
// => Service를 구현
/*
 * 사용자요청 ==> Controller ==> Serviece => ServiceImpl
 * 
 * MainClass ===> Hello ===> HelloImpl
 */
public class HelloImpl implements Hello {

	@Override
	public void seyHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + "님 환영합니다.");
	}

	
}
