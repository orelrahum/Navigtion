package packman;

import Geom.Point3D;

public class map {
	
	public static Point3D PixelToCoords(int x, int y) {
		Point3D leftUp = new Point3D(32.105770,  35.202469);
		Point3D leftDown = new Point3D(32.101899, 35.202469);
		Point3D RightUp = new Point3D(32.105770 , 35.211588);
		Point3D RightDown = new Point3D(32.101899, 35.211588);
		int widthPixel=1400;
		int HeightPixel=640;
		double Heightcoords= leftUp.distance3D(leftDown);
		double widthcoords= RightUp.distance3D(leftUp);
		Point3D p2=new Point3D(32.105770+(((double)x/HeightPixel)*Heightcoords ), (35.202469+(((double)y/widthPixel)*widthcoords)));
		System.out.println(p2.toString());
		return p2;
	}
	public static Point3D CoordsToPixel(Point3D p) {
		Point3D leftUp = new Point3D(32.105770,  35.202469);
		Point3D leftDown = new Point3D(32.101899, 35.202469);
		Point3D RightUp = new Point3D(32.105770 , 35.211588);
		Point3D RightDown = new Point3D(32.101899, 35.211588);
		double x=p.x()-32.105770;
		double y=p.y()-35.202469;
		int widthPixel=640;
		int HeightPixel=1400;
		double Heightcoords= leftUp.distance3D(leftDown);
		double widthcoords= RightUp.distance3D(leftUp);
		Point3D p2=new Point3D((x/Heightcoords)*(double)HeightPixel , (y/widthcoords)*(double)widthPixel);
		return p2;
	}
}
