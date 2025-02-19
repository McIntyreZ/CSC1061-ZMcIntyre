// This is designed to show what args[0] is used for and how the program can be run when in Bash/somewhere else 


public class TempConverter {

	public static void main(String[] args) {
		
		double answer = 0.0;
		double input = 75;
		
		if (args.length < 2) {
			System.out.println("Usage:");
			System.out.println("Enter in either \"-c\" or \"-f\"");
			System.exit(-1);
		}
		if (args[0].equals("-c")) {
			answer = ConvertFahToCel(input);
			answer = ConvertFahToCel(Double.parseDouble(args[1]));
			System.out.println("The Celsius value is: " + answer);
		}
		else if (args[0].equals("-f")) {
			answer = ConvertCelToFah(input);
			answer = ConvertCelToFah(Double.parseDouble(args[1]));
			System.out.println("The Fahrenheit value is: " + answer);
		}
		else {
			printUsage();
			System.exit(-1);
		}
	}
	
	public static void printUsage() {
		System.out.println("Usage:");
		System.out.println("Enter in either \"-c\" or \"-f\"");
	}
	
	public static double ConvertFahToCel(double input) {
		return ((input - 32) * (5.0/9.0));
	}

	public static double ConvertCelToFah(double input) {
		return ((input * (9.0/5.0)) + 32);
	}
}
