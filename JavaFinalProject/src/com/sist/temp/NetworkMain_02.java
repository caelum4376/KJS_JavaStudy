package com.sist.temp;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.*;
import com.sist.commons.ImageChange;
import com.sist.manager.GenieMusicVO;
import com.sist.manager.MusicSystem;
//// 네트워크 관련
import java.util.List;
import java.io.*;
import java.net.*;
/*
 *    프로그램 => 2개
 *    1) 로그인, 채팅문자열 입력... 일반 사용자
 *    2) 서버에서 전송되는 데이터를 출력
 *       ------------------------------- 쓰레드
 */

public class NetworkMain_02 extends JFrame implements ActionListener {
	MenuPanel mp;
	ControlPanel cp;
	TopPanel tp;

	JButton b1, b2, b3, b4, b5;
	Login login = new Login();
	JLabel logo;
	
	// 페이지 지정
	int curpage=1;
    int totalpage=0;
    MusicSystem ms=new MusicSystem();
	public NetworkMain_02() {
		
		logo = new JLabel();
		Image img = ImageChange.getImage(new ImageIcon("/Users/caelum/Documents/java_datas/logo.jpg"), 200, 130);
		
		logo.setIcon(new ImageIcon(img));
		mp = new MenuPanel();
		cp = new ControlPanel();
		tp = new TopPanel();

		setLayout(null); // Layout없이 직접 배치
		logo.setBounds(10, 15, 200, 130);
		mp.setBounds(10, 150, 960, 50); // 가로위치, 세로위치, 가로길이, 세로길이
		cp.setBounds(10, 215, 750, 530);
		tp.setBounds(770, 215, 200, 530);

		
		b1 = new JButton("홈");
		b2 = new JButton("음악검색");
		b3 = new JButton("채팅");
		b4 = new JButton("뉴스검색");
		b5 = new JButton("음악추천");
		mp.setLayout(new GridLayout(1, 5, 10, 10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);
		mp.add(b5);

		// 추가
		add(logo);
		add(mp);
		add(cp);
		add(tp);

		// 윈도우 크기
		setSize(1200, 1000);
//		setVisible(true);

		// 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("네트워크 음악 프로그램");

		// 이벤트 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);

		// 로그인
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		// 채팅
		cp.cp.tf.addActionListener(this);
		
		// Homepage
		List<GenieMusicVO> list = ms.musicListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		totalpage = ms.musicTotalPage();

		cp.hp.b1.addActionListener(this); // 이전 
		cp.hp.b2.addActionListener(this); // 다음 
		cp.hp.pageLa.setText(curpage +" page /" + totalpage + " page");
		
		musicDisplay();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {

		}
		new NetworkMain_02();

	}

	// 버튼처리	
	public void musicDisplay() {
		
		List<GenieMusicVO> list = ms.musicListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		totalpage = ms.musicTotalPage();v
		cp.hp.pageLa.setText(curpage +" page /" + totalpage + " page");
		// HomePage
		cp.hp.b1.addActionListener(this); // 이전 
		cp.hp.b2.addActionListener(this); // 다음 
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			musicDisplay();
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
			// 로그인 데이터 읽기 
			String id = login.tf1.getText();
			if (id.length() < 1) {
				JOptionPane.showMessageDialog(this, "ID를 입력하세요");
				login.tf1.requestFocus();
				return;
			}
			String name = login.tf1.getText();
			if (name.length() < 1) {
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				login.tf1.requestFocus();
				return;
			}
			String sex = "남자";
			if (login.rb1.isSelected()) { // 남자 라디오버튼이 선택 
				sex="남자";
			} else {
				sex="여자";
			}
			
			// 서버로 전송 
			try {
				// 서버 연결 
				s = new Socket("localhost", 33333);
				
				// 서버컴퓨터 => ip
				// 211.238.142.()
				// 읽는 위치 / 쓰는 위치
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				// s는 서버메모리 => 서버메모리로부터 값을 읽어 온다
				
				// 서버로 로그인 요청
				out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n"));
			} catch (Exception ee) {
				// 서버로부터 전송된 값을 받아온다
				new Thread(this).start(); // run()호출 
			}
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
		} else if (e.getSource() == cp.hp.b1) {
			if (curpage > 1) {
				curpage--;
				musicDisplay();
			}
		} else if (e.getSource() == cp.hp.b2) {
			if (curpage < totalpage) {
				curpage++;
				musicDisplay();
			}
		}
		
	}

}
