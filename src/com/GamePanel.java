package com;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, CollisonListener {

	private Game game;
	private Thread runner;
	private static GamePanel instance = null;
	private Image img;

	private GamePanel() {
		instance = this;
		game = Game.getGame();
		setFocusable(true);
		setLayout(null);

		game.getPlayer1().getProgressBar().setSize(20, 100);
		game.getPlayer1().getProgressBar().setLocation(50, 50);
		JLabel name1 = game.getPlayer1().getNameLabel();
		name1.setLocation(80, 50);
		name1.setSize(100, 100);
		add(game.getPlayer1().getProgressBar());
		add(name1);

		game.getPlayer2().getProgressBar().setSize(20, 100);
		game.getPlayer2().getProgressBar().setLocation(1300, 50);
		JLabel name2 = game.getPlayer2().getNameLabel();
		name2.setLocation(1270, 50);
		name2.setSize(100, 100);
		add(game.getPlayer2().getProgressBar());
		add(name2);

		img = getToolkit().createImage(
				"C:\\Users\\dell-iman\\workspace\\JTank\\pics\\back.gif");

	}
	
	public static GamePanel getGamePanel() {
		if (instance == null)
			new GamePanel();
		return instance;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		game.getPlayer1().getNameLabel().paint(g);
		game.getPlayer2().getNameLabel().paint(g);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		game.getPlayer1().getProgressBar().repaint();
		game.getPlayer2().getProgressBar().repaint();
		game.getPlayer1().getNameLabel().repaint();
		game.getPlayer2().getNameLabel().repaint();
		
		game.getTank1().paint(g);
		game.getTank2().paint(g);
		if (game.getTank1().getMissle() != null)
			game.getTank1().getMissle().paint(g);
		if (game.getTank2().getMissle() != null)
			game.getTank2().getMissle().paint(g);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	// public void renderImage(Graphics g) {
	// if (!runned) {
	// new Thread(new Runnable() {
	//
	// @Override
	// public void run() {
	// while (true) {
	// g.drawImage(GamePanel.getGamePanel().img, 0, 0,
	// GamePanel.getGamePanel());
	// try {
	// Thread.sleep(10);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// });
	// runned = true;
	// }
	// }

	@Override
	protected void processKeyEvent(KeyEvent e) {
		if (game.getTurn() % 2 == 0) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.getTank1().move(-1);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.getTank1().move(1);
			}
		} else {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.getTank2().move(-1);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.getTank2().move(1);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER
				&& e.getID() == KeyEvent.KEY_PRESSED) {
			if (runner == null) {
				runner = new Thread(this);
				runner.start();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (game.getTurn() % 2 == 0)
				game.getTank1().increaseDegree();
			else
				game.getTank2().increaseDegree();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (game.getTurn() % 2 == 0)
				game.getTank1().decreseDegree();
			else
				game.getTank2().decreseDegree();
		}
		repaint();
		super.processKeyEvent(e);
	}

	@Override
	public void run() {
		int resume = 3;
		while (resume == 3) {
			if (game.getTurn() % 2 == 0)
				resume = game.getTank1().shoot();
			else
				resume = game.getTank2().shoot();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			repaint();
			if (resume != 3) {
				if (game.getTurn() % 2 == 0) {
					if (resume == 0) {
						game.getTank1()
								.getMissle()
								.fireCollision(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					} else if (resume == 2) {
						game.getTank1()
								.getMissle()
								.fireCollision(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					} else {
						game.getTank1()
								.getMissle()
								.fireGoneOutOfPage(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					}
				} else {
					if (resume == 0) {
						game.getTank2()
								.getMissle()
								.fireCollision(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					} else if (resume == 2) {
						game.getTank2()
								.getMissle()
								.fireCollision(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					} else {
						game.getTank2()
								.getMissle()
								.fireGoneOutOfPage(
										new CollisionEvent(GamePanel
												.getGamePanel(), 0));
					}
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (game.getTurn() % 2 == 0)
			game.getTank1().setMissle(null);
		else
			game.getTank2().setMissle(null);
		game.makeTurn();
		runner = null;
	}

	@Override
	public void goneOutOfPage(CollisionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collided(CollisionEvent event) {
		if (event.getState() == 0) {
			game.getPlayer1().setLife(game.getPlayer1().getLife() - 10);
			game.getPlayer1().setBar(game.getPlayer1().getLife() - 10);
		} else {

			game.getPlayer2().setLife(game.getPlayer1().getLife() - 10);
			game.getPlayer2().setBar(game.getPlayer1().getLife() - 10);
		}
		repaint();
	}

}
