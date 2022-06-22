import java.awt.*;
import java.awt.Color;
import java.util.Random;

import javax.swing.JComponent;

public class ShapeComponent extends JComponent {
	
	public void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g; 
	
		// row of Circles
		GeometricShape[] gsCircles1 = new GeometricShape[24];
		for (int i=0; i<gsCircles1.length; i++) {
			gsCircles1[i] = new Circle(i*20, 10, randomColor(), checkFilled(i), 10);
			gsCircles1[i].draw(g2);			
		}
		GeometricShape[] gsCircles2 = new GeometricShape[15];
		for (int i=0; i<gsCircles2.length; i++) {
			gsCircles2[i] = new Circle(i*30, 30, randomColor(), checkFilled(i), 15);
			gsCircles2[i].draw(g2);			
		}
		GeometricShape[] gsCircles3 = new GeometricShape[12];
		for (int i=0; i<gsCircles3.length; i++) {
			gsCircles3[i] = new Circle(i*40, 60, randomColor(), checkFilled(i), 20);
			gsCircles3[i].draw(g2);			
		}

		// row of Octagons
		GeometricShape[] gsOctagons1 = new GeometricShape[9];
		for (int i=0; i<gsOctagons1.length; i++) {
			gsOctagons1[i] = new Octagon(i*50+20, 150, randomColor(), checkFilled(i), 20);
			gsOctagons1[i].draw(g2);
		}
		GeometricShape[] gsOctagons2 = new GeometricShape[16];
		for (int i=0; i<gsOctagons2.length; i++) {
			gsOctagons2[i] = new Octagon(i*30+10, 180, randomColor(), checkFilled(i), 10);
			gsOctagons2[i].draw(g2);
		}
		GeometricShape[] gsOctagons3 = new GeometricShape[6];
		for (int i=0; i<gsOctagons3.length; i++) {
			gsOctagons3[i] = new Octagon(i*80+25, 250, randomColor(), checkFilled(i), 30);
			gsOctagons3[i].draw(g2);
		}
		
		// row of Pentagons
		GeometricShape[] gsPentagon1 = new GeometricShape[9];
		for (int i=0; i<gsPentagon1.length; i++) {
			gsPentagon1[i] = new Pentagon(i*50+30, 280, randomColor(), checkFilled(i), 30);
			gsPentagon1[i].draw(g2);
		}
		GeometricShape[] gsPentagon2 = new GeometricShape[5];
		for (int i=0; i<gsPentagon2.length; i++) {
			gsPentagon2[i] = new Pentagon(i*90+50, 350, randomColor(), checkFilled(i), 60);
			gsPentagon2[i].draw(g2);
		}
		GeometricShape[] gsPentagon3 = new GeometricShape[15];
		for (int i=0; i<gsPentagon3.length; i++) {
			gsPentagon3[i] = new Pentagon(i*30+20, 410, randomColor(), checkFilled(i), 20);
			gsPentagon3[i].draw(g2);
		}
	}
	public Color randomColor() {
		Random num = new Random();
		Color c = new Color(num.nextInt(256), num.nextInt(256), num.nextInt(256));
		return c;
	}
	public boolean checkFilled(int i) {
		if(i%2==0)
			return true;
		return false;
	}
}
