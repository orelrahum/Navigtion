package packman;

import java.awt.Graphics;
import java.util.ArrayList;

import Geom.Point3D;

public class Fruit {

	private double Weight, Alt, Lat, Lon;
	private int ID;
	public Fruit( double Lat,double Lon,double Alt,double Weight,int ID ) {
		this.setLat(Lat);
		this.setLon(Lon);
		this.setAlt(Alt);
		this.setWeight(Weight);
		this.ID=ID;
	}
	public Fruit( Point3D Point,double Lon,double Alt,double Weight,int ID) {
		this.setLat(Point.x());
		this.setLon(Point.y());
		this.setAlt(Point.z());
		this.setWeight(Weight);
		this.ID=ID;

	}
	public Fruit() {
		Lat=0;
		Lon=0;
		Alt=0;
		Weight=0;
	}

 

	public double getAlt() {
		return Alt;
	}
	private void setAlt(double Alt) {
		this.Alt = Alt;
	}
	public double getLat() {
		return Lat;
	}
	private void setLat(double Lat) {
		this.Lat = Lat;
	}
	public double getLon() {
		return Lon;
	}
	private void setLon(double Lon) {
		this.Lon = Lon;
	}

	public double getWeight() {
		return Weight;
	}

	private void setWeight(double weight) {
		Weight = weight;
	}
	public Point3D getPoint() {
		Point3D point=new Point3D (Lat,Lon,Alt);
		return point;
	}
	public int GetID() {
		return ID;
	}


}


