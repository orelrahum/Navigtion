package packman;

import java.awt.Graphics;
import java.util.ArrayList;

public class Fruit {

	
	public Fruit( double Lat,double Lon,double Alt,double Weight ) {
		this.setWeight(Weight);
		this.Alt=Alt;
		this.setLat(Lat);
		this.setLon(Lon);	
	}
	
	public Fruit() {
		Weight=0;
		Alt=0;
		Lat=0;
		Lon=0;
	}

	private double Weight, Alt, Lat, Lon;
	int id=0;
	Graphics Pack; 

	public double getAlt() {
		return Alt;
	}
	public void setAlt(double Alt) {
		this.Alt = Alt;
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

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

}


