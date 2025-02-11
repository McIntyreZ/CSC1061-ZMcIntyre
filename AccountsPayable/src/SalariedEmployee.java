
public class SalariedEmployee extends Employee {
	// Data Members
	private double weeklySalary;
	
	// Constructors
	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(String firstName, String lastName, long socialSecNum, double weeklySalary) {
		super(firstName, lastName, socialSecNum);
		this.weeklySalary = weeklySalary;
	}

	// Getters and Setters
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "SalariedEmployee [firstName = " + super.getFirstName() + 
				"\n lastName = " + super.getLastName() + "\n socialSecNum = " 
				+ super.getSocialSecNum() + "\n weeklySalary =" + weeklySalary + "]";
	}
	
	
	
}
