package com.sist.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class ControlPanel  extends JPanel {

	Image back;
	JLabel la1,la2;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2;
	
	public ControlPanel() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\background.jpg");
		la1=new JLabel("ID");
		la2=new JLabel("Password");
		tf = new JTextField();
		pf = new JPasswordField();
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		//배치 => 실행과 동시에 실행문장
		setLayout(null);
		JPanel p1 = new JPanel();
		
		la1.setForeground(Color.white);
		la1.setBounds(10,15,80,30);
		tf.setBounds(95,15,300,30);
		add(la1);add(tf);
		
		la2.setForeground(Color.white);
		la2.setBounds(10,50,80,30);
		pf.setBounds(95,50,300,30);
		add(la2);add(pf);
		
		JPanel p2 =new JPanel();
		p2.setOpaque(false);
		p2.add(b1);
		p2.add(b2);
		p2.setBounds(10,90,285,35);
		add(p2);
		
		
		
		
	}
	//오버라이딩
	public void paintComponent (Graphics g) {
		g.drawImage(back, 0, 0,getWidth(), getHeight(), this);
	}
//	public ControlPanel() {
//		setBackground(Color.gray);
//	}
}
