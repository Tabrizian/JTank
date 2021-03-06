package com;

public class Position {

	private double x;
	private double y;

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Position(Position pos) {
		this.x = pos.x;
		this.y = pos.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Position good = new Position(this);
		return good;
	}

}
