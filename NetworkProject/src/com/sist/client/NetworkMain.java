package com.sist.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.*;

import com.sist.common.Function;
import com.sist.manager.MovieVO;
import com.sist.client.RecvMessage;
import com.sist.client.SendMessage;
import com.sist.common.ImageChange;
import com.sist.manager.*;

public class NetworkMain extends JFrame implements ActionListener,Runnable, MouseListener { //ActionListener 버튼 클릭
	MenuPanel mp;
	ControlPanel cp;
	SidePanel sp;
	JButton b1,b2,b3,b4; //홈, 영화검색, 영화 뉴스, 채팅
	JLabel logo;
	Login login = new Login(); // 로그인 클래스 호출
	MovieSystem ms = new MovieSystem();
	Socket s;
	BufferedReader in;
	OutputStream out;

	int curpage=1;
	int totalpage=0;
	
    // ID저장
    String myId;
    
    // 테이블 선택 인덱스번호
    int selectRow = -1;

    // 쪽지 보내기
    SendMessage sm = new SendMessage();
    RecvMessage rm = new RecvMessage();
    
	public NetworkMain() // 생성자 오버라이딩
	{
		mp = new MenuPanel();
		cp = new ControlPanel();
		sp = new SidePanel(); //클래스 호출
		
		setLayout(null); // 사용자 정의
		logo =new JLabel();
		Image img = ImageChange.getImage(new ImageIcon("/Users/caelum/Documents/java_datas/logo.png"), 240, 200);
		logo.setIcon(new ImageIcon(img));
		
		logo.setBounds(930, 15, 240, 200 );
		mp.setBounds(10, 15, 900, 50);
		cp.setBounds(10, 80, 900, 650);
		sp.setBounds(930, 230, 240,500);
		
		add(mp);
		add(cp);
		add(sp);
		add(logo);
		
		b1 = new JButton("홈");
		b2 = new JButton("영화 검색");
		b3 = new JButton("뉴스");
		b4 = new JButton("채팅");
		
		mp.setLayout(new GridLayout(1, 5, 0, 10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);
		
		setSize(1200,800); //윈도우 크기 설정
//		setVisible(true); // 윈도우를 보여준다 => 로그인이 되면 보여준다.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x 클릭시 메모리 해제 => 종료
		
		// 홈, 검색, 영화 상세 보기, 영화 뉴스, 채팅
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		// 로그인
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		// 채팅
		cp.cp.tf.addActionListener(this);
		
		List<MovieVO> list = ms.movieListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		
		totalpage = ms.movieTotalPage();
		cp.hp.b1.addActionListener(this); // 이전
		cp.hp.b2.addActionListener(this); // 다음
		cp.hp.pageLa.setText(curpage+" page/"+totalpage+" pages");
		
    	cp.cp.b1.addActionListener(this); // 쪽지보내기
    	cp.cp.b2.addActionListener(this); // 정보보기
    	cp.cp.table.addMouseListener(this);
    	
    	// 쪽지보내기
    	sm.b1.addActionListener(this);
    	sm.b2.addActionListener(this);
    	rm.b1.addActionListener(this);
    	rm.b2.addActionListener(this);
		
		
	}
	public void movieDisplay() {
		List<MovieVO> list=ms.movieListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		totalpage=ms.movieTotalPage();
		cp.hp.pageLa.setText(curpage+" page /"+totalpage+"pages");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cp.cp.table) {
			
				selectRow = cp.cp.table.getSelectedRow();
				String id = cp.cp.table.getValueAt(selectRow, 0).toString();
				if (id.equals(myId)) {
					cp.cp.b1.setEnabled(false);
					cp.cp.b2.setEnabled(false);
				} else {
					cp.cp.b1.setEnabled(true);
					cp.cp.b2.setEnabled(true);
				}
			}
//		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	public static void main(String[] args) {
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception ex) {ex.printStackTrace();}
		
		new NetworkMain();

	}

	// 버튼 클릭 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			curpage=1;
			cp.card.show(cp, "home");
		}
		else if(e.getSource()==b2)
		{
			cp.card.show(cp, "find");
		}
		else if(e.getSource()==b3)
		{
			cp.card.show(cp, "news");
		}
		else if(e.getSource()==b4)
		{
			cp.card.show(cp, "chat");
		}
		else if(e.getSource()==login.b1) // 로그인 버튼을 누르면
		{
//			login.setVisible(false); // 로그인 창은 사라지고
//			setVisible(true); // 메인 윈도우창을 보여준다.
			String id = login.tf1.getText();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력하시오");
				login.tf1.requestFocus();
				return;
			}
			String name = login.tf2.getText();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름 입력하시오");
				login.tf2.requestFocus();
				return;
			}
			String sex="남자";
			if(login.rb1.isSelected())
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			
			// 서버로 전송
			try
			{
				s= new Socket("211.238.142.117",33333);
//				s=new Socket("localhost",33333);
				//읽는 위치 / 쓰는 위치
				in= new BufferedReader(new InputStreamReader(s.getInputStream()));
				// s는 서버 메모리 => 서버메모리로부터 값을 읽어 온다.
				out=s.getOutputStream();
				// 서버에서 읽어 갈 수 있게 메모리에 저장
				
				// 서버로 로그인 요청
				out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
				
			}catch(Exception ex) {ex.printStackTrace();}
			// 서버로부터 전송된 값을 받아 온다.
			new Thread(this).start(); // run() 호출
			
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0); // 프로그램 종료
		}
		else if(e.getSource()==cp.cp.tf)
		{
			cp.cp.initStyle();
			String msg = cp.cp.tf.getText();
			String color = cp.cp.box.getSelectedItem().toString();
			if(msg.length()<1) return;
			// 서버로 전송
			try 
			{
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());
			}catch (Exception ex) {ex.printStackTrace();}
			 cp.cp.tf.setText("");
		}
		else if(e.getSource()==cp.hp.b1)
		{
			if(curpage>1)
			{
				curpage--;
				movieDisplay();
			}
		}
		else if(e.getSource()==cp.hp.b2)
		{
			if(curpage<totalpage)
			{
				curpage++;
				movieDisplay();
			}
		} else if (e.getSource() == cp.cp.b2) {
			// 정보보기
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "정보볼 대상을 선택하세요");
				return;
			}
			// 선택된 경우
			String youId = cp.cp.table.getValueAt(selectRow, 0).toString();
			try {
				// 선택된 아이디의 정보를 보여달라 (서버에 요청)
				// out.write => 서버요청 => \n포함되야 한다
				// 처리 => 서버 => 결과값을 받아서 클라이언트에서 출력
				out.write((Function.INFO+"|"+youId+"\n").getBytes());
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		} else if (e.getSource() == cp.cp.b1) {
			// 쪽지보내기
			sm.ta.setText("");
			String youId = cp.cp.table.getValueAt(selectRow, 0).toString();
			
			sm.tf.setText(youId);
			sm.setVisible(true);
		} else if (e.getSource() == sm.b2) {
			sm.setVisible(false);
		} else if (e.getSource() == rm.b2) {
			rm.setVisible(false);
		} else if (e.getSource() == sm.b1) {
			String youId = sm.tf.getText();
			String msg = sm.ta.getText();
			if (msg.length() < 1) {
				sm.ta.requestFocus();
				return;
			}
			try {
				// youId를 찾아서 msg를 보내주는 기능을 수행
				out.write((Function.MSGSEND + "|" + youId + "|" + msg + "\n").getBytes());
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			// 창을감춘다
			sm.setVisible(false);
		} else if (e.getSource() == rm.b1) {
			sm.tf.setText(rm.tf.getText());
			sm.ta.setText("");
			sm.setVisible(true);
			rm.setVisible(false);
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				String msg= in.readLine();
				// 서버에서 보낸값
				StringTokenizer st = new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				// 100|id|name|sex
				switch(protocol) 
				{
					// LOGIn => 테이블에 정보를 출력한다.
					case Function.LOGIN:
					{
						String[] data = { st.nextToken(),
								st.nextToken(),
								st.nextToken()};
						cp.cp.model.addRow(data);
					}
					break;
					// C/S => 모든 명령이 서버로부터 받아서 처리
					// MYLOG => 로그인 종료하고 메인창을 보여준다.
					case Function.MYLOG:
					{
						setTitle(st.nextToken());
						myId = st.nextToken();
						login.setVisible(false);
						setVisible(true);
					}
					break;
					case Function.CHAT:
					{
						cp.cp.initStyle();
						cp.cp.append(st.nextToken(), st.nextToken());
						//            채팅문자열           색상
						
					}
					break;
					  case Function.INFO:
					  {
								// 전송기능
								String data = "아이디 : " + st.nextToken() + "\n"
										+ "이름 : " + st.nextToken() + "\n"
										+ "성별 : "	+ st.nextToken();
								JOptionPane.showMessageDialog(this, data);
								
					  }
					  break;
					  case Function.MSGSEND:
					  {
						  String id = st.nextToken();
						  String strMsg = st.nextToken();
						  rm.tf.setText(id);
						  rm.ta.setText(strMsg);
						  rm.setVisible(true);
					  }
					  break;
				}
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}

}
