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
				eat(PointP,PointF,packC,normal,game.packmans.get(pack).getRadius());
				Point3D F=game.Fruits.get(i).getPoint();
				packman temp= new packman (F,2,2);
				game.packmans.add(temp);
				game.packmans.remove(pack);
				game.Fruits.remove(i);
				i=0;
				pack=0;
				dis=Double.MAX_VALUE;
			}
		}

	}



	public void eat(Point3D p,Point3D f,Circle C,Point3D normal,double radius) {
		Path path=new Path (p);
		double counter=0;
		double dis=C.distance3D(f);
		System.out.println(dis);
		System.out.println(normal);
		while(dis!=0) {
			p.add(normal);
			Circle Ctemp=new Circle (p,radius);
			dis=Ctemp.distance3D(f);
			path.add(p);
			System.out.println(counter++);
		}
	}

}
