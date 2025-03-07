import java.time.LocalDate;

public class Transaction {
	private LocalDate dateOfTransaction;
	private char tranType; // Either 'W' or 'D'
	private double amount; 
	private double newBalance;
	
	public Transaction(char tranType, double amount, double newBalance) {
		this.dateOfTransaction = java.time.LocalDate.now();
		this.tranType = tranType;
		this.amount = amount;
		this.newBalance = newBalance;
	}

	@Override
	public String toString() {
		return "Transaction [dateOfTransaction = " + dateOfTransaction + ", tranType = "
				+ tranType + ", amount = " + amount + ", newBalance = " + 
				newBalance + "]";
	} 
	
	
}
