import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private int id;  // Default 0
	private double balance; // Default 0
	private double annualInterestRate;  // Default 0
	private LocalDate dateCreated;  
	private String name; 
	protected List<Transaction> transactions = new ArrayList<>();
	
	// Constructors
	public Account() {
		id = 0;
		balance = 0; 
		annualInterestRate = 0;
		dateCreated = java.time.LocalDate.now();
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		dateCreated = java.time.LocalDate.now();
	}
	
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		dateCreated = java.time.LocalDate.now();
		this.annualInterestRate = annualInterestRate; 
	}
	
	public Account(String name, int id, double balance) {
		this.name = name; 
		this.id = id;
		this.balance = balance;
		dateCreated = java.time.LocalDate.now();
	}
	
	public Account(String name, int id, double balance, double interestRate) {
		this.name = name; 
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = interestRate; 
		dateCreated = java.time.LocalDate.now();
	}

	// Getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if (id < 0) {
			throw new Exception("ID cannot be negative"); 
		}
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) throws Exception {
		if (annualInterestRate < 0) {
			throw new Exception("Interest rate must be positive"); 
		}
		this.annualInterestRate = annualInterestRate;  
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	// Other methods 
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = annualInterestRate / 100; 
		return monthlyInterestRate; 
	}
	
	public double getMonthlyInterest() {
		double monthlyInterest = balance * (getMonthlyInterestRate() / 100); 
		return monthlyInterest; 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Other methods 
	public void printList() {
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i)); 
		}
	}
	
	public void withdraw(double amountWithdrawn) throws Exception {
		if (amountWithdrawn < 0) {
			throw new Exception("Amount withrawn must be positive"); 
		}
		balance = balance - amountWithdrawn; 
		Transaction newTran = new Transaction('W', amountWithdrawn, balance);
		transactions.add(newTran); 
	}
	
	public void deposit(double amountDeposited) throws Exception {
		if (amountDeposited < 0) {
			throw new Exception("Deposit amount must be positive"); 
		}
		balance = balance + amountDeposited; 
		Transaction newTran = new Transaction('D', amountDeposited, balance);
		transactions.add(newTran); 
	}

	@Override
	public String toString() {
		return "Account [id = " + id + ", name = " + name + ", balance = " + balance + 
				", annualInterestRate = " + annualInterestRate + 
				"monthlyInterestRate = " + getMonthlyInterestRate() +
				", dateCreated = "
				+ dateCreated + "]";
	}
}
