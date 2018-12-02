package GIS;
import Geom.Point3D;
/**
 * 
 *@author orelr
 *@author lital
 */
public class data implements Meta_data{
	public long UTC;
	private Point3D point;
	public data() {
		this.point=null;
		this.UTC=0;
	}

	public data(long UTC, Point3D point0) {
		this.UTC = UTC;
		this.point = point0;
	}
	/**
	 * @return UTC
	 */
	@Override
	public long getUTC() {
		return UTC;
	}
	/**
	 * @return toString of the meta data
	 */
	@Override
	public String toString() {
		return "UTC=" + this.UTC + "\n point=" + this.point;
	}
	/**
	 * @return the Orientation
	 */
	@Override
	public Point3D get_Orientation() {
		return point;
	}

}
