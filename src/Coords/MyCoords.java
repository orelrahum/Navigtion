package Coords;

import Geom.Point3D;
/**
 * 
 *@author orelr
 *@author lital
 */

public class MyCoords implements coords_converter {
	/**
	 * @param R Represents the radius of the Earth (6371000)
	 */
	long R=6371000;
	/** 
	 * Computes a new point which is the gps point transformed by a 3D vector (in meters).
	 * @param gps - the point in degrees
	 * @param local_vector_in_meter - the vector in meters
	 * @return - the new point that we get after the local_vector_in_meter added to the gps point, return "null" if the point is not valid
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		gps.PolarToCartes();
		gps.add(local_vector_in_meter);
		return gps;
	}
	/**
	 *  This function calculates the distance between  2 gps Coords
	 *  To read about the calculation https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	 *@param lonNorm
	 *@param lon Longitude is a geographic coordinate that specifies the east–west position of a point on the Earth's surface
	 *@param lat latitude is a geographic coordinate that specifies the north–south position of a point on the Earth's surface.
	 *@param dis the distance between 2 gps Coords
	 *@return dis 
	 */
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
	/**
	 * Computes the 3D vector (in meters) between two gps like points.
	 * @param gps0 - the first 3d point
	 * @param gps1 - the second 3d point
	 * @return - the vector between the points
	 */
	public Point3D vector3D(Point3D gps0, Point3D gps1)
	{
		if (!(isValid_GPS_Point(gps0))) { //validate gps0 is valid point
			throw new RuntimeException("gps0 is invalid point");
			
		} else if (!(isValid_GPS_Point(gps1))) { //validate gps1 is valid point
			throw new RuntimeException("gps1 is invalid point");
			
		} else { //if both of the points are valid
			double dx = gps1.x()-gps0.x(); //the distance between the Lat(x) in degrees
			double dy = gps1.y()-gps0.y(); //the distance between the Lon(y) in degrees
			dx = (dx*Math.PI)/180; //the distance between the Lat(x) in radians
			dy = (dy*Math.PI)/180; //the distance between the Lon(y) in radians
			dx = Math.sin(dx)*R; //the distance between the Lat(x) in meters
			dy = Math.sin(dy)*R; //the distance between the Lon(y) in meters
			double dz = gps1.z() - gps0.z(); //the distance between heights
			Point3D vector3D = new Point3D(dx, dy, dz);
			return vector3D;
		}
	}

	/**
	 * Computes the polar representation of the 3D vector be gps0-->gps1.
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 * @param gps0 - the first 3d point
	 * @param gps1 - the second 3d point
	 * @return - the distance between the points 
	 * 
	 */
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1)
	{
		double [] azimuth = new double [3];
		azimuth[0] = gps0.north_angle(gps1);
		azimuth[1] = gps0.up_angle(gps1); 
		azimuth[2] =(distance3d(gps0, gps1));

		return azimuth;
	}

	/**
	 * isValid_GPS_Point
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p - the point
	 * @return - true if the point valid, otherwise false
	 */
	public boolean isValid_GPS_Point(Point3D p)
	{
	
		return (Math.abs(p.y())<180)&&((Math.abs(p.x()))<90)&&((p.z()>=-450));
	}



	
}
