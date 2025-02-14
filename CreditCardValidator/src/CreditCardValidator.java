
public class CreditCardValidator {
	
	public static boolean isValid(long cnum) {
		String cnumStr = String.valueOf(cnum); // Or Long.toString(cnum) 
		System.out.println(cnumStr);
		
		// Check length
		if (cnumStr.length() < 13 || cnumStr.length() > 16){
			return false;
		}
		
		// Check prefix
		long prefix = getPrefix(cnum, 1); 
		if (prefix != 4 && prefix != 5 && prefix != 6 && getPrefix(cnum, 2) != 37) {
			return false; 
		}
		
		int evenSum = sumOfEvenPlace(cnum);
		int oddSum = sumOfOddPlace(cnum);
		
		int total = evenSum + oddSum;
		
		if (total % 10 > 0) {
			return false;  // The program will return false every time at this point
		}
		else {
			return true; 
		}
	}
	
	private static long getPrefix(long num, int numDigits) {
		String str = Long.toString(num);
		if (str.length() < numDigits) {
			throw new IllegalArgumentException("String smaller than digits requested");
		}
		
		String prefixStr = str.substring(0, numDigits);
		
		long retNum = Long.parseLong(prefixStr);
		
		return retNum;
	}
	
	private static int sumOfEvenPlace(long num) {
		String str = Long.toString(num);
		int sum = 0;
		
		for (int i = str.length() - 2; i > -1; i -= 2) {
			char c = str.charAt(i);
			int product = Character.getNumericValue(c) * 2;
			int digit = getDigit(product); 
			sum += digit; 
		}
		
		return sum;
	}
	
	private static int getDigit(int num) {
		int digit = num;
			// Using switch just as another way to accomplish the goal
			switch(num) {
			case 10:
				digit = 1;
				break;
			case 12:
				digit = 3;
				break;
			case 14: 
				digit = 5;
				break;
			case 16:
				digit = 7;
				break;
			case 18:
				digit = 9;
				break;
			default:
				return digit;
		}
			return digit; 
	}
	
	private static int sumOfOddPlace(long num) {
		String str = String.valueOf(num);
		int sum = 0;
		
		for (int i = str.length() - 1; i < -1; i -= 2) {
			char c = str.charAt(i);
			sum += Character.getNumericValue(c);
		}
		return sum; 
	}
}
