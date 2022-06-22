
public class Circle extends GeometricShape{
	private double radius;

	public Circle(String color, boolean isFilled, double radius) {
		super(color,isFilled);
		this.radius=radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		String result ="[Circle] "; 
		result += super.toString() + " Radius: " + radius;
		return result;
	}
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
}
