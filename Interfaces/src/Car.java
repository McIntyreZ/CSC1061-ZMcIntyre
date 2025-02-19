
public class Car extends Vehicle {
	private double mpg = 20.0;
	private long numMiles;
	private boolean isRollsRoyce; 
	private double numGallons;
	
	public Car() {
		mpg = 20.0;
		numMiles = 0;
		isRollsRoyce = false; 
		numGallons = 12.0;
	}
	
	public Car(double mpg, long numMiles, boolean isRollsRoyce, double numGallons) {
		super();
		this.mpg = mpg;
		this.numMiles = numMiles;
		this.isRollsRoyce = isRollsRoyce;
		this.numGallons = numGallons;
	}

	public long getNumMiles() {
		return numMiles;
	}

	public boolean isRollsRoyce() {
		return isRollsRoyce;
	}

	@Override
	void drive(double miles) {
		numMiles += miles; 
		numGallons = numGallons - (miles / mpg);
	}

	@Override
	public void feed(int numGallons) {
		this.numGallons += numGallons; 
	}

	@Override
	public String toString() {
		return "Car [mpg=" + mpg + ", numMiles=" + numMiles + ", isRollsRoyce=" + isRollsRoyce + ", numGallons="
				+ numGallons + super.getColor() + ", id= " + super.getId() + "]";
	}
	
	

}
