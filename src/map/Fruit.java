package map;

import java.awt.Graphics;
import java.util.ArrayList;

public class Fruit {

	
	public Fruit(double value, double Lat,double Lon,double Alt ) {
		this.setValue(value);
		this.Alt=Alt;
		this.setLat(Lat);
		this.setLon(Lon);	
	}
	
	private double value, Alt, Lat, Lon;
	int id=0;
	Graphics Pack; 

	public double getAlt() {
		return Alt;
	}
	public void setAlt(double Alt) {
		this.Alt = Alt;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getLat() {
		return Lat;
	}
	public void setLat(double Lat) {
		this.Lat = Lat;
	}
	public double getLon() {
		return Lon;
	}
	public void setLon(double Lon) {
		this.Lon = Lon;
	}

}


