
public class Car {
	// Data Members
	private final double MILES_PER_GALLON = 20.0; 
	private String color;
	private int mileage;
	private double amountOfGas;
	private boolean isClean = true;
	private boolean wantRadio;
	private Radio radio;
	private Wheel[] wheels = new Wheel[4]; 
	
	// Constructors 
	public Car() {
		color = "Grey";
		mileage = 10;
		amountOfGas = 2.0;
		isClean = true;
	}
	
	public Car(String color, int mileage) {
        this.color = color;
        this.mileage = mileage;
        this.amountOfGas = amountOfGas;
	}
	
	public Car(String color, int mileage, double amountOfGas) {
        this.color = color;
        this.mileage = mileage;
        this.amountOfGas = amountOfGas;
	}
	
	public Car(String color, int mileage, double amountOfGas, boolean wantRadio) {
        this.color = color;
        this.mileage = mileage;
        this.amountOfGas = amountOfGas;
        if (wantRadio) {
        	Radio radio = new Radio(true, false);
        }
	}
	
	// Getters and Setters (Accessors and Mutators)
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		if (color.equals("Platinum")) {
			System.out.println("Illegal Paint Color");
		}
		else {
			this.color = color;
		}
	}

	public int getMileage() {
		return mileage;
	}

	public double getAmountOfGas() {
		return amountOfGas;
	}

	public void setAmountOfGas(double amountOfGas) {
		if (amountOfGas > 20) {
			System.out.println("Too large of tank");
		}
		else {
			this.amountOfGas = amountOfGas;
		}
	}

	public boolean isClean() {
		return isClean;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	
	public Radio getRadio() {
		return radio;
	}
	
	public Wheel[] getWheels() {
		return wheels;
	}

	public void setWheels(int radius, String material) {
		for (int i = 0; i < wheels.length; ++i) {
			wheels[i] = new Wheel(radius, material);
		}
	}
	
	// Methods
	public double getMILES_PER_GALLON() {
		return MILES_PER_GALLON;
	}

	public boolean isWantRadio() {
		return wantRadio;
	}

	// ToString()
    @Override // The override (in this case) will only let me know if my method name is incorrect; as toString is a universal method call
	public String toString() {
		String str = "Car: color: " + color + " Mileage: " + mileage 
				+ " Gas: " + amountOfGas + " Clean: " + isClean;
		return str;
	}
    
	public void drive(int numMiles) {
		for (int i = 0; i < numMiles; i++) {
			System.out.print("+");
			++mileage;
		}
		amountOfGas -= numMiles / MILES_PER_GALLON;
		System.out.println();
	}
	
	public void clean() {
		isClean = true;
	}
	
	
	
}
