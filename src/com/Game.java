package com;

import java.awt.Color;

public class Game {

	private Tank tank1;
	private Tank tank2;
	private MainFrame mainFrame;
	private int turn = 1;
	private static Game instance = null;
	private Player player1;
	private Player player2;

	private Game(String player1, String player2,Color color1,Color color2) {
		instance = this;
		
		tank1 = new Tank(color1);
		tank2 = new Tank(color2);
		
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
		
		mainFrame = new MainFrame();
		mainFrame.init();
		mainFrame.repaint();
	}

	public static Game getGame(String player1, String player2,Color color1,Color color2) {
		if (instance == null) {
			new Game(player1, player2,color1,color2);
		}
		return instance;
	}
	public static Game getGame(){
		return instance;
	}

	public Tank getTank1() {
		return tank1;
	}

	public Tank getTank2() {
		return tank2;
	}

	public int getTurn() {
		return turn;
	}

	public void makeTurn() {
		turn++;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
}
