import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends GeometricShape{
	private double radius;
	
	public Circle(int x, int y, Color color, boolean isFilled, double radius) {
		super(x, y, color, isFilled);
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
	public void draw(Graphics2D g2) {
		Ellipse2D.Double circle = new Ellipse2D.Double(this.getX(), this.getY(), this.radius*2, this.radius*2);
		g2.setColor(this.getColor());
		g2.draw(circle);
		if(this.isFilled())
			g2.fill(circle);
	}
}
