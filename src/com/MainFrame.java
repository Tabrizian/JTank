package com;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private GamePanel gamePanel;
	private JPanel shootingPanel;
	
	
	public MainFrame(){
		gamePanel = new GamePanel();
		add(gamePanel);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false);
		
	}

}
