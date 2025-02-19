
public class Animal implements Feedable {
	private String name;
	private double weight;
	private double metabolism; // For this program: calories / metabolism = weight gained
	
	public Animal() {
		name = "noName"; 
		weight = 55.0;
		metabolism = 10;
	}
	
	public Animal(String name, double weight, double metabolism) {
		super();
		this.name = name;
		this.weight = weight;
		this.metabolism = metabolism;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public void feed(int numCalories) {
		weight += (numCalories / metabolism);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", metabolism=" + metabolism + "]";
	} 
	
	
	
}
