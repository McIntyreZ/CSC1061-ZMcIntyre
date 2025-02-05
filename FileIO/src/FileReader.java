import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReader {

	public static void main(String[] args) {
		File readFile = new File("fileWriteTest.txt");
		Scanner input = null;
		try {
			input = new Scanner(readFile);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while(input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
		
	}

}
