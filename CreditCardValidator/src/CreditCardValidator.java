
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
		
		
		
		
		return false; 
	}
	
	private static long getPrefix(long num, int numDigits) {
		String str = Long.toString(num);
		if (str.length() < numDigits) {
			throw new IllegalArgumentException("String smaller than digits requested");
		}
		
		String prefixStr = str.substring(0, numDigits);
		System.out.println("Substring: " + prefixStr);
		
		long retNum = Long.parseLong(prefixStr);
		
		return retNum;
	}
	
	private static int sumOfEvenPlace(long num) {
		String str = Long.toString(num);
		
		for (int i = str.length() - 2; i > -1; i -= 2) {
			char c = str.charAt(i);
			int product = Character.getNumericValue(c) * 2;
			int digit = getDigit(product); 
		}
		
	}
	
	private static int getDigit(int num) {
		int digit = num;
		
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
		}
			return digit; 
	}
}
