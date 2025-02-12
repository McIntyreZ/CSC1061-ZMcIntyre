import java.util.Scanner;

public class TestCreditCard {
	private static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the credit card number: ");
		long num = scnr.nextLong();
		
		CreditCardValidator.isValid(num);
		
		
	}
}
