
public class Recursion {

	public static void main(String[] args) {

		System.out.println("The value of 4! is " + recursiveTest(4)); 
		System.out.println("The 5th element in the fib sequence: " + fibRecurse(5)); 
	}
	
	public static int fibRecurse(int n) {
		if (n <= 1) {
			return n; 
		}
		else {
			return fibRecurse(n - 1) + fibRecurse(n - 2 ); 
		}
	}
	
	public static int recursiveTest(int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return n * recursiveTest(n - 1);
		}
	}
}
