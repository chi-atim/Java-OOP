import javax.swing.JFrame;

/**
 * This is a class that creates Frame.
 * @author Chiemi Mita
 * @since 2019-03-07
 */
public class TextStatFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Text Statistic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new TextStatPanel());
		frame.pack();
		frame.setVisible(true);
		
	}

}
