
public class CommissionEmployee extends Employee {
	// Data Members
	private double grossSales;
	private double commissionRate;
	
	// Constructors 
	public CommissionEmployee() {
		super();
		grossSales = 0.0;
		commissionRate = 0.0;
	}
	public CommissionEmployee(String firstName, String lastName, 
			long socialSecNum, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecNum);
		this.grossSales = grossSales;
		this.commissionRate = grossSales;
	}
	
	// Getters and Setters
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	// Other methods
	@Override
	public double getPaymentAmount(){
		return grossSales * commissionRate;
	}
	
	@Override
	public String toString() {
		return "CommissionEmployee [firstName = " + super.getFirstName() + "\n lastName = "
				+ super.getLastName() + "\n socialSecNum = " + super.getSocialSecNum() 
				+ "\n grossSales = " + grossSales + "\n commissionRate = " + commissionRate
				+ "]";
	}
	
}
