package com.sist.exception;
/*
 * 1) 예외방법과 형식
 *      --------------
 *      CheckException => 컴파일시
 *          => java.io / java.net / java.sql
 *          => 반드시 예외처리 해야함
 *          => 컴파일시에 예외처리를 작성했는지 확인
 *      UnCheckException => 런타임(실행시)
 *          => java.lang / java.util
 *              => Object => clone() => 예외처리가 필요
 *                                    -------- 메모리 복제 (prototype)
 *          => 예외처리를 필요시에만 작성
 *                              ------ 사용자가 자주 발생하는 에러가 있는 경우
 *      => 예외 종류 / 형식
 *               웹 개발 => network (c/s) => 반드시 예외처리
 *          1) 직접처리 (예외복구)
 *          try
 *          {
 *              실행이 가능한 소스 코딩 (정상 수행)
 *              => 에러가 발생할 수 있다 => 사전에 방지하는 목적
 *              => 에러가 난 경우 => 스킵
 *          } catch(예외 클래스)
 *          {
 *              1. 에러확인 가능
 *                  getMessage() => 에러메세지 확인
 *                  printStackTrace() => 실행과정 => 에러 위치 확인
 *              2. 복구 여부 => 에러에 대한 영역
 *          }
 *          finally => 생략이 가능
 *          {
 *              try ~ catch와 상관없이 무조건 수행
 *          }
 *          ** catch => 에러가 발생시 처리하는 영역
 *               ----- 다중 catch가 사능
 *               ----- 에러 종류에 따라 따로 잡는 경우도 있다
 *               ----- 한개 통합 (최상의 예외 클래스를 이용한다)
 *                       --------- Exception / Throwable
 *                                    -----------  ------------
 *                                     예외만 가능  예외+에러
 *               ----- 순서가 존재
 *               
 *          *** try에서 정상수행을 하면 => catch는 수행안함
 *                --------------------- finally가 있는 경우에는 finally는 무조건 수행
 *          2) 간접 처리 (예외회피) => 컴파일시에 통과
 *              => 특별한 경우가 아니면 사용자 정의에서는 많이 사용하지 않는다
 *                    ---------- 소스가 많은 경우 (try설정이 어려운 경우)
 *                    ㅣ유지보수 => 추가하는 기능에 예외처리가 필요하다
 *                       ------- 기능 추가 / 기능 수행
 *              => 시스템 자체에서 처리 => 복구(X) , 정상수행도 불가능
 *  
 *  => throws : 예상되는 에러를 선언만 한다
 *  => throw : 고의로 예외를 발생 (테스트) => 견고성
 */
public class 예외처리_예외복구 {

	public void display() throws Exception{
		System.out.println(10/0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		예외처리_예외복구 a= 	new 예외처리_예외복구();
		try {
			a.display();
		}catch (Exception e) {
			
			// TODO: handle exception
		}

	}

}
