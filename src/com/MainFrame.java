package com;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private GamePanel gamePanel;
	private JPanel shootingPanel;

	public MainFrame() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);

	}
	public void init(){
		gamePanel = GamePanel.getGamePanel();
		add(gamePanel);
		gamePanel.requestFocusInWindow();
	}
}
