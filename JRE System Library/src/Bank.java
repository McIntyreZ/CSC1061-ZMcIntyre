
public class Bank extends FIAbstract {
	private String name;
	private double interestRate; 
	private Address address;
	private long routingNum;
	private 
	
	// Constructors
	public Bank() {
		name = "noname";
		interestRate = 0;
		address = new Address();
		routingNum = 0;
	}
	
	public Bank(String name, double interestRate) {
		this.name = name;
		this.interestRate = interestRate;
	}

	// Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
