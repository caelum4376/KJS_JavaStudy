package com.sist.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.table.*;

import com.sist.common.ImageChange;
import com.sist.inter.FindInterface;

import java.util.*;
import java.util.List;
import com.sist.manager.*;
public class FindPanel extends JPanel implements ActionListener, FindInterface
{
	JTextField tf;
	JButton b1;
	JButton b2,b3,b4;
	JTable table;
	DefaultTableModel model;
	MovieSystem ms=new MovieSystem();
	public FindPanel() {
		// 초기화
		tf=new JTextField();
		b1=new JButton("검색");
				
		b2=new JButton("예매순위");
		b3=new JButton("박스오피스");
		b4=new JButton("OTT");
		
		
		String[] col= {"","영화명","평점","예매율"};
		Object[][] row=new Object[0][4];
		model=new DefaultTableModel(row, col) {
			
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex)
			{
				return getValueAt(0, columnIndex).getClass();
			}
			
		};
		
		table=new JTable(model);
		table.setRowHeight(50); 
		table.getTableHeader().setReorderingAllowed(false);			// 타이틀바 고정
		JScrollPane js=new JScrollPane(table);
		
		
		setLayout(null);
		tf.setBounds(10, 15, 600, 30);
		b1.setBounds(615, 15, 100, 30);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(1, 6, 5, 5));
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.setBounds(10, 55, 700, 35);
		
		js.setBounds(10, 100,700,600);
		add(tf);
		add(b1);
		add(p);
		add(js);
		//https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F8876ecefc861afc397a9943ab781bdf0316c4983
		List<MovieVO> list=ms.movieCategoryData(1);			
		try
		{
			for(MovieVO vo:list)
			{
				URL url=new URL("https:"+vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 30, 30);
				if(vo.getCno()==1)
				{
				Object[] data= {new ImageIcon(img), vo.getTitle(),vo.getGrade(),vo.getRegDate()};
				model.addRow(data);
				}
				else
				{
					Object[] data= {new ImageIcon(img), vo.getTitle(),"",""};
					model.addRow(data);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		tf.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			findPrint(1);
		}
		else if(e.getSource()==b3)
		{
			findPrint(2);
		}
		else if(e.getSource()==b4)
		{
			findPrint(3);
		}
		else if(e.getSource()==b1 || e.getSource()==tf)
		{
			String title=tf.getText();
			if(title.length()<1)	
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력");
				tf.requestFocus();
				return;
			}
			findPrint2(title);
		}
		
		
		
	}
	
	public void findPrint(int cno)
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		
		try
		{
			List<MovieVO> list=ms.movieCategoryData(cno);
			for(MovieVO vo:list)
			{
				URL url=new URL("https:"+vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 30, 30);
				if(vo.getCno()==1)
				{
				Object[] data= {new ImageIcon(img), vo.getTitle(),vo.getGrade(),vo.getRegDate()};
				model.addRow(data);
				}
				else
				{
					Object[] data= {new ImageIcon(img), vo.getTitle(),"",""};
					model.addRow(data);
				}
			}
		} catch (Exception e)
		{
		}
		
	}
	
	public void findPrint2(String title)
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		
		try
		{
			List<MovieVO> list=ms.movieFindData(title);
			for(MovieVO vo:list)
			{
				URL url=new URL("https:"+vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 30, 30);
				if(vo.getCno()==1)
				{
				Object[] data= {new ImageIcon(img), vo.getTitle(),vo.getGrade(),vo.getRegDate()};
				model.addRow(data);
				}
				else
				{
					Object[] data= {new ImageIcon(img), vo.getTitle(),"",""};
					model.addRow(data);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
