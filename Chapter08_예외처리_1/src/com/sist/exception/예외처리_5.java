package com.sist.exception;
/*
 * 예외처리 => try ~ catch
 * => IO / SQL
 * => try : 정상 수행하는 문장
 *              => 입력값, 실수 => 오류발생
 *       => 오류 발생 => 찾아서 => 오류 복구
 *             ---------------------------------
 *             catch
 *        try => if
 *        catch => else
 *        => if~else if....
 *        catch => 한개만 수행
 *        catch => 클래스크기에 따라 작은 순서 제작
 *                       -----------------------------
 *                       1. 계층구조
 *                           Object : 최상위 클래스
 *                                ㅣ
 *                            Throwable
 *                                 l
 *                   -----------------------
 *                   l                              l
 *                Error                     Exception
 *                => 처리 X               => 처리 O
 *                
 *                             Exception
 *                                   l
 *     Check                                       UnCheck
 *  컴파일시에                                      필요시만
 *  예외처리가                                      예외처리
 *  되었는지 확인
 *          -------------------------------------
 *          l                                                 l
 *   IOException                             실행시 => 입력값 확인
 *   SQLException                          RuntimeException
 *   ClassNotFoundException                    l
 *                                                  NumberFormatException
 *                                                  ArrayIndexOfBoundsException
 *                                                  ClassCastException
 *                                                  ...
 *                                                  NullPointerException
 */
public class 예외처리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
