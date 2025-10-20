package se411.maven.site.data;

public class CircleWithException {

    /** The radius of the circle */
    private double radius;

    /** The number of the objects created */
    private static int numberOfObjects = 0;

    /** Construct a circle with radius 1 */
    public CircleWithException() {
        this(1.0);
    }

    /** Construct a circle with a specified radius */
    public CircleWithException(double newRadius) {
       setRadius(newRadius);
       numberOfObjects++;
    }

    /** Return radius */
    public double getRadius() {
       return radius;
   }
	
    /** Construct a circle with a specified radius */
    public void setR(double newRadius) {
       setRadius(newRadius);
       numberOfObjects++;
    }
	
	  /** Set a new radius */
	  public void setRadius(double newRadius)
	         throws RadiusException {
	       if (newRadius >= 0)
	           radius = newRadius;
	       else
	           throw new RadiusException();
	   }

	   /** Return numberOfObjects */
	   public static int getNumberOfObjects() {
	      return numberOfObjects;
	   }

	   /** Return the area of this circle */
	   public double findArea() {
	      return radius * radius * 3.14159;
	   }

}
