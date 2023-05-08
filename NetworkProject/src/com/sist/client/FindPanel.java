package com.sist.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;
import com.sist.manager.*;
import com.sist.commons.ImageChange;
import com.sist.manager.*;

public class FindPanel extends JPanel implements ActionListener {
	JTextField tf;
	JButton b1;
	JButton b2, b3, b4;
	JTable table;
	DefaultTableModel model;
	MovieSystem ms = new MovieSystem();

	public FindPanel() {
		// 초기화
		tf = new JTextField();
		b1 = new JButton("검색");

		b2 = new JButton("예매순위");
		b3 = new JButton("박스오피스");
		b4 = new JButton("OTT");

		String[] col = { "", "영화제목", "평점", "예매율" };
		Object[][] row = new Object[0][4];
		model = new DefaultTableModel(row, col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				// 이미지 출력
				return getValueAt(0, columnIndex).getClass();
			}
		};
		table = new JTable(model);

		// 출력위치 길이 설정
		table.setRowHeight(35);

		// 타이틀바 고정
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane js = new JScrollPane(table);

		// 배치 750 730
		setLayout(null);
		tf.setBounds(10, 15, 300, 30);
		b1.setBounds(315, 15, 100, 30);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 6, 5, 5));
		p.add(tf);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.setBounds(10, 55, 700, 35);

		js.setBounds(10, 100, 700, 550);

		add(tf);
		add(b1);
		add(p);
		add(js);
		try {
			List<MovieVO> list = ms.movieCategoryData(1);

			for (MovieVO vo : list) {
//				System.out.println(vo.getPorster());

				URL url = new URL("http:" + vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				if (vo.getCno()==0) {
					Object[] data = { new ImageIcon(img), vo.getTitle(), vo.getAvg(), vo.getReservationRate() };
					model.addRow(data);
				} else {
					Object[] data = { new ImageIcon(img), vo.getTitle(), "", ""};
					model.addRow(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		tf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b2) {
			findPrint(1);			
		} else if (e.getSource() == b3) {
			findPrint(2);
		} else if (e.getSource() == b4) {
			findPrint(3);
		} else if (e.getSource() == b1 || e.getSource() == tf) {
			String title = tf.getText();
			
			// 입력이 안됐을떄
			if (title.length() < 1) {
				JOptionPane.showMessageDialog(this, "검색어 입력");
				return;
			}
			
			findPrint2(title);
		}
	}

	public void findPrint(int cno) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		try {
			List<MovieVO> list = ms.movieCategoryData(cno);

			for (MovieVO vo : list) {

				URL url = new URL("http:" + vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				Object[] data = { new ImageIcon(img), vo.getTitle(), vo.getAvg(), vo.getReservationRate() };
				model.addRow(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void findPrint2(String title) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		try {
			List<MovieVO> list = ms.movieFindData(title);

			for (MovieVO vo : list) {

				URL url = new URL("http:" + vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				Object[] data = { new ImageIcon(img), vo.getTitle(), vo.getAvg(), vo.getReservationRate() };
				model.addRow(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}