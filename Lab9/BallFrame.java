import javax.swing.JFrame;

public class BallFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bouncing Ball Thread");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new BallComponent());
		frame.pack();
		frame.setVisible(true);		
	}
}
