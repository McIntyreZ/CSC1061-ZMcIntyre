
public class CheckingAccount extends Account {
	private double overdraftLimit; // Default 0, stored as a positive number 
	
	// Constructors 
	public CheckingAccount() {
		super();
		overdraftLimit = 0; 
	}
	
	public CheckingAccount(int id, double balance, double overdraftLimit) {
		super(id, balance); 
		this.overdraftLimit = overdraftLimit; 
	}
	
	public CheckingAccount(int id, double balance, double overdraftLimit, 
			double interestRate) {
		super(id, balance, interestRate); 
		this.overdraftLimit = overdraftLimit; 
	}
	
	public CheckingAccount(String name, int id, double balance, double overdraftLimit, 
			double interestRate) {
		super(name, id, balance, interestRate); 
		this.overdraftLimit = overdraftLimit; 
	}
	
	// Getter and setter for overdraftLimit 
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
	
	public void setOverdraftLimit(double overdraftLimit) throws OverdraftLimitException {
		if (overdraftLimit < 0) {
			throw new OverdraftLimitException("Limit must be positive"); 
		}
		this.overdraftLimit = overdraftLimit; 
	}
	
	// Other methods
	@Override 
	public void withdraw(double amountWithdrawn) throws Exception {
		if ((super.getBalance() - amountWithdrawn) > (0 - overdraftLimit)) {
			double newBalance = super.getBalance() - amountWithdrawn; 
			super.setBalance(newBalance); 
		}
		else {
			throw new OverdraftLimitException("Exceeds overdraft limit");
		}
		Transaction newTran = new Transaction('W', amountWithdrawn, super.getBalance());
		transactions.add(newTran);
	}
	
	public void deposit(double amountDeposited) throws Exception {
		if (amountDeposited < 0) {
			throw new Exception("Amount deposited must be positive"); 
		}
		else {
			double newBalance = super.getBalance() + amountDeposited;
			super.setBalance(newBalance);
		}
		Transaction newTran = new Transaction('D', amountDeposited, super.getBalance());
		transactions.add(newTran);
	}

	@Override
	public String toString() {
		return "CheckingAccount [id = " + super.getId() + ", name = " + super.getName() + 
				", balance = " + super.getBalance() + ", annualInterestRate = " + 
				super.getAnnualInterestRate() + "monthlyInterestRate = " + 
				super.getMonthlyInterestRate() + ", dateCreated = " + 
				super.getDateCreated() + "overdraftLimit = " + overdraftLimit + "]";
	}	
}
