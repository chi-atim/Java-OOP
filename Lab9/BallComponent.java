import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class BallComponent extends JPanel {
	private ArrayList<Ball> ballArray;
	
	public BallComponent(){
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.BLACK);
		ballArray = new ArrayList<Ball>();		
		addMouseListener(new BallMouseListener());	
	}		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Ball eachBall : ballArray) {
			eachBall.draw(g2);
		}		
	}
	private class BallMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Ball ball = new Ball(e.getX(),e.getY(), (JComponent)e.getComponent());
			ballArray.add(ball);
			Thread t = new Thread (ball);
			t.start();	
		}	
	}
}
