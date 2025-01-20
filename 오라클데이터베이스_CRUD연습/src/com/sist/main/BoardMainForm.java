package com.sist.main;
import javax.swing.*;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import java.util.Date;
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
		bDelete.pf.addActionListener(this);
		
		//수정
		bUpdate.b1.addActionListener(this);
		bUpdate.b2.addActionListener(this);
		bUpdate.pwdPf.addActionListener(this);
		
	}
	public void listPrint()
	{
		//테이블 전체 데이터 지우기
		for(int i=bList.model.getRowCount()-1;i>=0;i--)
		{
			bList.model.removeRow(i);
		}
		//JLabel => init => JLabel 초기화
		FreeBoardDAO dao= FreeBoardDAO.newInstance();
		List<FreeBoardVO> list = dao.getFreeBoardList(curpage);
		for(FreeBoardVO vo:list)
		{
			String[] data= {
				String.valueOf(vo.getNo()),
				vo.getSubject(),
				vo.getName(),
				vo.getRegdate().toString(),
				String.valueOf(vo.getHit())
			};
			
			bList.model.addRow(data);
			
		}
		totalPage=dao.boardTotalPage();
		bList.pageLa.setText(curpage+" page / " + totalPage + " pages");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardMainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==bList.prevBtn)
		{
			if(curpage>1)
			{
				curpage--;
				listPrint();
			}
		}
		else if(e.getSource()==bList.nextBtn)
		{
			if(curpage<totalPage)
			{
				curpage++;
				listPrint();
			}
		}
		else if(e.getSource()== bList.inBtn)
		{
			card.show(getContentPane(), "INSERT");
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			bInsert.nameTf.requestFocus();
			//card => 단점은 윈도우가 종료하지 않는다 => 입력된 내용을 그대로 유지한다.
		}
		//글쓰기 등록
		else if(e.getSource() == bInsert.b1)
		{
			// 입력한 데이터 읽기
			String name=bInsert.nameTf.getText();
			if(name.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				bInsert.nameTf.requestFocus();
				
				return;
			}
			String subject= bInsert.subTf.getText();
			if(subject.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				bInsert.subTf.requestFocus();
				
				return;
			}
			String content = bInsert.ta.getText();
			if(content.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				bInsert.ta.requestFocus();
				
				return;
			}
			String pwd = String.valueOf(bInsert.pwdPf.getPassword());
			if(pwd.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				bInsert.pwdPf.requestFocus();
				
				return;
			}
			
			// 오라클 연동
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			FreeBoardVO vo = new FreeBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			dao.boardInsert(vo);
			
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		//글쓰기 취소
		else if(e.getSource()== bInsert.b2)
		{
			// javascript:history.back();
			card.show(getContentPane(), "LIST");
		}
		//상세보기 페이지에서
		else if(e.getSource()==bDetail.b3)
		{
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		//수정
		else if(e.getSource()==bDetail.b1)
		{
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			int no = Integer.parseInt(bDetail.no.getText());
			FreeBoardVO vo = dao.boardupdatedata(no);
			card.show(getContentPane(), "UPDATE");
			bUpdate.pwdPf.setText("");
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.ta.setText(vo.getContent());
		}
		//삭제
		else if(e.getSource()==bDetail.b2)
		{
			card.show(getContentPane(), "DELETE");
			bDelete.pf.setText("");
			bDelete.pf.requestFocus();
		}
		
		//삭제페이지에서
		else if(e.getSource()==bDelete.b2)
		{
			card.show(getContentPane(),"DETAIL");
		}
		else if(e.getSource() == bDelete.b1 || e.getSource()==bDelete.pf)
		{
			if(String.valueOf(bDelete.pf.getPassword()).trim().length() < 1)
			{
				bDelete.pf.requestFocus();
				return;
			}
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			int no = Integer.parseInt(bDetail.no.getText());
			int pwd = Integer.parseInt(String.valueOf(bDelete.pf.getPassword()));
			boolean result=dao.boardDelete( pwd, no);
			if(result==true)
			{
				card.show(getContentPane(),"LIST");
				listPrint();
			}
			else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
			
			
		}
		//수정
		else if(e.getSource()==bUpdate.b1 || e.getSource()==bUpdate.pwdPf) {
			String name=bUpdate.nameTf.getText();
			if(name.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				bUpdate.nameTf.requestFocus();
				
				return;
			}
			String subject= bUpdate.subTf.getText();
			if(subject.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				bUpdate.subTf.requestFocus();
				
				return;
			}
			String content = bUpdate.ta.getText();
			if(content.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				bUpdate.ta.requestFocus();
				
				return;
			}
			String pwd = String.valueOf(bUpdate.pwdPf.getPassword());
			if(pwd.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				bUpdate.pwdPf.requestFocus();
				
				return;
			}
			int no = Integer.parseInt(bDetail.no.getText());
			
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			FreeBoardVO vo = new FreeBoardVO();
			vo.setPwd(pwd);
			vo.setNo(no);
			vo.setSubject(subject);
			vo.setContent(content);
			
			boolean res = dao.boardUpdate(vo);
			if(res ==false)
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				bUpdate.pwdPf.setText("");
				bUpdate.pwdPf.requestFocus();
			}
			else
			{
				card.show(getContentPane(), "DETAIL");
				detailPrint(no);
			}
			
		}
		else if(e.getSource()==bUpdate.b2) {
			card.show(getContentPane(), "DETAIL");
		}
	}
	
	public void detailPrint(int no)
	{
		FreeBoardDAO dao = FreeBoardDAO.newInstance();
		FreeBoardVO vo = dao.getFreeBoardDetail(no);
		bDetail.no.setText(String.valueOf(vo.getNo()));
		bDetail.name.setText(vo.getName());
		bDetail.sub.setText(vo.getSubject());
		bDetail.ta.setText(vo.getContent());
		bDetail.day.setText(new SimpleDateFormat("yyyy-MM-DD").format(vo.getRegdate()));
		bDetail.hit.setText(String.valueOf(vo.getHit()));
	}
	
	//onMouseDown
	@Override
	public void mouseClicked(MouseEvent e) {//상세페이지로 이동
		if(e.getSource()==bList.table)
		{
			if(e.getClickCount()==2)
			{
				int row=bList.table.getSelectedRow();
				String no = bList.model.getValueAt(row, 0).toString();
				detailPrint(Integer.parseInt(no));
				
				card.show(getContentPane(), "DETAIL");
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
