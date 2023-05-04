package com.sist.client;
/*
 *    Window => javax.swing
 *    ---------------------
 *       Container : 윈도우
 *          |
 *        JFrame : 일반 윈도우
 *        JDialog : 정보창, 입력창
 *        JWinodw : 사용빈도가 거의 없다
 *        JPanel : 독립적으로 사용이 불가능 => JFrame위에 설정
 *                 화면 분할 => Component를 모아서 사용
 *       Comonent :
 *          |
 *        Button => JButton, Menu, JCheckBox, JRadioButton
 *        입력창 => 한줄 => JTextField, JPasswordField
 *                  여러줄 => JTextArea
 *        목록출력 => JComboBox, JTable, JTree
 *        
 *        Label : 정보/이미지
 *        JscrollPane
 *    ---------------------------------------------------------------
 *       => BorderLayout
 *          => 위/아래/좌/우/가운데
 *       => FlowLayout
 *       => GridLayout
 *       => CardLayout
 *       => 사용자 정의 (위치를 잡아서 처리)
 *          x, y, width, height
 *          
 *       ==> 윈도우
 *          1) 크기 설정
 *             setSize(width, height)
 *          2) 윈도우를 보여준다
 *             setVisiable(true)
 *          3) 상속 => 이미 만들어져 있는 기능을 재사용
 *                     => 변경이 가능 
 */

import java.awt.*;  // Layout
import javax.swing.*; // window
import java.awt.event.*;
public class MainClass_01 extends JFrame {
	// 시작과 동시에 윈도우 설정
	// ----------- 생성자 : 1) 초기화 담당, 2) 시작과 동시에 처리하는 일
	// 생성자는 모든 클래스에서 사용이 가능하게 만든다 => public
	JButton b1,b2,b3,b4,b5;
	JMenuItem home, find, chat, news, border;
	JTabbedPane pane;
	public void MainClass_01() {
		
		home = new JMenuItem("홈");
		find = new JMenuItem("검색");
		chat = new JMenuItem("채팅");
		news = new JMenuItem("뉴스");
		border = new JMenuItem("커뮤니티");
		
		JMenu menu = new JMenu("메뉴");
		menu.add(home);
		menu.add(find);
		menu.add(chat);
		menu.add(news);
		menu.add(border);
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		setJMenuBar(bar);
		
		pane = new JTabbedPane();
		pane.addTab("홈", new JPanel());
		pane.addTab("검색", new JPanel());
		pane.addTab("채팅", new JPanel());
		pane.addTab("뉴스", new JPanel());
		pane.addTab("커뮤니티", new JPanel());
		
		
		// 윈도우 크기 설정
		b1 = new JButton("홈");
		b2 = new JButton("검색");
		b3 = new JButton("채팅");
		b4 = new JButton("뉴스");
		b5 = new JButton("커뮤니티");
		
		JPanel p = new JPanel(); // 일자배치
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1, 5, 5));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		
		// 윈도우에 배치
		add("North", p); // North, South, East, West, Center
		
		// JFrame => BorderLayout
		// JPanel => FlowLayout
		
		setSize(1024, 768);
		
		// 윈도우를 보여준다
		setVisible(true);
		
		// X => 클릭시 메모리 해제
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.McWinLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.MintLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.AcrylLookAndFeel");
			
//			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.smart.Smart.LunaLookAndFeel");
		} catch (Exception e) {
			
		}
		new MainClass_01();
	}

}
