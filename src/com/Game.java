package com;


public class Game {

	private Tank tank1;
	private Tank tank2;
	private MainFrame mainFrame;
	private int turn = 1;
	private static Game instance = null;
	private Player player1;
	private Player player2;

	private Game() {
		instance = this;
		tank1 = new Tank();
		tank2 = new Tank();
		player1 = new Player("Iman");
		player2 = new Player("Amin");
		mainFrame = new MainFrame();
		mainFrame.init();
		mainFrame.repaint();
	}

	public static Game getGame() {
		if (instance == null) {
			new Game();
		}
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
