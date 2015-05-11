package com;

import java.awt.Color;

import javax.swing.JProgressBar;

public class Player {
	
	private String name;
	private Tank tank;
	private int life = 100;
	private JProgressBar bar;
	public Player(String name){
		this.name = name;
		bar = new JProgressBar();
		bar.setMaximum(100);
		bar.setValue(100);
		bar.setForeground(Color.green);
		bar.setOrientation(JProgressBar.VERTICAL);
	}

	public String getName() {
		return name;
	}
	
	public void setBar(int value){
		bar.setValue(value);
	}
	
	public JProgressBar getProgressBar(){
		return bar;
	}
	
	public int getLife(){
			return life;
	}
	
	public void setLife(int life){
		this.life = life;
		bar.setValue(life);
	}
	
	

	
}