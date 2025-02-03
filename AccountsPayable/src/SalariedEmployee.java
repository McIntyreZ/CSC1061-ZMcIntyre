
public class SalariedEmployee extends Employee {
	// Data Members
	private double weeklySalary;
	private 
	
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
	public double getPaymentAccount() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "SalariedEmployee [firstName = " + firstName + "\n lastName = " + lastName
				+ "\n socialSecNum = " + socialSecNum + "\n weeklySalary =" + weeklySalary + "]";
	}
	
	
	
}
