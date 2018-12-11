package Coords;
import Geom.Point3D;
import map.MainWindow;
public class PixelToCoords {
	Point3D leftUp = new Point3D(32.105770,  35.202469);
	Point3D RightUp = new Point3D(32.105770 , 35.211588);
	Point3D leftDown = new Point3D(32.101899, 35.202469);
	Point3D RightDown = new Point3D(32.101899, 35.211588);
	int widthPixel=1433;
	int HeightPixel=642;
	double Heightcoords= leftUp.distance3D(leftDown);
	double widthcoords= RightUp.distance3D(RightDown);
	
	
	
}

