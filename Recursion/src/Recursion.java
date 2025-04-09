
public class Recursion {
	private static long counter = 0; 
	private static long[] termArray = new long[200]; 
	
	public static void main(String[] args) {

		System.out.println("The value of 4! is " + recursiveTest(4)); 
		System.out.println("The 5th element in the fib sequence: " + fibDynamic(45)); 
		
		System.out.println("Counter value: " + counter); 
	}
	
	public static int fibRecurse(int n) {
		if (n <= 1) {
			return n; 
		}
		else {
			counter++; 
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
	
	public static long fibDynamic(int n) { 
		if (n <= 1) {
			return n; 
		}
		if (termArray[n] > 0) {
			return termArray[n]; 
		}
		counter++;
		termArray[n] = fibDynamic(n - 1) + fibDynamic(n - 2 ); 
		return termArray[n]; 
	}
	
	public static long fibIterative(int n) {
		if (n < 2) {
			return n; 
		}
		long total = 0; 
		long prevVal1 = 1;
		long prevVal2 = 0;
		for (int i = 2; i <= n; i++) {
			total += prevVal1 + prevVal2;
			prevVal2 = prevVal1; 
			prevVal1 = total; 
		}
		
		return total; 
	}
}
