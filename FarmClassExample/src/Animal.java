
public class Animal {
	// Data Members
	private String name;
	private int age;
	private double weight;
	
	// Constructors
	public Animal() {
		name = "noName";
		age = 0;
		weight = 0;
	}
	
	public Animal(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
	
	
}
