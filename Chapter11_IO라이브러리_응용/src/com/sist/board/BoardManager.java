package com.sist.board;
import java.util.*;
import java.io.*;

public class BoardManager {
	// 게시물을 모아서 관리 영역
	// 게시물이 모든 사용자에게 공유
	private static List<BoardVO> boardList = new ArrayList<BoardVO>();
	// 오라클 => 저장된 데이터가 static => 공유된 데이터
	// 초기화
	public BoardManager() {
		boardGetData();
	}

	//기능 설정
	// 1. 목록 출력 => 페이지 나누기 =>Read => SELECT
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		int j=0;//10개씩 나눠주는 변수
		int pagecnt=(page*10)-10;
		//시작 위치
		List<BoardVO> temp = new ArrayList<BoardVO>();
		// 최신순으로 출력
		for(int i=boardList.size()-1;i>=0;i--) {
			temp.add(boardList.get(i));
		}
		// 페이지별 출력
		for(int i=0;i<temp.size();i++)
		{
			if(j<10 && i>=pagecnt)
			{
				BoardVO vo = temp.get(i);
				list.add(vo);
				j++;
			}
		}
		
		
		return list;
	}
	// 2. 추가 =>Create => INSERT
	public void boardInsert(BoardVO vo)
	{
		boardList.add(vo);
		boardSave();// 파일변경
		
	}
	// 3. 상세보기
	public BoardVO boardDetailData(int no) {
		BoardVO vo = new BoardVO();
		for(BoardVO dvo: boardList)
		{
			if(dvo.getNo() ==no) {
				dvo.setHit(dvo.getHit()+1);
				boardSave();
				break;
			}
		}
		boardGetData();
		for(BoardVO dvo: boardList)
		{
			if(dvo.getNo() ==no)
			{
				vo=dvo;
				break;
			}
		}
		
		return vo;
		
	}
	// 4. 수정 / 삭제 => Update / Delete => UPDATE / DELETE
	//-------------------------------------------------------------수정
	public BoardVO boardUpdateData(int no) {
		BoardVO vo = new BoardVO();
		for(BoardVO dvo:boardList)
		{
			if(dvo.getNo()==no)
			{
				vo=dvo;
				break;
			}
		}
		return vo;
	}
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
		int index=0;
		for(int i=0;i<boardList.size();i++)
		{
			BoardVO dvo=boardList.get(i);
			if(vo.getNo()==dvo.getNo())
			{
				index=i;
				break;
			}
		}
		BoardVO dvo = boardList.get(index);
		if(dvo.getPwd().equals(vo.getPwd()))
		{
			bCheck= true;
			boardList.set(index, vo);//수정 => List에서만 수정됨
			boardSave();// 파일 변경
		}
		else
		{
			bCheck = false;
		}
		
		return bCheck;
	}
	//-----------------------------------------------------------------삭제
	public boolean BoardDelete(int no, String pwd)
	{
		boolean bCheck = true;
		for(BoardVO vo: boardList)
		{
			if(vo.getNo()==no)
			{
				if(!vo.getPwd().equals(pwd)) {
					bCheck=false;
				return bCheck;
			}
		}
		}
		int index=0;
		// remove(int index) 
		for(int i=0; i<boardList.size();i++) {
			BoardVO vo =boardList.get(i);
			if(vo.getNo()==no)
			{
				index=i;
				break;
			}
		}
		boardList.remove(index);
		boardSave();// 파일 저장
		return bCheck;
	}
	// CRUD => DML
	// 5. 검색
	// => 오라클 => 
	// 중복 => 저장 / 읽기
	// 추가 / 수정 / 삭제
	public void boardGetData() {
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("c:\\java_data\\board.txt");
			ois=new ObjectInputStream(fis);
			boardList =(List<BoardVO>) ois.readObject();
			// ObjectInputStream => 파일 연결
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally
		{
			try {
				ois.close();
				
			} catch (Exception e2) {}
		}
	}
	// => 자바 => 자동으로 갱신은 없다
	// => 메소드 호출시에만 갱신
	// 수정 / 추가 /삭제 => 변경
	public void boardSave()// finally에 집어넣어서 계속 호출할 수 있도록 하자
	{
		ObjectOutputStream oos =null;
		try {
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			// 수정 => boardList.set()
			// 삭제 => boardList.remove()
			// 추가 => boardList.add()
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {}
		}
	}
	//총페이지 구하기
	public int boardTotalPage()
	{
		return (int)(Math.ceil(boardList.size()/10.0));
	}
	// 시퀀스
	public int boardSequence() // 게시물번호 자동 생성
	{
		int max=0;
		// 비정상 종료 방지하는 프로그램
		try {
			
			for(BoardVO vo: boardList)
			{
				if(vo.getNo()>max)
				{
					max=vo.getNo();
				}
			}
		} catch(Exception e) {}
		return max+1;
	}
	// 게시물 번호를 자동 생성 => 시퀀스 Create Sequence
	// auto_increment()
	
}
