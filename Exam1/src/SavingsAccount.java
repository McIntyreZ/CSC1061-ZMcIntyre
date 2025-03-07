
public class SavingsAccount extends Account {
	private double minBalance;  // Default 0 
	
	// Constructors 
	public SavingsAccount() {
		super();
		minBalance = 0; 
	}
	
	public SavingsAccount(int id, double balance, double minBalance) {
		super(id, balance); 
		this.minBalance = minBalance; 
	}
	
	public SavingsAccount(int id, double balance, double minBalance, 
			double interestRate) {
		super(id, balance, interestRate); 
		this.minBalance = minBalance; 
	}
	
	public SavingsAccount(String name, int id, double balance, double minBalance, 
			double interestRate) {
		super(name, id, balance, interestRate); 
		this.minBalance = minBalance; 
	}
	
	// Other methods 
	public double getMinBalance() {
		return minBalance;
	}
	
	@Override 
	public void withdraw(double amountWithdrawn) throws Exception {
		if ((super.getBalance() - amountWithdrawn) > minBalance) {
			double newBalance = super.getBalance() - amountWithdrawn; 
			super.setBalance(newBalance); 
		}
		else {
			throw new MinBalanceException("Account must maintain minimum amount");
		}
		Transaction newTran = new Transaction('W', amountWithdrawn, super.getBalance());
		transactions.add(newTran);
	}
	
	@Override 
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
		return "SavingsAccount [id = " + super.getId() + ", name = " + super.getName()
				+ ", balance = " + super.getBalance() + ", annualInterestRate = " +  
				super.getAnnualInterestRate() + "monthlyInterestRate = " + 
				super.getMonthlyInterestRate() +", dateCreated = " + 
				super.getDateCreated() + "minBalance = " + minBalance + "]";
	}	
	
	
	
}
