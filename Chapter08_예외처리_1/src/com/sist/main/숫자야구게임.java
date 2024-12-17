package com.sist.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * 1. 이벤트 처리
 *    -----------
 *    제공하는 메소드 => 구현이 안됨
 *                              ------------ 인터페이스
 *                              
 *   = ActionListener
 *        :버튼 클릭 , 메뉴 클릭 , text에서 엔터
 *       => actionPerformed() => 구현해서 사용
 *   = MouseListener / MouseMotionListener
 *   = KeyListener
 *   
 * => 문제 발생
 *     => 입력창에서 정수 입력
 *                         --------- 예외처리
 * 
 * 
 */
public class 숫자야구게임 extends JFrame
implements ActionListener
{
	JTextArea ta;//힌트 출력
	JTextField tf; //입력창
	JButton b1,b2; // 시작 종료
	int[] com = new int[3];
	int[] user = new int[3];
	
	public 숫자야구게임() {
		
		ta=new JTextArea();
		//JTextPane(워드) / JTextArea(메모장)
		JScrollPane js = new JScrollPane(ta);
		ta.setEditable(false);//편집 불가능
		tf=new JTextField(10);
		tf.setEnabled(false);//비활성화
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		
		//배치
		JPanel jp = new JPanel();
		jp.add(tf);
		jp.add(b1);
		jp.add(b2);
		
		add("Center",js);
		add("South",jp);
		
		
		
		setSize(350,350);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이벤트 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf.addActionListener(this);
		// 자신이 가지고 있는acttionPerformed()를 호출해라
		// 마우스 => addMouseListener(b1)
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 숫자야구게임();
	}
	
	public void getRand() {
		for(int i=0; i<3;i++) {
			com[i]  = (int)(Math.random()*9)+1;
			for(int j=0; j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) { //b2버튼을 클릭했다면
			 int sel=JOptionPane.showConfirmDialog(this,"종료할까요?",
					"종료",JOptionPane.YES_NO_OPTION);
			 if(sel==JOptionPane.YES_OPTION) {
				 System.exit(0);
			 }
			
		}
		else if(e.getSource() ==b1) {
			getRand();
			tf.setEnabled(true);
			tf.requestFocus();
			b1.setEnabled(false);
		}
		else if(e.getSource()==tf) {
			try
			{
				//입력된 데이터 읽기
				String str = tf.getText();
				int input = Integer.parseInt(str);
				if(input<100 || input>999) {
					JOptionPane.showMessageDialog(this, "세자리 정수만 입력할 수 없습니다.");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				
				user[0]=input/100;
				user[1]=(input%100)/10;
				user[2]=input%10;
				
				if(user[0]==user[1]||user[0]==user[2]||user[1]==user[2]) {
					JOptionPane.showMessageDialog(this, "중복 수는 사용할 수 없습니다.");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				if(user[0]==0 || user[1]==0 || user[2]==0) {
					JOptionPane.showMessageDialog(this, "0은 사용할 수 없습니다.");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				
				int s=0,b=0;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(com[i]==user[j]) {
							if(i==j) {
								s++;
							}
							else
								b++;
						}
					}
				}
				String hint = "Input Number:" + input
								+", Result:"+s+"S-"+b+"B\n";
				ta.append(hint);
				tf.setText("");
				tf.requestFocus();
				
				if(s==3) {
					JOptionPane.showMessageDialog(this, "게임에서 승리했습니다!!");
					ta.setText("");
					tf.setEnabled(false);
					b1.setEnabled(true);
					com[0]=0;
					com[1]=0;
					com[2]=0;
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "세자리 정수만 입력해야됩니다.");
				tf.setText("");
				tf.requestFocus();
				// 예외복구 => RuntimeException
				// 예외처리가 없어도 가능 (UnCheck)
			}
		}
	}

}
