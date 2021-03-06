package wblut.geom;

import wblut.math.WB_Epsilon;
import wblut.math.WB_M33;
import wblut.math.WB_Math;

public class WB_Vector extends WB_SimpleVector implements
WB_MutableCoordinateFull {
    public static WB_Coordinate X() {
	return new WB_Vector(1, 0, 0);
    }

    public static WB_Coordinate Y() {
	return new WB_Vector(0, 1, 0);
    }

    public static WB_Coordinate Z() {
	return new WB_Vector(0, 0, 1);
    }

    public static WB_Coordinate ZERO() {
	return new WB_Vector(0, 0, 0);
    }

    public WB_Vector() {
	super();
    }

    public WB_Vector(final double x, final double y) {
	super(x, y);
    }

    public WB_Vector(final double x, final double y, final double z) {
	super(x, y, z);
    }

    public WB_Vector(final double[] x) {
	super(x);
    }

    public WB_Vector(final double[] fromPoint, final double[] toPoint) {
	super(fromPoint, toPoint);
    }

    public WB_Vector(final WB_Coordinate v) {
	super(v);
    }

    public WB_Vector(final WB_Coordinate fromPoint, final WB_Coordinate toPoint) {
	super(fromPoint, toPoint);
    }

    /**
     * @deprecated Use {@link #addMulSelf(double,double,double,double)} instead
     */
    @Deprecated
    public WB_Vector _addMulSelf(final double f, final double x,
	    final double y, final double z) {
	return addMulSelf(f, x, y, z);
    }

    @Override
    public WB_Vector addMulSelf(final double f, final double x, final double y,
	    final double z) {
	set(xd() + f * x, yd() + f * y, zd() + f * z);
	return this;
    }

    /**
     * @deprecated Use {@link #addMulSelf(double,WB_Coordinate)} instead
     */
    @Deprecated
    public WB_Vector _addMulSelf(final double f, final WB_Coordinate p) {
	return addMulSelf(f, p);
    }

    @Override
    public WB_Vector addMulSelf(final double f, final WB_Coordinate p) {
	set(xd() + f * p.xd(), yd() + f * p.yd(), zd() + f * p.zd());
	return this;
    }

    /**
     * @deprecated Use {@link #addSelf(double,double,double)} instead
     */
    @Deprecated
    public WB_Vector _addSelf(final double x, final double y, final double z) {
	return addSelf(x, y, z);
    }

    @Override
    public WB_Vector addSelf(final double x, final double y, final double z) {
	set(xd() + x, yd() + y, zd() + z);
	return this;
    }

    /**
     * @deprecated Use {@link #addSelf(WB_Coordinate)} instead
     */
    @Deprecated
    public WB_Vector _addSelf(final WB_Coordinate p) {
	return addSelf(p);
    }

    @Override
    public WB_Vector addSelf(final WB_Coordinate p) {
	set(xd() + p.xd(), yd() + p.yd(), zd() + p.zd());
	return this;
    }

    /**
     * @deprecated Use {@link #applyAsNormalSelf(WB_Transform)} instead
     */
    @Deprecated
    public WB_Vector _applyAsNormalSelf(final WB_Transform T) {
	return applyAsNormalSelf(T);
    }

    @Override
    public WB_Vector applyAsNormalSelf(final WB_Transform T) {
	T.applyAsNormal(this, this);
	return this;
    }

    /**
     * @deprecated Use {@link #applyAsPointSelf(WB_Transform)} instead
     */
    @Deprecated
    public WB_Vector _applyAsPointSelf(final WB_Transform T) {
	return applyAsPointSelf(T);
    }

    @Override
    public WB_Vector applyAsPointSelf(final WB_Transform T) {
	T.applyAsPoint(this, this);
	return this;
    }

    /**
     * @deprecated Use {@link #applyAsVectorSelf(WB_Transform)} instead
     */
    @Deprecated
    public WB_Vector _applyAsVectorSelf(final WB_Transform T) {
	return applyAsVectorSelf(T);
    }

    @Override
    public WB_Vector applyAsVectorSelf(final WB_Transform T) {
	T.applyAsVector(this, this);
	return this;
    }

    /**
     * @deprecated Use {@link #crossSelf(WB_Coordinate)} instead
     */
    @Deprecated
    public WB_Vector _crossSelf(final WB_Coordinate p) {
	return crossSelf(p);
    }

    @Override
    public WB_Vector crossSelf(final WB_Coordinate p) {
	set(yd() * p.zd() - this.zd() * p.yd(), this.zd() * p.xd() - this.xd()
		* p.zd(), this.xd() * p.yd() - yd() * p.xd());
	return this;
    }

    /**
     * @deprecated Use {@link #divSelf(double)} instead
     */
    @Deprecated
    public WB_Vector _divSelf(final double f) {
	return divSelf(f);
    }

    @Override
    public WB_Vector divSelf(final double f) {
	return mulSelf(1.0 / f);
    }

    /**
     * @deprecated Use {@link #invert()} instead
     */
    @Deprecated
    public void _invert() {
	invert();
    }

    public void invert() {
	mulSelf(-1);
    }

    /**
     * @deprecated Use {@link #mulAddMulSelf(double,double,WB_Coordinate)}
     *             instead
     */
    @Deprecated
    public WB_Vector _mulAddMulSelf(final double f, final double g,
	    final WB_Coordinate p) {
	return mulAddMulSelf(f, g, p);
    }

    @Override
    public WB_Vector mulAddMulSelf(final double f, final double g,
	    final WB_Coordinate p) {
	set(f * xd() + g * p.xd(), f * yd() + g * p.yd(), f * zd() + g * p.zd());
	return this;
    }

    /**
     * @deprecated Use {@link #mulSelf(double)} instead
     */
    @Deprecated
    public WB_Vector _mulSelf(final double f) {
	return mulSelf(f);
    }

    @Override
    public WB_Vector mulSelf(final double f) {
	set(f * xd(), f * yd(), f * zd());
	return this;
    }

    /**
     * @deprecated Use {@link #normalizeSelf()} instead
     */
    @Deprecated
    public double _normalizeSelf() {
	return normalizeSelf();
    }

    @Override
    public double normalizeSelf() {
	final double d = getLength3D();
	if (WB_Epsilon.isZero(d)) {
	    set(0, 0, 0);
	} else {
	    set(xd() / d, yd() / d, zd() / d);
	}
	return d;
    }

    /**
     * @deprecated Use {@link #scaleSelf(double)} instead
     */
    @Deprecated
    public WB_Vector _scaleSelf(final double f) {
	return scaleSelf(f);
    }

    @Override
    public WB_Vector scaleSelf(final double f) {
	mulSelf(f);
	return this;
    }

    @Override
    public WB_Vector scale(final double f) {
	return mul(f);
    }

    /**
     * @deprecated Use {@link #scaleSelf(double,double,double)} instead
     */
    @Deprecated
    public WB_Vector _scaleSelf(final double fx, final double fy,
	    final double fz) {
	return scaleSelf(fx, fy, fz);
    }

    @Override
    public WB_Vector scaleSelf(final double fx, final double fy, final double fz) {
	set(xd() * fx, yd() * fy, zd() * fz);
	return this;
    }

    @Override
    public WB_Vector scale(final double fx, final double fy, final double fz) {
	return new WB_Vector(xd() * fx, yd() * fy, zd() * fz);
    }

    /**
     * @deprecated Use {@link #subSelf(double,double,double)} instead
     */
    @Deprecated
    public WB_Vector _subSelf(final double x, final double y, final double z) {
	return subSelf(x, y, z);
    }

    @Override
    public WB_Vector subSelf(final double x, final double y, final double z) {
	set(xd() - x, yd() - y, zd() - z);
	return this;
    }

    /**
     * @deprecated Use {@link #subSelf(WB_Coordinate)} instead
     */
    @Deprecated
    public WB_Vector _subSelf(final WB_Coordinate v) {
	return subSelf(v);
    }

    @Override
    public WB_Vector subSelf(final WB_Coordinate v) {
	set(xd() - v.xd(), yd() - v.yd(), zd() - v.zd());
	return this;
    }

    @Override
    public WB_Vector trimSelf(final double d) {
	if (getSqLength3D() > d * d) {
	    normalizeSelf();
	    mulSelf(d);
	}
	return this;
    }

    @Override
    public double absDot(final WB_Coordinate p) {
	return WB_Math.fastAbs(WB_CoordinateOp.dot(xd(), yd(), zd(), p.xd(),
		p.yd(), p.zd()));
    }

    @Override
    public double absDot2D(final WB_Coordinate p) {
	return WB_Math
		.fastAbs(WB_CoordinateOp.dot2D(xd(), yd(), p.xd(), p.yd()));
    }

    @Override
    public WB_Vector add(final double x, final double y, final double z) {
	return new WB_Vector(this.xd() + x, this.yd() + y, this.zd() + z);
    }

    /**
     * @deprecated Use
     *             {@link #addInto(double,double,double,WB_MutableCoordinate)}
     *             instead
     */
    @Deprecated
    public void add(final double x, final double y, final double z,
	    final WB_MutableCoordinate result) {
	addInto(x, y, z, result);
    }

    @Override
    public void addInto(final double x, final double y, final double z,
	    final WB_MutableCoordinate result) {
	result.set(this.xd() + x, this.yd() + y, this.zd() + z);
    }

    @Override
    public WB_Vector add(final WB_Coordinate p) {
	return new WB_Vector(xd() + p.xd(), yd() + p.yd(), zd() + p.zd());
    }

    /**
     * @deprecated Use {@link #addInto(WB_Coordinate,WB_MutableCoordinate)}
     *             instead
     */
    @Deprecated
    public void add(final WB_Coordinate p, final WB_MutableCoordinate result) {
	addInto(p, result);
    }

    @Override
    public void addInto(final WB_Coordinate p, final WB_MutableCoordinate result) {
	result.set(xd() + p.xd(), yd() + p.yd(), zd() + p.zd());
    }

    @Override
    public WB_Vector addMul(final double f, final double x, final double y,
	    final double z) {
	return new WB_Vector(this.xd() + f * x, this.yd() + f * y, this.zd()
		+ f * z);
    }

    /**
     * @deprecated Use
     *             {@link #addMulInto(double,double,double,double,WB_MutableCoordinate)}
     *             instead
     */
    @Deprecated
    public void addMul(final double f, final double x, final double y,
	    final double z, final WB_MutableCoordinate result) {
	addMulInto(f, x, y, z, result);
    }

    @Override
    public void addMulInto(final double f, final double x, final double y,
	    final double z, final WB_MutableCoordinate result) {
	result.set(this.xd() + f * x, this.yd() + f * y, this.zd() + f * z);
    }

    @Override
    public WB_Vector addMul(final double f, final WB_Coordinate p) {
	return new WB_Vector(xd() + f * p.xd(), yd() + f * p.yd(), zd() + f
		* p.zd());
    }

    /**
     * @deprecated Use
     *             {@link #addMulInto(double,WB_Coordinate,WB_MutableCoordinate)}
     *             instead
     */
    @Deprecated
    public void addMul(final double f, final WB_Coordinate p,
	    final WB_MutableCoordinate result) {
	addMulInto(f, p, result);
    }

    @Override
    public void addMulInto(final double f, final WB_Coordinate p,
	    final WB_MutableCoordinate result) {
	result.set(xd() + f * p.xd(), yd() + f * p.yd(), zd() + f * p.zd());
    }

    @Override
    public WB_Vector apply(final WB_Transform T) {
	final WB_Vector v = new WB_Vector(this);
	return v.applySelf(T);
    }

    @Override
    public WB_Vector applySelf(final WB_Transform T) {
	return applyAsVector(T);
    }

    @Override
    public void applyInto(final WB_Transform T,
	    final WB_MutableCoordinate result) {
	T.applyAsVector(this, result);
    }

    @Override
    public WB_Vector applyAsNormal(final WB_Transform T) {
	final WB_Vector result = new WB_Vector();
	T.applyAsNormal(this, result);
	return result;
    }

    @Override
    public void applyAsNormalInto(final WB_Transform T,
	    final WB_MutableCoordinate result) {
	T.applyAsNormal(this, result);
    }

    @Override
    public WB_Vector applyAsPoint(final WB_Transform T) {
	final WB_Vector result = new WB_Vector();
	T.applyAsPoint(this, result);
	return result;
    }

    @Override
    public void applyAsPointInto(final WB_Transform T,
	    final WB_MutableCoordinate result) {
	T.applyAsPoint(this, result);
    }

    @Override
    public WB_Vector applyAsVector(final WB_Transform T) {
	final WB_Vector result = new WB_Vector();
	T.applyAsVector(this, result);
	return result;
    }

    @Override
    public void applyAsVectorInto(final WB_Transform T,
	    final WB_MutableCoordinate result) {
	T.applyAsVector(this, result);
    }

    @Override
    public int compareTo(final WB_Coordinate p) {
	int cmp = Double.compare(xd(), p.xd());
	if (cmp != 0) {
	    return cmp;
	}
	cmp = Double.compare(yd(), p.yd());
	if (cmp != 0) {
	    return cmp;
	}
	cmp = Double.compare(zd(), p.zd());
	if (cmp != 0) {
	    return cmp;
	}
	return Double.compare(wd(), p.wd());
    }

    public int compareToY1st(final WB_Coordinate p) {
	int cmp = Double.compare(yd(), p.yd());
	if (cmp != 0) {
	    return cmp;
	}
	cmp = Double.compare(xd(), p.xd());
	if (cmp != 0) {
	    return cmp;
	}
	cmp = Double.compare(zd(), p.zd());
	if (cmp != 0) {
	    return cmp;
	}
	return Double.compare(wd(), p.wd());
    }

    public double[] coords() {
	return new double[] { xd(), yd(), zd() };
    }

    @Override
    public WB_Vector cross(final WB_Coordinate p) {
	return new WB_Vector(yd() * p.zd() - zd() * p.yd(), zd() * p.xd()
		- xd() * p.zd(), xd() * p.yd() - yd() * p.xd());
    }

    @Override
    public void crossInto(final WB_Coordinate p,
	    final WB_MutableCoordinate result) {
	result.set(yd() * p.zd() - zd() * p.yd(),
		zd() * p.xd() - xd() * p.zd(), xd() * p.yd() - yd() * p.xd());
    }

    @Override
    public WB_Vector div(final double f) {
	return mul(1.0 / f);
    }

    /**
     * @deprecated Use {@link #divInto(double,WB_MutableCoordinate)} instead
     */
    @Deprecated
    public void div(final double f, final WB_MutableCoordinate result) {
	divInto(f, result);
    }

    @Override
    public void divInto(final double f, final WB_MutableCoordinate result) {
	mulInto(1.0 / f, result);
    }

    @Override
    public double dot(final WB_Coordinate p) {
	return WB_CoordinateOp.dot(xd(), yd(), zd(), p.xd(), p.yd(), p.zd());
    }

    @Override
    public double dot2D(final WB_Coordinate p) {
	return WB_CoordinateOp.dot2D(xd(), yd(), p.xd(), p.yd());
    }

    @Override
    public boolean equals(final Object o) {
	if (o == null) {
	    return false;
	}
	if (o == this) {
	    return true;
	}
	if (!(o instanceof WB_Vector)) {
	    return false;
	}
	final WB_Vector p = (WB_Vector) o;
	if (!WB_Epsilon.isEqualAbs(xd(), p.xd())) {
	    return false;
	}
	if (!WB_Epsilon.isEqualAbs(yd(), p.yd())) {
	    return false;
	}
	if (!WB_Epsilon.isEqualAbs(zd(), p.zd())) {
	    return false;
	}
	return true;
    }

    public WB_Vector get() {
	return new WB_Vector(xd(), yd(), zd());
    }

    @Override
    public double getAngle(final WB_Coordinate p) {
	return WB_CoordinateOp.angleBetween(xd(), yd(), zd(), p.xd(), p.yd(),
		p.zd());
    }

    @Override
    public double getAngleNorm(final WB_Coordinate p) {
	return WB_CoordinateOp.angleBetweenNorm(xd(), yd(), zd(), p.xd(),
		p.yd(), p.zd());
    }

    /**
     * @deprecated Use {@link #getDistance3D(WB_Coordinate)} instead
     */
    @Deprecated
    public double getDistance(final WB_Coordinate p) {
	return getDistance3D(p);
    }

    @Override
    public double getDistance3D(final WB_Coordinate p) {
	return WB_CoordinateOp.getDistance3D(xd(), yd(), zd(), p.xd(), p.yd(),
		p.zd());
    }

    @Override
    public double getDistance2D(final WB_Coordinate p) {
	return WB_CoordinateOp.getDistance2D(xd(), yd(), p.xd(), p.yd());
    }

    /**
     * @deprecated Use {@link #getLength3D()} instead
     */
    @Deprecated
    public double getLength() {
	return getLength3D();
    }

    @Override
    public double getLength3D() {
	return WB_CoordinateOp.getLength3D(xd(), yd(), zd());
    }

    @Override
    public double getLength2D() {
	return WB_CoordinateOp.getLength2D(xd(), yd());
    }

    /**
     * @deprecated Use {@link #getSqDistance3D(WB_Coordinate)} instead
     */
    @Deprecated
    public double getSqDistance(final WB_Coordinate p) {
	return getSqDistance3D(p);
    }

    @Override
    public double getSqDistance3D(final WB_Coordinate p) {
	return WB_CoordinateOp.getSqDistance3D(xd(), yd(), zd(), p.xd(),
		p.yd(), p.zd());
    }

    @Override
    public double getSqDistance2D(final WB_Coordinate p) {
	return WB_CoordinateOp.getSqDistance2D(xd(), yd(), p.xd(), p.yd());
    }

    /**
     * @deprecated Use {@link #getSqLength3D()} instead
     */
    @Deprecated
    public double getSqLength() {
	return getSqLength3D();
    }

    @Override
    public double getSqLength3D() {
	return WB_CoordinateOp.getSqLength3D(xd(), yd(), zd());
    }

    @Override
    public double getSqLength2D() {
	return WB_CoordinateOp.getSqLength2D(xd(), yd());
    }

    @Override
    public int hashCode() {
	return WB_CoordinateOp.calculateHashCode(xd(), yd(), zd());
    }

    @Override
    public double heading2D() {
	return Math.atan2(yd(), xd());
    }

    public boolean isCollinear(final WB_Coordinate p, final WB_Coordinate q) {
	if (WB_Epsilon.isZeroSq(WB_GeometryOp.getSqDistanceToPoint2D(p, q))) {
	    return true;
	}
	if (WB_Epsilon.isZeroSq(WB_GeometryOp.getSqDistanceToPoint2D(this, q))) {
	    return true;
	}
	if (WB_Epsilon.isZeroSq(WB_GeometryOp.getSqDistanceToPoint2D(this, p))) {
	    return true;
	}
	return WB_Epsilon.isZeroSq(sub(p).cross(sub(q)).getSqLength3D());
    }

    public boolean isParallel(final WB_Coordinate p) {
	final double pm2 = p.xd() * p.xd() + p.yd() * p.yd() + p.zd() * p.zd();
	return (cross(p).getSqLength3D() / (pm2 * getSqLength3D()) < WB_Epsilon.SQEPSILON);
    }

    public boolean isParallel(final WB_Coordinate p, final double t) {
	final double pm2 = p.xd() * p.xd() + p.yd() * p.yd() + p.zd() * p.zd();
	return (cross(p).getSqLength3D() / (pm2 * getSqLength3D()) < t
		+ WB_Epsilon.SQEPSILON);
    }

    public boolean isParallelNorm(final WB_Coordinate p) {
	return (cross(p).getLength3D() < WB_Epsilon.EPSILON);
    }

    public boolean isParallelNorm(final WB_Coordinate p, final double t) {
	return (cross(p).getLength3D() < t + WB_Epsilon.EPSILON);
    }

    @Override
    public boolean isZero() {
	return WB_CoordinateOp.isZero3D(xd(), yd(), zd());
    }

    @Override
    public WB_Vector mul(final double f) {
	return new WB_Vector(xd() * f, yd() * f, zd() * f);
    }

    /**
     * @deprecated Use {@link #mulInto(double,WB_MutableCoordinate)} instead
     */
    @Deprecated
    public void mul(final double f, final WB_MutableCoordinate result) {
	mulInto(f, result);
    }

    @Override
    public void mulInto(final double f, final WB_MutableCoordinate result) {
	scaleInto(f, result);
    }

    @Override
    public WB_Vector mulAddMul(final double f, final double g,
	    final WB_Coordinate p) {
	return new WB_Vector(f * xd() + g * p.xd(), f * yd() + g * p.yd(), f
		* zd() + g * p.zd());
    }

    /**
     * @deprecated Use
     *             {@link #mulAddMulInto(double,double,WB_Coordinate,WB_MutableCoordinate)}
     *             instead
     */
    @Deprecated
    public void mulAddMul(final double f, final double g,
	    final WB_Coordinate p, final WB_MutableCoordinate result) {
	result.set(f * xd() + g * p.xd(), f * yd() + g * p.yd(), f * zd() + g
		* p.zd());
    }

    @Override
    public void mulAddMulInto(final double f, final double g,
	    final WB_Coordinate p, final WB_MutableCoordinate result) {
	result.set(f * xd() + g * p.xd(), f * yd() + g * p.yd(), f * zd() + g
		* p.zd());
    }

    @Override
    public WB_Vector rotateAbout2PointAxisSelf(final double angle,
	    final double p1x, final double p1y, final double p1z,
	    final double p2x, final double p2y, final double p2z) {
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, new WB_Vector(p1x, p1y, p1z),
		new WB_Vector(p2x - p1x, p2y - p1y, p2z - p1z));
	raa.applySelfAsVector(this);
	return this;
    }

    @Override
    public WB_Vector rotateAbout2PointAxisSelf(final double angle,
	    final WB_Coordinate p1, final WB_Coordinate p2) {
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, p1, new WB_Vector(p1, p2));
	raa.applySelfAsVector(this);
	return this;
    }

    @Override
    public WB_Vector rotateAboutAxisSelf(final double angle,
	    final WB_Coordinate p, final WB_Coordinate a) {
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, p, a);
	raa.applySelfAsVector(this);
	return this;
    }

    @Override
    public WB_Vector rotateAbout2PointAxis(final double angle,
	    final double p1x, final double p1y, final double p1z,
	    final double p2x, final double p2y, final double p2z) {
	final WB_Vector result = new WB_Vector(this);
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, new WB_Vector(p1x, p1y, p1z),
		new WB_Vector(p2x - p1x, p2y - p1y, p2z - p1z));
	raa.applySelfAsVector(result);
	return result;
    }

    @Override
    public WB_Vector rotateAbout2PointAxis(final double angle,
	    final WB_Coordinate p1, final WB_Coordinate p2) {
	final WB_Vector result = new WB_Vector(this);
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, p1, new WB_Vector(p1, p2));
	raa.applySelfAsVector(this);
	return result;
    }

    @Override
    public WB_Vector rotateAboutAxis(final double angle, final WB_Coordinate p,
	    final WB_Coordinate a) {
	final WB_Vector result = new WB_Vector(this);
	final WB_Transform raa = new WB_Transform();
	raa.addRotateAboutAxis(angle, p, a);
	raa.applySelfAsVector(this);
	return result;
    }

    @Override
    public double scalarTriple(final WB_Coordinate v, final WB_Coordinate w) {
	return WB_CoordinateOp.scalarTriple(xd(), yd(), zd(), v.xd(), v.yd(),
		v.zd(), w.xd(), w.yd(), w.zd());
    }

    public void scaleInto(final double f, final WB_MutableCoordinate result) {
	result.set(xd() * f, yd() * f, zd() * f);
    }

    public boolean smallerThan(final WB_Coordinate otherXYZ) {
	int _tmp = WB_Epsilon.compareAbs(xd(), otherXYZ.xd());
	if (_tmp != 0) {
	    return (_tmp < 0);
	}
	_tmp = WB_Epsilon.compareAbs(yd(), otherXYZ.yd());
	if (_tmp != 0) {
	    return (_tmp < 0);
	}
	_tmp = WB_Epsilon.compareAbs(zd(), otherXYZ.zd());
	return (_tmp < 0);
    }

    @Override
    public WB_Vector sub(final double x, final double y, final double z) {
	return new WB_Vector(this.xd() - x, this.yd() - y, this.zd() - z);
    }

    @Override
    public void subInto(final double x, final double y, final double z,
	    final WB_MutableCoordinate result) {
	result.set(this.xd() - x, this.yd() - y, this.zd() - z);
    }

    @Override
    public WB_Vector sub(final WB_Coordinate p) {
	return new WB_Vector(this.xd() - p.xd(), this.yd() - p.yd(), this.zd()
		- p.zd());
    }

    @Override
    public void subInto(final WB_Coordinate p, final WB_MutableCoordinate result) {
	result.set(this.xd() - p.xd(), this.yd() - p.yd(), this.zd() - p.zd());
    }

    @Override
    public WB_M33 tensor(final WB_Coordinate v) {
	return new WB_M33(WB_CoordinateOp.tensor3D(xd(), yd(), zd(), v.xd(),
		v.yd(), v.zd()));
    }

    @Override
    public String toString() {
	return "WB_Vector [x=" + xd() + ", y=" + yd() + ", z=" + zd() + "]";
    }

    @Override
    public WB_Vector getOrthoNormal2D() {
	final WB_Vector a = new WB_Vector(-yd(), xd(), 0);
	a.normalizeSelf();
	return a;
    }

    @Override
    public WB_Vector getOrthoNormal3D() {
	if (Math.abs(zd()) > WB_Epsilon.EPSILON) {
	    final WB_Vector a = new WB_Vector(1, 0, -xd() / zd());
	    a.normalizeSelf();
	    return a;
	} else {
	    return new WB_Vector(0, 0, 1);
	}
    }
}
