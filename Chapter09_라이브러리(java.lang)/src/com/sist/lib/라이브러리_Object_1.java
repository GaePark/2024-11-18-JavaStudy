/*
 * Object외에 다른 클래스는 final이다
 *                 -------------------------
 *                 상속을 받아서 변경이 불가능
 *                 
 *  toString() : 문자열 변환 / 객체의 정보 확인
 *  ----------- 멤버변수 확인 =>오버라이딩
 *                                         ---------
 *                                         상위 클래스로 객체를 선언
 *                                         => 오버라이딩된 메소드 호출이 가능
 */

package com.sist.lib;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class 라이브러리_Object_1 extends JFrame
implements ItemListener
{
	
	JComboBox box = new JComboBox();
	JLabel la = new JLabel();
	public 라이브러리_Object_1() {
		box.addItem("홍길동:남자");
		box.addItem("심청이:여자");
		box.addItem("박문수:남자");
		box.addItem("이순신:남자");
		box.addItem("김두한:남자");
		
		setLayout(null);
		
		box.setBounds(10,15,100,35);
		add(box);
		la.setBounds(10,100,300,35);
		add(la);
		
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		box.addItemListener(this);
		
		// Object는 출력가능
		// => Object => 매개변수 , Object => 리턴형
		// 사용시에는 반드시 형변환
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new 라이브러리_Object_1();
//		Object o =1;
//		o="Hello";
//		o=10.5;
//		o='A';
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box) {
			String obj=box.getSelectedItem().toString();
			String[] datas=obj.split(":");
			la.setText("이름: "+datas[0]+", 성별: "+datas[1]);
			
		}
	}

}
