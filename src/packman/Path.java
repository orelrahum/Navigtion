package packman;
import Geom.Point3D;
import java.util.*;

import GIS.GIS_project;
public class Path{
	ArrayList<Date> time=new ArrayList<Date>();
	ArrayList<Point3D> path=new ArrayList<Point3D>();
	Path(){
	}
	Path(Point3D point){
		this.path.add(point);
		time.add(new Date());	}
	public static double dist(Point3D point1,Point3D point2) {
		return point1.distance3dCoords(point2);
	}
	public static Point3D vector(Point3D point1,Point3D point2,double  speed) {
		Point3D vector = new Point3D(point2);
		vector.vector(point1);
		Point3D vec=new Point3D((vector.x()/100)*speed,(vector.y()/100)*speed,vector.z());
		return vec;
	}
	public void add(Point3D p) {
		path.add(p);
		time.add(new Date());

	}

	public void addAll (ArrayList p) {
		path.addAll(p);
		time.add(new Date());
	}
}


