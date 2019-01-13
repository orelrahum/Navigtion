package packman;

import Geom.Point3D;

public class Ghost {
	private double Radius,Speed,Weight;
	private int ID;
	private Point3D Point=new Point3D();
	public Ghost(Point3D Point,double Speed , double Radius,int ID) {
		this.setPoint(Point);
		this.setSpeed(Speed);
		this.setRadius(Radius);
		this.setID(ID);
	}
	public Point3D getPoint() {
		return Point;
	}
	public void setPoint(Point3D point) {
		Point = point;
	}
	public double getRadius() {
		return Radius;
	}
	public void setRadius(double radius) {
		Radius = radius;
	}
	public double getSpeed() {
		return Speed;
	}
	public void setSpeed(double speed) {
		Speed = speed;
	}

	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
