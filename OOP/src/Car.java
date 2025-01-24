
public class Car {
	// Data Members
	private String color;
	private int mileage;
	private double amountOfGas;
	private boolean isClean = true;
	
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
	
	
}
