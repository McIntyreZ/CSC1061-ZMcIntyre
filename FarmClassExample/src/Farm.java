
public class Farm {

	public static void main(String[] args) {
		Horse anim = new Horse("Charlie", 3, 900, "Black");
		
		
		
	}

	public static String identifyAnimal(Animal anim) {
		if (anim instanceof Dog) {
			return "Dog";
		}
		if (anim instanceof Cat) {
			return "Cat";
		}
		if (anim instanceof Horse) {
			return "Horse";
		}
	}
}
