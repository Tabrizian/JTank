package com;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Missle {
	private Position pos;
	private double speed;
	private double t = 0;
	private Position firstPos;
	private ArrayList<CollisonListener> listeners;
	private Image img = null;
	public Missle(Position pos, double speed,Image img) {
		this.pos = new Position(pos.getX(), pos.getY());
		firstPos = new Position(pos.getX(), pos.getY());
		this.speed = speed;
		listeners = new ArrayList<>();
		this.img = img;
	}

	public int fire(Tank tank) {
		pos.setY(+30 * t * t - speed
				* Math.cos(Math.toRadians(tank.getDegree())) * t
				+ firstPos.getY());
		pos.setX(2 * speed * t * Math.sin(Math.toRadians(tank.getDegree()))
				+ firstPos.getX());

		t += 0.01;
		return collided();

	}

	public void paint(Graphics g) {
		g.fillArc((int) pos.getX(), (int) pos.getY(), 10, 10, 0, 360);
		
		
		
		Position good1 = new Position((int) (Game.getGame().getTank1().getPos()
				.getX()) + 100 / 2, (int) (Game.getGame().getTank1().getPos()
				.getY()) + 50 / 2);
		Position good2 = new Position((int) (Game.getGame().getTank2().getPos()
				.getX()) + 100 / 2, (int) (Game.getGame().getTank2().getPos()
				.getY()) + 50 / 2);
		if (collided() != 3 && collided() != 1) {
			if (collided() == 0) {
				g.drawImage(img, (int) good1.getX(), (int) good1.getY(),
						GamePanel.getGamePanel());
				GamePanel.getGamePanel().repaint();

			} else {

				g.drawImage(img, (int) good2.getX(), (int) good2.getY(),
						GamePanel.getGamePanel());
				GamePanel.getGamePanel().repaint();
			}
		}
	}

	public double getSpeed() {
		return speed;
	}

	public int collided() {
		// Tank 1 x aligned;
		boolean condition1 = Game.getGame().getTank1().getPos().getX() <= pos
				.getX()
				&& pos.getX() <= Game.getGame().getTank1().getPos().getX() + 100;
		// Tank 1 y aligned;
		boolean condition2 = Game.getGame().getTank1().getPos().getY() <= pos
				.getY()
				&& pos.getY() <= Game.getGame().getTank1().getPos().getY() + 50;
		// General conditions
		boolean condition3 = pos.getX() < 0
				|| pos.getY() > GamePanel.getGamePanel().getHeight()
				|| pos.getX() > GamePanel.getGamePanel().getWidth();
		// Tank 2 x aligned;
		boolean condition4 = Game.getGame().getTank2().getPos().getX() <= pos
				.getX()
				&& pos.getX() <= Game.getGame().getTank2().getPos().getX() + 100;
		// Tank 2 y aligned;
		boolean condition5 = Game.getGame().getTank2().getPos().getY() <= pos
				.getY()
				&& pos.getY() <= Game.getGame().getTank2().getPos().getY() + 50;
		if (condition1 && condition2) {
			return 0;
		}
		if (condition3) {
			fireGoneOutOfPage(new CollisionEvent(GamePanel.getGamePanel(), 1));
			return 1;
		}
		if (condition4 && condition5) {
			return 2;
		}
		return 3;

	}

	public void addListener(CollisonListener listener) {
		listeners.add(listener);
	}

	public void fireCollision(CollisionEvent event) {
		for (CollisonListener collisonListener : listeners) {
			collisonListener.collided(event);
		}
	}

	public void fireGoneOutOfPage(CollisionEvent event) {
		for (CollisonListener collisonListener : listeners) {
			collisonListener.goneOutOfPage(event);
		}
	}

}
