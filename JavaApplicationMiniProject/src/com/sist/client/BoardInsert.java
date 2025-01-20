package com.sist.client;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sist.dao.ReplyBoardDAO;
import com.sist.vo.ReplyBoardVO;
public class BoardInsert extends JPanel
	implements ActionListener
{
    JLabel titleLa,nameLa,subLa,contLa,pwdLa;
    JTextField nameTf,subTf;
    JPasswordField pwdPf;
    JTextArea ta;
    JButton b1,b2;
    ControlPanel cp;
    ReplyBoardDAO dao = ReplyBoardDAO.newInstance();
    public BoardInsert(ControlPanel cp)
    {
    	this.cp = cp;
    	titleLa=new JLabel("글쓰기",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	setLayout(null);
    	titleLa.setBounds(10, 15, 620, 50);
    	add(titleLa);
    	
    	nameLa=new JLabel("이름",JLabel.CENTER);
    	nameTf=new JTextField();
    	nameLa.setBounds(50, 70, 80, 30);
    	nameTf.setBounds(135, 70, 150, 30);
    	add(nameLa);add(nameTf);
    	
    	subLa=new JLabel("제목",JLabel.CENTER);
    	subTf=new JTextField();
    	subLa.setBounds(50, 105, 80, 30);
    	subTf.setBounds(135, 105, 450, 30);
    	add(subLa);add(subTf);
    	
    	
    	contLa=new JLabel("내용",JLabel.CENTER);
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	contLa.setBounds(50, 140, 80, 30);
    	js.setBounds(135, 140, 450, 250);
    	add(contLa);add(js);
 
    	pwdLa=new JLabel("비밀번호",JLabel.CENTER);
    	pwdPf=new JPasswordField();
    	//             Top  Right Bottom Left ==> CSS
    	pwdLa.setBounds(50, 395, 80, 30);
    	//             x  y width heigth
    	pwdPf.setBounds(135, 395, 150, 30);
    	add(pwdLa);add(pwdPf);
    	
    	b1=new JButton("글쓰기");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(50, 435, 535, 35);
    	add(p);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) 
		{
			String name = nameTf.getText();
			if(nameTf.getText().trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
				nameTf.requestFocus();
				return;
			}
			
			String subject = subTf.getText();
			if(subject.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "제목을 입력해주세요");
				subTf.requestFocus();
				return;
			}
			
			String content = ta.getText();
			if(content.length()<1)
			{
				JOptionPane.showMessageDialog(this, "내용을 입력해주세요");
				ta.requestFocus();
				return;
			}
			String pwd = String.valueOf(pwdPf.getPassword());
			if(pwd.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요");
				pwdPf.requestFocus();
				return;
			}
			
			ReplyBoardVO vo = new ReplyBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			dao.boardInsert(vo);
			
			cp.bList.curpage=1;
			cp.card.show(cp, "BLIST");
			cp.bList.print();
		}
		else if(e.getSource()==b2)
		{
			cp.card.show(cp, "BLIST");
		}
	}
}
