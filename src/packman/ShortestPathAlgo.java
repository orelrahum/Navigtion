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
				//Point3D normal=Path.vector(PointP, PointF);
				//Path path=new Path() ;
				path=eat(game,i,pack,packC,path);
			//	path=eat(PointP,PointF,packC,normal,game.packmans.get(pack).getRadius(),3);
				game.packmans.get(pack).pathPack.addAll(path.path);
				//int meters=0;
//				for(int index=0;index<path.path.size();index++) {
//					game.packmans.get(pack).setPoint(path.path.get(index));
//					System.out.println(path.time.get(index).toString());
//				}
			//	game.packmans.get(pack).setPoint(path.get(path.size()-1));
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
	//	Path path=new Path() ;
		packman pack = game.packmans.get(p);
		Fruit fruit = game.Fruits.get(f);
		Point3D normal=Path.vector(pack.getPoint(),fruit.getPoint());
		double dis=c.distance3D(fruit.getPoint());
		//int meters=0;
		Point3D packpoint=game.packmans.get(p).getPoint();
		while(dis!=0) {
		//	meters++;
//			if( meters==(int)pack.getSpeed()) {
//				try {
//					time.sleep(1000);
//					meters=0;
//				} catch (InterruptedException e) {
//
//				}
//			}
			packpoint.add(normal);
			//p.add(normal);
			Circle Ctemp=new Circle (game.packmans.get(p).getPoint(),pack.getRadius());
			dis=Ctemp.distance3D(fruit.getPoint());
			path.add(game.packmans.get(p).getPoint());
			game.packmans.get(p).setPoint(packpoint);
	//		System.out.println(game.packmans.get(p).getPoint().toString());

		}
		return path;
	}
	public Path getPath() {
		return path;
	}

}
