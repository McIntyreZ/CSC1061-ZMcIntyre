
public class Motorbike extends Vehicle {
	private double mpg;
	private long numMiles;
	private int numWheels; 
	private double numGallons = 5.0; 
	
	public Motorbike() {
		mpg = 40.0;
		numMiles = 0;
		numWheels = 2;
		numGallons = 6.0;
	}
	
	public Motorbike(double mpg, long numMiles, int numWheels, double numGallons) {
		super();
		this.mpg = mpg;
		this.numMiles = numMiles;
		this.numWheels = numWheels;
		this.numGallons = numGallons;
	}

	public long getNumMiles() {
		return numMiles;
	}

	public int getNumWheels() {
		return numWheels;
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
		return "Motorbike [mpg=" + mpg + ", numMiles=" + numMiles + ", numWheels=" + numWheels + ", numGallons="
				+ numGallons + super.getColor() + ", id= " + super.getId() + "]";
	}
	
	

}
