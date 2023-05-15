package com.sist.client;
import java.util.*;
import com.sist.manager.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 *   윈도우 / 네트워크
 *   ------ HTML
 *   IO처리(파일처리) => 데이터수집...
 *   URL처리
 *   화면UI => 윈도우, HTML/CSS
 *   이벤트 처리 => 자바(인터페이스), 자바스크립트
 *   ActionListener => onClick
 *   제네릭, 객체지향 ES6 ==> ES8(시네마)
 *   버튼, 메뉴, 텍스트필드 => ActionListener
 *   JLabel, 테이블 => MouseListener
 */
public class DetailPanel extends JPanel implements ActionListener {
	JLabel imgLa;
	JLabel la1, la2, la3, la4, la5, la6, la7;
	JButton b1, b2;
	JLabel titleLa, ageLa, gradeLa, reservationLa, regDateLa, contentLa, keyLa;
	ControlPanel cp;
	public DetailPanel(ControlPanel cp) {
		this.cp = cp;
		
		// 초기화, 시작과 동시에 구현
		// 웹 => 데이터베이스 설정, 자동로그인...
		imgLa = new JLabel();
		la1 = new JLabel("제목");
		la2 = new JLabel("등급");
		la3 = new JLabel("평점");
		la4 = new JLabel("예매율");
		la5 = new JLabel("개봉일");
		la6 = new JLabel("줄거리");
		
		b1 = new JButton("동영상");
		b2 = new JButton("목록");
		
		titleLa = new JLabel("");
		ageLa = new JLabel("");
		gradeLa = new JLabel("");
		reservationLa = new JLabel("");
		regDateLa = new JLabel("");
		contentLa = new JLabel("");
		keyLa = new JLabel("");
		
		// 배치
		setLayout(null);
		imgLa.setBounds(15, 20, 350, 530);
		
		la1.setBounds(375, 20, 60, 40);
		titleLa.setBounds(440, 20, 300, 40);
		
		la2.setBounds(375, 70, 60, 40);
		ageLa.setBounds(440, 70, 300, 40);
		
		la3.setBounds(375, 120, 60, 40);
		gradeLa.setBounds(440, 120, 300, 40);
		
		la4.setBounds(375, 170, 60, 40);
		reservationLa.setBounds(440, 170, 300, 40);
		
		la5.setBounds(375, 220, 60, 40);
		regDateLa.setBounds(440, 220, 300, 40);
		
		la6.setBounds(375, 270, 60, 40);
		contentLa.setBounds(440, 270, 300, 80);
		
		keyLa.setBounds(100, 625, 300, 40);
		keyLa.setVisible(false);
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(100, 670, 365, 40);
		
		// 윈도우 추가
		add(imgLa);
		add(keyLa);
		add(la1); add(titleLa);
		add(la2); add(ageLa);
		add(la3); add(gradeLa);
		add(la4); add(reservationLa);
		add(la5); add(regDateLa);
		add(la6); add(contentLa);
		add(p);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			try {
				Runtime.getRuntime().exec("/Applications/Firefox.app/Contents/MacOS/firefox "
						+ "http://youtube.com/embed/" + keyLa.getText());
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource()==b2) {
			cp.card.show(cp, "home");
		}
	}
}