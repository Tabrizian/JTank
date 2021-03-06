package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.Random;

public class Tank {

	private Position pos;
	private boolean player1 = true;
	private static int population = 0;
	private Missle missle = null;
	private int theta = 0;
	private Color color;

	public Tank(Color color) {
		super();
		if (population == 0) {
			pos = new Position(
					new Random(System.currentTimeMillis()+80).nextInt(1800) + 50,
					600);
		} else {
			pos = new Position(
					new Random(System.currentTimeMillis()).nextInt(1800) + 50,
					600);
			player1 = false;
		}
		this.color = color;

		population++;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect((int) pos.getX(), (int) pos.getY(), 100, 50);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (player1)
			g2d.rotate(Math.toRadians(theta), pos.getX() + 100, pos.getY());
		else
			g2d.rotate(Math.toRadians(theta), pos.getX(), pos.getY());
		if (player1)
			g2d.fillRect((int) pos.getX() + 100, (int) pos.getY() - 50, 10, 50);
		else
			g2d.fillRect((int) pos.getX() - 10, (int) pos.getY() - 50, 10, 50);
		if (player1)
			g2d.rotate(Math.toRadians(-theta), pos.getX() + 100, pos.getY());
		else
			g2d.rotate(Math.toRadians(-theta), pos.getX(), pos.getY());

	}

	public void move(int x) {
		pos.setX(pos.getX() + 5 * x);
	}

	public Position getPos() {
		return pos;
	}

	public int shoot(Image img) {
		if (missle == null) {
			missle = new Missle(getEndOfTube(), 200,img);
			missle.addListener(GamePanel.getGamePanel());
		}
		return missle.fire(this);
	}

	public Missle getMissle() {
		return missle;
	}

	public void increaseDegree() {
		theta++;
	}

	public void decreseDegree() {
		theta--;
	}

	public int getDegree() {
		return theta;
	}

	public Position getEndOfTube() {
		if (player1) {
			return new Position(pos.getX() + 100 + 50
					* Math.cos(Math.toRadians(90 - theta)), pos.getY() - 50
					* Math.sin(Math.toRadians(90 - theta)));
		} else
			return new Position(pos.getX() + 50
					* Math.cos(Math.toRadians(90 - theta)), pos.getY() - 50
					* Math.sin(Math.toRadians(90 - theta)));

	}

	public void setMissle(Missle missle) {
		this.missle = missle;
	}
}
