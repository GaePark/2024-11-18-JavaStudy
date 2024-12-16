package com.sist.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;// 인터페이스
/*
 * ActionListener : 버튼 / enter / Menu
 *     => actionperformed
 * Mouselistener / MouseMotionListener
 * KeyListener
 * 
 *    //인터페이스 : 처리하는 기능이 여러개 있다
 *                       -------------------------
 *                       ㅣ메소드는 선언 => 프로그램에 맞게 구현
 *                       ㅣ단점 => 선언된 메소드가 많은 경우
 *                                       -----------------------
 *                                       ㅣ선택적으로 사용할 수 없다
 *                                       ㅣ메소드는 {} 구현완료
 *                        ㅣ가급적이면 구현해서 전송
 *                                        ------- 선택적으로 처리가 가능
 *                                        ------- default
 *                                        ------- 필요시에 해당 메소드만 오버라이딩이 가능
 *                                        ------- 선언된 메소드는 모든 구현을 해야된다
 */
public class 퍼즐게임 extends JFrame
implements ActionListener
{
	JButton[] btns = new JButton[9];
	JLabel la = new JLabel("퍼즐게임",JLabel.CENTER);
	JButton b1, b2;
	int[] panCount = new int[9];
	int cols= 0, rows=0;//빈칸
	int last=0;
	//초기화
	public 퍼즐게임() {
		b1 = new JButton("시작");
		b2 = new JButton("종료");
		
		JPanel p = new JPanel(); //컴포넌트 여러개 묶어서 배치
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,3,5,5));// 3*3 모양 padding 5px;
		for(int i=0; i<9; i++) {
			btns[i]=new JButton(String.valueOf(i+1));//문자열 집어넣어야함
			btns[i].setFont(new Font("고딕체",Font.BOLD,45));
			btns[i].addActionListener(this);
			pan.add(btns[i]);
		}
		
		setLayout(null);
		pan.setBounds(10,15,350,350);
		add(pan);

		p.add(b1); p.add(b2);
		p.setBounds(10,370,300,35);
		add(p);
		
		setSize(400,500);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//등록
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) {
		new 퍼즐게임();
	}
	
	//버튼 처리하는 메소드 => 개발자가 구현 => 자동 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==btns[last])
			{
				return;
			}
			if(e.getSource()==btns[i]) {
				
				panCount[i]=8;
				panCount[last]=Integer.parseInt(btns[i].getText())-1;
				last=i;
				
				puzzleLayout();
				
				if(isEnd()) {
					JOptionPane.showMessageDialog(this, "Game Over!!");
				}
			}
		}
		
		if(e.getSource()==b2) {
			System.exit(0);
		}
		else if(e.getSource()==b1) {
			getRand();
			puzzleLayout();
		}

	}
	// 사용자 정의 메소드
	public void getRand()
	{
		for(int i=0;i<9;i++) {
			panCount[i]=(int)(Math.random()*9);
			
			for(int j=0;j<i;j++) {
				if(panCount[i]==panCount[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(panCount[i]==8) {
				last=i;
				break;
			}
		}
	}
	
	// 배치
	public void puzzleLayout() {
		for(int i=0; i<9; i++) {
			if(last == i) {
				btns[i].setText("");
			}
			else {
				btns[i].setText(String.valueOf(panCount[i]+1));
			}
		}
	}
	
	public boolean isEnd()
	{
		for(int i=0;i<9;i++) {
			if(panCount[i]!=i)
				return false;
		}
		return true;
	}
}
