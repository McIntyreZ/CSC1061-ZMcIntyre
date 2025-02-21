// This is a class that does length conversions
/**
 * Methods for converting between inches and centimeters
 * @author Zachary McIntyre 
 */
public class Convertor {

	public static final double CM_PER_INCH = 2.54;
	public static final int IN_PER_FOOT = 12;
	
	/**
	 * Converts a measurement in centimeters to inches 
	 * @param cm length in centimeters 
	 * @return length in inches 
	 */
	public static double toInches(double cm) {
		return cm / CM_PER_INCH;
	}
	
	/**
	 * Converts a measurement in inches to centimeters 
	 * @param feet	how many feet
	 * @param inches	how many inches
	 * @return length in centimeters 
	 */
	public static double toCentimeters(int feet, int inches) {
		int total = feet * IN_PER_FOOT + inches;
		return total; 
	}
}
