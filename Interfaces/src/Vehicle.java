
public abstract class Vehicle implements Feedable{
	private String color;
	private static long id;
	
	public String getColor() {
		return null;
	}
	
	public void setColor(String color) {
		this.color = color;
		id += 1;
	}

	public long getId() {
		return id;
	}

	
	abstract void drive(double miles);
	
}	
