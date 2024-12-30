package com.sist.commons;
// 서버와 클라이언트가 공통으로 사용
// 내부 프로토콜 : 서버와 클라이언트의 약속
/*
 * 100번을 보내면 => 로그인 => login.jsp
 * 200번을 보내면 => 방만들기 => make.jsp
 * admin|1234|aaaaa => send.jsp
 * 
 * 1. 서버로 요청 => 응답을 받아서 윈도우 출력
 *     ----------
 *     요청 처리          결과값을 출력
 * 2. 
 */
public class Function {
	public static final int LOGIN = 100; // 먼저 로그인한 사람 처리
	public static final int MYLOG = 110;// 로그인하느 사람
	public static final int SAITCHAT = 200;
	public static final int END= 900; // 남아 있는 사람
	public static final int MYEND=910; // 나가는 사람
	// 모든 처리는 서버에서 명령을 내린다
	/*
	 * 웹 => Oracle (SQL) => TCP => IP/PORT
	 * ---      ------ 네트워크 이용 => 서버가 이미 제작됨
	 * 
	 * 빅데이터 / 게임/모바일
	 * 
	 */
	
}
