package com.sist.client;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sist.vo.*;
import java.util.List;

import com.sist.commons.ImageChange;
import com.sist.dao.FoodDAO;
public class HomePanel extends JPanel
implements MouseListener,ActionListener
{
	ControlPanel cp;
	JPanel pan = new JPanel();
	
	//이미지 출력
	JButton b1,b2; //이전 ,다음
	JLabel la=new JLabel("0 page / 0 pages");
	JLabel[] imgs = new JLabel[12];
	
	int curpage=1;
	int totalpage=0;
	
	//데이터베이스 연동 => FoodDAO
	FoodDAO dao = FoodDAO.newInstance();
	public HomePanel(ControlPanel cp)
	{
		setLayout(new BorderLayout());
		this.cp=cp;
		pan.setLayout(new GridLayout(3,4,5,5));
		add("Center",pan);
		b1 = new JButton("이전");
		b2 = new JButton("다음");
		JPanel p = new JPanel();
		p.add(b1); p.add(la); p.add(b2);
		//add => 코딩순서로 배치
		add("South",p);
		print();
		
		b1.addActionListener(this);//이전
		b2.addActionListener(this);//다음
	}
	public void init()
	{
		for(int i=0;i<imgs.length;i++) {
			imgs[i]=new JLabel("");
		}
		pan.removeAll();//전체 삭제
		pan.validate();//재배치
	}
	
	// 이미지 출력
		public void print()
		{
			//총페이지 읽기
			totalpage = dao.foodTotalPage();
			List<FoodVO> list = dao.FoodListData(curpage);
			for(int i=0; i< list.size();i++)
			{
				FoodVO vo = list.get(i);
				try
				{
					URL url= new URL(vo.getPoster());
					Image image=ImageChange.getImage(new ImageIcon(url), 200, 150);
					imgs[i] = new JLabel(new ImageIcon(image));
					imgs[i].setToolTipText(vo.getName()+"^"+vo.getFno());
					pan.add(imgs[i]);
					//이벤트 등록
					imgs[i].addMouseListener(this);
				}catch(Exception e) {}
			}
			la.setText(curpage+" page / "+totalpage + " page");
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i])
			{
				if(e.getClickCount()==2)
				{
					String fno=imgs[i].getToolTipText();
					fno=fno.substring(fno.lastIndexOf("^")+1);
					FoodVO vo = dao.foodDetailData(Integer.parseInt(fno));
					cp.fdp.detailPrint(1, vo);
					cp.card.show(cp, "DETAIL");
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(new LineBorder(Color.red,3));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(curpage>1)
			{
				curpage--;
				init();
				print();
			}
		}
		else if(e.getSource()==b2)
		{
			if(curpage<totalpage)
			{
				curpage++;
				init();
				print();
			}
		}
	}
}
