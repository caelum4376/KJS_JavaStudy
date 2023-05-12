package com.sist.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sist.common.ImageChange;
import com.sist.inter.HomeInterface;
import com.sist.manager.MovieSystem;
import com.sist.manager.MovieVO;
import com.sist.client.ControlPanel;

public class HomePanel extends JPanel implements HomeInterface, MouseListener {
	PosterCard[] pcs = new PosterCard[20];
	JPanel pan = new JPanel();
	JButton b1,b2;
	JLabel pageLa;
	ControlPanel cp;
	MovieSystem ms = new MovieSystem();
	public HomePanel(ControlPanel cp)
	{
		this.cp = cp;
//		setBackground(Color.blue);
		b1= new JButton("이전");
		b2= new JButton("다음");
		pageLa = new JLabel("0 page /0 page");
		setLayout(null);
		pan.setLayout(new GridLayout(4,5,5,5));
		
		pan.setBounds(10, 15, 730, 600);
		add(pan);
		JPanel p = new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		p.setBounds(10, 720, 730, 35);
		add(p);
	}
	public void cardPrint(List<MovieVO> list)
	{
		int i=0;
		for(MovieVO vo:list)
		{
			pcs[i]= new PosterCard(vo);
			pan.add(pcs[i]);
			i++;
		}
	}
	public void cardInit(List<MovieVO> list) 
	{
		/*for(int i=0;i<list.size();i++)
		{
			pcs[i].poLa.setIcon(null);
			pcs[i].tLa.setText("");
		}*/
		pan.removeAll();
		pan.validate();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i=0; i<pcs.length; i++) {
			   if (e.getSource()==pcs[i]) {
//				   JOptionPane.showMessageDialog(this, i+"번째 호출");
				   String title = pcs[i].tLa.getText();
//				   JOptionPane.showMessageDialog(this, title);
				   MovieVO vo = ms.movieDetailData(title);
				   try {
					   URL url = new URL("http:" + vo.getPoster());
					   Image img = ImageChange.getImage(new ImageIcon(url), 350, 530);
					   cp.dp.imgLa.setIcon(new ImageIcon(img));
					   cp.dp.titleLa.setText(vo.getTitle());
					   cp.dp.ageLa.setText(vo.getAge());
					   cp.dp.gradeLa.setText(vo.getGrade());
					   cp.dp.reservationLa.setText(vo.getReservation());
					   cp.dp.regDateLa.setText(vo.getRegDate());
					   cp.dp.contentLa.setText(vo.getContent());
					   cp.card.show(cp, "detail");
				   } catch (Exception ex) {
					   ex.printStackTrace();
				   }
			   }
		   }
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
	
}

