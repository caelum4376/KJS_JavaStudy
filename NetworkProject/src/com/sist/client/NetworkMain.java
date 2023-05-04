package com.sist.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import com.sist.manager.*;
import com.sist.commons.ImageChange;

public class NetworkMain extends JFrame implements ActionListener {
	MenuPanel mp;
	ControlPanel cp;
	SidePanel sp;

	JButton b1, b2, b3, b4, b5;
	Login login = new Login();
	JLabel logo;

	public NetworkMain() {
		
		logo = new JLabel();
		Image img = ImageChange.getImage(new ImageIcon("C:\\javaDev\\logo.png"), 200, 130);
		
		logo.setIcon(new ImageIcon(img));
		mp = new MenuPanel();
		cp = new ControlPanel();
		sp = new SidePanel();

		setLayout(null); // Layout없이 직접 배치
		logo.setBounds(10, 15, 200, 130);
		mp.setBounds(10, 150, 960, 50); // 가로위치, 세로위치, 가로길이, 세로길이
		cp.setBounds(10, 215, 750, 730);
		sp.setBounds(770, 215, 200, 730);

		
		b1 = new JButton("홈");
		b2 = new JButton("영화검색");
		b3 = new JButton("채팅");
		b4 = new JButton("뉴스검색");
		b5 = new JButton("영화추천");
		mp.setLayout(new GridLayout(1, 5, 10, 10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);

		// 추가
		add(logo);
		add(mp);
		add(cp);
		add(sp);

		// 윈도우 크기
		setSize(1200, 1000);
//		setVisible(true);

		// 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("네트워크 영화 프로그램");

		// 이벤트 등록
		b1.addActionListener(this);//
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);

		// 로그인
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		// 채팅
		cp.cp.tf.addActionListener(this);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {

		}
		new NetworkMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			cp.card.show(cp, "home");
		} else if (e.getSource() == b2) {
			cp.card.show(cp, "find");
		} else if (e.getSource() == b3) {
			cp.card.show(cp, "chat");
		} else if (e.getSource() == b4) {
			cp.card.show(cp, "news");
		} else if (e.getSource() == b5) {
			cp.card.show(cp, "recomm");
		} else if (e.getSource() == login.b1) {
			login.setVisible(false);
			setVisible(true);
		} else if (e.getSource() == login.b2) {
			System.exit(0); // 프로그램 종료
		} else if (e.getSource() == cp.cp.tf) {
			cp.cp.initStyle();
			String msg = cp.cp.tf.getText();
			String color = cp.cp.box.getSelectedItem().toString();
			if (msg.length()<1) {
				return;
			}
			cp.cp.append(msg, color);
			
			cp.cp.tf.setText("");
		}
	}

}
