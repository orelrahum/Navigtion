package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	long R=6371000;
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		gps.PolarToCartes();
		gps.add(local_vector_in_meter);
		return gps;
	}
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		double lat,lon,lonNorm,dis;
		lonNorm=Math.cos(gps0.x()*Math.PI/180);
		lat=(gps1.x()-gps0.x())*Math.PI/180;
		lon=gps1.y()-gps0.y()*Math.PI/180;
		lat=Math.sin(lat)*R;
		lon=Math.sin(lon)*R*lonNorm;
		dis=Math.pow(Math.pow(lat, 2)*Math.pow(lon, 2), 0.5);
		
		return dis;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}

}
