package packman;

import java.awt.Graphics;
import java.util.ArrayList;

import GIS.GIS_element;
import Geom.Point3D;

public class packman {
	private double Radius,Speed, Alt ,Lat , Lon;
	public packman(double Lat,double Lon, double Alt ,double Speed , double Radius) {
		this.setLat(Lat);
		this.setLon(Lon);
		this.setAlt(Alt);
		this.setSpeed(Speed);
		this.setRadius(Radius);
	}
	public packman () {
		Lat=0;
		Lon=0;
		Alt=0;
		Speed=0;
		Radius=0;
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
}
