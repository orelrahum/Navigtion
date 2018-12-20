package packman;

import java.awt.Graphics;
import java.util.ArrayList;

import GIS.GIS_element;
import Geom.Point3D;

public class packman {
	private double Radius,Speed, Alt ,Lat , Lon ,Weight;
	private int ID;
	public Path pathPack;
	private Point3D Point=new Point3D();
	public packman(double Lat,double Lon, double Alt ,double Speed , double Radius, int ID) {
		this.setLat(Lat);
		this.setLon(Lon);
		this.setAlt(Alt);
		this.setSpeed(Speed);
		this.setRadius(Radius);
		Point3D temp=new Point3D (Lat,Lon,Alt);
		pathPack=new Path(temp);
		Weight=0;
		this.ID=ID;
	}
	public packman(Point3D Point,double Speed , double Radius,int ID) {
		this.setLat(Point.x());
		this.setLon(Point.y());
		this.setAlt(Point.z());
		this.setSpeed(Speed);
		this.setRadius(Radius);
		pathPack=new Path(Point);
		this.ID=ID;

	}
	public packman () {
		Lat=0;
		Lon=0;
		Alt=0;
		Speed=0;
		Radius=0;
	}
	public int GetID() {
		return ID;
	}
	public double getRadius() {
		return Radius;
	}

	private void setRadius(double radius) {
		Radius = radius;
	}

	public double getSpeed() {
		return Speed;
	}

	private void setSpeed(double speed) {
		Speed = speed;
	}

	public double getAlt() {
		return Alt;
	}

	private void setAlt(double alt) {
		Alt = alt;
	}

	public double getLat() {
		return Lat;
	}

	private void setLat(double lat) {
		Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	private void setLon(double lon) {
		Lon = lon;
	}
	public Point3D getPoint() {
		Point3D point=new Point3D (Lat,Lon,Alt);
		return point;
	}
	
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public void setPoint(Point3D point) {
		this.Point	= point;
		this.setLat(Point.x());
		this.setLon(Point.y());
		this.setAlt(Point.z());
	}
	public Path getPath() {
		return pathPack;
	}
}
