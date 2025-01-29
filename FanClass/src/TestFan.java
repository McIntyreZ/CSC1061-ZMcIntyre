// Zachary McIntyre
// Built for CSC-1061, assignment The Fan Class, 1/29/25 
// Program written in Java
// This program is designed to demonstrate the creation and alteration of objects.
// The program creates Fan objects then changes the speed, color, etc... 

public class TestFan {

	public static void main(String[] args) {
		// Data Members for main()
		final int FAST = 3;
		final int MEDIUM = 2;
		final int SLOW = 1;
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		// Program will output message so that the user has a better understanding
		System.out.println("This program is designed to create and track the properties of "
				+ "different objects.");
		System.out.println("The object this program can create are fans; the color, speed, "
				+ "radius, and the setting of On/Off are recorded.");
		System.out.println("The speed setting of the fan are FAST (3), MEDIUM (2), and SLOW (1).\n");
		
		// First Fan object created and altered 
		fan1.setSpeed(FAST);
		fan1.setColor("Yellow");
		fan1.setOn(true); 
		System.out.println(fan1);
		System.out.println();
		
		// Second Fan object created and altered 
		fan2.setSpeed(MEDIUM);
		fan2.setColor("Blue");
		fan2.setOn(false);
		System.out.println(fan2);	
		
	} // End main()
} // End class TestFan
