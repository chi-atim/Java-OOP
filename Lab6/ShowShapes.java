import javax.swing.JFrame;

public class ShowShapes {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		frame.setSize(500,500); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Lab 6"); 

        frame.add(new ShapeComponent());
        frame.setVisible(true); 
        
	}
}
