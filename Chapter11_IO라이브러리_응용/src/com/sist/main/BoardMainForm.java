package com.sist.main;
import javax.swing.*;

import com.sist.board.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import java.text.SimpleDateFormat;
public class BoardMainForm extends JFrame
implements ActionListener,MouseListener
{
	CardLayout card = new CardLayout();
	BoardList bList = new BoardList();
	BoardDetail bDetail = new BoardDetail();
	BoardInsert bInsert = new BoardInsert();
	BoardUpdate bUpdate = new BoardUpdate();
	BoardDelete bDelete = new BoardDelete();
	//게시판 관리자
	BoardManager bm = new BoardManager();
	// 변수 설정
	int curpage=1;
	int totalPage=0;
	public BoardMainForm() {
		setLayout(card);
		//추가
		add("LIST", bList);
		add("INSERT", bInsert);
		add("DETAIL", bDetail);
		add("UPDATE", bUpdate);
		add("DELETE", bDelete);
		
		setTitle("윈도우 게시판 ver 1.0");
		listPrint();
		setSize(640,540);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//이벤트 등록
		bList.inBtn.addActionListener(this);// 글쓰기 이동
		bInsert.b1.addActionListener(this);// 글쓰기
		bInsert.b2.addActionListener(this);// 취소
		bList.nextBtn.addActionListener(this);
		bList.prevBtn.addActionListener(this);
		//table
		bList.table.addMouseListener(this);
		
		bDetail.b1.addActionListener(this);
		bDetail.b2.addActionListener(this);
		bDetail.b3.addActionListener(this);
		bDelete.b1.addActionListener(this);
		bDelete.b2.addActionListener(this);
		
		//수정
		bUpdate.b1.addActionListener(this);
		bUpdate.b2.addActionListener(this);
	}
	public void listPrint() {
		//=> table의 내용을 지운다
		for(int i=bList.model.getRowCount()-1;i>=0;i--) {
			bList.model.removeRow(i);
		}
		//데이터 받기
		List<BoardVO> list = bm.boardListData(curpage);
		totalPage= bm.boardTotalPage();
		bList.pageLa.setText(curpage+"page / "+totalPage + "page");
		
		for(int i=0;i<list.size();i++) {
			BoardVO vo =list.get(i);
			String[] data= {
					String.valueOf(vo.getNo()),
					vo.getSubject(),
					vo.getName(),
					new SimpleDateFormat("yyy-MM-dd").format(vo.getRegdate())
					,String.valueOf(vo.getHit())
			};
			bList.model.addRow(data);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardMainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(bList.inBtn==e.getSource())// 목록에서 새글버튼 클릭
		{
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			// 카드 변경 => 윈도우창 변경 ↓;
			card.show(getContentPane(), "INSERT");
			bInsert.nameTf.requestFocus();
		}
		else if (bInsert.b2==e.getSource())
		{
			card.show(getContentPane(), "LIST");
			// javaScript:history.back()
		}
		
		else if(bInsert.b1==e.getSource())//글쓰기
		{
			String name = bInsert.nameTf.getText();
			// 입력된 값 읽기
			if(name.length() <1)
			{
				bInsert.nameTf.requestFocus();
				return;
			}
			String subject = bInsert.subTf.getText();
			// 입력된 값 읽기
			if(subject.length() <1)
			{
				bInsert.subTf.requestFocus();
				return;
			}
			String content = bInsert.ta.getText();
			// 입력된 값 읽기
			if(content.length() <1)
			{
				bInsert.ta.requestFocus();
				return;
			}
			String pwd = String.valueOf(bInsert.pwdPf.getPassword());
			// 입력된 값 읽기
			if(pwd.length() <1)
			{
				bInsert.pwdPf.requestFocus();
				return;
			}
			
			BoardVO vo = new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			int no=bm.boardSequence();
			vo.setNo(no);
			vo.setRegdate(new Date());
			
			bm.boardInsert(vo);//추가
			//목록으로 이동
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		else if(bList.nextBtn == e.getSource()){
			if(curpage <totalPage) {
				curpage++;
				listPrint();
			}
		}
		else if(bList.prevBtn ==e.getSource())
		{
			if(curpage>1) {
				curpage--;
				listPrint();
			}
		}
		//상세페이지
		else if(bDetail.b3==e.getSource())
		{
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		else if(bDetail.b1==e.getSource())
		{
			//수정요청
			String no=bDetail.no.getText();
			BoardVO vo =bm.boardUpdateData(Integer.parseInt(no));
			card.show(getContentPane(), "UPDATE");
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.ta.setText(vo.getContent());
			bUpdate.ta.setText("");
			
		}
		else if(bDetail.b2==e.getSource())
		{
			card.show(getContentPane(), "DELETE");
		}
		//--------------------삭제---------------------------
		else if(bDelete.b1==e.getSource())
		{
			String pwd=String.valueOf(bDelete.pf.getPassword());
			if(pwd.length()<1)
			{
				bDelete.pf.requestFocus();
				return;
			}
			String no=bDetail.no.getText();
			boolean bCheck = bm.BoardDelete(Integer.parseInt(no), pwd);
			if(bCheck==false)
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
			else
			{
				card.show(getContentPane(), "LIST");
				listPrint();
			}
		}
		else if(bDelete.b2== e.getSource())
		{
			card.show(getContentPane(), "DETAIL");
		}
		//----------------------수정------------------------------
		else if(bUpdate.b1==e.getSource())
		{
			BoardVO vo = new BoardVO();
			vo.setNo(Integer.parseInt(bDetail.no.getText()));
			vo.setName(bUpdate.nameTf.getText());
			vo.setContent(bUpdate.ta.getText());
			vo.setSubject(bUpdate.subTf.getText());
			vo.setPwd(String.valueOf(bUpdate.pwdPf.getPassword()));
			vo.setHit(Integer.parseInt(bDetail.hit.getText()));
			vo.setRegdate(new Date());
			
			boolean bCheck = bm.boardUpdate(vo);
			
			if(bCheck==true) {
				card.show(getContentPane(), "DETAIL");
				bDetail.no.setText(String.valueOf(vo.getNo()));
				bDetail.name.setText(vo.getName());
				bDetail.sub.setText(vo.getSubject());
				bDetail.ta.setText(vo.getContent());
				bDetail.day.setText(new SimpleDateFormat("yyy-MM-dd").format(vo.getRegdate()));
				bDetail.hit.setText(String.valueOf(vo.getHit()));
			}
			else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				bUpdate.pwdPf.setText("");
				bUpdate.pwdPf.requestFocus();
			}
		}
		else if(bUpdate.b2==e.getSource())
		{
			card.show(getContentPane(), "DETAIL");
		}
	}
	
	
	
	//onMouseDown
	@Override
	public void mouseClicked(MouseEvent e) {//상세페이지로 이동
		// TODO Auto-generated method stub
		if(e.getSource()==bList.table)
		{
			if(e.getClickCount()==2)//더블클릭
			{
				int row=bList.table.getSelectedRow();
				String no = bList.model.getValueAt(row, 0).toString();
				BoardVO vo = bm.boardDetailData(Integer.parseInt(no));
				
				card.show(getContentPane(), "DETAIL");
				//출력 => bDetail
					bDetail.no.setText(String.valueOf(vo.getNo()));
					bDetail.name.setText(vo.getName());
					bDetail.sub.setText(vo.getSubject());
					bDetail.ta.setText(vo.getContent());
					bDetail.day.setText(new SimpleDateFormat("yyy-MM-dd").format(vo.getRegdate()));
					bDetail.hit.setText(String.valueOf(vo.getHit()));
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//onMouseUp
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//onMouseOver
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//onMouseOut
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
