import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;

public class Ball implements Runnable{
	private int x, y, xVelocity, yVelocity, diameter;
	private JComponent ballComp;
	private Color color;
	private Random gen = new Random();	

	public Ball(int x, int y, JComponent ballComp) {
		this.x = x;
		this.y = y;
		this.ballComp = ballComp;
		this.xVelocity = gen.nextInt(2) == 0 ? -5 : 5;
		this.yVelocity = gen.nextInt(2) == 0 ? -5 : 5;
		this.diameter = 25;
		this.color = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
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
	public int getxVelocity() {
		return xVelocity;
	}
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}
	public int getyVelocity() {
		return yVelocity;
	}
	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public JComponent getBallComp() {
		return ballComp;
	}
	public void setBallComp(JComponent ballComp) {
		this.ballComp = ballComp;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public void move() {
		if (getX() >= (500-diameter) || getX() <= 0) {
			setxVelocity(getxVelocity() * -1);
		}
		if (getY() >= (500-diameter) || getY() <= 0) {
			setyVelocity(getyVelocity() * -1);
		}
		setX(getX() + getxVelocity());
		setY(getY() + getyVelocity());
	}
	public void draw(Graphics2D g2){		
		g2.setColor(color);
		Ellipse2D.Double ball = new Ellipse2D.Double(x, y, diameter, diameter);
		g2.fill(ball);
	}
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			move();
			ballComp.repaint();
			try{
				Thread.sleep(60);
			}catch (InterruptedException e){
				e.getMessage();
			}
		}
	}
}
