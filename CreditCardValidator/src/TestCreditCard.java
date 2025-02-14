import java.util.Scanner;

public class TestCreditCard {
	private static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the credit card number: ");
		long num = scnr.nextLong();
		boolean valid = false;
		
		valid = CreditCardValidator.isValid(num);
		
		if (valid) {
			System.out.println("The credit card is valid");
		}
		else {
			System.out.println("The credit card is invalid");
		}
		
	}
}
