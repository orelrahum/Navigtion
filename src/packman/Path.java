package packman;

import java.util.ArrayList;

import Geom.Point3D;

public class Path {
	private double Score=0;
	ArrayList<Point3D> path=new ArrayList<Point3D>();
	Path(){
	}
	Path(Point3D point){
		this.path.add(point);
	}
	public static double dist(Point3D point1,Point3D point2) {
		return point1.distance3dCoords(point2);
	}
	public static Point3D vector(Point3D point1,Point3D point2) {
		Point3D vector = new Point3D(point2);
		vector.vector(point1);
		vector.set_x(vector.get_x()/100);
		vector.set_y(vector.get_y()/100);
		vector.set_z(vector.get_z()/100);
		double x=vector.get_x()*vector.get_x();
		double y=vector.get_y()*vector.get_y();
		double z=vector.get_z()*vector.get_z();
		double det=Math.sqrt(x+y+z);
		Point3D normal=new Point3D(vector.get_x()/det, vector.get_y()/det, vector.get_z()/det);
		return vector;
	}
	public void add(Point3D p) {
		path.add(p);
	}
}


