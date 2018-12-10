package map;

import java.awt.Graphics;
import java.util.ArrayList;

import GIS.GIS_element;

public class packman {
	private double Radius,Speed, Alt ,Lat , Lon;

	public packman(double Lat,double Lon, double Alt ,double Speed , double Radius) {
		this.setRadius(Radius);
		this.setSpeed(Speed);
		this.setAlt(Alt);
		this.setLat(Lat);
		this.setLon(Lon);	
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

	public double getAlt() {
		return Alt;
	}

	public void setAlt(double alt) {
		Alt = alt;
	}

	public double getLat() {
		return Lat;
	}

	public void setLat(double lat) {
		Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	public void setLon(double lon) {
		Lon = lon;
	}
}
