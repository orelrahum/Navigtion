package packman;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.RepaintManager;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Geom.Circle;
import Geom.Point3D;

public class ShortestPathAlgo {

	public ShortestPathAlgo(Game game) {
		double dis=Double.MAX_VALUE;
		int pack=0;
		Circle packC=null;
		while (!game.Fruits.isEmpty()) {
			for (int i=0;i<game.Fruits.size();i++){
				Point3D PointF=game.Fruits.get(i).getPoint();
				Point3D PointP=null;
				for (int j=0;j<game.packmans.size();j++) {
					PointP=game.packmans.get(j).getPoint();
					packC=new Circle (PointP,game.packmans.get(j).getRadius());
					double distemp=packC.distance3D(PointF)/game.packmans.get(i).getSpeed();
					if (distemp<dis) {
						dis=distemp;
						pack=j;
						j=0;
					}
				}
				Point3D normal=Path.vector(PointP, PointF);
				ArrayList<Point3D> path=new ArrayList<Point3D>() ;
				path=eat(PointP,PointF,packC,normal,game.packmans.get(pack).getRadius());
				game.packmans.get(pack).pathPack.addAll(path);
				game.packmans.get(pack).setPoint(path.get(path.size()-1));
				double Weight =game.Fruits.get(i).getWeight()+game.packmans.get(pack).getWeight();
				game.packmans.get(i).setWeight(Weight);
				game.Fruits.remove(i);
				i=0;
				pack=0;
				dis=Double.MAX_VALUE;
			}
		}

	}



	public ArrayList eat(Point3D p,Point3D f,Circle C,Point3D normal,double radius) {
		ArrayList<Point3D> path=new ArrayList<Point3D>() ;
		double dis=C.distance3D(f);
		while(dis!=0) {
			p.add(normal);
			Circle Ctemp=new Circle (p,radius);
			dis=Ctemp.distance3D(f);
			path.add(p);
		}
		return path;
	}

}
