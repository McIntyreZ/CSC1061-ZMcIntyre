
public class Circle extends GeometricObject{
	private double radius; 
	private boolean isFilled = false;
	private String color;
	
	public Circle() {
		radius = 1.0;
		color = "white";
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, boolean isFilled, double radius) {
		this.color = color;
		this.isFilled = isFilled;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color; 
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", isFilled=" + isFilled + "]";
	}

}
