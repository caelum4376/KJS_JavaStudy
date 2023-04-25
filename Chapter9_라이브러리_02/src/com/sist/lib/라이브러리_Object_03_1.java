package com.sist.lib;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 라이브러리_Object_03_1 extends JFrame implements ItemListener {

	JComboBox box;
	JLabel la;
	
	public 라이브러리_Object_03_1() {
		box = new JComboBox();
		box.addItem("홍길동");
		box.addItem("심청이");
		box.addItem("박문수");
		
		la = new JLabel();
		
		// 배치
		add("North", box);
		add("Center", la);
		
		setSize(300, 300);
		setVisible(true);
		
		box.addItemListener(this);
	}
	
	public static void main(String[] args) {
		new 라이브러리_Object_03_1();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == box) {
//			String name = (String)box.getSelectedItem();	
//			String name = box.getSelectedItem().toString();
			String name = String.valueOf(box.getSelectedItem());
			
			la.setText(name);
		}
	}

}
