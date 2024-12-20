package com.sist.lang;


/*
 * java.lang
 *     => Object / String / StringBuffer / Math / Wrapper
 * java.util
 *     => Random / StringTokenizer / Date / Calendar
 *     => Collection (List , Map , Set)
 * java.io
 *     => File / FileInputStream / FileOutputStream
 *           FileReader / FileWriter / BufferReader
 *           BufferedInputStream / BUbbberedOutputStream
 *           OutputStream
 * java.sql
 *     => Connection / Statement / ResultSet
 *     
 * => 외부 라이브러리 (웹) => (XML,HTML,JSON,CSV)
 * ------------------------------------------------------------------------
 * 
 * StringBuffer : 임시로 문자열을 저장해서 => 한번에 출력
 *     => append() => 문자열 결합할때
 *           ----------
 * Math
 *     => random() => 난수 발생
 *     => ceil() =>올림함수 => 총페이지 나눌때 사용
 * Wrapper
 *     => 데이터를 쉽게 다루기 위해서 클래스화한 클래스
 *     => 제네릭스 : 데이터형의 통일화 => 형변환없이 사용
 *         => COllection이 나오면 사용
 *     => int => Integer : 문자열을 정수형 변환
 *           long => Long : 문자열을 long형으로 변환
 *           double => Double : 문자열을 실수형으로 변환
 *           boolean => Boolean : 문자열을 boolean으로 변환
 *           
 *     
 */
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 135;
		// SELET CEIL(COUNT(*)/10.0) FROM emp;
		int totalpage = (int)(Math.ceil(count/10.0));
		System.out.println(totalpage);
		//Random => naxtInt(100)+1
		
	}

}
