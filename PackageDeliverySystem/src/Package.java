
public class Package {
	// Data Members
	private Destination destination;
	private double weight;
	private double costPerKg;
	private boolean status;
	private int trackingNum; 
	private static int nextTrackNum = 1;
	
	// Constructor
	public Package(Destination destination, double weight, double costPerKg, boolean status) {
		super();
		this.destination = destination;
		this.weight = weight;
		this.costPerKg = costPerKg;
		this.status = status;
		this.trackingNum = nextTrackNum;
		nextTrackNum += 1;
	}
	
	public void generateTrackingNumber() {
		
	}
	
}
