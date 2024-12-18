package com.sist.exception;
/*
 * 간접처리: throws
 * => 예외를 피해간다
 * => 예상되는 예외를 선언 => 이런 예외 발생할거 같다
 *                                   ---------------------
 *                                   컴파일러에 알려준다
 * => 이 메소드를 사용시에는 반드시 예외처리 후 사용이 가능
 *     => throws / try~catch를 이용할 수 있다
 * => 사용자 정의는 사용빈도가 적다 / 라이브러리가 많이 존재
 *       --------------------------
 *       코딩 소스가 많은데 중간에 예외
 * => 형식_
 *      public void display() throws 예외처리 클래스...
 *          => 여러개일 경우 : ,
 *          => 순서 상관없음
 *          => 예상되는 에러만 지정해야함
 */
public class 예외처리_1 {
//	public int div(int a, int b) throws ArithmeticException {
//		
//		return a/b;
//	}
//	public void print()
//	{
//		int c=div(10,0);
//		System.out.println(c);
//	}
	public void display() throws Exception,ClassNotFoundException{
		System.out.println("display call...");
	}
	// check => 호출시에는 반드시 예외처리를 해야함
	// uncheck => throws문장을 사용하지 않는다
	//1. try ~catch
	public void print()
	{
		try {
			display();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//2. try~catch
	public void print2() {
		try {
			display();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//3. throws
	public void print3() throws ClassNotFoundException,Exception{
		display();
	}
	//4. throws
	public void print4() throws Exception{
		display();
	}
	/*
	 * 소스가 없는 경우 => 새로운 메소드를 만드는 경우
	 * try~catch=> 개발
	 * 이미 소스 코딩이 있는 경우 => 새로운 기능 추가
	 * throws => 유지보수
	 * -------
	 * 1. 예상되는 예외를 메소드뒤에 선언
	 * 2. 메소드 호출에 반듯 ㅣ예외처리후 호출
	 * -------------------------------------
	 *     => 직접처리 (*****)
	 *     => 선언하고 사용할 수 있다
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
