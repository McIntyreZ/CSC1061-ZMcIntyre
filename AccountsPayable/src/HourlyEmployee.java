
public class HourlyEmployee extends Employee {
	// Data Members
	private double hourlyWage;
	private double hours;
		
	// Constructors
	public HourlyEmployee() {
		super();
		hourlyWage = 0.0;
		hours = 0.0;
	}

	public HourlyEmployee(String firstName, String lastName, long socialSecNum,
			double hourlyWage, double hours) {
		super(firstName, lastName, socialSecNum);
		this.hourlyWage = hourlyWage;
		this.hours = hours; 
	}

	// Getters and Setters
	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount() {
		return hourlyWage * hours;
	}
	
	@Override
	public String toString() {
		return "HourlyEmployee [firstName = " + super.getFirstName() + 
				"\n lastName = " + super.getLastName() + "\n socialSecNum = " + 
				super.getSocialSecNum() + "\n hourlyWage = " + hourlyWage + "\n hours"
				+ hours +"]";
	}
}
