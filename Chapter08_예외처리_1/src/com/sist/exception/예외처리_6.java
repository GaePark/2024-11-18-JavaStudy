package com.sist.exception;
/*
 * 예외처리
 * -------
 *     => 개발자 실수 , 사용자 입력이 잘못된 경우 , 시스템 ...
 *     => 소스상에서 수정 가능한 에러
 *          --------------------------
 * 형식)
 *     try
 *     {
 *     
 *     } catch(예상되는 예외 클래스)
 *     {
 *          오류에 대한 확인
 *          --------------
 *          SYstem.out.println(e.getMessage())
 *          => 에러메세지만 출력
 *          e.printStackTrace()
 *          => 실행하는 순서 => 에러 위치 확인 (권장)
 *     }
 *     finally
 *     {
 *         => try/catch => 상관없이 무조건 수행
 *         => 파일 닫기
 *         => 오라클 연결해제
 *         => 서버 연결 종료
 *     }
 *     종료하는 프로그램
 *     => try ~ catch ~finally
 */
// => CheckException : io,sql
public class 예외처리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
