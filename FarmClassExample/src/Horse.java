
public class Horse extends Animal{
	// Data Members
	private String coat; 
	
	// Constructors
	public Horse() {
		super();
		coat = "noCoat"; 
	}
	public Horse(String name, int age, double weight, String coat) {
		super(name, age, weight);
		this.coat = coat;
	}

	// Getters and Setters
	public String getCoat() {
		return coat;
	}

	public void setCoat(String coat) {
		this.coat = coat;
	}
	
	@Override
	public String makeSound() {
		return "Neigh! Neigh!";
	}
	
	
	
	
}
