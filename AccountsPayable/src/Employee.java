
public class Employee {
	// Data Members
	private String firstName;
	private String lastName;
	private long socialSecNum;
	private double payAmount;
	
	// Constructors
	public Employee() {
		firstName = "John";
		lastName = "Doe";
		socialSecNum = 999999999;
	}
	
	public Employee(String firstName, String lastName, long socialSecNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecNum = socialSecNum;
	}
	
	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getSocialSecNum() {
		return socialSecNum;
	}
	public void setSocialSecNum(long socialSecNum) {
		this.socialSecNum = socialSecNum;
	}
	
	// Other Methods
	public double getPaymentAmount() {
		return payAmount;
	}
	

	@Override
	public String toString() {
		return "Employee [firstName = " + firstName +"\n lastName = " + 
				lastName + "\n socialSecNum = " + socialSecNum + "]";
	}

	
	

}
