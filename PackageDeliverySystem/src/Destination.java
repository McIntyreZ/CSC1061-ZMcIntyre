
public class Destination {
	// Data Members
	private String address;
	private String city;
	private String state;
	
	// Constructors 
	public Destination(String address, String city, Sting state) {
		this.address = address;
		this.city = city;
		this.state = state;
	}
	
	// Getters and Setters
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Destination [address = " + address + ", city = " + city + ", state = " + state + "]";
	} 
	
}
