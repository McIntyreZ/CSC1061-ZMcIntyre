
// TODO comment out the program


public class Fan {
	// Data Members
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	private int speed; 
	private boolean on; 
	private int radius;
	private String color;
	private int id = 0; // Program will assign each Fan object an id which will stay with the object
	private static int nextId = 1;
	
	// Constructor
	public Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "Blue";
		id = nextId;
		nextId += 1;
	}
	
	// Getters and Setters
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed > FAST) {
			this.speed = FAST;
		}
		else if (speed < SLOW) {
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
		if (radius > 0) {
			this.radius = radius;
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
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
	
	
	
}
