import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;



public class ExamPanel extends JPanel {
	private int current;
	private JButton b1,b2,b3,b4,b5;
	
	
	public ExamPanel(){
		
		setLayout(new BoxLayout(b1, BoxLayout.Y_AXIS));
		b1 = new JButton("Hello");
		b2 = new JButton("Hello");
		b3 = new JButton("Hello");
		b4 = new JButton("Hello");
		b5 = new JButton("Hello");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
		
		
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(100, 300));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

	}
}
