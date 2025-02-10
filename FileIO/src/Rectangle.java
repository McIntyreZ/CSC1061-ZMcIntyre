
public class Rectangle extends GeometricObject {
	private double width; 
	private double height;
	
	// Constructors
	public Rectangle() {
		super("Black", false);
		width = 1.0;
		height = 1.0;
	}
	
	public Rectangle(String color, boolean isFilled, double width, double height) {
		super(color, isFilled);
		this.width = width;
		this.height = height;
	}

	// Getters and setters 
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Methods
	public double getArea() {
		return width * height;
	}
	
	public double getPerimiter() {
		return 2 * (width + height);
	}
	
	@Override
	public String toString() {
		return super.toString() +"Rectangle [width=" + width + ", height=" + height + "]";
	}
	

	
}
