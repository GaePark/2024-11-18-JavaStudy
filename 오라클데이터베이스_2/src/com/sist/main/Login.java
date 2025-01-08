package com.sist.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
	JLabel idLa,passLa;
	JTextField idrf;
	JPasswordField pf;
	JButton login,register;
	
	public Login() {
		idLa = new JLabel("ID");
		passLa = new JLabel("PASSWORD");
		idrf = new JTextField();
		pf = new JPasswordField();
		
		login = new JButton("로그인");
		register = new JButton("회원가입");
		
		setLayout(null);
		idLa.setForeground(Color.black);
		idLa.setBounds(0,0,80,20);
		idrf.setBounds(0, 25, 300, 30);;
		
		passLa.setForeground(Color.black);	
		passLa.setBounds(0,60,80,20);
		pf.setBounds(0,85,300,30);
		
		add(idLa);add(idrf);
		add(passLa);add(pf);
		
		login.setBounds(0,120,300,30);
		add(login);
		register.setBounds(0,155,300,30);
		add(register);
	
		
	}
	
	
}
