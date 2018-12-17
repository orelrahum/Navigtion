package packman;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.RepaintManager;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Geom.Circle;
import Geom.Point3D;

public class ShortestPathAlgo {

	public ShortestPathAlgo(Game game) {
		Iterator<Fruit> FruitsIT=game.Fruits.iterator();
		Iterator<packman> packmansIT=game.packmans.iterator();
		while (FruitsIT.hasNext()){
			packmansIT=game.packmans.iterator();
			Fruit f=FruitsIT.next();
			Point3D pointF=new Point3D(f.getLat(),f.getLon(),f.getAlt());
			packman p=packmansIT.next();
			Point3D pointP=new Point3D(p.getLat(),p.getLon(),p.getAlt());
			double dis=Path.dist(pointP, pointF)/p.getSpeed();
			double distemp=dis;
			packman minPac=p;
			while(packmansIT.hasNext()) {
				p=packmansIT.next();
				pointP=new Point3D(p.getLat(),p.getLon(),p.getAlt());
				distemp=Path.dist(pointP, pointF)/p.getSpeed();
				if (distemp<dis) {
					dis=distemp;
					minPac=p;	
				}
			}
			if (minPac!=null) {
			minPac.setLat(f.getLat());
			minPac.setLon(f.getLon());
			minPac.setAlt(f.getAlt());
			FruitsIT.remove();}
			}
//			if (minPac!=null) {
//			Point3D pointP=new Point3D(minPac.getLat(),minPac.getLon(),minPac.getAlt());
//			Point3D pointf=new Point3D(f.getLat(),f.getLon(),f.getAlt());
//			Point3D normal=vector(pointP,pointf);
//			
//			eat(pointP,pointf,normal,minPac.getRadius());}
//		}
		
	}
	public void eat(Point3D p,Point3D f,Point3D normal,double radius) {
//		Path path=new Path (p);
//		double dis=p.distance3dCoords(f);
//		Circle pack= new Circle (p,radius);
//		double dis2=pack.distance3D(f);
//		System.out.println(dis2);
//		System.out.println(normal);
//		while(dis2!=0) {
//			p.add(normal);
//			path.add(p);
//		}
	}

	private static Point3D vector(Point3D point1,Point3D point2) {
		Point3D vector = new Point3D(point1);
		vector.vector(point2);
		double x=vector.get_x()*vector.get_x();
		double y=vector.get_y()*vector.get_y();
		double z=vector.get_z()*vector.get_z();
		double det=Math.sqrt(x+y+z);
		Point3D normal=new Point3D(vector.get_x()/det, vector.get_y()/det, vector.get_z()/det);
		return normal;
	}
}
