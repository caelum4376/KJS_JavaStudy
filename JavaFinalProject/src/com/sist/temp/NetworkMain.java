package com.sist.temp;

import java.awt.*;
import javax.swing.*;
public class NetworkMain extends JFrame {
	MenuPanel mp;
	ControlPanel cp;
	TopPanel tp;
	
	JButton b1, b2, b3, b4, b5;
	
	public NetworkMain() {
		mp = new MenuPanel();
		cp = new ControlPanel();
		tp = new TopPanel();
		
		setLayout(null); // Layout없이 직접 배치
		mp.setBounds(10, 15, 200, 300);
		cp.setBounds(220, 15, 750, 730);
		tp.setBounds(980, 15, 200, 730);
		
		b1 = new JButton("홈");
		b2 = new JButton("음악검색");
		b3 = new JButton("채팅");
		b4 = new JButton("뉴스검색");
		b5 = new JButton("뮤직추천");
		mp.setLayout(new GridLayout(5, 1, 10, 10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);
		mp.add(b5);
		
		// 추가
		add(mp);
		add(cp);
		add(tp);
		
		// 윈도우 크기
		setSize(1200, 800);
		setVisible(true);
		
		// 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {

		}
		new NetworkMain();
		
	}

}
