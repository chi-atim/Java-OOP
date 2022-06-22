import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

public class Pentagon extends GeometricShape {
	
	private int sideLength;
	
	public Pentagon(int x, int y, Color color, boolean isFilled, int sideLength) {
		super(x, y, color, isFilled);
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
		String result ="[Pentagon] "; 
		result += super.toString() + " SideLength: " + sideLength;
		return result;
	}
	@Override
	public double getArea() {
		return  (Math.sqrt(5 * (5 + 2 * (Math.sqrt(5)))) * Math.pow(sideLength, 2)) / 4;
	}
	@Override
	public double getPerimeter() {
		return 5 * sideLength;
	}
	public void draw(Graphics2D g2) {
		double radius= sideLength / (2* Math.sin(180/Math.PI));
		int angle = (int)Math.toRadians(540);
		int num = 5;

		int[] xPoints = new int[num];
		for(int i=0; i<xPoints.length; i++) {
			xPoints[i]= (int)(this.getX()+radius * Math.cos(angle + i * 2 * Math.PI / num));
		}
		int[] yPoints = new int[num];
		for(int i=0; i<yPoints.length; i++) {
			yPoints[i]= (int)(this.getY()+radius * Math.sin(angle + i * 2 * Math.PI / num));
		}
		
		Polygon p = new Polygon (xPoints, yPoints, num);
		
		g2.setColor(this.getColor());
		g2.draw(p);
		if(this.isFilled())
			g2.fill(p);
	}

}
