package packman;

import Geom.Point3D;

public class Player {
	private double Speed ,Result;
	private Point3D Point=new Point3D();

	public Player(Point3D Point,double Speed) {
		this.setPoint(Point);
		this.setSpeed(Speed);
		Result=0;
	}

	public double getSpeed() {
		return Speed;
	}

	private void setSpeed(double speed) {
		Speed = speed;
	}

	public double getResult() {
		return Result;
	}

	public Point3D getPoint() {
		return Point;
	}

	public void setPoint(Point3D point) {
		Point = point;
	}
}

