
public class Fan {
	// Data Members
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	private int speed; 
	private boolean on; 
	private int radius;
	private String color;
	private int id = 0; // Program will assign and keep track each fan object an id
	private static int nextId = 1; // Allows program to have unique ids for each object
	
	// Constructor
	public Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "Blue";
		id = nextId;
		nextId += 1; // Allows the next id to have a different and unique id (nextId is static)
	}
	
	// Getters and Setters
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed > FAST) {      // Ensures the speed will not be set past the max (FAST)
			System.out.println("The maximum speed of the fan is 3.");
			this.speed = FAST;
		}
		else if (speed < SLOW) { // Ensures the speed will not be set below the min (SLOW)
			System.out.println("The minimum speed of the fan is 1.");
			this.speed = SLOW;
		}
		else {
			this.speed = speed;
		}
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		if (radius > 0) { // Ensures the radius of the fan will not be set below 0
			this.radius = radius;
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() { // No option to set id, only the getter is available
		return id;
	}

	@Override
	public String toString() {
		if (on) {
			return "Fan [speed = " + speed + ", radius = " + radius + ", color = " 
					+ color + ", id = " + id + ",]";
		}
		else {
			return "Fan [speed = " + speed + ", radius = " + radius + ", color = " 
					+ color + ", id = " + id + ",] The fan is off.";
		}
	}
} // End class Fan
