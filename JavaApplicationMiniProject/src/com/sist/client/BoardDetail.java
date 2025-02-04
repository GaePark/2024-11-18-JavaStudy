package com.sist.client;
import java.awt.Color;
import java.awt.Font;

//detail.jsp
import javax.swing.*;
import java.awt.event.*;

import com.sist.dao.ReplyBoardDAO;
import com.sist.vo.ReplyBoardVO;
public class BoardDetail extends JPanel
implements ActionListener
{
  JLabel titleLa,nameLa,noLa,subLa,dayLa,hitLa;
  JLabel name,no,sub,day,hit;
  JTextArea ta;
  JButton b1,b2,b3,b4; // 수정 / 삭제 / 목록 
  ControlPanel cp;
     public  BoardDetail(ControlPanel cp)
  {
    	 this.cp=cp;
 	 titleLa=new JLabel("내용보기",JLabel.CENTER);// <table>
  	 titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
  	 setLayout(null);
 	 titleLa.setBounds(50, 15, 620, 50);
 	 add(titleLa);
 	 
 	 noLa=new JLabel("번호",JLabel.CENTER);
 	 noLa.setBounds(50, 75 , 80, 30);
 	 noLa.setBackground(Color.green);
 	 noLa.setOpaque(true);
 	 no=new JLabel("",JLabel.CENTER);
 	 no.setBounds(145, 75, 120, 30);
 	 add(noLa);add(no);
 	 
 	 dayLa=new JLabel("작성일",JLabel.CENTER);
 	 dayLa.setBounds(270, 75 , 80, 30);
 	dayLa.setBackground(Color.green);
 	dayLa.setOpaque(true);
 	 day=new JLabel("",JLabel.CENTER);
 	 day.setBounds(355, 75, 200, 30);
 	 add(dayLa);add(day);
 	 
 	 nameLa=new JLabel("이름",JLabel.CENTER);
 	 nameLa.setBounds(50, 110 , 80, 30);
 	nameLa.setBackground(Color.green);
 	nameLa.setOpaque(true);
 	 name=new JLabel("",JLabel.CENTER);
 	 name.setBounds(145, 110, 120, 30);
 	 add(nameLa);add(name);
 	 
 	 hitLa=new JLabel("조회수",JLabel.CENTER);
 	 hitLa.setBounds(270, 110 , 80, 30);
 	hitLa.setBackground(Color.green);
 	hitLa.setOpaque(true);
 	 hit=new JLabel("",JLabel.CENTER);
 	 hit.setBounds(355, 110, 200, 30);
 	 add(hitLa);add(hit);
 	 
 	 subLa=new JLabel("제목",JLabel.CENTER);
 	 subLa.setBounds(50, 145 , 80, 30);
 	subLa.setBackground(Color.green);
 	subLa.setOpaque(true);
 	 sub=new JLabel("");
 	 sub.setBounds(1455, 145, 400, 30);
 	 add(subLa);add(sub);
 	 
 	 ta=new JTextArea();
 	 ta.setEditable(false); // 비활성화 
 	 ta.setBounds(50, 180, 485, 250);
 	 add(ta);
 	 
 	 JPanel p=new JPanel();
 	 b1=new JButton("수정");
 	 b2=new JButton("삭제");
 	 b3=new JButton("목록");
 	 b4=new JButton("답변");
 	 p.add(b4);p.add(b1);p.add(b2);p.add(b3);
 	 p.setBounds(50, 440, 485, 35);
 	 add(p);
 	 b1.addActionListener(this);
 	 b2.addActionListener(this);
 	 b3.addActionListener(this);
 	 b4.addActionListener(this);
  }
     public void print(int type, int n)
     {
    	 ReplyBoardDAO dao = ReplyBoardDAO.newInstance();
    	 ReplyBoardVO vo = dao.boardDetailData(type,n);
    	 name.setText(vo.getName());
    	 no.setText(String.valueOf(vo.getNo()));
    	 day.setText(vo.getDbday());
    	 hit.setText(String.valueOf(vo.getHit()));
    	 sub.setText(vo.getSubject());
    	 ta.setText(vo.getContent());
    	 
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b3)
		{
			cp.card.show(cp,"BLIST");
			cp.bList.print();
		}
		else if(e.getSource()==b1)
		{
			cp.bUpdate.pwdPf.setText("");
			String strNo= no.getText();
			ReplyBoardDAO dao= ReplyBoardDAO.newInstance();
			ReplyBoardVO vo = dao.boardUpdateData(Integer.parseInt(strNo));
			cp.card.show(cp,"BUPDATE");
			cp.bUpdate.print(vo);;
		}
		else if(e.getSource()==b2)
		{
			
		}
		else if(e.getSource()==b4)
		{
			
		}
	}
}
