package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;

public class ControlPanel extends JPanel {
	NewsPanel np = new NewsPanel();
	ChatPanel cp = new ChatPanel();
	FindPanel fp = new FindPanel();
	RecommandPanel rp = new RecommandPanel();
	HomePanel hp;
	DetailPanel dp;
	CardLayout card = new CardLayout();

	public ControlPanel() {
		dp = new DetailPanel(this);
		hp = new HomePanel(this);
		setLayout(card);
		add("home", hp);
		add("news", np);
		add("chat", cp);
		add("find", fp);
		add("recomm", rp);
		add("detail", dp);
		
	}
}
