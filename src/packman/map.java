package packman;

import Geom.Point3D;

public class map {
	Point3D leftUp = new Point3D(32.105770,  35.202469);
	Point3D leftDown = new Point3D(32.101899, 35.202469);
	Point3D RightUp = new Point3D(32.105770 , 35.211588);
	Point3D RightDown = new Point3D(32.101899, 35.211588);
	double Heightcoords= 32.105770-32.101899;
	double widthcoords=35.211588-35.202469;
	static public int widthPixel=1400;
	static public int HeightPixel=640;
	
	public map () {

	}
	
	public Point3D PixelToCoords(int x, int y) {
		double lat=(((double)x/HeightPixel)*Heightcoords) +32.105770;
		double lon=(((double)y/widthPixel)*widthcoords)+35.202469;
		Point3D p2=new Point3D(lat,lon);
		System.out.println(p2.toString());
		return p2;
	}
	public Point3D CoordsToPixel(Point3D p) {
		
		double ix=p.x()-32.105770;
		double iy=p.y()-35.202469;
		p.PolarToCartes();
		int x= (int)(ix/Heightcoords*(double)HeightPixel);
		int y=(int)((iy/widthcoords)*(double)widthPixel);
		Point3D p2=new Point3D(x ,y);
		System.out.println(p2.toString());
		return p2;
	}
}
