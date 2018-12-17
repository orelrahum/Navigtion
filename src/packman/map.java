package packman;

import Geom.Point3D;

public class map {
	Point3D leftUp = new Point3D(32.105770,  35.202469);
	Point3D leftDown = new Point3D(32.101899, 35.202469);
	Point3D RightUp = new Point3D(32.105770 , 35.211588);
	Point3D RightDown = new Point3D(32.101899, 35.211588);

	
	public static Point3D PixelToCoords(Point3D p, int HeightPixel,int widthPixel ) {
		double Heightcoords=32.105770-32.101899;
		double widthcoords=35.211588-35.202469;
		double lat=(32.105770-((double)p.y()/HeightPixel)*Heightcoords);
		double lon=35.202469+(((double)p.x()/widthPixel)*widthcoords);
		Point3D p2=new Point3D(lat,lon);
		return p2;
	}
	public static Point3D CoordsToPixel(Point3D p, int HeightPixel,int widthPixel ) {
		double Heightcoords=32.105770-32.101899;
		double widthcoords=35.211588-35.202469;
		double lat_temp=p.x()-32.105770;
		double lon_temp=p.y()-35.202469;
		double x=(lon_temp/widthcoords*(double)widthPixel);
		double y=((lat_temp/Heightcoords)*-(double)HeightPixel);
		Point3D p2=new Point3D(x ,y);
		return p2;
	}
}
