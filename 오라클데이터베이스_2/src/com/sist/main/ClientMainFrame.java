package com.sist.main;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
import com.sist.vo.*;

//AcrylLookAndFeel 
import javax.swing.*;
//                                                   상속 => 재사용 => 변경
public class ClientMainFrame  extends JFrame implements ActionListener {
	MenuForm mf = new MenuForm(); // 포함 클래스 => 있는 그대로 사용
	ControlPanel cp = new ControlPanel();
	Login login = new Login();
	// 배치
	public ClientMainFrame() {
		setLayout(null); // 사용자 정의 => 직업 배치
			setLayout(null); // 사용자 정의 => 직업 배치
			mf.setBounds(10,15,1250,50);
			add(mf);
			cp.setBounds(10,95,1250,650);
			add(cp);

		System.out.println();

		setSize(1280, 800);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.b1.addActionListener(this);
		cp.b2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin. McWinLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		new ClientMainFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==cp.b1)
		{
			String id=cp.tf.getText();
			if(id.trim().length()<1)
			{
				cp.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(cp.pf.getPassword());
			if(pwd.trim().length()<1)
			{
				cp.pf.requestFocus();
				return;
			}
			
			MemberDAO dao = MemberDAO.newInstance();
			MemberVO vo = dao.isLogin(id, pwd);
			if(vo.getMsg().equals("NOID"))
			{
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
				cp.tf.setText("");
				cp.pf.setText("");
				cp.tf.requestFocus();
			}
			else if(vo.getMsg().equals("NOPWD"))
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				cp.pf.setText("");
				cp.pf.requestFocus();
			}
			else//로그인 상태
			{
				String msg=vo.getName()+"님 로그인되었습니다\n"
														+"메인페이지로 이동합니다!!";
				JOptionPane.showMessageDialog(this, msg);
			}
			
		}
		
	}

}
