package com.sist.main;
import javax.swing.*;
import javax.swing.table.*;

import com.sist.manager.GenieMusicSystem;
import com.sist.vo.MusicVO;
/*
 * Container
 *     = JFrame
 *     = JDialog => 창위에 창
 *     = JWindow => 창을 닫고 열고 하는게 없음
 *     = JPanel =>
 */
public class MusicUserMain extends JFrame{
	JTabbedPane  tp;
	MusicListPanel mlp = new MusicListPanel();
	MusicFindPanel mfp = new MusicFindPanel();
	MusicDetailPanel mdp = new MusicDetailPanel();
	

	{
		tp = new JTabbedPane();
		tp.addTab("뮤직목록", mlp);
		tp.addTab("뮤직검색", mfp);
		tp.addTab("상세보기", mdp);
		tp.setTabPlacement(JTabbedPane.TOP);
		//윈도우에 추가
		add("Center", tp);
		
		//윈도우 크기
		setSize(1280,720);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MusicUserMain();
	}
}
