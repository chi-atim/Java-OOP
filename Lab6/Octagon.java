import java.awt.*;

public class Octagon extends GeometricShape {
	private int sideLength;

	public Octagon(int x, int y, Color color, boolean isFilled, int sideLength) {
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
	
	public void draw(Graphics2D g2) {
		int d = this.sideLength;
		int a = (int)(d / Math.sqrt(2));

		int[] xPoints = new int[8];
		xPoints[0]=this.getX();
		xPoints[1]=this.getX()+d;
		xPoints[2]=this.getX()+d+a;
		xPoints[3]=this.getX()+d+a;
		xPoints[4]=this.getX()+d;
		xPoints[5]=this.getX();
		xPoints[6]=this.getX()-a;
		xPoints[7]=this.getX()-a;
		
		int[] yPoints = new int[8];
		yPoints[0]=this.getY();
		yPoints[1]=this.getY();
		yPoints[2]=this.getY()-a;
		yPoints[3]=this.getY()-(a*2);
		yPoints[4]=this.getY()-(a*3);
		yPoints[5]=this.getY()-(a*3);
		yPoints[6]=this.getY()-(a*2);
		yPoints[7]=this.getY()-a;
			
		Polygon p = new Polygon (xPoints, yPoints, 8);
		
		g2.setColor(this.getColor());
		g2.draw(p);
		if(this.isFilled())
			g2.fill(p);
	}
}
























