import java.awt.Color;
import java.awt.Graphics2D;

public abstract class GeometricShape implements Comparable<GeometricShape>{
	private Color color;
	private boolean isFilled;
	private int x, y;	
	
	public GeometricShape(int x, int y, Color color, boolean isFilled) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.isFilled = isFilled;
	}
	public GeometricShape() {
		this(1, 1, Color.WHITE, true);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isFilled() {
		return isFilled;
	}
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	@Override
	public String toString() {
		return "Color: " + color + " isFilled: " + isFilled;
	}
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public int compareTo(GeometricShape shape) {
		return (int)(this.getArea() - shape.getArea());		
	}
	public static GeometricShape max(GeometricShape gs1, GeometricShape gs2) {
		if (gs1.getArea() > gs2.getArea() || gs1.getArea() == gs2.getArea() )			
			return gs1;
		else			
			return gs2;
	}
	public static double sumArea(GeometricShape[] shapes) {
		double sum=0;
		for (GeometricShape g : shapes)
			sum += g.getArea();
		return sum;
	}
	public void draw(Graphics2D g2) {}
	
}