import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class FileWriter {

	public static void main(String[] args) {
			File myFile = new File("fileWriteTest.txt");
			
			if (!myFile.exists()) {
				try {
					myFile.createNewFile();
				}
				catch (IOException e){
					System.out.println(e.getMessage());
					System.exit(-1);
				}
			}
			
			PrintWriter pWriter = null; // Declaring it outside of try catch block because later on 
										// there might be a command using pWriter
			try {
				// pWriter = new PrintWriter(myFile);
				pWriter = new PrintWriter(new FileOutputStream(myFile, true)); // true or false 
																				// dictates whether
																				// whether file will
																				// be appended or not
			}
			catch (IOException e){
				System.out.println(e.getMessage());
			}
			
			pWriter.println("Aristotle's Golden Mean philosophy is very old.");
			pWriter.flush(); // Essentially "empties" the print writer onto the file 
			pWriter.close(); // Automatically flushes whatever has not already been flushed 
							 // from the print witer 
			
	}

}
