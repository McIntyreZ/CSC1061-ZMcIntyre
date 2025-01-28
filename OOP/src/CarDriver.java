
public class CarDriver {

	public static void main(String[] args) {
		Car myCar = new Car("Pink", 50, 20.0, true);
		
		myCar.drive(5);
		myCar.clean();
		myCar.setWheels(15, "Alloy");
		
		Wheel[] wheels = myCar.getWheels();
		for (Wheel wheel : wheels) {
			System.out.println(wheel);
		}
	}
}
