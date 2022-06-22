
public abstract class GeometricShape implements Comparable<GeometricShape>{
	private String color;
	private boolean isFilled;

	public GeometricShape(String color, boolean isFilled) {
		this.color = color;
		this.isFilled = isFilled;
	}
	public GeometricShape() {
		this("white", true);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
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
	
}