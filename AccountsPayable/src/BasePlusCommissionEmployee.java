
public class BasePlusCommissionEmployee extends CommissionEmployee {
	// Data Members
	private double basePay;
	
	// Constructors
	public BasePlusCommissionEmployee() {
		super();
		basePay = 0.0;
	}
	public BasePlusCommissionEmployee(String firstName, String lastName, long socialSecNum, double grossSales,
			double commissionRate, double basePay) {
		super(firstName, lastName, socialSecNum, grossSales, commissionRate);
		this.basePay = basePay;
	}

	// Getters and Setters
	public double getBasePay() {
		return basePay;
	}
	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override 
	public double getPaymentAmount() {
		return super.getPaymentAmount() + basePay;
	}
	
	@Override
	public String toString() {
		return "BasePlusCommission [firstName = " + super.getFirstName() + 
				"\n lastName = " + super.getLastName() + "\n socialSecNum = "
				+ super.getSocialSecNum() + "\n grossSales = " + super.getGrossSales()
				+ "\n commissionRate = " + super.getCommissionRate()  + "\n basePay "
				+ basePay + "]";
	}

}
