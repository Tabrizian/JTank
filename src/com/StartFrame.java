package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartFrame extends JFrame implements ActionListener {

	private Image img;
	private int xPos = 0;
	private int yPos = 0;
	private JButton exit;
	private JButton multiPlayer;

	public StartFrame() {

		try {
			img = ImageIO
					.read(new File(
							"C:\\Users\\dell-iman\\workspace\\JTank\\pics\\Tank-wallpapers.jpg"));
		} catch (IOException e) {
			System.out.println("An error occurred");
		}
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setLayout(null);
		
		exit = new JButton("Exit");
		exit.setBackground(Color.black);
		exit.setForeground(Color.WHITE);
		exit.setLocation(150, 600);
		exit.setSize(150, 40);
		exit.addActionListener(this);
		add(exit);
		
		multiPlayer = new JButton("Multi Player");
		multiPlayer.setBackground(Color.black);
		multiPlayer.setForeground(Color.WHITE);
		multiPlayer.setLocation(150, 550);
		multiPlayer.setSize(150, 40);
		multiPlayer.addActionListener(this);
		add(multiPlayer);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		runFrame();
	}

	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		arg0.setColor(Color.RED);
		arg0.setFont(new Font("TimesRoman", Font.BOLD, 80));
		arg0.drawString("JTank", xPos, 50 + yPos);
		if(xPos == 100){
			exit.repaint();
			multiPlayer.repaint();
		}
	}

	public void runFrame() {
		while (xPos != 100) {
			xPos += 2;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			yPos += 2;
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == exit)
		{
			System.exit(9);
		}
		else if(arg0.getSource() == multiPlayer){
			dispose();
			new MenuFrame();
		}
	}
}
