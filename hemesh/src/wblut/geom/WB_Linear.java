package wblut.geom;

import wblut.math.WB_Epsilon;

public abstract class WB_Linear {

	protected WB_Point origin;

	protected WB_Vector direction;

	public WB_Linear() {
		origin = new WB_Point();
		direction = new WB_Vector(1, 0, 0);
	}

	public WB_Linear(final WB_Coordinate o, final WB_Coordinate d) {
		origin = new WB_Point(o);
		direction = new WB_Vector(d);
		direction.normalizeSelf();
	}

	protected void set(final WB_Coordinate o, final WB_Coordinate d) {
		origin.set(o);
		direction.set(d);
		direction.normalizeSelf();
	}

	public WB_Point getPointOnLine(final double t) {
		final WB_Point result = new WB_Point(direction);
		result.scaleSelf(t);
		result.addSelf(origin);
		return result;
	}

	public void getPointOnLineInto(final double t, final WB_MutableCoordinate p) {
		p.set(direction.mul(t).addSelf(origin));
	}

	public WB_Point getOrigin() {
		return origin;
	}

	public WB_Vector getDirection() {
		return direction;
	}

	public WB_Vector getNormal() {
		WB_Vector n = new WB_Vector(0, 0, 1);
		n = n.cross(direction);
		final double d = n.normalizeSelf();
		if (WB_Epsilon.isZero(d)) {
			n = new WB_Vector(1, 0, 0);
		}
		return n;
	}

	public double a() {
		return -direction.yd();
	}

	public double b() {
		return direction.xd();
	}

	public double c() {
		return origin.xd() * direction.yd() - origin.yd() * direction.xd();
	}
}
