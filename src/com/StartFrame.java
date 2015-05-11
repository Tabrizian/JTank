package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartFrame extends JFrame {

	private Image img;
	private int xPos = 0;
	private int yPos = 0;
	private JButton exit;
	private JButton singlePlayer;

	public StartFrame() {

		try {
			img = ImageIO
					.read(new File(
							"C:\\Users\\dell-iman\\workspace\\JTank\\pics\\Tank-wallpapers.jpg"));
		} catch (IOException e) {
			System.out.println("An error occurred");
		}
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		exit = new JButton("Exit");
		exit.setLocation(20, 800);
		exit.setSize(20, 20);
		add(exit);
		setVisible(true);
		setResizable(false);

		runFrame();
	}
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		exit.paint(g);
	}
	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		arg0.setColor(Color.RED);
		arg0.setFont(new Font("TimesRoman", Font.BOLD, 80));
		arg0.drawString("JTank", xPos, 50 + yPos);
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
}
