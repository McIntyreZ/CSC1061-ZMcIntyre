import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Database {
	static final String fileName = "Database.csv";
	static File outFile = new File(fileName);
	static PrintWriter printer; 
	
	public static void writeGeometricObject(GeometricObject obj) throws GeometricObjectDBException {
		if (printer == null) {
			try {
				printer = new PrintWriter(outFile.getName());
			} 
			catch (FileNotFoundException e) {
				throw new GeometricObjectDBException("Database creation error");
			}
		}
		
		printer.print(obj.getClass().getName() + "," + obj.getColor() + "," + obj.isFilled() 
			+ "," + obj.getDateCreated());
		if (obj instanceof Circle) {
			printer.print("," + ((Circle)obj).getRadius());
		}
		else if (obj instanceof Rectangle) {
			printer.print("," + ((Rectangle)obj).getHeight() + ((Rectangle)obj).getWidth());
		}
		
	}
	
}
