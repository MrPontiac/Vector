import java.lang.Math;

class Vector {
	private double magnitude;
	private double angle;
	private double i;
	private double j;

	private Vector(double a, double b, boolean type) {
		if (type) {
			magnitude = a;
			angle = b;
			i = a * Math.cos(Math.toRadians(b));
			j = a * Math.sin(Math.toRadians(b));
		} else {
			i = a;
			j = b;
			magnitude = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
			angle = Math.toDegrees(Math.atan((b / a)));
			if (angle < 0) {
				angle += 360;
			} else if (a < 0 && b > 0) {
				angle += 90;
			} else if (a < 0 && b < 0) {
				angle += 180;
			} else if (a > 0 && b < 0) {
				angle += 270;
			}
		}
	}

	public static Vector VectorMA(double magnitude, double angle) {
		return new Vector(magnitude, angle, true);
	}

	public static Vector VectorIJ(double i, double j) {
		return new Vector(i, j, false);
	}

	public Vector ScalarMulti(double multi) {
		return new Vector(i * multi, j * multi, false);
	}

	public Vector VectorAdd(Vector add) {
		return new Vector(add.i + i, add.j + j, false);
	}

	public Vector VectorSub(Vector sub) {
		return new Vector(i - sub.i, j - sub.j, false);
	}

	public double getI() {
		return i;
	}
	public double getJ() {
		return j;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public double getAngle() {
		return angle;
	}

	public String toString() {
		return "⟨" + i + ", " + j + "⟩\nMagnitude: " + magnitude + "\nAngle: " + angle + "\n";
	}
}