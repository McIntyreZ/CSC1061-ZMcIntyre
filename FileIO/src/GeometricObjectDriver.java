import java.io.FileNotFoundException;
import java.util.List;

public class GeometricObjectDriver {

	public static void main(String[] args) {

		Circle circ1 = new Circle();
		Rectangle rect1 = new Rectangle();
		
		try {
			Database.writeGeometricObject(circ1);
			Database.writeGeometricObject(rect1);
		}
		catch (GeometricObjectDBException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Database.readGeometricObject();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		try {
			GeometricObject obj = Database.readGeometricObject();
			System.out.println(obj);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		List<GeometricObject> gObjs = Database.readDatabase();
		for (GeometricObject obj: gObjs) {
			System.out.println(obj); 
		}
	}

}
