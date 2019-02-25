import java.lang.Math;

class Vector {
	private double magnitude;
	private double angle;
	private double i;
	private double j;
  /*
  * A Private Constructor for the vector
  */
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
  
  /*
  * A static factory method that utilizes Magnitude and Angle to determine everything
  * @param Magntude - The magnitude of the vector
  * @param Angle - The angle of the vector
  * @returns A vector Object
  */
	public static Vector VectorMA(double magnitude, double angle) {
		return new Vector(magnitude, angle, true);
	}

	/*
  * A static factory method that utilizes I and J to determine everything
  * @param I - The x component of the vector
  * @param J - The y component of the vector
  * @returns A vector Object
  */
  public static Vector VectorIJ(double i, double j) {
		return new Vector(i, j, false);
	}
  
  /*
  * Returns this vector multiplied by a variable
  * @param multi - The variable to multiply by
  * @returns A Vector Object
  */
	public Vector ScalarMulti(double multi) {
		return new Vector(i * multi, j * multi, false);
	}
  
  /*
  * Returns this vector added with another Vector
  * @param add - The vector to add
  * @returns A Vector Object
  */
	public Vector VectorAdd(Vector add) {
		return new Vector(add.i + i, add.j + j, false);
	}

  /*
  * Returns this vector subtracted with another Vector
  * @param sub - The vector to subtract
  * @returns A Vector Object
  */
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