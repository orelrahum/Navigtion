package packman;

import Geom.Point3D;

public class Box {
	private Point3D LeftDown, rightUp ;
	public Box (Point3D RightUp,Point3D LeftDown) {
		setRightUp(RightUp);
		setLeftDown(LeftDown);
	}
	public Point3D getRightUp() {
		return rightUp;
	}
	public void setRightUp(Point3D rightUp) {
		this.rightUp = rightUp;
	}
	public Point3D getLeftDown() {
		return LeftDown;
	}
	public void setLeftDown(Point3D leftDown) {
		LeftDown = leftDown;
	}
}
