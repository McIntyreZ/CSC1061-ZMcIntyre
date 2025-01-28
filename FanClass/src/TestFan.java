// TODO comment out program


public class TestFan {

	public static void main(String[] args) {
		final int FAST = 3;
		final int MEDIUM = 2;
		final int SLOW = 1;
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		System.out.println("This program is designed to create and track the properties of "
				+ "different objects.");
		System.out.println("The object this program can create are fans; the color, speed, "
				+ "radius, and the setting of On/Off are recorded.");
		System.out.println("The speed setting of the fan are FAST (3), MEDIUM (2), and SLOW (1).\n");
		
		fan1.setSpeed(FAST);
		fan1.setColor("Yellow");
		fan1.setOn(true); 
		System.out.println(fan1);
		System.out.println();
		
		fan2.setSpeed(MEDIUM);
		fan2.setColor("Blue");
		fan2.setOn(false);
		System.out.println(fan2);	
	}

}
