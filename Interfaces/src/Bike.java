
public class Bike extends Vehicle {
	private boolean isElectric; 
	private String bikeType; // Mountain, HardTail, Gravel
	
	
	// Constructors
	public Bike() {
		isElectric = false;
		bikeType = "Gravel";
	}

	public Bike(boolean isElectric, String bikeType) {
		super();
		this.isElectric = isElectric;
		this.bikeType = bikeType;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}

	@Override
	void drive(double miles) {
		 throw new UnsupportedOperationException("This bike can't be fed");
	}
	
	public void feed(int numGallons) {
		throw new UnsupportedOperationException("Bikes can't be fed"); 
	}

	@Override
	public String toString() {
		return "Bike [isElectric=" + isElectric + ", bikeType=" + bikeType + ", color= " +
				super.getColor() + ", id= " + super.getId() + "]";
	}
	
	
}
