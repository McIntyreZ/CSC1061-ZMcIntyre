
public class Exam1Test {

	public static void main(String[] args) {
		
		CheckingAccount checking1 = new CheckingAccount(1111, 2000, 200, 0.5);
		
		try {
			checking1.withdraw(2100);
			checking1.deposit(3000); 
			System.out.println(checking1); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		SavingsAccount saving1 = new SavingsAccount(1100, 500, 200, 1);
		
		try {
			saving1.withdraw(300);
			saving1.toString();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		CheckingAccount checking2 = new CheckingAccount("George", 2222, 1000, 200, 1.5);
		
		try {
			checking2.deposit(30); 
			checking2.deposit(40);
			checking2.deposit(50);
			checking2.withdraw(5);
			checking2.withdraw(4);
			checking2.withdraw(2);
			System.out.println(checking2); 
			checking2.printList(); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
