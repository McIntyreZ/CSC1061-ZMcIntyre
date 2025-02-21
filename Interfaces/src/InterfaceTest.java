
public class InterfaceTest {

	public static void main(String[] args) {
		
		Bike bike = new Bike();
		
		try {
			bike .feed(4);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
