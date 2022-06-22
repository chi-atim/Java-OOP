
public class Octagon extends GeometricShape {
	private int sideLength;

	public Octagon(String color, boolean isFilled, int sideLength) {
		super(color,isFilled);
		this.sideLength = sideLength;
	}
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	@Override
	public String toString() {
		String result ="[Octagon] "; 
		result += super.toString() + " SideLength: " + sideLength;
		return result;
	}
	@Override
	public double getArea() {
		return 2*(1 + Math.sqrt(2)) * Math.pow(sideLength, 2);
	}
	@Override
	public double getPerimeter() {
		return 8 * sideLength;
	}

}
