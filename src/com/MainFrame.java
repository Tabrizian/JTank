package com;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private GamePanel gamePanel;
	private JPanel shootingPanel;

	public MainFrame() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

	}
	public void init(){
		gamePanel = GamePanel.getGamePanel();
		add(gamePanel);
		gamePanel.requestFocusInWindow();
	}
}
