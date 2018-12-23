package packman;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.RepaintManager;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Geom.Circle;
import Geom.Point3D;

public class ShortestPathAlgo {
	Thread time = new Thread();
	Path path=new Path() ;
	public ShortestPathAlgo(Game game) {
		double dis=Double.MAX_VALUE;
		int pack=0;
		Circle packC=null;
		Path path=new Path() ;
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
				path=eat(game,i,pack,packC,path);
				game.packmans.get(pack).pathPack.addAll(path.path);
				double Weight =game.Fruits.get(i).getWeight()+game.packmans.get(pack).getWeight();
				game.packmans.get(i).setWeight(Weight);
				game.Fruits.remove(i);
				i=0;
				pack=0;
				dis=Double.MAX_VALUE;
			}
		}
	}
	public Path eat(Game game,int f,int p,Circle c,Path path) {
		packman pack = game.packmans.get(p);
		Fruit fruit = game.Fruits.get(f);
		Point3D normal=Path.vector(pack.getPoint(),fruit.getPoint());
		double dis=c.distance3D(fruit.getPoint());
		Point3D packpoint=game.packmans.get(p).getPoint();
		while(dis!=0) {
			packpoint.add(normal);			
			Circle Ctemp=new Circle (game.packmans.get(p).getPoint(),pack.getRadius());
			dis=Ctemp.distance3D(fruit.getPoint());
			path.add(game.packmans.get(p).getPoint());
			game.packmans.get(p).setPoint(packpoint);
		}
		return path;
	}
	public Path getPath() {
		return path;
	}

}
