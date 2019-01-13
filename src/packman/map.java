package packman;

import Geom.Point3D;

public class map {
	Point3D leftUp = new Point3D(32.105728,  35.202369);
	Point3D leftDown = new Point3D(32.101898, 35.202369);
	Point3D RightUp = new Point3D(32.105728 , 35.212416);
	Point3D RightDown = new Point3D(32.101898, 35.212416);

	
	public static Point3D PixelToCoords(Point3D p, int HeightPixel,int widthPixel ) {
		double Heightcoords=32.105728-32.101898;
		double widthcoords=35.212416-35.202369;
		double lat=(32.105728-((double)p.y()/HeightPixel)*Heightcoords);
		double lon=35.202369+(((double)p.x()/widthPixel)*widthcoords);
		Point3D p2=new Point3D(lat,lon);
		return p2;
	}
	public static Point3D CoordsToPixel(Point3D p, int HeightPixel,int widthPixel ) {
		double Heightcoords=32.105728-32.101898;
		double widthcoords=35.212416-35.202369;
		double lat_temp=p.x()-32.105728;
		double lon_temp=p.y()-35.202369;
		double x=(lon_temp/widthcoords*(double)widthPixel);
		double y=((lat_temp/Heightcoords)*-(double)HeightPixel);
		Point3D p2=new Point3D(x ,y);
		return p2;
	}
}
