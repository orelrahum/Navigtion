package packman;

import java.util.ArrayList;

import Geom.Point3D;

public class Path {
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
		Point3D vec=new Point3D(vector.x()/100,vector.y()/100,vector.z());
		return vec;
	}
	public void add(Point3D p) {
		path.add(p);
	}
	public void addAll (ArrayList p) {
		path.addAll(p);
	}
}


